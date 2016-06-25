package controllerTest;

import com.msesoft.fom.domain.Person;
import com.msesoft.fom.domain.Places;
import com.msesoft.fom.repository.PlacesRepository;
import org.apache.catalina.util.ParameterMap;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by oguz on 23.06.2016.
 */
public class controllerRandomTest {

    @Autowired
    PlacesRepository placesRepository;

    @Test
    public void personTest() {
        String uri = new String("http://localhost:8081/person/findByName?name=A1");
        RestTemplate restTemplate = new RestTemplate();
        Person person = restTemplate.getForObject(uri,Person.class);
        System.out.println(person.getName());
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
                .setType("SPORT CLUB")
                .setName("GAZİANTEPSPOR");


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


}
