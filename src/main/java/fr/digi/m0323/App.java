package fr.digi.m0323;

import fr.digi.m0323.entites.*;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;


public class App {

    public static void main(String[] args) {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo-jpa-m0323");
             EntityManager em = emf.createEntityManager()) {

            em.getTransaction().begin();

            /*// C -> CRUD
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

            TypedQuery<Fournisseur> queryAll = em.createQuery("from Fournisseur fo where fo.raisonSociale ='Digi'", Fournisseur.class);
            System.out.println(queryAll.getResultList());

            Article article = em.find(Article.class, 2);
            if (null != article) {
                System.out.println(article.getFournisseur());
            }


            Bon bon = em.find(Bon.class, 1);
            if (null != bon) {
                System.out.println(bon.getArticles());
            }*/

            //Récupération d'un article
            Article article = em.find(Article.class, 5);
            if (null != article) {
                System.out.println(article.getRef());
                System.out.println(article.getFournisseur().getRaisonSociale());
            }

            Composition composition = em.find(Composition.class, new CompositionKey(5,1));
            if ( composition != null) {
                System.out.println(composition.getQte());
            } else {
                System.out.println("pas réussi");
            }

            // Créer un nouveau fournisseur, un nouveau bon et des nouveaux articles
//            Fournisseur fournisseurACreer = new Fournisseur("La maison de l'ordi");
//
//            Article hp1705 = new Article("HP1705", "laptop", 200);

//            Bon bon41 = new Bon(41, LocalDateTime.now(), 10);


//            hp1705.setFournisseur(fournisseurACreer);
//            fournisseurACreer.addArticle(hp1705);

            //em.persist(hp1705);
//            em.persist(fournisseurACreer);
//            em.persist(bon41);


            em.getTransaction().commit();
        }
    }
}