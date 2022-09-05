package com.example.restintro.service;

import java.util.Optional;
import java.util.Set;
// ikke nødvendig men lettere hvis større projekt
public interface CrudService<T, ID> {
    Set<T> findAll();
    T save(T object);
    void delete(T object);
    void deleteById(ID id);
    Optional<T> findById(ID id);
}