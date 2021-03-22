package com.donatien.test.entities;

import com.donatien.test.enumeration.TypeCompte;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;



@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Compte implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String numero;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    private double solde;
    private Boolean isActive;
    @NotNull
    @Enumerated (EnumType.STRING)
    private TypeCompte typeCompte;
    private String periodeEpargne;
    private Long plafondPret;
    private Long cumulTransaction;
    @OneToMany(mappedBy = "compte")
    private Collection<CodeTransfert> codeTransferts;
    @ManyToOne
    private Utilisateur utilisateur;
    @OneToMany(mappedBy = "compte")
    private Collection<Transaction> transactions;
}
