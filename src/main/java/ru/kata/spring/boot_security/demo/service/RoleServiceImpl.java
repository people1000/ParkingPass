package ru.kata.spring.boot_security.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.entities.Role;
import ru.kata.spring.boot_security.demo.repository.RoleRepository;

import java.util.List;
@Service
public class RoleServiceImpl  implements  RoleService{

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }


    @Transactional(readOnly = true)
    public List<Role> listRoles() {
        return roleRepository.findAll();
    }
}
