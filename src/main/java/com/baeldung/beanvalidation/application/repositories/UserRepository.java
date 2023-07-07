package com.baeldung.beanvalidation.application.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.baeldung.beanvalidation.application.entities.Uzer;

@Repository
public interface UserRepository extends CrudRepository<Uzer, Long> {}
