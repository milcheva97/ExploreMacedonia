package main.java.com.exploreCity.repository.impl;

import main.java.com.exploreCity.assets.JenaAssets;
import main.java.com.exploreCity.model.City;
import main.java.com.exploreCity.repository.ListOfCitiesRepository;
import main.java.com.exploreCity.utils.Utils;
import org.apache.jena.query.*;

import java.util.ArrayList;
import java.util.List;

public class ListOfCitiesRepositoryImpl implements ListOfCitiesRepository {
    @Override
    public List<City> cityName(String cityURI) {
        String queryCapitalCityInfo =
                "prefix dbp: <http://dbpedia.org/property/> " +
                        "prefix dbo: <http://dbpedia.org/ontology/> " +
                        "prefix dbr: <http://dbpedia.org/resource/> " +
                        "prefix rdfs: <http://www.w3.org/2000/01/rdf-schema#> " +
                        "prefix rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
                        "SELECT * WHERE { " +
                        "             OPTIONAL { dbr:" + cityURI + " dbp:city ?city . } " +
                        "}";

        Query query = QueryFactory.create(queryCapitalCityInfo);

        List<City> cities = new ArrayList<>();

        try (QueryExecution queryExecution = QueryExecution.service(JenaAssets.SPARQLEndpoint).query(query).build()) {
            ResultSet resultSet = queryExecution.execSelect();
            while (resultSet.hasNext()) {
                City city = new City();
                Utils.addCityInfo(city, resultSet.next());
                cities.add(city);
            }
        }
        return cities;
    }
}
