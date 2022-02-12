package com.probert999.cinnamon;

import com.probert999.cinnamon.model.Movie;
import com.probert999.cinnamon.testhelper.SeatingPlanStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class MovieTest {

    private String movieId;
    private String movieName;
    private LocalDateTime movieShowTime;
    private SeatingPlanStub dummySeatingPlan;

    @BeforeEach
    public void setup()
    {
        movieId = "Movie-1";
        movieName = "Star Wars";
        dummySeatingPlan = new SeatingPlanStub('A', 2);
        movieShowTime = LocalDateTime.of(2022, 3, 6, 19, 0);
    }

    @Test
    public void shouldBeAbleToCreateANewMovie()
    {
        Movie movie = new Movie(movieId, movieName, movieShowTime, dummySeatingPlan);
        assertNotNull(movie);
    }

    @Test
    public void shouldBeAbleToGetMovieId()
    {
        Movie movie = new Movie(movieId, movieName, movieShowTime, dummySeatingPlan);
        assertEquals(movieId, movie.getMovieId());
    }

    @Test
    public void shouldBeAbleToGetMovieShowTime()
    {
        Movie movie = new Movie(movieId, movieName, movieShowTime, dummySeatingPlan);
        assertEquals(movieShowTime, movie.getShowTime());
    }

    @Test
    public void shouldBeAbleToGetMovieName()
    {
        Movie movie = new Movie(movieId, movieName, movieShowTime, dummySeatingPlan);
        assertEquals(movieName, movie.getMovieName());
    }

    @Test
    public void shouldNotBeAbleToCreateAMovieWithANullMovieId()
    {
        assertThrows(IllegalArgumentException.class, ()-> new Movie(null, movieName, movieShowTime, dummySeatingPlan));
    }

    @Test
    public void shouldNotBeAbleToCreateAMovieWithANullMovieName()
    {
        assertThrows(IllegalArgumentException.class, ()-> new Movie(movieId, null, movieShowTime, dummySeatingPlan));
    }

    @Test
    public void shouldNotBeAbleToCreateAMovieWithANullMovieShowTime()
    {
        assertThrows(IllegalArgumentException.class, ()-> new Movie(movieId, movieName, null, dummySeatingPlan));
    }

    @Test
    public void shouldNotBeAbleToCreateAMovieWithANullSeatingPlan()
    {
        assertThrows(IllegalArgumentException.class, ()-> new Movie(movieId, movieName, movieShowTime, null));
    }

    @Test
    public void shouldBeAbleToGeteatingPlan()
    {
        Movie movie = new Movie(movieId, movieName, movieShowTime, dummySeatingPlan);
        assertEquals(dummySeatingPlan, movie.getSeatingPlan());
    }
}
