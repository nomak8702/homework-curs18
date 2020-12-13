package ro.fasttrackit.homework.curs18.homework.webcountries;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class CountryReader {
    private static   int idNumber;

    public static List<Country> rCountry(String text) {

        List<Country> result = new ArrayList<>();
        String line;
        try {
            BufferedReader read = new BufferedReader(new FileReader(text));
            while ((line = read.readLine()) != null) {
                idNumber++;
                result.add(getCountry(line));
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return result;
    }

    private static Country getCountry(String line){

      String[] lineCountry=line.split("[|]");
      Country country;
        List<String> neighbours=new ArrayList<>();
        if(lineCountry.length>5){
            neighbours= listNeighbours(lineCountry[5]);
        }
        country=new Country(idNumber, lineCountry[0],
              lineCountry[1],
              Long.parseLong(lineCountry[2]),
              Long.parseLong(lineCountry[3]),
              lineCountry[4],neighbours);
      
        return country;
    }

    private static List<String> listNeighbours(String neighbours) {
        String[] neighboursList=neighbours.split("[~]");
        List<String> result=new ArrayList<>();
        for(String neig:neighboursList){
            result.add(neig);
        }
        return result;
    }

}
