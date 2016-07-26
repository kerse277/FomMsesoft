package com.msesoft.fom.repository;

import com.msesoft.fom.domain.CustomPerson;
import com.msesoft.fom.domain.Person;

import java.util.List;

/**
 * Created by kerse on 19.07.2016.
 */
public interface PersonRepositoryCustom {

    List<CustomPerson> findDegreeFriend(String uniqueId, String degree, String limit);
}
