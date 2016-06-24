package com.msesoft.sample.controller;

import com.msesoft.sample.business.PersonBS;
import com.msesoft.sample.domain.Person;
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

    @PostMapping(value = "/findByFirstDegreeFriend")
    @ResponseBody
    public List<Person> findByFirstDegreeFriend(String nodeName) {
        return personBS.findByFirstDegreeFriend(nodeName);
    }

    @PostMapping(value = "/workNotFriend")
    @ResponseBody
    public List<Person> workNotFriend(String person) {
        return personBS.workNotFriend(person);
    }
}
