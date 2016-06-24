package com.msesoft.sample.controller;

import com.msesoft.sample.business.FriendRelationshipBS;
import com.msesoft.sample.relationshipdomain.FriendRelationship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by oguz on 23.06.2016.
 */
@Controller
@RequestMapping("friendRelationShip")
public class FriendRelationShipController {

     @Autowired
     FriendRelationshipBS friendRelationshipBS;


    @PostMapping(value = "/findFriendAll")
    @ResponseBody
    public List<FriendRelationship> findFriendAll (String person) {
        return friendRelationshipBS.findFriendAll(person);
    }

    @PostMapping(value = "/findFriendByType")
    @ResponseBody
    public List<FriendRelationship> findFriendByType(String person, String type) {
        return  friendRelationshipBS.findFriendByType(person,type);
    }
    @PostMapping(value = "/friendWay")
    @ResponseBody
    public List<FriendRelationship> friendWay(int limit, String startNode, String endNode, int length){
        return friendRelationshipBS.friendWay(limit,startNode,endNode,length);
    }


}
