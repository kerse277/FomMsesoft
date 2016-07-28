package com.msesoft.fom.controller;

import com.msesoft.fom.domain.CustomPerson;
import com.msesoft.fom.domain.Person;
import com.msesoft.fom.business.PersonBS;
import com.msesoft.fom.domain.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Created by oguz on 22.06.2016.
 */
@Controller
@RequestMapping("person")
public class PersonController {

    @Autowired
    PersonBS personBS;


    @GetMapping(value = "findByFirstName")
    @ResponseBody
    public CustomPerson findByFirstName (@RequestParam("firstName") String name) {
        return personBS.findByFirstName(name);
    }

    @GetMapping(value = "findByFirstDegreeFriend")
    @ResponseBody
    public List<CustomPerson> findByFirstDegreeFriend(@RequestParam("token") String token) {
        return personBS.findByFirstDegreeFriend(token);
    }

    @GetMapping(value = "deletePerson")
    @ResponseBody
    public void deletePerson(@RequestParam("uniqueId") String uniqueId){
         personBS.deletePerson(uniqueId);
    }

    @GetMapping(value = "workNotFriend")
    @ResponseBody
    public List<CustomPerson> workNotFriend(@RequestParam("uniqueId") String uniqueId) {
        return personBS.workNotFriend(uniqueId);
    }

    @PostMapping(value = "signUp")
    @ResponseBody
    public Person insertPerson(@RequestBody Person person) {
     return personBS.insertPerson(person);
    }

    @GetMapping(value = "signIn")
    @ResponseBody
    public Token singIn(@RequestParam("email") String email, @RequestParam("password") String password){

        return personBS.singIn(email, password);
    }

    @GetMapping(value = "updatePhoto")
    @ResponseBody
    public Person updatephoto(){
        return personBS.updatephoto();
    }

    @GetMapping(value = "friendDegree")
    @ResponseBody
    public List<CustomPerson> findDegreeFriend(@RequestParam("token") String token, @RequestParam("degree") String degree, @RequestParam("limit") String limit) {
        return personBS.findDegreeFriend(token,degree,limit);
    }

    @GetMapping(value = "regGCM")
    @ResponseBody
    public void registerGCM(@RequestParam("token") String token,@RequestParam("regId") String regId){

        personBS.registerGCM(token, regId);
    }
    @GetMapping(value = "/findByToken")
    @ResponseBody
    public CustomPerson findByToken(@RequestParam("token") String token){
        return personBS.findByToken(token);
    }

}
