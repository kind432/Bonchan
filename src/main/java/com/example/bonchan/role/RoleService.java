package com.example.bonchan.role;

import org.springframework.stereotype.Service;

@Service
public class RoleService {
    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role GetRoleByName(ERole name) {
        Role role = roleRepository.findByName(name).orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        return role;
    }
}
