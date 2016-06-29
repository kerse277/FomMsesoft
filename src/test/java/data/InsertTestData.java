package data;

import com.msesoft.fom.domain.Person;
import com.msesoft.fom.domain.Places;
import com.msesoft.fom.relationshipdomain.FriendRelationship;
import com.msesoft.fom.relationshipdomain.WorkRelationship;
import com.msesoft.fom.neo.FriendRelationshipRepository;
import com.msesoft.fom.neo.PersonRepository;
import com.msesoft.fom.neo.PlacesRepository;
import com.msesoft.fom.neo.WorkRelationshipRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;

/**
 * Created by kerse on 23.06.2016.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class InsertTestData {
    @Autowired
    PlacesRepository placesRepository;

    @Autowired
    PersonRepository personRepository;

    @Autowired
    WorkRelationshipRepository workRelationshipRepository;

    @Autowired
    FriendRelationshipRepository friendRelationshipRepository;

    Person friendPerson1 = new Person();
    Person friendPerson2 = new Person();

    @Test
    public void placesInsert() {
        String placesType [] = {"HOSPITAL","ENGINEER OFFICE","SCHOOL","SPORT CLUB"};
        String placesNameHospital [] ={"ANKARA HASTANESİ","GAZİ HASTANESİ","HACETTEPE HASTANESİ"};
        String placesNameEngineerOffice [] ={"BEAM TEKNOLOJİ","ABC TEKNOLOJİ","ABC","TEKNOLOJİ","COMPUTER"};
        String placesNameSchool [] = {"GAZİ ÜNİVERSİTESİ","ANKARA ÜNİVERSİTESİ","ORTA DOĞU TEKNİK ÜNİVERSİTESİ","BİLKENT ÜNİVERSİTESİ","SELÇUK ÜNİVERSİTESİ"};
        String placesNameClub [] = {"GALATASARAY","ANKARAGÜCÜ","FENERBAHÇE","BEŞİKTAŞ","SİVASSPOR","İSTANBUL BÜYÜKŞEHİR BELEDİYE SPOR","TRABZON SPOR","KONYA SPROR"};
        String placesName [] = {"ANKARA HASTANESİ","GAZİ HASTANESİ","HACETTEPE HASTANESİ","BEAM TEKNOLOJİ","ABC TEKNOLOJİ","ABC","TEKNOLOJİ","COMPUTER","GAZİ ÜNİVERSİTESİ","ANKARA ÜNİVERSİTESİ"
                ,"ORTA DOĞU TEKNİK ÜNİVERSİTESİ","BİLKENT ÜNİVERSİTESİ","SELÇUK ÜNİVERSİTES","GALATASARAY","ANKARAGÜCÜ","FENERBAHÇE","BEŞİKTAŞ","SİVASSPOR","İSTANBUL BÜYÜKŞEHİR BELEDİYE SPOR","TRABZON SPOR","KONYA SPROR"};
        String hospital [] = {"NURSE","DOCTOR"};
        String engineer [] = {"ENGINEER","DEVOLOPER"};
        String school [] = {"TEACHER","STUDENT"};
        String sport [] = {"FOOTBOLLER","DIRECTOR"};

        for (int i = 0; i<3; i++) {
            Places places = new Places();
            places.setType(placesType[0])
                    .setName(placesNameHospital[i]);
            placesRepository.save(places);
        }
        for (int i = 0; i<5; i++) {
            Places places = new Places();
            places.setType(placesType[1])
                    .setName(placesNameEngineerOffice[i]);
            placesRepository.save(places);
        }
        for (int i = 0; i<5; i++) {
            Places places = new Places();
            places.setType(placesType[2])
                    .setName(placesNameSchool[i]);
            placesRepository.save(places);
        }
        for (int i = 0; i<8; i++) {
            Places places = new Places();
            places.setType(placesType[3])
                    .setName(placesNameClub[i]);
            placesRepository.save(places);
        }
    }
    @Test
    public void placesAndWorkRelationInsert() {
        String placesType [] = {"HOSPITAL","ENGINEER OFFICE","SCHOOL","SPORT CLUB"};
        String placesName [] = {"ANKARA HASTANESİ","GAZİ HASTANESİ","HACETTEPE HASTANESİ","BEAM TEKNOLOJİ","ABC TEKNOLOJİ","ABC","TEKNOLOJİ","COMPUTER","GAZİ ÜNİVERSİTESİ","ANKARA ÜNİVERSİTESİ"
                ,"ORTA DOĞU TEKNİK ÜNİVERSİTESİ","BİLKENT ÜNİVERSİTESİ","SELÇUK ÜNİVERSİTESİ","GALATASARAY","ANKARAGÜCÜ","FENERBAHÇE","BEŞİKTAŞ","SİVASSPOR","İSTANBUL BÜYÜKŞEHİR BELEDİYE SPOR","TRABZON SPOR","KONYA SPROR"};
        String hospital [] = {"NURSE","DOCTOR"};
        String engineer [] = {"ENGINEER","DEVOLOPER"};
        String school [] = {"TEACHER","STUDENT"};
        String sport [] = {"FOOTBOLLER","DIRECTOR"};
        Random r = new Random();
        int rn2;
        for (int i = 1; i<=200; i=i+2) {
            rn2=r.nextInt(placesName.length-1);
            WorkRelationship wR = new WorkRelationship();
            Person person = new Person();
            person = personRepository.findByName("A"+i);
            Places places= new Places();

            places = placesRepository.findByName(placesName[rn2]);
            if (places.getType().equals(placesType[0]))  {
                wR.setStartNode(person)
                        .setEndNode(places)
                        .setWorkType(hospital[i%2]);
                workRelationshipRepository.save(wR);
            }
            else if (places.getType().equals(placesType[1])) {
                wR.setStartNode(person)
                        .setEndNode(places)
                        .setWorkType(engineer[i%2]);
                workRelationshipRepository.save(wR);
            }
            else if (places.getType().equals(placesType[2])) {
                wR.setStartNode(person)
                        .setEndNode(places)
                        .setWorkType(school[i%2]);
                workRelationshipRepository.save(wR);

            }
            else if (places.getType().equals(placesType[3])) {
                wR.setStartNode(person)
                        .setEndNode(places)
                        .setWorkType(sport[i%2]);
                workRelationshipRepository.save(wR);
            }
        }
    }

    @Test
    public void testPersonRepositoryInsert () {

        personRepository.deleteAll();
        String genders [] = {"M","F"};
        String Hoby [] = {"Music","Art","Play Game"};

        for(int i= 1; i<=200; i++) {

            Person person = new Person()
                    .setGender(genders[i%2])
                    .setHoby(Hoby[i%3])
                    .setName("A"+i)
                    .setPhoto("/home/oguz/IMG/img.jpeg")
                    .setSurname("B"+i)
                    .setTc("100000000"+i);
            person =personRepository.save(person);
            System.out.println(person.getName());
        }
        Random random = new Random();
        String[] friend={"Facebook","Instagram","Work"};
        for (int i = 1; i<=200; i++) {

            friendPerson1 = personRepository.findByName("A"+i);
            for (int j = 1; j<=10; j++) {
                int [] rndm = new int[10];
                int rondomFriend=random.nextInt(199)+1;

                boolean deger=true;
                for(int k=0;k<rndm.length;k++){
                    if(rndm[k]==rondomFriend)
                        deger=false;

                }
                rndm[j-1]=rondomFriend;
                if (i != rondomFriend && deger ){
                    friendPerson2 = personRepository.findByName("A"+rondomFriend);
                    FriendRelationship fr = new FriendRelationship();
                    fr.setStartNode(friendPerson1);
                    fr.setEndNode(friendPerson2);
                    fr.setFriendType(friend[i%3]);
                    FriendRelationship fr2 = new FriendRelationship();
                    fr2.setStartNode(friendPerson2);
                    fr2.setEndNode(friendPerson1);
                    fr2.setFriendType(friend[i%3]);
                    friendRelationshipRepository.save(fr);
                    friendRelationshipRepository.save(fr2);
                }
                deger=true;
            }
        }
    }
    @Test
    public void relaitonTest(){
        friendPerson2 = personRepository.findByName("A187");
        friendPerson1 = personRepository.findByName("A194");
        FriendRelationship fr = new FriendRelationship();
        fr.setStartNode(friendPerson2);
        fr.setEndNode(friendPerson1);
        fr.setFriendType("Work");
        friendRelationshipRepository.save(fr);
    }


}
