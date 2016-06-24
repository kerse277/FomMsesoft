package com.msesoft.sample.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity(label = "Places")
@Accessors(chain = true)
public class Places {

    @GraphId
    @Getter
    private Long id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String type;

    @Override
    public String toString () {
        return String.format("Places[id=%s, name='%s', type='%s']", id,
                name, type);
    }
}
