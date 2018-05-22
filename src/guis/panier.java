/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guis;

import Entities.Produits;
import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BoxLayout;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import service.ServiceProduit;

/**
 *
 * @author beryl kristina
 */
public class panier {
    Form f;
    SpanLabel lb;

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

   
    public panier(int id,int idLogged ) throws IOException 
            
    {
        f = new Form();
        f.setTitle("le panier");
        Container C1=new Container(new BoxLayout(BoxLayout.Y_AXIS));
        Label totalProduit = new Label();
        Button continuer = new Button("poursuivre commande");
        Button retour = new Button("continuer achats");        
       
        
        continuer.addActionListener((e)->{
        adresse a = null;
        try {
                a = new adresse(id,idLogged);
                a.getF().show();
                 } catch (IOException ex) {
                //Logger.getLogger(Affichage.class.getName()).log(Level.SEVERE, null, ex);
                 }
        
        });
        
        retour.addActionListener((e)->{
        shop sh = null;
        try {
                sh = new shop(idLogged);
                sh.getF().show();
                 } catch (IOException ex) {
                //Logger.getLogger(Affichage.class.getName()).log(Level.SEVERE, null, ex);
                 }
        
        });
               
         ArrayList<Produits> lis = new ArrayList<>();
        for(Produits p: shop.produit)
        {
            
            lis.add(p);
            
            Button b = new Button("supprimer");
            TextField tf = new TextField("1");
            p.setQuantite(1);
            shop.produit.get(shop.produit.indexOf(p)).setQuantite(1);
            float prix=0f;
            
            if(tf.getText()!=null)
               {
                 prix= p.getPrix()*Float.parseFloat(tf.getText());
               }
            
             b.addActionListener((e)->{
              shop.produit.remove(p);
                panier po = null;
                 try {
                 po = new panier(id,idLogged);
                  po.getF().show();
                  } catch (IOException ex) {
                //Logger.getLogger(Affichage.class.getName()).log(Level.SEVERE, null, ex);
                  }
         
            });
            Container C2 =new Container(new BoxLayout(BoxLayout.Y_AXIS));
        
            Label nom = new Label(p.getNom());
            Label prixtot = new Label(Float.toString(prix));
            String nom_image = p.getImg();
              EncodedImage img = EncodedImage.createFromImage(Image.createImage(Display.getInstance().getDisplayWidth(),150), true);
                  URLImage imgg= URLImage.createToStorage(img, "http://localhost/ansiw/web/images/"+nom_image, "http://localhost/ansiw/web/images/"+nom_image);
                  
                  imgg.fetch();
                  ImageViewer imgv = new ImageViewer(imgg);
                  int fiveMM = Display.getInstance().convertToPixels(20);
                  final Image finalDuke = imgg.scaledWidth(fiveMM);
            C2.add(imgv);
            C2.add(nom);
            C2.add(new Label(Float.toString(p.getPrix())));
            C2.add(tf);
            C2.add(prixtot);
            C2.add(b);
            
            C1.add(C2);
            
            
            tf.addDataChangedListener((ev,e)->{
            float prixp=0f;
            
            try{
             prixp= p.getPrix()*Float.parseFloat(tf.getText());
             int index = shop.produit.indexOf(p);     
             p.setPrix(prixp);
             p.setQuantite(Integer.parseInt(tf.getText()));
             shop.produit.get(index).setPrix(prixp);
             shop.produit.get(index).setQuantite(p.getQuantite());
             
             System.out.println(shop.produit);
             prixtot.setText(Float.toString(prixp));
            
             Float total = calculTotal(shop.produit);
             totalProduit.setText(total.toString());
             
            }catch(NumberFormatException ex)
                  {
                      System.out.println("");
                  }      
             
        });
        }
        
             Float total = calculTotal(shop.produit);
             totalProduit.setText(total.toString());
             
            f.add(C1);  
            f.add(totalProduit);
            
            f.add(retour);
            f.add(continuer);
           
        
    }

   public float calculTotal(List<Produits> prod)
    {
       float total=0f; 
     for(Produits p: prod)
    {  
       total+=p.getPrix();   
    }
      return total;
    }
    
    
}
