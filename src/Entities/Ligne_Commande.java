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
public class Ligne_Commande {
    
    private int id;
    private Commandes commande;
    private Produits produit;
     private int quantite;
    private float prixp;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Commandes getCommande() {
        return commande;
    }

    public void setCommande(Commandes commande) {
        this.commande = commande;
    }

    public Produits getProduit() {
        return produit;
    }

    public void setProduit(Produits produit) {
        this.produit = produit;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public float getPrixp() {
        return prixp;
    }

    public void setPrixp(float prixp) {
        this.prixp = prixp;
    }

    public Ligne_Commande(int id, Commandes commande, Produits produit, int quantite, float prixp) {
        this.id = id;
        this.commande = commande;
        this.produit = produit;
        this.quantite = quantite;
        this.prixp = prixp;
    }
    
     public Ligne_Commande( float prixp, int quantite, Commandes commande, Produits produit) {
        
        this.prixp = prixp;
        this.quantite = quantite;
        this.commande = commande;
        this.produit = produit;
    }

    @Override
    public String toString() {
        return "Ligne_Commande{" + "id=" + id + ", commande=" + commande + ", produit=" + produit + ", quantite=" + quantite + ", prixp=" + prixp + '}';
    }
    
    
    
}
