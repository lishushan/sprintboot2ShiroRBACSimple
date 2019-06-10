package com.jungle.springboot.security.dao;

import com.jungle.springboot.security.entity.po.SystemUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * SystemUser的映射接口。
 */
@Mapper
@Repository
public interface SystemUserMapper {

    int deleteByPrimaryKey(Long id);

    int insert(SystemUser record);

    int insertSelective(SystemUser record);

    SystemUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SystemUser record);

    int updateByPrimaryKey(SystemUser record);

    SystemUser loadUserByUsername(String username);
}