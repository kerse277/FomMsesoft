package com.msesoft.sample.business;

import com.msesoft.sample.domain.Person;
import com.msesoft.sample.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by oguz on 23.06.2016.
 */
@Service
public class PersonBS {

    @Autowired
    PersonRepository personRepository;


    public Person findByName(String name) {
        return personRepository.findByName(name);
    }
    public List<Person> findByFirstDegreeFriend(String nodeName) {
        return personRepository.findByFirstDegreeFriend(nodeName);
    }
    public List<Person> workNotFriend(String person) {
        return personRepository.workNotFriend(person);
    }
}