package com.dudaMeneses.wauw_tsiwmb.repository;

import com.dudaMeneses.wauw_tsiwmb.entity.FooEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FooRepository extends CrudRepository<FooEntity, Long> {
}
