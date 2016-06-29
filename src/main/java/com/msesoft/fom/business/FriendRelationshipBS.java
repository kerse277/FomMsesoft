package com.msesoft.fom.business;

import com.msesoft.fom.repository.FriendRepository;
import com.msesoft.fom.domain.FriendRelationship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by oguz on 23.06.2016.
 */
@Service
public class FriendRelationshipBS {

    @Autowired
    FriendRepository friendRepository;

    public List<FriendRelationship> findFriendAll (String person) {
        return friendRepository.findFriendAll(person);
    }

    public List<FriendRelationship> findFriendByType(String person, String type) {
        return  friendRepository.findFriendByType(person,type);
    }
    public List<FriendRelationship> friendWay(int limit, String startNode, String endNode, int length){
        return friendRepository.friendWay(limit,startNode,endNode,length);
    }

}
