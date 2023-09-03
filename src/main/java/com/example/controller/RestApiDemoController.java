package com.example.controller;

import com.example.domain.model.Coffee;
import com.example.domain.repository.CoffeesRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coffees")
public class RestApiDemoController {


    @Autowired
    private final CoffeesRepository coffeesRepository;


    public RestApiDemoController(CoffeesRepository coffeesRepository) {
        this.coffeesRepository = coffeesRepository;

        this.coffeesRepository.saveAll(List.of(
                new Coffee("Cafe Cereza"),
                new Coffee("Cafe Ganador"),
                new Coffee("Cafe Lareno"),
                new Coffee("Cafe Tres Pontas"))
        );

    }

    //
    @GetMapping
    Iterable<Coffee> getCoffes() {
        return coffeesRepository.findAll();
    }

    @GetMapping("/{id}")
    Optional<Coffee> getCoffeById(@PathVariable String id) {
        return coffeesRepository.findById(id);
    }

    @PostMapping
    Coffee postCoffe(@RequestBody Coffee coffee) {
        return coffeesRepository.save(coffee);
    }

    @PutMapping("/{id}")
    ResponseEntity<Coffee> putCoffe(@PathVariable String id, @RequestBody Coffee coffee) {
        return coffeesRepository.existsById(id) ? new ResponseEntity<>(coffeesRepository.save(coffee),
                HttpStatus.OK) : new ResponseEntity<>(coffeesRepository.save(coffee), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    void deleteCoffe(@PathVariable String id) {
        coffeesRepository.deleteById(id);
    }


}
