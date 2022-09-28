package main.java.com.exploreCity.repository.impl;

import main.java.com.exploreCity.assets.JenaAssets;
import main.java.com.exploreCity.model.CapitalCity;
import main.java.com.exploreCity.model.exceptions.CapitalCityNotFoundException;
import main.java.com.exploreCity.repository.CapitalCityRepository;
import org.apache.jena.query.*;

public class CapitalCityRepositoryImpl implements CapitalCityRepository {
    @Override
    public void addCapitalCityInfo(String capitalCityURI, CapitalCity capitalCity) throws CapitalCityNotFoundException {
        String queryCapitalCityInfo =
                "prefix dbp: <http://dbpedia.org/property/> " +
                "prefix dbo: <http://dbpedia.org/ontology/> " +
                "prefix dbr: <http://dbpedia.org/resource/> " +
                "prefix rdfs: <http://www.w3.org/2000/01/rdf-schema#> " +
                "prefix rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
                "SELECT * WHERE { " +
                "             OPTIONAL { dbr:" + capitalCityURI + " dbo:thumbnail ?thumbnail . } " +
                "             OPTIONAL { dbr:" + capitalCityURI + " dbo:abstract ?abstract . } " +
                "             OPTIONAL { dbr:" + capitalCityURI + " dbp:leaderName ?leader . } " +
                "             FILTER (lang(?abstract) = \"en\")" +
                "}";

        Query query = QueryFactory.create(queryCapitalCityInfo);

        try (QueryExecution queryExecution = QueryExecution.service(JenaAssets.SPARQLEndpoint).query(query).build()) {
            ResultSet resultSet = queryExecution.execSelect();
        }
    }
}
