package com.dudaMeneses.wauw_tsiwmb.service;

import com.dudaMeneses.wauw_tsiwmb.entity.FooEntity;
import com.dudaMeneses.wauw_tsiwmb.repository.FooRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FooService {

    private final FooRepository fooRepository;

    public FooService(FooRepository fooRepository) {
        this.fooRepository = fooRepository;
    }

    public List<FooEntity> findAll() {
        List<FooEntity> entities = new ArrayList<>();
        fooRepository.findAll().forEach(entities::add);
        return entities;
    }

    public FooEntity save(FooEntity fooEntity) {
        return fooRepository.save(fooEntity);
    }

    @CacheEvict(value = "foo")
    public void delete(Long id) {
        fooRepository.deleteById(id);
    }

    @Cacheable(value = "foo")
    public FooEntity findById(Long id) {
        return fooRepository.findById(id).orElse(null);
    }
}
