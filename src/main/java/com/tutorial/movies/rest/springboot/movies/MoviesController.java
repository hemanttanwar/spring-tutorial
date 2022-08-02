package com.tutorial.movies.rest.springboot.movies;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movie")
public class MoviesController {
    MovieService movieService;
    public MoviesController(MovieService ms) {
        this.movieService = ms;
    }

    @GetMapping(value = "/about")
    public String generalInformation() {
        return movieService.generalInformation();
    }

    /** This will add GET end point.
     * Given a integer id, it will return corresponding movie detail in json.
     * */
    @GetMapping(value = "/{id}")
    public ResponseEntity<Movie> getMovieData(@PathVariable("id") Integer id) {
        System.out.println("Received Movie ID:" + id);
        return new ResponseEntity<>( moviesArray[id-1], HttpStatus.OK);
    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<Movie> updateMovieData(@PathVariable("movie") Integer id) {
        System.out.println("Received Movie ID:" + id);
        return new ResponseEntity<>( moviesArray[id-1], HttpStatus.CREATED);
    }

    /**
     * This is list of the movies which our syatem will maintain as in memory database.
     * @return array of movies.
     */
    private static Movie[] moviesArray = new Movie[] {
            new Movie(1,"STAR WARS: EPISODE I -- THE PHANTOM MENACE", 1999,
                    "Liam Neeson, Ewan McGregor, Natalie Portman, Jake Lloyd"),
            new Movie(2,"STAR WARS: EPISODE II -- ATTACK OF THE CLONES", 2002,
                    "Ewan McGregor, Natalie Portman, Hayden Christensen, Christopher Lee"),
            new Movie(3,"STAR WARS: EPISODE III -- REVENGE OF THE SITH", 2005,
                    "Ewan McGregor, Natalie Portman, Hayden Christensen, Ian McDiarmid"),
            new Movie(4,"SOLO: A STAR WARS STORY", 2018,
                    "Alden Ehrenreich, Emilia Clarke, Donald Glover, Woody Harrelson")
    };
}