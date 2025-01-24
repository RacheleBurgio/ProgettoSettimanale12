package org.example;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "Rivista")
public class Rivista extends Elemento_Catalogo {
    private String periodicita;

    public String getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(String periodicita) {
        this.periodicita = periodicita;
    }

    public Rivista(Integer id, Integer isbn, String titolo, Integer annoPubblicazione, Integer numeroPagine, String periodicita) {
        super(id, isbn, titolo, annoPubblicazione, numeroPagine);
        this.periodicita = periodicita;


    }
}
