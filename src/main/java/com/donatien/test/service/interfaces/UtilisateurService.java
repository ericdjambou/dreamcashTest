package com.donatien.test.service.interfaces;

import com.donatien.test.dto.UtilisateurDTO;
import com.donatien.test.entities.Utilisateur;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

/**
 * @author donatien
 * @created 20/03/2021 - 3:21 AM
 * @project test
 */

public interface UtilisateurService  {

    //Optional <Utilisateur> findByPhoneNumber( String telephone);

    Boolean existsByUsername(String username);

    Utilisateur createUser( UtilisateurDTO dto);

    Utilisateur save(Utilisateur user);

    public List <Utilisateur> findUsers( Long id);
}
