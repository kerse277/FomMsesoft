package com.msesoft.fom.repository;

import com.msesoft.fom.domain.FriendRelationship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.template.Neo4jOperations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FriendRepositoryImpl implements FriendRepositoryCustom {

    private Neo4jOperations neo4jOperations;

    @Autowired
    public FriendRepositoryImpl(Neo4jOperations neo4jTemplate){
        this.neo4jOperations = neo4jTemplate;
    }

    @Override
    public List<FriendRelationship> friendWay(int limit, String startNode, String endNode, int length) {

        String query = "MATCH p=((:Person{uniqueId: {startNode} })-[:FRIEND*1.." + length +"]->(:Person{uniqueId: {endNode} })) return p limit {limit}";

        Map<String,Object> params = new HashMap<>();
        params.put("startNode", startNode);
        params.put("endNode", endNode);
        params.put("limit", limit);

        List<FriendRelationship> list = new ArrayList<FriendRelationship>();

        for (FriendRelationship friendRelationship:neo4jOperations.queryForObjects(FriendRelationship.class,query,params)){
            list.add(friendRelationship);
        }
        return list;
    }
}
