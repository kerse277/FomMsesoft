package com.msesoft.sample.business;

import com.msesoft.sample.relationshipdomain.WorkRelationship;
import com.msesoft.sample.repository.WorkRelationshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkRelationshipBS {

    @Autowired
    WorkRelationshipRepository workRelationshipRepository;

    public WorkRelationship findNodeWorkType(Long id){

        return workRelationshipRepository.findNodeWorkType(id);

    }

    public List<WorkRelationship> findNodeWorkTypeForPlace(String placeName,String workType){

        return workRelationshipRepository.findNodeWorkTypeForPlace(placeName,workType);

    }

    public List<WorkRelationship> findByWorkType(String type){

        return workRelationshipRepository.findByWorkType(type);

    }

}
