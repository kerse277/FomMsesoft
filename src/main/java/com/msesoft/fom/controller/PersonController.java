package com.msesoft.fom.controller;

import com.msesoft.fom.domain.Person;
import com.msesoft.fom.business.PersonBS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by oguz on 22.06.2016.
 */
@Controller
@RequestMapping("person")
public class PersonController {

    @Autowired
    PersonBS personBS;


    @GetMapping(value = "/findByFirstName")
    @ResponseBody
    public Person findByFirstName (@RequestParam("firstName") String name) {
        return personBS.findByFirstName(name);
    }

    @GetMapping(value = "/findByFirstDegreeFriend")
    @ResponseBody
    public List<Person> findByFirstDegreeFriend(@RequestParam("uniqueId") String uniqueId) {
        return personBS.findByFirstDegreeFriend(uniqueId);
    }

    @GetMapping(value = "/deletePerson")
    @ResponseBody
    public Person deletePlaces(@RequestParam("uniqueId") String uniqueId){
        return personBS.deletePerson(uniqueId);
    }

    @GetMapping(value = "/workNotFriend")
    @ResponseBody
    public List<Person> workNotFriend(@RequestParam("uniqueId") String uniqueId) {
        return personBS.workNotFriend(uniqueId);
    }

    @PostMapping(value = "/singUp")
    @ResponseBody
    public Person insertPerson(@RequestBody Person person) {
     return personBS.insertPerson(person);
    }

    @GetMapping(value = "/singIn")
    @ResponseBody
    public Person singIn(@RequestParam("email") String email,@RequestParam("password") String password){
        return personBS.singIn(email, password);
    }

    @GetMapping(value = "/updatePhoto")
    @ResponseBody
    public Person updatephoto(){
        return personBS.updatephoto();
    }

    @GetMapping(value = "/secondDegreeFriend")
    @ResponseBody
    public List<Person> secondDegreeFriend(@RequestParam("uniqueId") String uniqueId) {
        return personBS.secondDegreeFriend(uniqueId);
    }


}
