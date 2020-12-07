package ro.fasttrackit.homework.curs18.homework.webcountries;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

@RestController
@RequestMapping
public class CountryController {
    private final CountryService countryService;


    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/countries")
    public List<Country> getAllCountries() {
        return countryService.getAllCountryes();
    }

    @GetMapping("/countries/names")
    public List<String> getAllNames() {
        return countryService.getNames();
    }

    @GetMapping("/countries/{id}/capital")
    public String getCapital(@PathVariable int id) {
        return countryService.getCapital(id).orElse("Not find!");
    }

    @GetMapping("/countries/{id}/population")
    public Optional<Long> getPopulation(@PathVariable int id) {
        return countryService.getPopulation(id);
    }

    @GetMapping("/countries/{continent}/countries")

    public List<Country> getCountriesOnContinent(@PathVariable String continent) {

        return countryService.getCountryOnContinent(continent);
    }

    @GetMapping("/country/{id}")

    public Optional<List<List<String>>> getneighboursCountry(@PathVariable int id) {
        return Optional.ofNullable(countryService.getNeighbours(id));
    }

    @GetMapping("/countries/{population}")

    public Optional<Stream<Object>> getCountriesPopulation(@PathVariable long population) {
        return Optional.ofNullable(countryService.getCountriespopulation(population));
    }

    @GetMapping("/countries/{neighbour1}/{neighbour2}")

    public List<Country> getCountryThanNeighbours(@PathVariable String neighbour1,
                                                            @PathVariable String neighbour2) {
        return countryService.getCountryThanNeighbours(neighbour1, neighbour2);
    }

    @GetMapping("/population/{country}")

    public Optional<Map<String, Long>> getPopulationCountry(@PathVariable String country) {

        return Optional.ofNullable(countryService.getPopulationCountry(country));
    }

    @GetMapping("/{continent}/countries")

    public Map<String, List<Country>> getCountriesContinent(@PathVariable String continent) {
        return countryService.getCountriesContinent(continent);
    }
}
