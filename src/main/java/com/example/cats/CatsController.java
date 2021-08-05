package com.example.cats;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CatsController {

    private CatService catService;

    public CatsController (CatService catService) {
        this.catService = catService;
    }

    @GetMapping("/api/cat/{id}")
    public Cat getCatById(@PathVariable long id) throws Exception {
        return catService.findById(id);
    }
}
