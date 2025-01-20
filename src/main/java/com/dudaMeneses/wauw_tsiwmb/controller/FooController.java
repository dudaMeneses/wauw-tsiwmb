package com.dudaMeneses.wauw_tsiwmb.controller;

import com.dudaMeneses.wauw_tsiwmb.entity.FooEntity;
import com.dudaMeneses.wauw_tsiwmb.service.FooService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/foos")
public class FooController {

    private final FooService fooService;

    public FooController(FooService fooService) {
        this.fooService = fooService;
    }

    @GetMapping
    public List<FooEntity> findAll() {
        return fooService.findAll();
    }

    @GetMapping("/{id}")
    public FooEntity findById(Long id) {
        return fooService.findById(id);
    }

    @PostMapping
    public FooEntity save(FooEntity fooEntity) {
        return fooService.save(fooEntity);
    }

    @DeleteMapping
    public void delete(Long id) {
        fooService.delete(id);
    }
}
