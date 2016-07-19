package com.msesoft.fom.controller;

import com.msesoft.fom.business.FriendRelationshipBS;
import com.msesoft.fom.domain.FriendRelationship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by oguz on 23.06.2016.
 */
@Controller
@RequestMapping("friendRelationShip")
public class FriendController {

     @Autowired
     FriendRelationshipBS friendRelationshipBS;


    @GetMapping(value = "/findFriendAll")
    @ResponseBody
    public List<FriendRelationship> findFriendAll (@RequestParam("person") String person) {
        return friendRelationshipBS.findFriendAll(person);
    }

    @GetMapping(value = "/findFriendByType")
    @ResponseBody
    public List<FriendRelationship> findFriendByType(@RequestParam("person") String person,@RequestParam("type") String type) {
        return  friendRelationshipBS.findFriendByType(person,type);
    }
    @GetMapping(value = "/friendWay")
    @ResponseBody
    public List<FriendRelationship> friendWay(@RequestParam("limit") int limit,@RequestParam("startNode") String startNode,@RequestParam("endNode") String endNode,@RequestParam("length") int length){
        return friendRelationshipBS.friendWay(limit,startNode,endNode,length);
    }

    @PostMapping(value = "/saveFriend")
    @ResponseBody
    public FriendRelationship saveFriend(@RequestBody FriendRelationship friendRelationship){
        return friendRelationshipBS.saveFriend(friendRelationship);
    }
    @GetMapping(value = "/deleteFriend")
    @ResponseBody
    public void deleteFriend(@RequestParam("id") Long id) {
        friendRelationshipBS.deleteFriend(id);
    }


}
