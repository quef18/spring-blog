package com.example.ltw_nhom20.service;

import com.example.ltw_nhom20.entity.Role;

public interface RoleService {
    Role findByRoleName(String roleName);

    Role save(Role role);
}
