package com.tutorial.movies.rest.springboot.movies.test;

import com.tutorial.movies.rest.springboot.movies.MovieService;
import com.tutorial.movies.rest.springboot.movies.MoviesController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@WebMvcTest(controllers = MovieControllerTest.class)
@ActiveProfiles("test")

public class MovieControllerTest {

    private MockMvc mockMvc;
    private MoviesController moviesController;
    private MovieService movieService;
    public MovieControllerTest() {
        movieService = Mockito.mock(MovieService.class);
        moviesController = new MoviesController(movieService);
    }

    @BeforeEach
    public void setUp() {

        this.mockMvc = MockMvcBuilders.standaloneSetup(moviesController)
                .build();
    }
    @Test
    public void successAboutResponse_thenHttp200() throws Exception {
        String expectedResponse = "hello";
        Mockito.doReturn("hello")
                .when(movieService)
                .generalInformation();
        mockMvc.perform(MockMvcRequestBuilders.get("/movie/about"))
                .andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()))
                .andExpect(MockMvcResultMatchers.content().string(expectedResponse));
    }
}
