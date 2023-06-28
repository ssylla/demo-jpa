package fr.digi.m0323.entites;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "FOURNISSEUR")
@Cacheable()
public class Fournisseur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "NOM", length = 50)
    private String raisonSociale;
    @Transient
    private float chiffreAffaire;

    private static int NB = 0;

    @OneToMany(mappedBy = "fournisseur", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private Set<Article> articles;

    @OneToMany(mappedBy = "fournisseur")
    private Set<Bon> bons;

    {
        articles = new HashSet<>();
        bons = new HashSet<>();
    }

    public Fournisseur() {}

    public Fournisseur(String raisonSociale) {
        this.raisonSociale = raisonSociale;
    }

    public Fournisseur(Integer id, String raisonSociale) {
        this.id = id;
        this.raisonSociale = raisonSociale;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRaisonSociale() {
        return raisonSociale;
    }

    public void setRaisonSociale(String raisonSociale) {
        this.raisonSociale = raisonSociale;
    }

    public float getChiffreAffaire() {
        return chiffreAffaire;
    }

    public void setChiffreAffaire(float chiffreAffaire) {
        this.chiffreAffaire = chiffreAffaire;
    }

    public Set<Article> getArticles() {
        return articles;
    }

    public void setArticles(Set<Article> articles) {
        this.articles = articles;
    }

    public Set<Bon> getBons() {
        return bons;
    }

    public void setBons(Set<Bon> bons) {
        this.bons = bons;
    }

    public void addArticle(Article article) {
        if (null != article) {
            article.setFournisseur(this);
        }
    }

    public void removeArticle(Article article) {
        if (null != article) {
            article.setFournisseur(null);
        }
    }
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Fournisseur{");
        sb.append("id=").append(id);
        sb.append(", raisonSociale='").append(raisonSociale).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
