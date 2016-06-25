package controllerTest;

import com.msesoft.fom.domain.Person;
import com.msesoft.fom.relationshipdomain.FriendRelationship;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by oguz on 23.06.2016.
 */
public class controllerRandomTest {

    @Test
    public void personTest() {
        String name = "A1";
        String uri = new String("http://localhost:8081/person/findByName?name=" +
                name);
        RestTemplate restTemplate = new RestTemplate();
        Person person = restTemplate.getForObject(uri,Person.class);
        System.out.println(person.getName());


        uri = new String ("http://localhost:8081/person/findByFirstDegreeFriend?name=A1");
        Person [] personlist = restTemplate.getForObject(uri,Person[].class);
        System.out.println(personlist.length);

        uri = new String("http://localhost:8081/person/workNotFriend?name=A1");
        personlist = restTemplate.getForObject(uri,Person[].class);
        System.out.println(personlist.length);
    }
    @Test
    public void friendRelationShip() {
        String uri = new String("http://localhost:8081/friendRelationShip/findFriendAll?person=A1");
        RestTemplate restTemplate = new RestTemplate();
        FriendRelationship[] friendList = restTemplate.getForObject(uri,FriendRelationship[].class);
        System.out.println(friendList.length);


        uri = new String("http://localhost:8081/friendRelationShip/findFriendByType?person=A2&type=Instagram");
        friendList = restTemplate.getForObject(uri,FriendRelationship[].class);
        System.out.println(friendList.length);


        uri = new String("http://localhost:8081/friendRelationShip/friendWay?limit=1&startNode=A1&endNode=A10&length=3");
        friendList = restTemplate.getForObject(uri,FriendRelationship[].class);
        System.out.println(friendList.length);
    }
    @Test
    public void addPerson () {
        Person person = new Person()
                .setSurname("YILMAZ")
                .setHoby("Write Code")
                .setGender("E")
                .setOccupation("Gazi")
                .setPhoto("/Home/Oguz/Sample")
                .setName("OGUZ");
        String name = "A1";
        String uri = new String("http://localhost:8081/person/insertPerson");
        RestTemplate restTemplate = new RestTemplate();
        person = restTemplate.postForObject(uri,person,Person.class);
        System.out.println(person.getName());

    }

}
