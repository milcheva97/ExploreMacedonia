package main.java.com.exploreCity.utils;

import main.java.com.exploreCity.model.City;
import org.apache.jena.query.QuerySolution;

public class Utils {
    public static void addCityInfo (City city, QuerySolution qs) {
        city.setURI(qs.contains("city") && qs.get("city").isResource() ?
                qs.getResource("city").toString().split("/")[qs.getResource("city").toString().split("/").length - 1]
                : null);
        city.setName(qs.get("name") != null && qs.get("name").isLiteral() ? qs.get("name").asLiteral().getLexicalForm() : null);
    }
}
