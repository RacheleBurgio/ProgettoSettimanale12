package org.example;

import org.example.DAO.ElementoCatalogoDAO;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ElementoCatalogoDAO elementoDAO = new ElementoCatalogoDAO();

        while (true) {
            System.out.println("\nScegli un'operazione:");
            System.out.println("0 - Aggiungi un libro");
            System.out.println("1 - Aggiungi una rivista");
            System.out.println("2 - Rimuovi un elemento dal catalogo");
            System.out.println("3 - Ricerca per ISBN");
            System.out.println("4 - Ricerca per anno");
            System.out.println("5 - Ricerca per autore");
            System.out.println("6 - Ricerca per titolo");
            System.out.println("7 - Ricerca libri attualmente in prestito");
            System.out.println("8 - Ricerca prestiti scaduti");
            System.out.println("9 - Esci");

            int scelta = scanner.nextInt();
            scanner.nextLine(); 

            switch (scelta) {
                case 0 -> aggiungiLibro(scanner, elementoDAO);
                case 1 -> aggiungiRivista(scanner, elementoDAO);
                case 2 -> rimuoviElemento(scanner, elementoDAO);
                case 3 -> ricercaPerISBN(scanner, elementoDAO);
                case 4 -> ricercaPerAnno(scanner, elementoDAO);
                case 5 -> ricercaPerTitolo(scanner, elementoDAO);
                case 9 -> {
                    System.out.println("Grazie per aver usato il sistema. Uscita in corso...");
                    scanner.close();
                    System.exit(0);
                }
                default -> System.out.println("Scelta non valida. Riprova.");
            }
        }
    }

    private static void aggiungiLibro(Scanner scanner, ElementoCatalogoDAO elementoDAO) {
        System.out.println("\nAggiungi un libro:");
        int lastId = elementoDAO.trovaultimoidlibro() + 1;

        System.out.print("ISBN: ");
        int ISBN = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Titolo: ");
        String titolo = scanner.nextLine();

        System.out.print("Anno di pubblicazione (yyyy): ");
        int anno = scanner.nextInt();

        System.out.print("Numero di pagine: ");
        int numeroPagine = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Autore: ");
        String autore = scanner.nextLine();

        System.out.print("Genere: ");
        String genere = scanner.nextLine();

        Libro libro = new Libro(lastId, ISBN, titolo, anno, numeroPagine, autore, genere);
        elementoDAO.salva(libro);
        System.out.println("Libro aggiunto con successo!");
    }

    private static void aggiungiRivista(Scanner scanner, ElementoCatalogoDAO elementoDAO) {
        System.out.println("\nAggiungi una rivista:");
        int lastId = elementoDAO.trovaultimoidlibro() + 1;

        System.out.print("ISBN: ");
        int ISBN = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Titolo: ");
        String titolo = scanner.nextLine();

        System.out.print("Anno di pubblicazione (yyyy): ");
        int anno = scanner.nextInt();

        System.out.print("Numero di pagine: ");
        int numeroPagine = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Periodicità: ");
        String periodicita = scanner.nextLine();

        Rivista rivista = new Rivista(lastId, ISBN, titolo, anno, numeroPagine, periodicita);
        elementoDAO.salvaR(rivista);
        System.out.println("Rivista aggiunta con successo!");
    }

    private static void rimuoviElemento(Scanner scanner, ElementoCatalogoDAO elementoDAO) {
        System.out.print("\nInserisci l'ISBN dell'elemento da rimuovere: ");
        int isbnDaEliminare = scanner.nextInt();

        if (elementoDAO.eliminabyISBN(isbnDaEliminare)) {
            System.out.println("Elemento rimosso con successo!");
        } else {
            System.out.println("Elemento non trovato.");
        }
    }

    private static void ricercaPerISBN(Scanner scanner, ElementoCatalogoDAO elementoDAO) {
        System.out.print("\nInserisci ISBN per la ricerca: ");
        int isbnDaCercare = scanner.nextInt();

        Elemento_Catalogo risultato = elementoDAO.ricercaperISBN(isbnDaCercare);
        if (risultato != null) {
            System.out.println("Elemento trovato: " + risultato.getTitolo());
        } else {
            System.out.println("Nessun elemento trovato con questo ISBN.");
        }
    }

    private static void ricercaPerAnno(Scanner scanner, ElementoCatalogoDAO elementoDAO) {
        System.out.print("\nInserisci l'anno per la ricerca: ");
        int annoDaCercare = scanner.nextInt();

        List<Elemento_Catalogo> risultati = elementoDAO.ricercaperanno(annoDaCercare);
        if (risultati.isEmpty()) {
            System.out.println("Nessun elemento trovato per l'anno " + annoDaCercare);
        } else {
            System.out.println("Elementi trovati:");
            for (Elemento_Catalogo elemento : risultati) {
                System.out.println("- " + elemento.getTitolo());
            }
        }
    }

    private static void ricercaPerTitolo(Scanner scanner, ElementoCatalogoDAO elementoDAO) {
        System.out.print("\nInserisci il titolo o una parte di esso: ");
        String titoloDaCercare = scanner.nextLine();

        List<Elemento_Catalogo> risultati = elementoDAO.ricercatitolo(titoloDaCercare);
        if (risultati.isEmpty()) {
            System.out.println("Nessun elemento trovato.");
        } else {
            System.out.println("Elementi trovati:");
            for (Elemento_Catalogo elemento : risultati) {
                System.out.println("- " + elemento.getTitolo());
            }
        }
    }
}
