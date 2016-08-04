package com.msesoft.fom.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;


@Accessors(chain = true)
public class CustomPerson {


    @Getter
    @Setter
    private String uniqueId;

    @Getter
    @Setter
    private String email;

    @Setter
    @Getter
    private String firstName;

    @Setter
    @Getter
    private String lastName;

    @Getter
    @Setter
    private char gender;

    @Setter
    @Getter
    private String hoby;

    @Setter
    @Getter
    private String photo;

    @Getter
    @Setter
    private ArrayList<String> photoList = new ArrayList<>();


}
