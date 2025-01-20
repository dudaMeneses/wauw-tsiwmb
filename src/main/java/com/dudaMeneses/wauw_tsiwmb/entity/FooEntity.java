package com.dudaMeneses.wauw_tsiwmb.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "foo")
public record FooEntity(
    @Id Long id,
    String name
) {}
