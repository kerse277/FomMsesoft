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

    @GetMapping(value = "/findByName")
    @ResponseBody
    public Person findByName (@RequestParam("name") String name) {
        return personBS.findByName(name);
    }

    @GetMapping(value = "/findByFirstDegreeFriend")
    @ResponseBody
    public List<Person> findByFirstDegreeFriend(@RequestParam("name") String name) {
        return personBS.findByFirstDegreeFriend(name);
    }

    @GetMapping(value = "/workNotFriend")
    @ResponseBody
    public List<Person> workNotFriend(@RequestParam("name") String name) {
        return personBS.workNotFriend(name);
    }

    @PostMapping(value = "/insertPerson")
    @ResponseBody
    public Person insertPerson(@RequestBody Person person) {
        return personBS.insertPerson(person);
    }
}
