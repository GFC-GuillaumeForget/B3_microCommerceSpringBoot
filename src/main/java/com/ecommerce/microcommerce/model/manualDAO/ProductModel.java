package com.ecommerce.microcommerce.model.manualDAO;

public class ProductModel {
    private int id;
    private String nom;
    private Float prix;

    public ProductModel() {

    }
    //constructeur pour les tests
    public ProductModel(int id, String nom, Float prix) {
        this.id=id;
        this.nom=nom;
        this.prix=prix;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
