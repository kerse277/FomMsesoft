package com.msesoft.fom.controller;

import com.msesoft.fom.business.PlacesBS;
import com.msesoft.fom.domain.Person;
import com.msesoft.fom.domain.Places;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("places")
public class PlacesController {

    @Autowired
    PlacesBS placesBS;

    @GetMapping
    @ResponseBody
    public List<Places> listAll() {
        return placesBS.listAll();
    }

    @GetMapping(value = "getName")
    @ResponseBody
    public Places findByName(@RequestParam("name") String name) {

        return placesBS.findByName(name);
    }

    @GetMapping(value = "getId")
    @ResponseBody
    public Places place(@RequestParam("id") Long id) {
        return placesBS.findOne(id);
    }

    @PostMapping(value = "update")
    @ResponseBody
    public Places update(@RequestParam("id") Long id, @RequestParam("name") String name,@RequestParam("type") String type) {
        return placesBS.update(id, name,type);
    }

    @PostMapping(value = "insert")
    @ResponseBody
    public Places place(@RequestBody Places place) {
        return placesBS.dbInsert(place);
    }

    @GetMapping(value = "listNode")
    @ResponseBody
    public List<Person> listWorkAllNode(@RequestParam("placeNeme") String placeName){
        return placesBS.listWorkAllNode(placeName);
    }

    @GetMapping(value = "findType")
    @ResponseBody
    public List<Places> findByType(@RequestParam("type") String type){
        return placesBS.findByType(type);
    }

    @GetMapping(value = "personWorkSearch")
    @ResponseBody
    public Places findByType(@RequestParam("id") Long id){
        return placesBS.workSearch(id);
    }

}
