package com.donatien.test.dto;

import com.donatien.test.enumeration.TypeCompte;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel (value = "Compte DTO Request", description = "DTO pour la gestion des comptes")
public class CompteDTO {

    @ApiModelProperty (value = "type de compte", required = true, allowableValues = "NonEmpty String")
    private TypeCompte typeCompte;
    @ApiModelProperty (value = "période d'épargne défini par l'utilisateur")
    private String periodeEpargne;
}
