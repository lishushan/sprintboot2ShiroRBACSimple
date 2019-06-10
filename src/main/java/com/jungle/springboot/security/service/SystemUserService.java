package com.jungle.springboot.security.service;

import com.jungle.springboot.security.entity.po.SystemUser;

/**
* basic service of SystemUser.
*/
public interface SystemUserService {

    SystemUser loadUserByUsername(String username);
}