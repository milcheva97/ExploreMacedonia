package main.java.com.exploreCity.repository;

import main.java.com.exploreCity.model.CapitalCity;
import main.java.com.exploreCity.model.exceptions.CapitalCityNotFoundException;

public interface CapitalCityRepository {

    void addCapitalCityInfo (String capitalCityURI, CapitalCity capitalCity) throws CapitalCityNotFoundException;
}
