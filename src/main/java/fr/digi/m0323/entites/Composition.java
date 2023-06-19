package fr.digi.m0323.entites;

import jakarta.persistence.*;

@Entity
@Table(name = "compo2")
public class Composition {

    @EmbeddedId
    private CompositionKey id;

    private int qte;

    @ManyToOne
    @JoinColumn(name = "ID_ART")
    @MapsId("articleId")
    private Article article;

    @ManyToOne
    @JoinColumn(name = "ID_BON")
    @MapsId("bonId")
    private Bon bon;

    public Composition() {
    }

    public Composition(int qte) {
        this.qte = qte;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Composition{");
        sb.append("qte=").append(qte);
        sb.append('}');
        return sb.toString();
    }
}
