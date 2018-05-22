/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author Siala
 */
public class Recette {
     private int id=10;
     private User iduser;
     private String nom;
     private String type;
     private String description;
     private String nom_image;
     private String cout;

     private int nb_personne;
     private String difficulte;
     private String astuces;
     private String ingredients;
     private String etapes;

     
    public Recette(int id, User iduser, String nom, String type, String description, String nom_image, String cout, int nb_personne, String difficulte, String astuces, String ingredients, String etapes) {
        this.id = id;
        this.iduser = iduser;
        this.nom = nom;
        this.type = type;
        this.description = description;
        this.nom_image = nom_image;
        this.cout = cout;
     
        this.nb_personne = nb_personne;
        this.difficulte = difficulte;
        this.astuces = astuces;
        this.ingredients = ingredients;
        this.etapes = etapes;
    }

    public Recette(User iduser, String nom, String type, String description, String nom_image, String cout, int nb_personne, String difficulte, String astuces, String ingredients, String etapes) {
        this.iduser = iduser;
        this.nom = nom;
        this.type = type;
        this.description = description;
        this.nom_image = nom_image;
        this.cout = cout;
     
        this.nb_personne = nb_personne;
        this.difficulte = difficulte;
        this.astuces = astuces;
        this.ingredients = ingredients;
        this.etapes = etapes;
    }

    public Recette() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getIduser() {
        return iduser;
    }

    public void setIduser(User iduser) {
        this.iduser = iduser;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNom_image() {
        return nom_image;
    }

    public void setNom_image(String nom_image) {
        this.nom_image = nom_image;
    }

    public String getCout() {
        return cout;
    }

    public void setCout(String cout) {
        this.cout = cout;
    }



    public int getNb_personne() {
        return nb_personne;
    }

    public void setNb_personne(int nb_personne) {
        this.nb_personne = nb_personne;
    }

    public String getDifficulte() {
        return difficulte;
    }

    public void setDifficulte(String difficulte) {
        this.difficulte = difficulte;
    }

    public String getAstuces() {
        return astuces;
    }

    public void setAstuces(String astuces) {
        this.astuces = astuces;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getEtapes() {
        return etapes;
    }

    public void setEtapes(String etapes) {
        this.etapes = etapes;
    }

    @Override
    public String toString() {
        return "Recette{" + "id=" + id + ", iduser=" + iduser + ", nom=" + nom + ", type=" + type + ", description=" + description + ", nom_image=" + nom_image + ", cout=" + cout + ", nb_personne=" + nb_personne + ", difficulte=" + difficulte + ", astuces=" + astuces + ", ingredients=" + ingredients + ", etapes=" + etapes + '}';
    }
 
}
