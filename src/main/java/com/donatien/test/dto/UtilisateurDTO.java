package com.donatien.test.dto;

import com.donatien.test.entities.Compte;
import com.donatien.test.entities.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;



@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel (value = "Utilisateur DTO Request", description = "DTO pour l'entité Utilisateur")
public class UtilisateurDTO {

    @ApiModelProperty (value = "nom d'utilisateur", required = true, allowableValues = "NonEmpty String")
    private String nom;
    @ApiModelProperty (value = "prenom d'utilisateur", required = true, allowableValues = "NonEmpty String")
    private String prenom;
    @ApiModelProperty (value = "username de connexion", required = true, allowableValues = "NonEmpty String")
    private String username;
    //@NotBlank (message = "Registration phone number can be null but not blank")
    @ApiModelProperty (value = "téléphone valide", required = true, allowableValues = "NonEmpty String")
    private String telephone;
    @ApiModelProperty(value = "mot de pass valide", required = true, allowableValues = "NonEmpty String")
    private String motDePasse;


}
