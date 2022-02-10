package com.probert999.cinnamon;

import com.probert999.cinnamon.model.Cinema;
import com.probert999.cinnamon.model.Movie;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CinemaTest {

    @Test
    public void shouldBeAbleToCreateANewCinema()
    {
        String cinemaName = "Cinnamon Cinema";
        Cinema cinema = new Cinema(cinemaName);
        assertEquals(cinemaName, cinema.getName());
    }

    @Test
    public void shouldBeAbleToAddAMovie()
    {
        String movieName = "Star Wars";
        String movieId = "Movie-1";
        Cinema cinema = new Cinema("Test Cinema");
        LocalDateTime movieShowTime = LocalDateTime.of(2021, 3, 6, 19, 00);
        cinema.addMovie(movieName, movieShowTime);

        List<Movie> movies = cinema.getMovieList();
        assertEquals(movieId, movies.get(0).getMovieId());
        assertEquals(movieName, movies.get(0).getMovieName());
        assertEquals(movieShowTime, movies.get(0).getShowTime());
    }

    @Test
    public void shouldBeAbleToAddMoreThanOneMovie()
    {
        String movieName1 = "Star Wars";
        String movieName2 = "Empire Strikes Back";
        String movieId2 = "Movie-2";
        Cinema cinema = new Cinema("Test Cinema");
        LocalDateTime movieShowTime = LocalDateTime.of(2021, 3, 6, 19, 00);
        cinema.addMovie(movieName1, movieShowTime);
        cinema.addMovie(movieName2, movieShowTime);

        List<Movie> movies = cinema.getMovieList();
        assertEquals(movieId2, movies.get(1).getMovieId());
        assertEquals(movieName2, movies.get(1).getMovieName());
        assertEquals(movieShowTime, movies.get(1).getShowTime());
    }


}
