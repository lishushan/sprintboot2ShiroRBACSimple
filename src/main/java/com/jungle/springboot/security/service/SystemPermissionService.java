package com.jungle.springboot.security.service;

import com.jungle.springboot.security.entity.po.SystemPermission;

import java.util.List;

/**
* basic service of SystemPermission.
*/
public interface SystemPermissionService {

    List<SystemPermission> listUserPermission(Long id);
}