package com.msesoft.fom.business;

import com.msesoft.fom.domain.CustomPerson;
import com.msesoft.fom.domain.Person;
import com.msesoft.fom.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oguz on 23.06.2016.
 */
@Service
public class PersonBS {

    @Autowired
    PersonRepository personRepository;



    public CustomPerson findByFirstName(String name) {

        Person person = personRepository.findByFirstName(name);
        CustomPerson customPerson = new CustomPerson()
       .setEmail(person.getEmail())
       .setFirstName(person.getFirstName())
        .setLastName(person.getLastName())
        .setGender(person.getGender())
        .setPhoto(person.getPhoto())
        .setHoby(person.getHoby())
        .setUniqueId(person.getUniqueId());

        return customPerson;
    }

    public List<CustomPerson> findByFirstDegreeFriend(String uniqueId) {

        List<CustomPerson> customPersonList = new ArrayList<CustomPerson>();
        for (Person person:personRepository.findByFirstDegreeFriend(uniqueId)){
            CustomPerson customPerson = new CustomPerson()
            .setEmail(person.getEmail())
            .setFirstName(person.getFirstName())
            .setLastName(person.getLastName())
            .setGender(person.getGender())
            .setPhoto(person.getPhoto())
            .setHoby(person.getHoby())
            .setUniqueId(person.getUniqueId());

            customPersonList.add(customPerson);
        }

        return customPersonList;
    }

    public List<CustomPerson> workNotFriend(String uniqueId) {
        List<CustomPerson> customPersonList = new ArrayList<CustomPerson>();
        for (Person person:personRepository.workNotFriend(uniqueId)){
            CustomPerson customPerson = new CustomPerson()
            .setEmail(person.getEmail())
            .setFirstName(person.getFirstName())
            .setLastName(person.getLastName())
            .setGender(person.getGender())
            .setPhoto(person.getPhoto())
            .setHoby(person.getHoby())
            .setUniqueId(person.getUniqueId());

            customPersonList.add(customPerson);
        }

        return customPersonList;
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

    public void deletePerson(String uniqueId) {

        personRepository.deletePerson(uniqueId);

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
    public List<CustomPerson> findDegreeFriend(String uniqueId, String degree, String limit) {
        return personRepository.findDegreeFriend(uniqueId,degree,limit);
    }

    public void registerGCM(String uniqueId,String regId){
        Person person = new Person();
        person=personRepository.findByUniqueId(uniqueId);
        person.setDeviceID(regId);
        personRepository.save(person);
    }

}
