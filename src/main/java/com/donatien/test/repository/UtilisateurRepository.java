package com.donatien.test.repository;

import com.donatien.test.entities.CodeTransfert;
import com.donatien.test.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author donatien
 * @created 20/03/2021 - 12:54 AM
 * @project test
 */

@Repository
public interface UtilisateurRepository extends JpaRepository <Utilisateur, Long> {

    //Optional <Utilisateur> findByPhoneNumber( String telephone);

    Boolean existsByUsername(String username);

    //Utilisateur findByUsername (String username);

}
