package com.msesoft.fom.business;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.msesoft.fom.domain.CustomPerson;
import com.msesoft.fom.domain.Person;
import com.msesoft.fom.repository.FriendRepository;
import com.msesoft.fom.domain.FriendRelationship;
import com.msesoft.fom.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.Result;
import com.google.android.gcm.server.Sender;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by oguz on 23.06.2016.
 */
@Service
public class FriendRelationshipBS {

    @Autowired
    FriendRepository friendRepository;

    @Autowired
    PersonRepository personRepository;

    public List<FriendRelationship> findFriendAll(String person) {
        return friendRepository.findFriendAll(person);
    }

    public List<FriendRelationship> findFriendByType(String person, String type) {
        return friendRepository.findFriendByType(person, type);
    }

    public List<FriendRelationship> friendWay(int limit, String startNode, String endNode, int length) {
        return friendRepository.friendWay(limit, startNode, endNode, length);
    }

    public FriendRelationship saveFriend(FriendRelationship friendRelationship) {
        return friendRepository.save(friendRelationship);
    }


    public void deleteFriend(Long id) {
        friendRepository.delete(id);
    }

    public void GCMNotification(String friendAdder, String friendAdded, HttpServletRequest req, HttpServletResponse resp) {

        String GOOGLE_SERVER_KEY = "AIzaSyB88PAc35WT1E0_tGsFv-XHwtOOdF0QCsk";
        String MESSAGE_KEY = "message";

        Person person = personRepository.findByToken(friendAdder);
        CustomPerson customPerson = new CustomPerson()
                .setUniqueId(person.getUniqueId())
                .setHoby(person.getHoby())
                .setPhoto(person.getPhoto())
                .setLastName(person.getLastName())
                .setFirstName(person.getFirstName())
                .setGender(person.getGender())
                .setEmail(person.getEmail());

        ObjectMapper mapper = new ObjectMapper();
        String customPersonJSON = null;
        try {

            customPersonJSON = mapper.writeValueAsString(customPerson);
        }catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        String regId = personRepository.findByUniqueId(friendAdded).getDeviceID();

        InetAddress ip;

        Result result = null;
        String share = req.getParameter("shareRegId");

        try {
            Sender sender = new Sender(GOOGLE_SERVER_KEY);
            Message message = new Message.Builder().timeToLive(30).delayWhileIdle(true).addData(MESSAGE_KEY, customPersonJSON)
                    .build();
            System.out.println("regId: " + regId);
            result = sender.send(message, regId, 1);
            req.setAttribute("pushStatus", result.toString());
        } catch (IOException ioe) {
            ioe.printStackTrace();
            req.setAttribute("pushStatus", "RegId required: " + ioe.toString());
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("pushStatus", e.toString());
        }
    }

}
