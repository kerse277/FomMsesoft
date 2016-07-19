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
    public List<Person> findByFirstDegreeFriend(String uniqueId) {
        return personRepository.findByFirstDegreeFriend(uniqueId);
    }
    public List<Person> workNotFriend(String uniqueId) {
        return personRepository.workNotFriend(uniqueId);
    }

    public Person insertPerson(Person person) {
        return personRepository.save(person);
    }

    public Person findByEmail(String email){
        return personRepository.findByEmail(email);
    }

    public Person singIn(String email,String password){
        return personRepository.findByEmailAndPassword(email, password);
    }

    public Person deletePerson(String uniqueId) {
        Person person = new Person();

        person = personRepository.findByUniqueId(uniqueId);
        personRepository.deletePerson(uniqueId);

        return person;
    }

    public Person updatephoto() {
        Person person2 =new Person()
                .setEmail("asdasdasd");

        String [] personsPhoto = {"aaa.png","A1.png","A2.jpg","A3.jpg","A4.jpg","A5.jpg","A6.jpg","lisa.jpg"};
        for(int i=1;i<=200;i++){
            Person person = new Person();
            person=personRepository.findByFirstName("A"+i);
            person.setPhoto("http://fomdb.cloudapp.net/"+personsPhoto[i%7]);
            personRepository.save(person);
        }
        return person2;
    }
    public List<Person> secondDegreeFriend(String uniqueId) {
        return personRepository.secondDegreeFriend(uniqueId);
    }


}
