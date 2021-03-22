package com.donatien.test.service.impl;

import com.donatien.test.common.CustomUserDetails;
import com.donatien.test.dto.CompteDTO;
import com.donatien.test.dto.UtilisateurDTO;
import com.donatien.test.entities.Compte;
import com.donatien.test.entities.Utilisateur;
import com.donatien.test.exception.ResourceAlreadyInUseException;
import com.donatien.test.security.JwtTokenProvider;
import com.donatien.test.service.interfaces.CompteService;
import com.donatien.test.service.interfaces.RoleService;
import com.donatien.test.service.interfaces.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author donatien
 * @created 20/03/2021 - 4:13 AM
 * @project test
 */

@Service
public class AuthService {

    @Autowired
    private UtilisateurService userService;

    @Autowired
    private CompteService compteService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;



    /**
     * Enregistre un nouvel utilisateur dans la base de données en effectuant une série de vérifications rapides.
     * @return Un objet utilisateur si créé avec succès
     */
    public Optional <Utilisateur> registerUser( UtilisateurDTO dto) {

        String newRegistrationPhone = dto.getTelephone ();

        // Vérifier si le numéro de téléphone existe déjà
        if (usernameAlreadyExists(newRegistrationPhone)) {
            throw new ResourceAlreadyInUseException ("username", "Address", newRegistrationPhone);
        }
        Utilisateur newUser = userService.createUser(dto);
        Utilisateur registeredNewUser = userService.save(newUser);

        return Optional.ofNullable(registeredNewUser);
    }


    /**
     * Enregistre un nouveau compte dans la base de données en effectuant une série de vérifications rapides.
     * @return Un objet compte si créé avec succès
     */
    public Optional <Compte> createAccount( CompteDTO compteDTO) {


        Compte newCompte = compteService.createCompte (compteDTO);
        Compte registeredNewAccount = compteService.save(newCompte);

        return Optional.ofNullable(registeredNewAccount);
    }

    /*
     * Vérifier Si le numéro de téléphone existe déjà
     */
    public Boolean usernameAlreadyExists(String username) {
        return userService.existsByUsername (username);
    }

    /**
     * Authentifier l'utilisateur et le connecter avec un loginRequest
     */
    public Optional<Authentication> authenticateUser( String username, String password) {
        return Optional.ofNullable(authenticationManager.authenticate(new UsernamePasswordAuthenticationToken (username,
            password)));
    }

    /**
     * Génère un jeton JWT pour le client validé
     */
    public String generateToken( CustomUserDetails customUserDetails) {
        return tokenProvider.generateToken(customUserDetails);
    }

}
