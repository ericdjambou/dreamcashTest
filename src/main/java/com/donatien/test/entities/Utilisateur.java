package com.donatien.test.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;



@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Utilisateur implements Serializable {

    @Id
    @Column(name = "UTILISATEUR_ID")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String telephone;
    private String username;
    @JsonIgnore
    private String motDePasse;
    @Temporal (TemporalType.TIMESTAMP)
    private Date dateDerniereConnexion;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDerniereDeconnexion;
    private Boolean isActive;
    @ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "UTILISATEUR_ROLES", joinColumns = {
        @JoinColumn(name = "UTILISATEUR_ID", referencedColumnName = "UTILISATEUR_ID") }, inverseJoinColumns = {
        @JoinColumn(name = "ROLE_ID", referencedColumnName = "ROLE_ID") })
    private List <Role> roles = new ArrayList <> ();
    @OneToMany(mappedBy = "utilisateur")
    private Collection <Compte> comptes;

    // Gestion de l'ajout et du retrait des rôles d'un utilisateur
    public void addRole(Role nom) {
        getRoles().add(nom);
    }


}
