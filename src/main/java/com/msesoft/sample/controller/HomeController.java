package com.msesoft.sample.controller;

import com.msesoft.sample.domain.Sample;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by oguz on 24.06.2016.
 */

@RestController
public class HomeController {

    @GetMapping("sample")
    public Sample sample(){
        return new Sample()
                .setField("abcd");
    }

}
