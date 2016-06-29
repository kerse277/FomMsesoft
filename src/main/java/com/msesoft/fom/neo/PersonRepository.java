package com.msesoft.fom.neo;

import com.msesoft.fom.domain.Person;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by oguz on 18.06.2016.
 */
public interface PersonRepository extends GraphRepository<Person> {

    Person findByName(String name);

    @Query("MATCH p=((o:Person{name: {nodeName} })-[:FRIEND]-()) return p")
    List<Person> findByFirstDegreeFriend(@Param("nodeName") String nodeNames);

    @Query(" MATCH p=((o:Person{name: {person} })-[:WORK]-(n))\n" +
            "    MATCH r=((n)-[:WORK]-(t))\n" +
            "    WHERE NOT (o)-[:FRIEND]-(t) AND NOT o = t\n" +
            "    RETURN t")
    List<Person> workNotFriend(@Param("person") String person);

    Person save(Person person);

}






