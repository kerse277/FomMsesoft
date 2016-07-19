package com.msesoft.fom.repository;

import com.msesoft.fom.domain.Person;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by oguz on 18.06.2016.
 */
public interface PersonRepository extends GraphRepository<Person> {


    @Query("MATCH (o:Person{uniqueId: {uniqueId} })-[:FRIEND]-(p) return p")
    List<Person> findByFirstDegreeFriend(@Param("uniqueId") String uniqueId);

    @Query(" MATCH p=((o:Person{uniqueId: {uniqueId} })-[:WORK]-(n))\n" +
            "    MATCH r=((n)-[:WORK]-(t))\n" +
            "    WHERE NOT (o)-[:FRIEND]-(t) AND NOT o = t\n" +
            "    RETURN t")
    List<Person> workNotFriend(@Param("uniqueId") String person);

    @Query("MATCH (n:Person{uniqueId : {uniqueId} }) DETACH Delete n")
    void deletePerson(String uniqueId);

    @Query("match (n:Person{uniqueId: {uniqueId} })-->(:Person)-->(x:Person)\n" +
            "with n as nNode,x as xNode , count(*) as xCount\n" +
            "where not xNode = nNode and not (nNode)-->(xNode)\n" +
            "return xNode")
    List<Person> secondDegreeFriend(@Param("uniqueId") String uniqueId);

    Person findByEmail(String email);

    Person findByFirstName(String name);

    Person findByUniqueId(String uniqueId);

    Person findByEmailAndPassword(String email,String password);


}






