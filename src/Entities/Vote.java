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
public class Vote {
    private int id;
    private Recette idrecette;
    private int rating;

    public Vote(int id, Recette idrecette, int rating) {
        this.id = id;
        this.idrecette = idrecette;
        this.rating = rating;
    }

    public Vote(Recette idrecette, int rating) {
        this.idrecette = idrecette;
        this.rating = rating;
    }

    public Vote(int rating) {
        this.rating = rating;
    }

    public Vote() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Recette getIdrecette() {
        return idrecette;
    }

    public void setIdrecette(Recette idrecette) {
        this.idrecette = idrecette;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }



 

    @Override
    public String toString() {
        return "Vote{" + "id=" + id + ", idrecette=" + idrecette + ", rating=" + rating + '}';
    }
    
      
}
