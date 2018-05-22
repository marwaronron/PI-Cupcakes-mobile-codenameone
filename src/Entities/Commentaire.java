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
public class Commentaire {
   private int id;
    private Recette idrecette;
    private User iduser;
    
    private String comment;

    public Commentaire(int id,Recette idrecette, User iduser,  String comment) {
        this.id = id;
        this.idrecette = idrecette;
        this.iduser = iduser;
        
        this.comment = comment;
    }

    public Commentaire(int id, String comment) {
        this.id = id;
        this.comment = comment;
    }

    public Commentaire(Recette idrecette,User iduser, String comment) {
        this.idrecette = idrecette;
        this.iduser = iduser;
        
        this.comment = comment;
    }

    public Commentaire() {
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
    
    public User getIduser() {
        return iduser;
    }

    public void setIduser(User iduser) {
        this.iduser = iduser;
    }



    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


    @Override
    public String toString() {
        return "Commentaire{" + "id=" + id + ", idrecette=" + idrecette +", iduser=" + iduser +  ", comment=" + comment + '}';
    }
       
}
