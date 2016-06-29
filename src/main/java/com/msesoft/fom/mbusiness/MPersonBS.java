package com.msesoft.fom.mbusiness;

import com.msesoft.fom.domain.Person;
import com.msesoft.fom.mongo.MpersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by oguz on 29.06.2016.
 */
@Service
public class MPersonBS {
    @Autowired
    MpersonRepository mpersonRepository;


    public Person insert (Person person) {
        return mpersonRepository.save(person);
    }
}
