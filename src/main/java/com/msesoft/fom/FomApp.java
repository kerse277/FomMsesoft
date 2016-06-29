package com.msesoft.fom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.msesoft.fom.mongo")
@EnableNeo4jRepositories(basePackages = "com.msesoft.fom.neo")
public class FomApp {

	public static void main(String[] args) {
		SpringApplication.run(FomApp.class, args);
	}
}
