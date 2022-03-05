package com.reasonjun.cinema.actor.controller;

import static com.reasonjun.cinema.domain.Sex.FEMALE;
import static com.reasonjun.cinema.domain.Sex.MALE;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.reasonjun.cinema.movie.ActorRepresentationModelAssembler;
import com.reasonjun.cinema.movie.controller.ActorController;
import com.reasonjun.cinema.movie.domain.Actor;
import com.reasonjun.cinema.movie.repository.ActorRepository;
import java.util.Arrays;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.HttpHeaders;
import org.springframework.test.web.servlet.MockMvc;


@WebMvcTest(ActorController.class)
@Import({ActorRepresentationModelAssembler.class})
public class ActorControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private ActorRepository repository;

  @Test
  void findAll() throws Exception {
    given(repository.findAll()).willReturn(
        Arrays.asList(
            Actor.builder()
                .id(1)
                .brdt("19870222")
                .engFlnm("HanHyojoo")
                .frgnrYn('N')
                .kornFlnm("한효주")
                .sex(FEMALE)
                .build(),
            Actor.builder()
                .id(2)
                .brdt("19881216")
                .engFlnm("")
                .frgnrYn('N')
                .kornFlnm("박서준")
                .sex(MALE)
                .build()));

    mockMvc.perform(get("/actors").accept(MediaTypes.HAL_JSON_VALUE))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(header().string(HttpHeaders.CONTENT_TYPE, MediaTypes.HAL_JSON_VALUE))
        .andExpect(jsonPath("$._embedded.actors[0].id", is(1)))
        .andExpect(jsonPath("$._embedded.actors[0].brdt", is("19870222")))
        .andExpect(jsonPath("$._embedded.actors[0].engFlnm", is("HanHyojoo")))
        .andExpect(jsonPath("$._embedded.actors[0].frgnrYn", is("N")))
        .andExpect(jsonPath("$._embedded.actors[0].kornFlnm", is("한효주")))
        .andExpect(jsonPath("$._embedded.actors[0].sex", is(FEMALE.name())))
        .andExpect(
            jsonPath("$._embedded.actors[0]._links.self.href", is("http://localhost/actors/1")))
        .andExpect(
            jsonPath("$._embedded.actors[0]._links.actors.href", is("http://localhost/actors")))
        .andExpect(jsonPath("$._embedded.actors[1].id", is(2)))
        .andExpect(jsonPath("$._embedded.actors[1].brdt", is("19881216")))
        .andExpect(jsonPath("$._embedded.actors[1].engFlnm", is("")))
        .andExpect(jsonPath("$._embedded.actors[1].frgnrYn", is("N")))
        .andExpect(jsonPath("$._embedded.actors[1].kornFlnm", is("박서준")))
        .andExpect(jsonPath("$._embedded.actors[1].sex", is(MALE.name())))
        .andExpect(
            jsonPath("$._embedded.actors[1]._links.self.href", is("http://localhost/actors/2")))
        .andExpect(
            jsonPath("$._embedded.actors[1]._links.actors.href", is("http://localhost/actors")))
        .andExpect(jsonPath("$._links.self.href", is("http://localhost/actors")))
        .andReturn();
  }

  @Test
  void findById() throws Exception {
    given(repository.findById(any())).willReturn(
        Optional.of(
            Actor.builder()
                .id(1)
                .brdt("19870222")
                .engFlnm("HanHyojoo")
                .frgnrYn('N')
                .kornFlnm("한효주")
                .sex(FEMALE)
                .build()));

    mockMvc.perform(get("/actors/1").accept(MediaTypes.HAL_JSON_VALUE))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(header().string(HttpHeaders.CONTENT_TYPE, MediaTypes.HAL_JSON_VALUE))
        .andExpect(jsonPath("$.id", is(1)))
        .andExpect(jsonPath("$.brdt", is("19870222")))
        .andExpect(jsonPath("$.engFlnm", is("HanHyojoo")))
        .andExpect(jsonPath("$.frgnrYn", is("N")))
        .andExpect(jsonPath("$.kornFlnm", is("한효주")))
        .andExpect(jsonPath("$.sex", is(FEMALE.name())))
        .andExpect(jsonPath("$._links.self.href", is("http://localhost/actors/1")))
        .andExpect(jsonPath("$._links.actors.href", is("http://localhost/actors")))
        .andReturn();
  }
}