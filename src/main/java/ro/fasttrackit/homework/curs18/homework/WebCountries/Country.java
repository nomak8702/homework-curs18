package ro.fasttrackit.homework.curs18.homework.WebCountries;

import java.io.Serializable;
import java.util.*;

public class Country {

    private final int id;
    private final String name;
    private final String capital;
    private final long population;
    private final long area;
    private final String continent;
    private final List<String> neighbours;

    public Country(int id, String name, String capital, long population, long area,
                   String continent, List<String> neighbours) {
        this.id = id;
        this.name = name;
        this.capital = capital;
        this.population = population;
        this.area = area;
        this.continent = continent;
        this.neighbours = neighbours;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCapital() {
        return capital;
    }

    public long getPopulation() {
        return population;
    }

    public long getArea() {
        return area;
    }

    public String getContinent() {
        return continent;
    }

    public List<String> getNeighbours() {
        return Collections.unmodifiableList(neighbours);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return id == country.id && population == country.population && area == country.area
                && name.equals(country.name) && capital.equals(country.capital)
                && continent.equals(country.continent) && neighbours.equals(country.neighbours);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, capital, population, area, continent, neighbours);
    }

    @Override
    public String toString() {
        var vid = neighbours;
        Serializable epty = vid.size() > 0 ? "neighbours" + vid : "";
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", capital='" + capital + '\'' +
                ", population=" + population +
                ", area=" + area +
                ", continent='" + continent + '\'' + " " +
                epty +
                '}' + '\n';
    }
}


