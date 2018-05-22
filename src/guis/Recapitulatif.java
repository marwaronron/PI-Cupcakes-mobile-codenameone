/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guis;

import Entities.Commandes;
import Entities.Ligne_Commande;
import Entities.Produits;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.myapp.MyApplication;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import service.CommandesServices;
import service.LigneServices;

/**
 *
 * @author beryl kristina
 */
public class Recapitulatif {
     Form f;
    SpanLabel lb;

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
    
    public Recapitulatif (int id,int idLogged ) throws IOException
            {
                 f = new Form();
                 f.setTitle("Recapitulatif de votre commande");
                 
                 
                  Container C1=new Container(new BoxLayout(BoxLayout.Y_AXIS));
                  Button valider = new Button("valider ma commande");
        
        
                 Label l1 = new Label("Monsieur/Madame : ");
                 Label nom = new Label();
                 Label l2 = new Label("votre adresse de livraison : ");
                 Label adres = new Label();
                 Label l3 = new Label("Nombre d'article choisit : ");
                 Label article = new Label();
                 Label l4 = new Label("le prix total de votre commande est : ");
                 Label total = new Label();
                 
                 
                 
                 panier pa = new panier(id,idLogged);
                 nom.setText(MyApplication.user.get(id).getUsername());
                 adres.setText(adresse.choixAddr);
                 article.setText(Integer.toString(shop.produit.size()));
                 total.setText(Float.toString(pa.calculTotal(shop.produit)));
                 
                 valider.addActionListener((ActionEvent e)->{
                    
                         
                         CommandesServices cmd = new CommandesServices();
                         LigneServices li = new LigneServices();
                         Date d = new Date();
                         
                         Commandes com = new Commandes(MyApplication.user.get(id), d, pa.calculTotal(shop.produit), adresse.adress);
                         cmd.ajoutcommande(com);
                         
                         for(Produits pro : shop.produit)
                         {
                             ArrayList<Commandes> cmdes = cmd.getdate(d);
                             Ligne_Commande lc = new Ligne_Commande(pro.getPrix(), pro.getQuantite(), cmdes.get(id), pro);
                             li.ajoutligne(lc);
                         }
                    
              
                 
                     
                      confirmation conf = null;
            
                      conf = new confirmation(); //Logger.getLogger(Affichage.class.getName()).log(Level.SEVERE, null, ex);
                      conf.getF().show();
                 
                 });
                 
                 C1.add(l1);
                 C1.add(nom);
                 C1.add(l2);
                 C1.add(adres);
                 C1.add(l3);
                 C1.add(article);
                 C1.add(l4);
                 C1.add(total);
                 C1.add(valider);
                 f.add(C1);
                 
                         
                 
            }
    
}
