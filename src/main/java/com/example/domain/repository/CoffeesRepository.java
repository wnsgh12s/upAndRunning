package com.example.domain.repository;

import com.example.domain.model.Coffee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoffeesRepository extends CrudRepository<Coffee,String> {

}
