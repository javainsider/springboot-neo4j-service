package com.javainsider.springbootneo4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@SpringBootApplication
@EnableNeo4jRepositories("com.javainsider.springbootneo4j.repository")
public class SpringbootNeo4jApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootNeo4jApplication.class, args);
	}

}
