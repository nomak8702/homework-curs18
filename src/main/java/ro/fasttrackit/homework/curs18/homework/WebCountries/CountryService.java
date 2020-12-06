package ro.fasttrackit.homework.curs18.homework.WebCountries;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

@Service
public class CountryService {

    private List<Country> countries;

    public CountryService() {
        this.countries = new ArrayList<>();
        try {
            countries = CountryReader.rCountry("file/countries.txt");
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Country> getAllCountryes() {
        return countries;
    }

    public List<String> getNames() {
        return countries.stream()
                .map(Country::getName)
                .collect(toList());
    }

    public Optional<String> getCapital(int id) {
        return countries.stream()
                .filter(c -> c.getId() == id)
                .map(Country::getCapital)
                .findFirst();
    }

    public Optional<Long> getPopulation(int id) {
        return countries.stream()
                .filter(c -> c.getId() == id)
                .map(Country::getPopulation)
                .findFirst();
    }

    public Stream<Object> getCountryOnContinent(String continent) {
        return countries.stream()
                .filter(c -> c.getContinent().equalsIgnoreCase(continent))
                .flatMap(c -> Stream.of(c.getId(), c.getName(), c.getCapital(),
                        c.getPopulation(), c.getArea(), c.getContinent(), c.getNeighbours()))
                .distinct();
    }

    public List<List<String>> getNeighbours(int id) {
        return countries.stream()
                .filter(c -> c.getId() == id)
                .map(c -> c.getNeighbours())
                .collect(toList());
    }

    public Stream<Object> getCountriespopulation(long population) {
        return countries.stream()
                .filter(c -> c.getPopulation() > population)
                .flatMap(c -> Stream.of(c.getId(), c.getName(), c.getCapital(),
                        c.getPopulation(), c.getArea(), c.getContinent(), c.getNeighbours()))
                .distinct();
    }

    public List<Country> getCountryThanNeighbours(String neighbour1, String neighbour2) {

        List<Country> result = new ArrayList<>();
        for (Country ctry : countries) {
            if (ctry.getNeighbours().contains(neighbour1) && !ctry.getNeighbours().contains(neighbour2)) {
                result.add(ctry);
            }
        }
        return result.size() > 0 ? result : new ArrayList<>();
    }

    public Map<String, Long> getPopulationCountry(String country) {
        return countries.stream()
                .filter(c -> c.getName().equalsIgnoreCase(country))
                .collect(toMap(Country::getName, Country::getPopulation));
    }

    public Map<String, List<Country>> getCountriesContinent(String continent) {
        return countries.stream()
                .filter(c -> c.getContinent().equalsIgnoreCase(continent))
                .collect(groupingBy(Country::getContinent));

    }
}
