package com.donatien.test.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel (value = "Login DTO Request", description = "DTO pour la connexion")
public class LoginDTO {

    @ApiModelProperty (value = "username de connexion", allowableValues = "NonEmpty String", allowEmptyValue = false)
    private String username;

    @ApiModelProperty(value = "mot de passe", required = true, allowableValues = "NonEmpty String")
    private String motDePasse;

    @ApiModelProperty(value = "token généré")
    private String token;

    public LoginDTO(String username, String motDePasse) {
        this.username = username;
        this.motDePasse = motDePasse;
    }
}
