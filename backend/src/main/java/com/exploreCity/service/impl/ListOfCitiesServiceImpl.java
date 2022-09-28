package main.java.com.exploreCity.service.impl;

import main.java.com.exploreCity.model.ListOfCities;
import main.java.com.exploreCity.repository.ListOfCitiesRepository;
import main.java.com.exploreCity.service.ListOfCitiesService;

public class ListOfCitiesServiceImpl implements ListOfCitiesService {

    private final ListOfCitiesRepository listOfCitiesRepository;

    public ListOfCitiesServiceImpl(ListOfCitiesRepository listOfCitiesRepository) {
        this.listOfCitiesRepository = listOfCitiesRepository;
    }

    @Override
    public ListOfCities getListOfCities(String listOfCitiesURI) {
        ListOfCities listOfCities = new ListOfCities();
        this.listOfCitiesRepository.cityName(listOfCitiesURI);
        return listOfCities;
    }
}
