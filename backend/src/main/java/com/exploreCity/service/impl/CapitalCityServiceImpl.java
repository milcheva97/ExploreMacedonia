package main.java.com.exploreCity.service.impl;

import main.java.com.exploreCity.model.CapitalCity;
import main.java.com.exploreCity.model.exceptions.CapitalCityNotFoundException;
import main.java.com.exploreCity.repository.CapitalCityRepository;
import main.java.com.exploreCity.service.CapitalCityService;

public class CapitalCityServiceImpl implements CapitalCityService {

    private final CapitalCityRepository capitalCityRepository;

    public CapitalCityServiceImpl(CapitalCityRepository capitalCityRepository) {
        this.capitalCityRepository = capitalCityRepository;
    }

    @Override
    public CapitalCity getCapitalCityInfo(String capitalCityURI) throws CapitalCityNotFoundException {
        CapitalCity capitalCity = new CapitalCity();
        this.capitalCityRepository.addCapitalCityInfo(capitalCityURI);
        return capitalCity;
    }
}
