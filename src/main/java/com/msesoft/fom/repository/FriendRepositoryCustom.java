package com.msesoft.fom.repository;



import com.msesoft.fom.domain.FriendRelationship;

import java.util.List;

/**
 * Created by oguz on 23.06.2016.
 */
public interface FriendRepositoryCustom {

 List<FriendRelationship> friendWay(int limit, String startNode, String endNode, int length);

}
