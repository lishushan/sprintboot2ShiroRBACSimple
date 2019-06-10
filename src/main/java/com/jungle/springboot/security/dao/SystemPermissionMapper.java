package com.jungle.springboot.security.dao;

import com.jungle.springboot.security.entity.po.SystemPermission;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
*SystemPermission的映射接口。
*/
@Mapper
@Repository
public interface SystemPermissionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SystemPermission record);

    int insertSelective(SystemPermission record);

    SystemPermission selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SystemPermission record);

    int updateByPrimaryKey(SystemPermission record);

    List<SystemPermission> listUserPermission(Long id);
}