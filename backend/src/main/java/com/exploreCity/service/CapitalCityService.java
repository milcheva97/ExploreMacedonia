package main.java.com.exploreCity.service;

import main.java.com.exploreCity.model.CapitalCity;
import main.java.com.exploreCity.model.exceptions.CapitalCityNotFoundException;

public interface CapitalCityService {

    CapitalCity getCapitalCityInfo (String capitalCityURI) throws CapitalCityNotFoundException;
}
