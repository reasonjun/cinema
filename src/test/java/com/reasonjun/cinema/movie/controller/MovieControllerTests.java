package com.reasonjun.cinema.movie.controller;

import com.reasonjun.cinema.movie.MovieRepresentationModelAssembler;
import com.reasonjun.cinema.movie.domain.Movie;
import com.reasonjun.cinema.movie.repository.MovieRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.HttpHeaders;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Optional;

import static com.reasonjun.cinema.movie.enums.MovieGrade.OVER_FIFTEEN_YEAR_OLD_ALLOWED;
import static com.reasonjun.cinema.movie.enums.MovieGrade.OVER_TWELVE_YEAR_OLD_ALLOWED;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(MovieController.class)
@AutoConfigureMockMvc
@Import({MovieRepresentationModelAssembler.class})
class MovieControllerTests {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private MovieRepository repository;

    @Test
    void findAll() throws Exception {
        given(repository.findAll()).willReturn(
                Arrays.asList(
                        Movie.builder()
                                .id(1)
                                .movieGrade(OVER_TWELVE_YEAR_OLD_ALLOWED)
                                .ttlNm("뷰티 인사이드")
                                .releaseYmd("20150820")
                                .runningHr("020700")
                                .build(),
                        Movie.builder()
                                .id(2)
                                .movieGrade(OVER_FIFTEEN_YEAR_OLD_ALLOWED)
                                .ttlNm("기생충")
                                .releaseYmd("20190530")
                                .runningHr("021100")
                                .build()));

        mvc.perform(get("/movies").accept(MediaTypes.HAL_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(header().string(HttpHeaders.CONTENT_TYPE, MediaTypes.HAL_JSON_VALUE))
                .andExpect(jsonPath("$._embedded.movies[0].id", is(1)))
                .andExpect(jsonPath("$._embedded.movies[0].movieGrade", is(OVER_TWELVE_YEAR_OLD_ALLOWED.getCode())))
                .andExpect(jsonPath("$._embedded.movies[0].ttlNm", is("뷰티 인사이드")))
                .andExpect(jsonPath("$._embedded.movies[0].releaseYmd", is("20150820")))
                .andExpect(jsonPath("$._embedded.movies[0].runningHr", is("020700")))
                .andExpect(jsonPath("$._embedded.movies[0]._links.self.href", is("http://localhost/movies/1")))
                .andExpect(jsonPath("$._embedded.movies[0]._links.movies.href", is("http://localhost/movies")))
                .andExpect(jsonPath("$._embedded.movies[1].id", is(2)))
                .andExpect(jsonPath("$._embedded.movies[1].movieGrade", is(OVER_FIFTEEN_YEAR_OLD_ALLOWED.getCode())))
                .andExpect(jsonPath("$._embedded.movies[1].ttlNm", is("기생충")))
                .andExpect(jsonPath("$._embedded.movies[1].releaseYmd", is("20190530")))
                .andExpect(jsonPath("$._embedded.movies[1].runningHr", is("021100")))
                .andExpect(jsonPath("$._embedded.movies[1]._links.self.href", is("http://localhost/movies/2")))
                .andExpect(jsonPath("$._embedded.movies[1]._links.movies.href", is("http://localhost/movies")))
                .andExpect(jsonPath("$._links.self.href", is("http://localhost/movies")))
                .andReturn();
    }

    @Test
    void findOne() throws Exception {
        given(repository.findById(any())).willReturn(
                Optional.of(
                        Movie.builder()
                                .id(1)
                                .movieGrade(OVER_TWELVE_YEAR_OLD_ALLOWED)
                                .ttlNm("뷰티 인사이드")
                                .releaseYmd("20150820")
                                .runningHr("020700")
                                .build()));

        mvc.perform(get("/movies/1").accept(MediaTypes.HAL_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(header().string(HttpHeaders.CONTENT_TYPE, MediaTypes.HAL_JSON_VALUE))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.movieGrade", is(OVER_TWELVE_YEAR_OLD_ALLOWED.getCode())))
                .andExpect(jsonPath("$.ttlNm", is("뷰티 인사이드")))
                .andExpect(jsonPath("$.releaseYmd", is("20150820")))
                .andExpect(jsonPath("$.runningHr", is("020700")))
                .andExpect(jsonPath("$._links.self.href", is("http://localhost/movies/1")))
                .andExpect(jsonPath("$._links.movies.href", is("http://localhost/movies")))
                .andReturn();
    }
}