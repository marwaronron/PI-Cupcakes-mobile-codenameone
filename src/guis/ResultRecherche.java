/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guis;

import Entities.Recette;
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
import service.RecetteService;

/**
 *
 * @author Siala
 */
public class ResultRecherche {
   Form f;
    SpanLabel lb;
     public ResultRecherche(String nom,int idLogged) throws IOException {
        
        f = new Form();
        f.setTitle("Résultat de recherche");
        RecetteService serviceTask=new RecetteService();
    
        Container C5=new Container(new BoxLayout(BoxLayout.Y_AXIS));
        
         
            
       ArrayList<Recette> lis1 = serviceTask.getSearchList(nom);
        if (lis1.size()>0){
            for(int i=0; i<lis1.size()  ;i++){
            
               Container C7=new Container(new BoxLayout(BoxLayout.Y_AXIS));
               Label Nom = new Label(lis1.get(i).getNom()+" ");
               Nom.getUnselectedStyle().setFgColor(0x990033);
               Label Type = new Label("Type:  " + lis1.get(i).getType()+"               "); // don't change this line
               String nom_image = lis1.get(i).getNom_image();
            
                Button btnConsulter = new Button("Consulter");
                //////////////////////////////////////////////////////
                  EncodedImage img = EncodedImage.createFromImage(Image.createImage(Display.getInstance().getDisplayWidth(),150), true);
                  URLImage imgg= URLImage.createToStorage(img, "http://localhost/ansiw/web/images/"+nom_image, "http://localhost/ansiw/web/images/"+nom_image);
                  imgg.fetch();
                  ImageViewer imgv = new ImageViewer(imgg);
                  int fiveMM = Display.getInstance().convertToPixels(20);
                  final Image finalDuke = imgg.scaledWidth(fiveMM);
                //////////////////////////////////////////////////////
                Nom.setTextPosition(Component.TOP);
                C7.add(Nom);
                C7.add(Type);
                C7.add(imgv);
                C7.add(btnConsulter);
                C7.getAllStyles().setBgTransparency(255);
                C7.getAllStyles().setBgColor(0xFFFFFF);
                C7.getAllStyles().setMarginBottom(10);
                C7.getAllStyles().setMarginRight(5);
                C7.getAllStyles().setMarginLeft(5);
                C7.getAllStyles().setMarginTop(10);
                C5.add(C7);
                  //Consult Recette gui    
             System.out.println(lis1.get(i).getId());
             int idR = lis1.get(i).getId();
            btnConsulter.addActionListener((e)->{
                
            //  final 
            ShowRecette SR = null;
            try {
                SR = new ShowRecette(idR,idLogged);
                SR.getF().show();
            } catch (IOException ex) {
                //Logger.getLogger(Affichage.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        });
        // end of Consult
            }
        } else{
            Label noRecette = new Label("aucune résultat pour votre recherche");
            C5.add(noRecette);
        }
        f.add(C5);
        f.getToolbar().addCommandToRightBar("back", null, (ev)->{
            Affichage a = null;
            try {
                a = new Affichage(idLogged);
                a.getF().show();
            } catch (IOException ex) {
             //   Logger.getLogger(ResultRecherche.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        });
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
   
}
