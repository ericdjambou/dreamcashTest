package com.donatien.test.web;

import com.donatien.test.common.ApiResponse;
import com.donatien.test.dto.CompteDTO;
import com.donatien.test.dto.UtilisateurDTO;
import com.donatien.test.entities.Compte;
import com.donatien.test.entities.Utilisateur;
import com.donatien.test.exception.ResourceAlreadyInUseException;
import com.donatien.test.service.impl.AuthService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author donatien
 * @created 20/03/2021 - 10:59 AM
 * @project test
 */

@RestController
@RequestMapping ("/api/auth")
@CrossOrigin (origins = "*")
@Api (value = "Compte Rest API", description = "Définition des API liés aux comptes.")
public class CompteController {

    @Autowired
    private AuthService authService;



     @Secured ({"ADMIN"})
    @ApiOperation (value = "Enregistre un compte cheque ou epargne sur la plateforme")
    @PostMapping ("/createAccount")
    public ResponseEntity <?> createAccount( @ApiParam (value = "Compte DTO")  @RequestBody CompteDTO compteDTO) {

        Optional <Compte> optionalCompte = authService.createAccount (compteDTO);

        return ResponseEntity.ok ( new ApiResponse ( "Compte enregistré avec succès", true ) );

    }




}
