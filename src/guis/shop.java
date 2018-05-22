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
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
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
public class shop {
    
    Form f;
    SpanLabel lb;
    public static List<Produits> produit = new ArrayList<>();
  
    public shop(int idLogged ) throws IOException
    {
        f = new Form();
        f.setTitle("Nos patisseries");
        
        Container C7=new Container(new BoxLayout(BoxLayout.Y_AXIS));
        ServiceProduit st = new ServiceProduit();
        
        ArrayList<Produits> list = st.getList2();
        
        
        for(int i=0; i<list.size()  ;i++)
        {
            Container C=new Container(new BoxLayout(BoxLayout.Y_AXIS));
            Label Nom = new Label(list.get(i).getNom()+" ");
           // Label description = new Label(list.get(i).getDescription()+" ");
            Label prix = new Label(Float.toString(list.get(i).getPrix()));
            
            int idp = list.get(i).getId();
            String nom_image = list.get(i).getImg();
            System.out.println(nom_image);
            Button ajouterpanier = new Button("ajouter au panier");
            
              if(shop.produit.contains(list.get(i)))
            {
             ajouterpanier.setEnabled(false);
            
            }
            else{
                ajouterpanier.setEnabled(true);
            }
           
                //////////////////////////////////////////////////////
                  EncodedImage img = EncodedImage.createFromImage(Image.createImage(Display.getInstance().getDisplayWidth(),150), true);
                  URLImage imgg= URLImage.createToStorage(img, "http://localhost/ansiw/web/images/"+nom_image, "http://localhost/ansiw/web/images/"+nom_image);
                  
                  imgg.fetch();
                  ImageViewer imgv = new ImageViewer(imgg);
                  int fiveMM = Display.getInstance().convertToPixels(20);
                  final Image finalDuke = imgg.scaledWidth(fiveMM);
                //////////////////////////////////////////////////////
                Nom.setTextPosition(Component.TOP);
                C.add(Nom);
                C.add(prix);
             //   C.add(description);
                C.add(imgv);
                C.add(ajouterpanier);
                C.getAllStyles().setBgTransparency(255);
                C.getAllStyles().setBgColor(0xFFFFFF);
                C.getAllStyles().setMarginBottom(10);
                C.getAllStyles().setMarginRight(5);
                C.getAllStyles().setMarginLeft(5);
                
                final int j=i;
                
            
                
                ajouterpanier.addActionListener((e)->{
                    
                //ajouterpanier.setEnabled(false);
                produit.add(list.get(j));
                                 
                panier p = null;
                 try {
                p = new panier(idp,idLogged);
                p.getF().show();
                 } catch (IOException ex) {
                //Logger.getLogger(Affichage.class.getName()).log(Level.SEVERE, null, ex);
                  }
                
                });
                
                C7.add(C);
        }
        
          f.add(C7);
        f.getToolbar().addCommandToRightBar("back", null, (ev)->{HomeForm h=new HomeForm(idLogged);
        h.getF().show();
        });
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
    
    
}
