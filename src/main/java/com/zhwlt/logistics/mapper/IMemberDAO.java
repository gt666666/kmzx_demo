package com.zhwlt.logistics.mapper;


import com.zhwlt.logistics.mapper.abs.IDAO;
import com.zhwlt.logistics.pojo.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Map;
import java.util.Set;


@Mapper
public interface IMemberDAO extends IDAO <String ,Member>{

      @Override
      int doCreate(Member vo) throws Exception;

      @Override
      boolean doUpdate(Member vo) throws Exception;

      @Override
      boolean doRemoveBatch(Set<String> ids) throws Exception;

      @Override
      boolean doDelete(Member vo) throws Exception;

      @Override
      Member findById(String id) throws Exception;
      List<Member>   find(Member  vo);

      List<Member> findAll( Member vo) throws Exception;
      List<Member>  findAllByIds(List<String> lists);
      List<Member> findAllBySalary ( @Param("set") Set<Integer> ids);
      boolean    doUpdateByNameAndId(Map map);
      List<String >  findBySalary(Integer id);
}
