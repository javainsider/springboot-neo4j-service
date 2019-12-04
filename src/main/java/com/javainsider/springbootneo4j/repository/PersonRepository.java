package com.javainsider.springbootneo4j.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import com.javainsider.springbootneo4j.model.Person;

public interface PersonRepository extends Neo4jRepository<Person, Long> {

	Person findByName(String name);

}