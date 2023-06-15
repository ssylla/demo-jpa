package fr.digi.m0323.entites;

import jakarta.persistence.*;

@Entity
@Table(name = "FOURNISSEUR")
public class Fournisseur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "NOM")
    private String raisonSociale;
    @Transient
    private float chiffreAffaire;

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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Fournisseur{");
        sb.append("id=").append(id);
        sb.append(", raisonSociale='").append(raisonSociale).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
