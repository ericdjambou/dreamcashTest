package com.donatien.test.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;



@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Role implements Serializable {

    @Id
    @Column (name = "ROLE_ID")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
}
