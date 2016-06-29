package com.msesoft.fom.business;

import com.msesoft.fom.domain.Person;
import com.msesoft.fom.repository.PersonRepository;
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



    public Person findByFirstName(String name) {
        return personRepository.findByFirstName(name);
    }
    public List<Person> findByFirstDegreeFriend(String nodeName) {
        return personRepository.findByFirstDegreeFriend(nodeName);
    }
    public List<Person> workNotFriend(String person) {
        return personRepository.workNotFriend(person);
    }

    public Person insertPerson(Person person) {
        return personRepository.save(person);
    }

    public Person findByEmail(String email){
        return personRepository.findByEmail(email);
    }

}
