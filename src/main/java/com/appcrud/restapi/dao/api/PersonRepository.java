package com.appcrud.restapi.dao.api;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.appcrud.restapi.model.Person;

public interface PersonRepository extends MongoRepository<Person, String> {}
