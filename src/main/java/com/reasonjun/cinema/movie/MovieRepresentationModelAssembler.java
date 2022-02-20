package com.reasonjun.cinema.movie;

import com.reasonjun.cinema.movie.controller.MovieController;
import com.reasonjun.cinema.movie.domain.Movie;
import com.reasonjun.common.SimpleIdentifiableRepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class MovieRepresentationModelAssembler extends SimpleIdentifiableRepresentationModelAssembler<Movie> {

    public MovieRepresentationModelAssembler() {
        super(MovieController.class);
    }
}