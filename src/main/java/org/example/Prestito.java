package org.example;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "Prestito")
public class Prestito {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "utente_id", nullable = false)
    private Utente utente;

    @ManyToOne
    @JoinColumn (name = "elemento_id", nullable = false)
    private Elemento_Catalogo elementoPrestato;

    @Column(name = "data_inizio", nullable = false)
    private LocalDate dataInizio;

    @Column (name = "data_effettiva")
    private LocalDate dataEffettiva;

    @Column (name = "data_prevista")
    private LocalDate dataprevista;


}