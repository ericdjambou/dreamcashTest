package com.donatien.test.repository;

import com.donatien.test.entities.CodeTransfert;
import com.donatien.test.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author donatien
 * @created 20/03/2021 - 12:55 AM
 * @project test
 */

@Repository
public interface RoleRepository extends JpaRepository <Role, Long> {

    Optional <Role> findByNom( String nom);
}
