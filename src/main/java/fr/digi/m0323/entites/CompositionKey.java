package fr.digi.m0323.entites;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class CompositionKey implements Serializable {

    @Column(name = "ID_ART")
    private int articleId;
    @Column(name = "ID_BON")
    private int bonId;

    public CompositionKey() {
    }

    public CompositionKey(int articleId, int bonId) {
        this.articleId = articleId;
        this.bonId = bonId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CompositionKey{");
        sb.append("articleId=").append(articleId);
        sb.append(", bonId=").append(bonId);
        sb.append('}');
        return sb.toString();
    }
}
