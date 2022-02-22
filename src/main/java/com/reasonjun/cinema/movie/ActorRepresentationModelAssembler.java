package com.reasonjun.cinema.movie;

import com.reasonjun.cinema.movie.controller.ActorController;
import com.reasonjun.cinema.movie.domain.Actor;
import com.reasonjun.common.SimpleIdentifiableRepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class ActorRepresentationModelAssembler extends
    SimpleIdentifiableRepresentationModelAssembler<Actor> {

  public ActorRepresentationModelAssembler() {
    super(ActorController.class);
  }
}