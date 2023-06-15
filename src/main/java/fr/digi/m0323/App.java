package fr.digi.m0323;

import fr.digi.m0323.entites.Fournisseur;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App {
    public static void main(String[] args) {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo-jpa-m0323");
             EntityManager em = emf.createEntityManager()) {

            em.getTransaction().begin();

            // C -> CRUD
            Fournisseur nouveauFournisseur = new Fournisseur("Diginamic Auto créée");
            em.persist(nouveauFournisseur);

            // R -> CRUD
            Fournisseur fournisseur = em.find(Fournisseur.class, 4);
            if (null != fournisseur) {
                System.out.println(fournisseur);
            }

            // U -> CRUD
            Fournisseur fournisseurAModifier = em.find(Fournisseur.class, 7);
            if (null != fournisseurAModifier) {
                fournisseurAModifier.setRaisonSociale("Diginamic M");
            }

            // D -> CRUD
            Fournisseur fournisseurASupprimer = em.find(Fournisseur.class, 6);
            if (null != fournisseurASupprimer) {
                em.remove(fournisseurASupprimer);
            }


            em.getTransaction().commit();
        }
    }
}