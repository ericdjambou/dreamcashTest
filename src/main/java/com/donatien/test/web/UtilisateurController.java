package com.donatien.test.web;

import com.donatien.test.common.CustomUserDetails;
import com.donatien.test.dto.LoginDTO;
import com.donatien.test.dto.UtilisateurDTO;
import com.donatien.test.entities.Utilisateur;
import com.donatien.test.common.ApiResponse;
import com.donatien.test.exception.UserLoginException;
import com.donatien.test.repository.UtilisateurRepository;
import com.donatien.test.security.JwtAuthenticationResponse;
import com.donatien.test.service.impl.AuthService;
import com.donatien.test.service.interfaces.UtilisateurService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.catalina.authenticator.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author donatien
 * @created 20/03/2021 - 3:40 AM
 * @project test
 */

@RestController
@RequestMapping ("/api/auth")
@CrossOrigin (origins = "*")
@Api (value = "Authentication Rest API", description = "Définition des API d'authentification.")
public class UtilisateurController {

    @Autowired
    private AuthService authService;

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private UtilisateurService utilisateurService;

    @Secured ({"ADMIN"})
    @ApiOperation (value = "Enregistre un utilisateur sur la plateforme")
    @PostMapping ("/register")
    public ResponseEntity <?> registerUser( @ApiParam (value = "Utilisateur DTO")  @RequestBody UtilisateurDTO utilisateurDTO) {

        Optional <Utilisateur> utilisateurOptional = authService.registerUser(utilisateurDTO);

        return ResponseEntity.ok ( new ApiResponse ( "Utilisateur enregistré avec succès", true ) );

    }


    @ApiOperation(value = "Connecte l'utilisateur sur le système et retrourne les informations sur la connexion y compris le token et les paramètres de base de l'utilisateur.")
    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@ApiParam(value = "The LoginRequest dto")  @RequestBody LoginDTO loginDTO, HttpServletRequest request) {

        Optional<Authentication> authenticationOpt = authService.authenticateUser(loginDTO.getUsername(), loginDTO.getMotDePasse ());
        authenticationOpt.orElseThrow(() -> new UserLoginException ("Couldn't login user [" + loginDTO + "]"));
        Authentication authentication = authenticationOpt.get();
        CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwtToken = authService.generateToken(customUserDetails);

        return ResponseEntity.ok(new JwtAuthenticationResponse (jwtToken, customUserDetails.getUsername(), customUserDetails.getAuthorities()));
    }

    @Secured ({"ADMIN"})
    @ApiOperation(value = "retrouver tout les utilisateurs du systeme...")
    @GetMapping("/findAllUsers")
    @ResponseBody
    public ResponseEntity<List<UtilisateurDTO>> getAllUtilisateursLivreur(){
        List<UtilisateurDTO> utilisateurDTOS = new ArrayList <> ();

        for ( UtilisateurDTO utilisateur : utilisateurDTOS) {
            UtilisateurDTO utilisateurDTO = new UtilisateurDTO ();
            utilisateurDTO.setNom (utilisateur.getNom ());
            utilisateurDTO.setPrenom (utilisateur.getPrenom ());
            utilisateurDTO.setUsername (utilisateur.getUsername ());
            utilisateurDTO.setTelephone (utilisateur.getTelephone ());

        }

        return new ResponseEntity<List<UtilisateurDTO>>(utilisateurDTOS, HttpStatus.OK);
    }


}
