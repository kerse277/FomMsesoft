package controllerTest;

import com.msesoft.fom.domain.Person;
import com.msesoft.fom.domain.Places;
import com.msesoft.fom.domain.FriendRelationship;
import com.msesoft.fom.domain.WorkRelationship;
import org.apache.catalina.util.ParameterMap;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.UUID;

/**
 * Created by oguz on 23.06.2016.
 */
public class controllerRandomTest {

    @Test
    public void personTest() {
        String name = "A1";
        String uri = new String("http://localhost:8081/person/findByFirstName?firstName=" +
                name);
        RestTemplate restTemplate = new RestTemplate();
        Person person = restTemplate.getForObject(uri,Person.class);
        System.out.println(person.getEmail());


        uri = new String ("http://localhost:8081/person/findByFirstDegreeFriend?uniqueId=55a2678e-5c30-4928-90a0-94151307bc11");
        Person [] personlist = restTemplate.getForObject(uri,Person[].class);
        System.out.println(personlist.length);

        uri = new String("http://localhost:8081/person/workNotFriend?uniqueId=ef018a44-0560-4de6-bd5e-8efe25f79c5e");
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
    public void add1Person () {
        Person person = new Person()
                .setLastName("YILMAZ")
                .setHoby("Write Code")
                .setGender('E')
                .setPhoto("/Home/Oguz/Sample")
                .setFirstName("OGUZ");
        String name = "A1";
        String uri = new String("http://localhost:8081/person/insertPerson");
        RestTemplate restTemplate = new RestTemplate();
        person = restTemplate.postForObject(uri,person,Person.class);
        System.out.println(person.getEmail());

    }


    @Test
    public void placesTest(){
        String uri = new String("http://localhost:8081/places/getName?name=ABC");
        RestTemplate restTemplate = new RestTemplate();
        Places place = restTemplate.getForObject(uri,Places.class);
        System.out.println(place);

    }

    @Test
    public void placesIdTest(){
        String uri = new String("http://localhost:8081/places/getId?id=206");
        RestTemplate restTemplate = new RestTemplate();
        Places place = restTemplate.getForObject(uri,Places.class);
        System.out.println(place);

    }

    @Test
    public void placesUpdateTest(){
        Places places = new Places();

        String uri = new String("http://localhost:8081/places/update?name=LG TECH&type=ENGINEER OFFICE");
        RestTemplate restTemplate = new RestTemplate();
        Places place = restTemplate.postForObject(uri,places,Places.class);
        System.out.println(place);

    }

    @Test
    public void placesInsertTest(){

        Places places = new Places()
                .setType("Computer Engineer")
                .setName("BEAM Teknoloji");


        String uri = new String("http://localhost:8081/places/insert");
        RestTemplate restTemplate = new RestTemplate();
        Places place = restTemplate.postForObject(uri,places,Places.class);
        System.out.println(place);

    }

    @Test
    public void placesDeleteTest(){
        String uri = new String("http://localhost:8081/places/deleteplace?id={id}");

        long id = 223;
        Map<String,Long> params = new ParameterMap<>();
        params.put("id", id);

        RestTemplate restTemplate = new RestTemplate();
        Places place = restTemplate.getForObject(uri,Places.class,params);


    }
    @Test
    public void addPerson() {

        Person person = new Person()
                .setUniqueId(UUID.randomUUID().toString())
                .setPassword("atmega")
                .setEmail("yilmazoguz94@gmail.com")
                .setFirstName("Oğuzhan")
                .setLastName("Yılmaz")
                .setGender('E')
                .setHoby("Computer")
                .setPhoto("http://fomdb.cloudapp.net/oguz.png");

        String uri = new String("http://localhost:8081/person/singUp");

        RestTemplate restTamplate = new RestTemplate();
        person = restTamplate.postForObject(uri,person,Person.class);
    }

    @Test
    public void workkkTest () {

        WorkRelationship work = new WorkRelationship();
        Person person = new Person();

        String uri = new String("http://localhost:8081/person/findByFirstName?firstName=A1");


        RestTemplate restTemplate = new RestTemplate();
        person = restTemplate.getForObject(uri,Person.class);

        RestTemplate r2 = new RestTemplate();
        Places places = r2.getForObject("http://localhost:8081/places/personWorkSearch?uniqueId="+person.getUniqueId(),Places.class);
        System.out.println(places.getName());
    }
    @Test
    public void placesDeleteTest2(){

        String uri = new String("http://localhost:8081/person/updatePhoto");


        RestTemplate restTemplate = new RestTemplate();
       Person person= restTemplate.getForObject(uri,Person.class);


    }

    @Test
    public void personPlacesUpdate() {
        String uri = new String("http://192.168.2.6:8081/person/findByFirstName?firstName=Oğuzhan");

        RestTemplate restTemplate = new RestTemplate();
        Person person = new Person();
        person = restTemplate.getForObject(uri,Person.class);

        WorkRelationship wr = new WorkRelationship();
        Places places = new Places();
        places = restTemplate.getForObject("http://192.168.2.6:8081/places/getName?name=BEAM TEKNOLOJİ",Places.class);

        wr.setStartNode(person)
                .setEndNode(places)
                .setWorkType("ENGINEER");
        RestTemplate r = new RestTemplate();
        r.postForObject("http://192.168.2.6:8081/workrelationship/save",wr,WorkRelationship.class);


    }
    @Test
    public void personAddFriend() {
        String uri = new String("http://192.168.2.6:8081/person/findByFirstName?firstName=Oğuzhan");

        RestTemplate restTemplate = new RestTemplate();
        Person person = new Person();
        person = restTemplate.getForObject(uri,Person.class);

        String uri2 = new String("http://192.168.2.6:8081/person/findByFirstName?firstName=A151");

        RestTemplate restTemplate2 = new RestTemplate();
        Person person2 = new Person();
        person2 = restTemplate2.getForObject(uri2,Person.class);


        FriendRelationship friendRelationship = new FriendRelationship()
                .setFriendType("Facebook")
                .setStartNode(person)
                .setEndNode(person2);

        restTemplate.postForObject("http://192.168.2.6:8081/friendRelationShip/saveFriend",friendRelationship,FriendRelationship.class);
        FriendRelationship friendRelationship2 = new FriendRelationship()
                .setFriendType("Facebook")
                .setStartNode(person2)
                .setEndNode(person);

        restTemplate.postForObject("http://192.168.2.6:8081/friendRelationShip/saveFriend",friendRelationship2,FriendRelationship.class);

    }

    @Test
    public void onePersonDelete () {
        String uri = new String("http://192.168.2.130:8081/person/findByFirstName?firstName=mehmet");

        RestTemplate restTemplate = new RestTemplate();
        Person person = new Person();
        person = restTemplate.getForObject(uri,Person.class);

    }

}
