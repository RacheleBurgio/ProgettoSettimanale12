package org.example.DAO;

import org.example.Elemento_Catalogo;
import org.example.Libro;
import org.example.Rivista;

import javax.persistence.*;
import java.util.List;

public class ElementoCatalogoDAO {

    protected static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Bibliotekk");


    public int trovaultimoidlibro() {
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createQuery("SELECT MAX(e.id) FROM Libro e");
            Integer result = (Integer) query.getSingleResult();
            return result != null ? result : 0;
        } catch (Exception e) {
            System.err.println("Errore durante la ricerca dell'ultimo ID: " + e.getMessage());
            return 0;
        } finally {
            em.close();
        }
    }


    public void salva(Libro libro) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(libro);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Errore durante il salvataggio del libro: " + e.getMessage());
        } finally {
            em.close();
        }
    }


    public void salvaR(Rivista rivista) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(rivista);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Errore durante il salvataggio della rivista: " + e.getMessage());
        } finally {
            em.close();
        }
    }


    public boolean eliminabyISBN(int isbndaeliminare) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Query query = em.createQuery("DELETE FROM Elemento_Catalogo e WHERE e.ISBN = :isbn");
            query.setParameter("isbn", isbndaeliminare);
            int result = query.executeUpdate();
            em.getTransaction().commit();
            return result > 0;
        } catch (Exception e) {
            System.err.println("Errore durante l'eliminazione dell'elemento: " + e.getMessage());
            em.getTransaction().rollback();
            return false;
        } finally {
            em.close();
        }
    }


    public Elemento_Catalogo ricercaperISBN(int isbnDacercare) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Elemento_Catalogo.class, isbnDacercare);
        } catch (Exception e) {
            System.err.println("Errore durante la ricerca per ISBN: " + e.getMessage());
            return null;
        } finally {
            em.close();
        }
    }


    public List<Elemento_Catalogo> ricercaperanno(int annodacercare) {
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createQuery("SELECT e FROM Elemento_Catalogo e WHERE e.anno = :anno");
            query.setParameter("anno", annodacercare);
            return query.getResultList();
        } catch (Exception e) {
            System.err.println("Errore durante la ricerca per anno: " + e.getMessage());
            return null;
        } finally {
            em.close();
        }
    }

    public List<Elemento_Catalogo> ricercatitolo(String titolodacercare) {
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createQuery("SELECT e FROM Elemento_Catalogo e WHERE e.titolo LIKE :titolo");
            query.setParameter("titolo", "%" + titolodacercare + "%");
            return query.getResultList();
        } catch (Exception e) {
            System.err.println("Errore durante la ricerca per titolo: " + e.getMessage());
            return null;
        } finally {
            em.close();
        }
    }
}
