package fr.digi.m0323.entites;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "BON")
public class Bon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int numero;
    @Column(name = "DATE_CMDE")
    private LocalDateTime dateCommande;
    private int delai;

    @ManyToOne
    @JoinColumn(name = "ID_FOU")
    private Fournisseur fournisseur;

    @ManyToMany
    @JoinTable(name = "compo",
                joinColumns = @JoinColumn(name = "ID_BON", referencedColumnName = "ID"),
                inverseJoinColumns = @JoinColumn(name = "ID_ART", referencedColumnName = "ID"))
    private Set<Article> articles;


    @OneToMany(mappedBy = "bon")
    private Set<Composition> compositions;

    {
        articles = new HashSet<>();
    }
    public Bon() {}

    public Bon(int numero, LocalDateTime dateCommande, int delai) {
        this.numero = numero;
        this.dateCommande = dateCommande;
        this.delai = delai;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public LocalDateTime getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(LocalDateTime dateCommande) {
        this.dateCommande = dateCommande;
    }

    public int getDelai() {
        return delai;
    }

    public void setDelai(int delai) {
        this.delai = delai;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    public Set<Article> getArticles() {
        return articles;
    }

    public void setArticles(Set<Article> artciles) {
        this.articles = artciles;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Bon{");
        sb.append("id=").append(id);
        sb.append(", numero=").append(numero);
        sb.append(", dateCommande=").append(dateCommande);
        sb.append(", delai=").append(delai);
        sb.append('}');
        return sb.toString();
    }
}
