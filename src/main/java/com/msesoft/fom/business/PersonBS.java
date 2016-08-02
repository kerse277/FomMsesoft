package com.msesoft.fom.business;

import com.msesoft.fom.domain.*;
import com.msesoft.fom.repository.MobileSessionRepository;
import com.msesoft.fom.repository.PersonRepository;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by oguz on 23.06.2016.
 */
@Service
public class PersonBS {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    MobileSessionRepository mobileSessionRepository;

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

    public List<CustomPerson> findByFirstDegreeFriend(String token) {

        List<CustomPerson> customPersonList = new ArrayList<CustomPerson>();
        for (Person person:personRepository.findByFirstDegreeFriend(token)){
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

    public Token singIn(String email,String password){
        String token = UUID.randomUUID().toString();
        Person person = personRepository.findByEmailAndPassword(email, password);
        person.setToken(token);
        personRepository.save(person);
        Token tokenModel = new Token();
        tokenModel.setToken(token);
        return  tokenModel;
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
    public List<CustomPerson> findDegreeFriend(String token, int degree,int skip) {
        return personRepository.findDegreeFriend(token,degree,skip);
    }

    public void registerGCM(String token,String regId){
        Person person = new Person();
        person=personRepository.findByToken(token);
        person.setDeviceID(regId);
        personRepository.save(person);
    }

    public CustomPerson findByToken(String token) {
        Person person = personRepository.findByToken(token);
        CustomPerson customPerson = new CustomPerson()
                .setEmail(person.getEmail())
                .setFirstName(person.getFirstName())
                .setGender(person.getGender())
                .setHoby(person.getHoby())
                .setLastName(person.getLastName())
                .setPhoto(person.getPhoto())
                .setUniqueId(person.getUniqueId());

    return customPerson;
    }

    public CustomPerson findByUniqueId(String uniqueId) {
        Person person = personRepository.findByUniqueId(uniqueId);
        CustomPerson customPerson = new CustomPerson()
                .setEmail(person.getEmail())
                .setFirstName(person.getFirstName())
                .setGender(person.getGender())
                .setHoby(person.getHoby())
                .setLastName(person.getLastName())
                .setPhoto(person.getPhoto())
                .setUniqueId(person.getUniqueId());

        return customPerson;
    }

    public void uploadPhoto(Image image) {

        byte[] imageByteArray = Base64.decodeBase64(image.getBase64String());
        Person person = new Person();
//        person = personRepository.findByToken(token);

        try {
          /*  File filedir = new File("//var//www//html//fomPic//" + person.getUniqueId());
            filedir.mkdir();
            File filedir2 = new File("//var//www//html//fomPic//AnimePictures//" + person.getUniqueId() + "//media//");
            filedir2.mkdir();
            FileOutputStream imageOutFile = new FileOutputStream("//var//www//html//fomPic//AnimePictures//" + person.getUniqueId() + "//media//"+person.getUniqueId()+".jpg");
       */ File filedir = new File("//var//www//html//fomPic//" + "abc");
            filedir.mkdir();
            File filedir2 = new File("//var//www//html//fomPic//" + "abc" + "//media//");
            filedir2.mkdir();
            FileOutputStream imageOutFile = new FileOutputStream("//var//www//html//fomPic//" + "abc" + "//media//abc.jpg");
            imageOutFile.write(imageByteArray);
            imageOutFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
