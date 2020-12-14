package com.ecommerce.microcommerce.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/* Model pour Entity avec JPA*/

@Entity
public class Product {
    /*
    If you are not maintaining any sequence in database, then Use @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY ) It will automatically maintain a unique Identification for your table.
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Integer id;
    private String nom;
    private Float prix;


    public Product() {
        super();
    }


    public Product(String nom, Float prix) {
        super();
        this.nom=nom;
        this.prix=prix;
    }




    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Float getPrix() {
        return prix;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }
}
