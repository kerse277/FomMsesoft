package com.msesoft.fom.mongo;

import com.msesoft.fom.domain.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by oguz on 29.06.2016.
 */
public interface MpersonRepository extends MongoRepository<Person,Long> {



}
