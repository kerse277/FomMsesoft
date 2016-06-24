package controllerTest;

import com.msesoft.sample.domain.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

/**
 * Created by oguz on 23.06.2016.
 */
public class controllerRandomTest {

    @Test
    public void personTest() {
        String uri = new String("http://localhost:8081/person/findByName?name=A1");
        RestTemplate restTemplate = new RestTemplate();
        Person person = restTemplate.getForObject(uri,Person.class);
        System.out.println(person.getName());
    }

}
//