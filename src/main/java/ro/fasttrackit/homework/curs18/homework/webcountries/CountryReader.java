package ro.fasttrackit.homework.curs18.homework.webcountries;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CountryReader {

    public static List<Country> rCountry(String line) {
        List<Country> result = new ArrayList<>();
        int idNumber = -1;
        String readL;
        Country country;

        try {
            BufferedReader read = new BufferedReader(new FileReader(line));
            while ((readL = read.readLine()) != null) {
                List<String> listNeighbours = new ArrayList<>();
                String[] lineCountry = readL.split("[|~]");
                for (String conty : lineCountry) {
                    if ((conty == conty.toUpperCase()) && (!conty.matches(".*\\d.*"))) {
                        listNeighbours.add(conty);
                    }
                }
                country = new Country(++idNumber,
                        lineCountry[0],
                        lineCountry[1],
                        Long.parseLong(lineCountry[2]),
                        Long.parseLong(lineCountry[3]),
                        lineCountry[4],
                        listNeighbours.equals(new ArrayList<>()) ? new ArrayList<>() : listNeighbours);
                result.add(country);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return result;
    }
}
