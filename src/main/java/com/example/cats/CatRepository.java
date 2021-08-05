package com.example.cats;

import org.springframework.data.repository.CrudRepository;

public interface CatRepository extends CrudRepository<Cat, Long> {
}
