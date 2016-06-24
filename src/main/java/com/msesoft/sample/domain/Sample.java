package com.msesoft.sample.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * Created by oguz on 24.06.2016.
 */
@Accessors(chain = true)
public class Sample {

    @Getter
    @Setter
    private String field;
}
