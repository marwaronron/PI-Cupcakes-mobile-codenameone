/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author beryl kristina
 */
public class Produits {
     private int id;
    private String nom;
 //   private String description;
  //  private String disponible;
    private float prix;
 //   private String categorie;
    private String img;
    
    
    private int quantite;

    public Produits() {
    }
    
    

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
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





    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }



    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Produits(int id, String nom, String description, String disponible, float prix, String categorie, String img) {
        this.id = id;
        this.nom = nom;
       
        this.prix = prix;
       
        this.img = img;
       
    }

    @Override
    public String toString() {
        return "Produits{" + "id=" + id + ", nom=" + nom + ", prix=" + prix + ", img=" + img+'}';
    }


    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Produits other = (Produits) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
}
