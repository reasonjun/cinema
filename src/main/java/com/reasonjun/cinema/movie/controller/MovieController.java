package com.reasonjun.cinema.movie.controller;


import com.reasonjun.cinema.movie.MovieRepresentationModelAssembler;
import com.reasonjun.cinema.movie.domain.Movie;
import com.reasonjun.cinema.movie.repository.MovieRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MovieController {

  private final MovieRepository repository;
  private final MovieRepresentationModelAssembler assembler;

  @GetMapping("/movies")
  public ResponseEntity<CollectionModel<EntityModel<Movie>>> findAll() {
    List<Movie> movies = this.repository.findAll();
    System.out.println("movies = " + movies);


    /*
    List<EntityModel<Employee>> employeeResources = StreamSupport.stream(repository.findAll().spliterator(), false)
  				.map(employee -> EntityModel.of(employee,
  						linkTo(methodOn(EmployeeController.class).findOne(employee.getId())).withSelfRel()
  								.andAffordance(afford(methodOn(EmployeeController.class).updateEmployee(null, employee.getId())))
  								.andAffordance(afford(methodOn(EmployeeController.class).deleteEmployee(employee.getId()))),
  						linkTo(methodOn(EmployeeController.class).findAll()).withRel("employees")))
  				.collect(Collectors.toList());

  		return ResponseEntity.ok(CollectionModel.of( //
  				employeeResources, //
  				linkTo(methodOn(EmployeeController.class).findAll()).withSelfRel()
  						.andAffordance(afford(methodOn(EmployeeController.class).newEmployee(null)))));
    */

    return ResponseEntity.ok(
        assembler.toCollectionModel(repository.findAll()));
  }

  @GetMapping("/movies/{id}")
  public ResponseEntity<EntityModel<Movie>> findOne(@PathVariable int id) {
    return repository.findById(id)
        .map(assembler::toModel)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }
}