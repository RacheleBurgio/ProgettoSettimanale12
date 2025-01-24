package org.example;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Utente")
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private String cognome;

    @Column(name = "data_nascita")
    private LocalDate dataNascita;

    @Column(unique = true, nullable = false)
    private int numero;

    // Getters e Setters
}