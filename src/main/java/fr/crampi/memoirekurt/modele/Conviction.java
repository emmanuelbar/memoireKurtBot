package fr.crampi.memoirekurt.modele;

import javax.persistence.*;

/**
 * Created by crampi on 08/04/17.
 */
@Entity
@Table(name = "conviction")
public class Conviction {
    @Id
    @GeneratedValue
    private int id;
    /**
     * foreign key with table politic
     */

    @Column(name = "libelle")
    private String libelle;
    /**
     * source is a url
     */
    @Column(name = "source")
    private String source;

    @ManyToOne
    @JoinColumn(name = "id_politic")
    private Politic politic;

    public Conviction(int idPolitic, String libelle, String source) {
        this.libelle = libelle;
        this.source = source;
    }

    public Conviction() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String details) {
        this.source = details;
    }

    @Override
    public String toString() {
        return "Conviction{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                ", source='" + source + '\'' +
                '}';
    }
}
