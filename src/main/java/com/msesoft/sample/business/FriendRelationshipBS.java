package com.msesoft.sample.business;

import com.msesoft.sample.relationshipdomain.FriendRelationship;
import com.msesoft.sample.repository.FriendRelationshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by oguz on 23.06.2016.
 */
@Service
public class FriendRelationshipBS {

    @Autowired
    FriendRelationshipRepository friendRelationshipRepository;

    public List<FriendRelationship> findFriendAll (String person) {
        return friendRelationshipRepository.findFriendAll(person);
    }

    public List<FriendRelationship> findFriendByType(String person, String type) {
        return  friendRelationshipRepository.findFriendByType(person,type);
    }
    public List<FriendRelationship> friendWay(int limit, String startNode, String endNode, int length){
        return friendRelationshipRepository.friendWay(limit,startNode,endNode,length);
    }

}
