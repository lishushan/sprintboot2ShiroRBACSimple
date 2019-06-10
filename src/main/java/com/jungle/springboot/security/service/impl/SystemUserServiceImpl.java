package com.jungle.springboot.security.service.impl;

import com.jungle.springboot.security.dao.SystemUserMapper;
import com.jungle.springboot.security.entity.po.SystemUser;
import com.jungle.springboot.security.service.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* implementation of com.jungle.springboot.security.service.SystemUserService
*/
@Service
class SystemUserServiceImpl implements SystemUserService {
    /**
    * mapper 层支持。
    */
    @Autowired
    private SystemUserMapper mapper;

    @Override
    public SystemUser loadUserByUsername(String username) {

        return mapper.loadUserByUsername(username) ;
    }
}