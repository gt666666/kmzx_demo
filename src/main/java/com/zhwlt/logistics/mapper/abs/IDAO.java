package com.zhwlt.logistics.mapper.abs;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Set;


public interface IDAO<K,V> {
     int  doCreate(V vo)throws Exception;
     boolean  doUpdate(V vo)throws Exception;
     boolean doRemoveBatch(Set<K> ids)throws  Exception;
     V    findById(K id) throws  Exception;
     List<V> findAll()throws  Exception;
     boolean  doDelete(V  vo)throws Exception;


}
