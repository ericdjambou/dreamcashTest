package com.donatien.test.service.impl;

import com.donatien.test.dto.UtilisateurDTO;
import com.donatien.test.entities.Role;
import com.donatien.test.entities.Utilisateur;
import com.donatien.test.repository.RoleRepository;
import com.donatien.test.repository.UtilisateurRepository;
import com.donatien.test.service.interfaces.RoleService;
import com.donatien.test.service.interfaces.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author donatien
 * @created 20/03/2021 - 3:26 AM
 * @project test
 */

@Transactional
@Service
public class UtilisateurServiceImpl implements UtilisateurService {



    @Autowired
    private UtilisateurRepository userRepository;

    @Autowired
    private RoleService roleService;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private AuthenticationManager authenticationManager;


    @Override
    public Boolean existsByUsername ( String username ) {
        return userRepository.existsByUsername (username);
    }



    // Création d'un utilisateur dans le système
    public Utilisateur createUser( UtilisateurDTO utilisateurDTO) {
        Utilisateur newUser = new Utilisateur();
        newUser.setTelephone (utilisateurDTO.getTelephone ());
        newUser.setNom (utilisateurDTO.getNom ());
        newUser.setUsername (utilisateurDTO.getUsername ());
        newUser.setPrenom (utilisateurDTO.getPrenom ());
        newUser.setMotDePasse ( utilisateurDTO.getMotDePasse ());
        newUser.setDateDerniereConnexion (new Date (  ) );
        newUser.setDateDerniereDeconnexion (new Date (  ));
        newUser.setIsActive (true);

        // Attribuer un rôle à l'utilisateur (RIDER par défaut)
        Optional<Role> role = roleService.findByNom("USER");
        if(role.isPresent()){
            newUser.addRole(role.get());
        }


        return newUser;
    }

    @Override
    public Utilisateur save ( Utilisateur user ) {
        return userRepository.save(user);
    }

    @Override
    public List <Utilisateur> findUsers ( Long id ) {
        return userRepository.findAll ();
    }


    /**
     * Authentifier l'utilisateur et le connecter avec un loginRequest
     */
    public Optional<Authentication> authenticateUser( String username, String motDePasse) {
        return Optional.ofNullable(authenticationManager.authenticate(new UsernamePasswordAuthenticationToken (username,
            motDePasse)));
    }
}
