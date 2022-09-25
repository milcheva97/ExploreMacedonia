package main.java.com.exploreCity.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
import java.util.TreeSet;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ListOfCities {
    String name;

    Set<City> cities = new TreeSet<City>();
}
