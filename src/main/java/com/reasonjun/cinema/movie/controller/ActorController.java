package com.reasonjun.cinema.movie.controller;


import com.reasonjun.cinema.movie.ActorRepresentationModelAssembler;
import com.reasonjun.cinema.movie.domain.Actor;
import com.reasonjun.cinema.movie.repository.ActorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ActorController {

    private final ActorRepository repository;
    private final ActorRepresentationModelAssembler assembler;

    @GetMapping("/actors")
    public ResponseEntity<CollectionModel<EntityModel<Actor>>> findAll() {
        return ResponseEntity.ok(
            assembler.toCollectionModel(repository.findAll()));
    }

    @GetMapping("/actors/{id}")
    public ResponseEntity<EntityModel<Actor>> findOne(@PathVariable int id) {
        return repository.findById(id)
            .map(assembler::toModel)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
}
