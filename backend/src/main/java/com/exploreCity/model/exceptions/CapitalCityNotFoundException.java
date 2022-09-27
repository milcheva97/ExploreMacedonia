package main.java.com.exploreCity.model.exceptions;

public class CapitalCityNotFoundException extends Exception{

    public CapitalCityNotFoundException (String capitalCity){
        super(capitalCity + " not found");
    }
}
