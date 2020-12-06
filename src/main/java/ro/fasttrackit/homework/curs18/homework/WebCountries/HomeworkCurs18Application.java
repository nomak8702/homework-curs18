package ro.fasttrackit.homework.curs18.homework.WebCountries;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class HomeworkCurs18Application {

    public static void main(String[] args) throws FileNotFoundException {
        SpringApplication.run(HomeworkCurs18Application.class, args);
    }
}
