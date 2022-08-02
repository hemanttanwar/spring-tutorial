package com.tutorial.movies.rest.springboot.movies.solutions.ch1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController //COPY FROM BELOW THIS LINE ONLY
public class MoviesController {

    @GetMapping(value = "/about")
    public String generalInformation() {
        return "Movies encyclopedia at your fingertips.";
    }
}
