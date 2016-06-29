package com.msesoft.fom.business;

import com.msesoft.fom.domain.Person;
import com.msesoft.fom.domain.Places;
import com.msesoft.fom.neo.PlacesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlacesBS {

    @Autowired
    PlacesRepository placesRepository;

    public List<Places> listAll(){

       return (List<Places>) placesRepository.findAll();

    }

    public List<Person> listWorkAllNode(String place){

        return placesRepository.findWorkAllNode(place);
    }

    public Places findOne(Long id){

        return placesRepository.findOne(id);

    }

    public List<Places> findByType(String type){

        return placesRepository.findByType(type);

    }

    public Places workSearch(Long id){

        return placesRepository.workSearch(id);

    }


    public Places findByName(String name) {

        return placesRepository.findByName(name);
    }

    public Places update(Long id,String name,String type){

        Places place = new Places();

        place = placesRepository.findOne(id);

        place.setName(name)
             .setType(type);

        placesRepository.save(place);

        return place;
    }

    public Places dbInsert(Places place) {

        return placesRepository.save(place);

    }
}
