package com.donatien.test.entities;

import com.donatien.test.enumeration.TypeCompte;
import com.donatien.test.enumeration.TypeTransaction;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;



@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Transaction implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String numeroTransaction;
    private double montant;
    @Temporal (TemporalType.TIMESTAMP)
    private Date dateTransaction;
    @NotNull
    @Enumerated (EnumType.STRING)
    private TypeTransaction typeTransaction;
    @ManyToOne
    private Compte compte;

    public Transaction ( Date date, double montant, Compte compte ) {

    }
}
