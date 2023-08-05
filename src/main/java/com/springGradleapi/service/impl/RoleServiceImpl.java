package com.springGradleapi.service.impl;

import com.springGradleapi.entity.Role;
import com.springGradleapi.repository.RoleRepository;
import com.springGradleapi.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
    @Override
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }
}
