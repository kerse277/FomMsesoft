package com.msesoft.sample.repository;


import com.msesoft.sample.relationshipdomain.WorkRelationship;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by kerse on 21.06.2016.
 */
public interface WorkRelationshipRepository extends GraphRepository<WorkRelationship> {


    List<WorkRelationship> findByWorkType(String workType);

    @Query("MATCH p =((:Place {name: {placeName} })-[x:WORK {workType: {workType} }]-()) return x")
    List<WorkRelationship> findNodeWorkTypeForPlace(@Param("placeName") String placeName, @Param("workType") String workType);

    @Query("MATCH p =((:Person {id: {id} })-[x:WORK]-()) return x")
    WorkRelationship findNodeWorkType(@Param("id") Long nodeName);

}

