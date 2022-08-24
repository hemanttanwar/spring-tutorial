package com.tutorial.movies.rest.springboot.movies;

import org.springframework.stereotype.Service;

@Service
public class MovieService {

    public String generalInformation() {
        return "Movies encyclopedia at your fingertips.";
    }
}
