package com.msesoft.fom.repository;

import com.msesoft.fom.domain.FriendRelationship;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by kerse on 21.06.2016.
 */
public interface FriendRepository extends GraphRepository<FriendRelationship>, FriendRepositoryCustom {

    @Query("MATCH p=((:Person{name: {person} })-[:FRIEND]-()) return p")
    List<FriendRelationship> findFriendAll(@Param("person") String person);

    @Query("MATCH p=((:Person{name: {person} })-[:FRIEND{friendType: {type} }]-()) return p")
    List<FriendRelationship> findFriendByType(@Param("person") String person, @Param("type") String type);

}