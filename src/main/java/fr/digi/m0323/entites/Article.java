package fr.digi.m0323.entites;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "article")
@Cacheable
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String ref;
    @Column(name = "DESIGNATION")
    private String libelle;
    private float prix;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_FOU")
    private Fournisseur fournisseur;

    @ManyToMany(mappedBy = "articles", fetch = FetchType.LAZY)
    private Set<Bon> bons;

    @OneToMany(mappedBy = "article")
    private Set<Composition> compositions;
    {
        bons = new HashSet<>();
    }
    public Article() {
    }

    public Article(String ref, String libelle, float prix) {
        this.ref = ref;
        this.libelle = libelle;
        this.prix = prix;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        if (null != this.fournisseur) {
            this.fournisseur.getArticles().remove(this);
        }
        this.fournisseur = fournisseur;
        if (null != this.fournisseur) {
            this.fournisseur.getArticles().add(this);
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Article{");
        sb.append("id=").append(id);
        sb.append(", ref='").append(ref).append('\'');
        sb.append(", libelle='").append(libelle).append('\'');
        sb.append(", prix=").append(prix);
        sb.append(", fournisseur=").append(fournisseur.getId());
        sb.append('}');
        return sb.toString();
    }
}
