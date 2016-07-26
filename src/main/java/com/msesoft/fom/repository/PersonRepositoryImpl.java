package com.msesoft.fom.repository;

import com.msesoft.fom.domain.CustomPerson;
import com.msesoft.fom.domain.FriendRelationship;
import com.msesoft.fom.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.template.Neo4jOperations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kerse on 19.07.2016.
 */
public class PersonRepositoryImpl implements PersonRepositoryCustom {

    private Neo4jOperations neo4jOperations;

    @Autowired
    public PersonRepositoryImpl(Neo4jOperations neo4jTemplate){
        this.neo4jOperations = neo4jTemplate;
    }

    @Override
    public List<CustomPerson> findDegreeFriend(String uniqueId, String degree, String limit) {


        String query = "MATCH p=((n:Person{uniqueId: '"+uniqueId+"' })-[:FRIEND*"+degree+".."+degree+"]->(w:Person))\n" +
                "with n as nNode,w as wNode , count(*) as xCount\n" +
                "where not wNode = nNode and not (n:Person{firstName: 'A3' })-[:FRIEND*1.."+(Integer.parseInt(degree)-1)+"]->(w:Person)\n" +
                "return wNode limit "+limit+";";

        Map<String,Object> params = new HashMap<>();

        List<Person> list = new ArrayList<Person>();
        List<CustomPerson> customList = new ArrayList<CustomPerson>();

        for (Person person:neo4jOperations.queryForObjects(Person.class,query,params)){
            CustomPerson customPerson = new CustomPerson()
            .setEmail(person.getEmail())
            .setFirstName(person.getFirstName())
            .setLastName(person.getLastName())
            .setGender(person.getGender())
            .setPhoto(person.getPhoto())
            .setHoby(person.getHoby())
            .setUniqueId(person.getUniqueId());

            customList.add(customPerson);
        }

        return customList;
    }
}
