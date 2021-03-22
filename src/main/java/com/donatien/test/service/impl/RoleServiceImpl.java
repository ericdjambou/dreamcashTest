package com.donatien.test.service.impl;

import com.donatien.test.entities.Role;
import com.donatien.test.repository.RoleRepository;
import com.donatien.test.service.interfaces.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author donatien
 * @created 20/03/2021 - 5:56 AM
 * @project test
 */

@Transactional
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;


    @Override
    public Optional <Role> findByNom ( String nom ) {
        return roleRepository.findByNom(nom);
    }
}
