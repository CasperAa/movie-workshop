package com.example.movieworkshoptemplate.controllers;

import com.example.movieworkshoptemplate.repositories.Movie;
import com.example.movieworkshoptemplate.repositories.ReadFile;
import com.example.movieworkshoptemplate.services.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MovieController{
    //Controller methods
    MovieService movieService = new MovieService();
    public MovieController() throws FileNotFoundException {
    }

    //Task 3.1:
    @GetMapping("/")
    public String index(){
        return "Hello user - Use This application to search for your movie facts <br>" +
                " Options: <br>" +
                "/getFirstMovie <br>"+
                "/getRandomMovie <br>"+
                "/getTenSortByPopularity <br>"+
                "/howManyWonAnAward <br>"+
                "/filter?char=a&amount=1  (insert character (char) and amount of times (amount) <br>"+
                "/longest?g1=Drama&g2=Comedy (insert two genres to compare which one has a longer average length) <br>";
    }

    //Task 3.2:
    @GetMapping("/getFirstMovie")
    public String getFirst(){
        return movieService.getFirstMovie();
    }

    //Task 3.3:
    @GetMapping("/getRandomMovie")
    public String getRandomMovie() throws FileNotFoundException{
        MovieService ms3_3 = new MovieService();
        return ms3_3.getRandomMovie();
    }

    //Task 3.4:
    @GetMapping("/getTenSortByPopularity")
    public String getTenSortByPopularity(){
        return movieService.getTenSortByPopularity();
    }

    //Task 3.5:
    @GetMapping("/howManyWonAnAward")
    public String howManyWonAnAward(){
        return movieService.HowManyWonAnAward();
    }


    // Task 3.6- Amanda
    ///filter?char=’x’amount=’n’
    // Eksempel: http://localhost:8080/filter?char=a&amount=1
    @GetMapping("/filter")
    public String filterMovies(@RequestParam("char") char c, @RequestParam("amount") int n)
            throws FileNotFoundException{
        return movieService.filterMovies(c,n);
    }


    //Task 3.7: - Amanda
    // Eksempel: http://localhost:8080/longest?g1=Drama&g2=Comedy
    @GetMapping("/longest")
    public String compareGenreLength(@RequestParam("g1") String g1, @RequestParam("g2") String g2){
        return movieService.compareGenreLength(g1, g2);
    }

}
