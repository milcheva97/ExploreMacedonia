package main.java.com.exploreCity.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class City implements Comparable<City> {
    String name;

    @Override
    public int compareTo(City o) {
        if(this.name != null && o.name != null) {
            return this.name.compareTo(o.name);
        }
        return 1;
    }
}
