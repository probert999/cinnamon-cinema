package com.probert999.cinnamon;

import com.probert999.cinnamon.model.Movie;
import com.probert999.cinnamon.testhelper.SeatingPlanDummy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieTest {


    @Test
    public void shouldBeAbleToCreateANewMovie()
    {
        String movieId = "Movie-1";
        String movieName = "Star Wars";
        SeatingPlanDummy dummySeatingPlan = new SeatingPlanDummy();
        LocalDateTime movieShowTime = LocalDateTime.of(2021, 3, 6, 19, 00);

        Movie movie = new Movie(movieId, movieName, movieShowTime, dummySeatingPlan);

        assertEquals(movieId, movie.getMovieId());
        assertEquals(movieName, movie.getMovieName());
        assertEquals(movieShowTime, movie.getShowTime());
    }
}
