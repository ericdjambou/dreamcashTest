package com.donatien.test.repository;

import com.donatien.test.entities.CodeTransfert;
import com.donatien.test.entities.Compte;
import com.donatien.test.enumeration.TypeCompte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

/**
 * @author donatien
 * @created 20/03/2021 - 12:55 AM
 * @project test
 */

@RepositoryRestResource
public interface CompteRepository extends JpaRepository <Compte, Long> {


    Optional<Compte> findById ( String id );
}
