package com.msesoft.fom.neo;



import com.msesoft.fom.relationshipdomain.FriendRelationship;

import java.util.List;

/**
 * Created by oguz on 23.06.2016.
 */
public interface FriendRelationshipRepositoryCustom {

 List<FriendRelationship> friendWay(int limit, String startNode, String endNode, int length);

}
