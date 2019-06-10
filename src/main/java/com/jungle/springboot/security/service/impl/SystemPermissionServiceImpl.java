package com.jungle.springboot.security.service.impl;

import com.jungle.springboot.security.dao.SystemPermissionMapper;
import com.jungle.springboot.security.entity.po.SystemPermission;
import com.jungle.springboot.security.service.SystemPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* implementation of com.jungle.springboot.security.service.SystemPermissionService
*/
@Service
class SystemPermissionServiceImpl implements SystemPermissionService {
    /**
    * mapper 层支持。
    */
    @Autowired
    private SystemPermissionMapper mapper;

    @Override
    public List<SystemPermission> listUserPermission(Long id) {

        return mapper.listUserPermission(id);
    }
}