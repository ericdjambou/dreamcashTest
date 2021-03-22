package com.donatien.test.service.interfaces;

import com.donatien.test.entities.Role;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author donatien
 * @created 20/03/2021 - 3:29 AM
 * @project test
 */

public interface RoleService {

    Optional <Role> findByNom( String nom);
}
