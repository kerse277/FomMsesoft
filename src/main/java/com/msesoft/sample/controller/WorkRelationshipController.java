package com.msesoft.sample.controller;


import com.msesoft.sample.business.WorkRelationshipBS;
import com.msesoft.sample.relationshipdomain.WorkRelationship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("workrelationship")
public class WorkRelationshipController {

    @Autowired
    WorkRelationshipBS workRelationshipBS;

    @GetMapping(value = "workType")
    @ResponseBody
    public WorkRelationship findNodeWorkType(@RequestParam("id") Long id) {
        return workRelationshipBS.findNodeWorkType(id);
    }

    @GetMapping(value = "workTypePlace")
    @ResponseBody
    public List<WorkRelationship> findNodeWorkTypeForPlace(@RequestParam("placeName") String placeName,@RequestParam("workType") String workType){
        return workRelationshipBS.findNodeWorkTypeForPlace(placeName, workType);
    }

    @GetMapping(value = "findWorkType")
    @ResponseBody
    public List<WorkRelationship> findByWorkType(@RequestParam("workType") String workType){
        return workRelationshipBS.findByWorkType(workType);
    }

}
