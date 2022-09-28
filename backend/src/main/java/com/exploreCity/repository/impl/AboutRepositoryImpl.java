package main.java.com.exploreCity.repository.impl;

import main.java.com.exploreCity.assets.JenaAssets;
import main.java.com.exploreCity.repository.AboutRepository;
import org.apache.jena.query.*;
import org.springframework.stereotype.Repository;

@Repository
public class AboutRepositoryImpl implements AboutRepository {
    @Override
    public void addMacedoniaInfo(String aboutURI) {
        String queryMacedoniaInfo =
                "prefix dbo: <http://dbpedia.org/ontology/> " +
                "prefix dbr: <http://dbpedia.org/resource/> " +
                "prefix rdfs: <http://www.w3.org/2000/01/rdf-schema#> " +
                "SELECT * WHERE { " +
                "             OPTIONAL { dbr:" + aboutURI + " dbo:thumbnail ?thumbnail . } " +
                "             OPTIONAL { dbr:" + aboutURI + " dbo:abstract ?abstract . } " +
                "             OPTIONAL { dbr:" + aboutURI + " dbo:currency ?currency . } " +
                "             OPTIONAL { dbr:" + aboutURI + " dbo:officialLanguage ?language . } " +
                "             FILTER (lang(?abstract) = \"en\")" +
                "}";

        Query query = QueryFactory.create(queryMacedoniaInfo);

        try (QueryExecution queryExecution = QueryExecution.service(JenaAssets.SPARQLEndpoint).query(query).build()) {
            ResultSet resultSet = queryExecution.execSelect();
        }
    }
}
