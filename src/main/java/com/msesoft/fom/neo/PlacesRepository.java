package com.msesoft.fom.neo;


import com.msesoft.fom.domain.Person;
import com.msesoft.fom.domain.Places;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface PlacesRepository extends GraphRepository<Places> {


    List<Places> findByType(String type);

    @Query("MATCH p=((:Person{id: {id} })-[:WORK]-(r)) return r")
    Places workSearch(@Param("id") Long id);

    @Query("MATCH p =((:Places {name: {nodeName} })-[:WORK]-(n)) return n")
    List<Person> findWorkAllNode(@Param("nodeName") String place);

    Places findByName(String name);
}
