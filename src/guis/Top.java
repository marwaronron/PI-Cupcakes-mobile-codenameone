/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guis;

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
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.layouts.BoxLayout;
import Entities.Recette;
import Entities.Vote;
import java.io.IOException;
import java.util.ArrayList;
import service.RecetteService;

/**
 *
 * @author Siala
 */
public class Top {
   Form f;
    SpanLabel lb;
  
    public Top(int idLogged) throws IOException {
        
        f = new Form("Top Recette",BoxLayout.y());
     
        RecetteService Rec=new RecetteService();
        /////////////////////////////////////////////////////////////TOP1
   
       ArrayList<Recette> lis=Rec.UneRecetteTop(Rec.Top1()); 
       
        for(int i=0; i<lis.size()  ;i++){
            final int idR =lis.get(i).getId();
            Container CTop1=new Container(new BoxLayout(BoxLayout.Y_AXIS));
            Label Nom = new Label("Top Recette: "+lis.get(i).getNom()+" ");
           String nom_image = lis.get(i).getNom_image();
            ArrayList<Vote> lis2=Rec.NotesOfRecette(idR);
            int SommeVotes=0;
            for(int k=0; k<lis2.size(); k++){
               SommeVotes=SommeVotes+ lis2.get(k).getRating();
            }
            Label lNote = new Label("Score: "+String.valueOf(SommeVotes)+" (Somme des notes)"); 
           Button btnConsulter = new Button("Consulter");
            btnConsulter.addActionListener((ActionEvent e)->{
                
            //  final 
            ShowRecette SR = null;
            try {
                SR = new ShowRecette(idR,idLogged);
                SR.getF().show();
            } catch (IOException ex) {
                //Logger.getLogger(Affichage.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        });
                //////////////////////////////////////////////////////
                  EncodedImage img = EncodedImage.createFromImage(Image.createImage(Display.getInstance().getDisplayWidth(),150), true);
                  URLImage imgg= URLImage.createToStorage(img, "http://localhost/ansiw/web/images/"+nom_image, "http://localhost/ansiw/web/images/"+nom_image);
                  imgg.fetch();
                  ImageViewer imgv = new ImageViewer(imgg);
                //  int fiveMM = Display.getInstance().convertToPixels(20);
                //  final Image finalDuke = imgg.scaledWidth(fiveMM); 
                //////////////////////////////////////////////////////
                Nom.setTextPosition(Component.TOP);
                CTop1.add(Nom);
//                CTop1.add(lNote);
              CTop1.add(imgv);
                CTop1.add(btnConsulter);
                CTop1.getAllStyles().setBgTransparency(255);
                CTop1.getAllStyles().setBgColor(0xE7717D);
                CTop1.getAllStyles().setMarginTop(10);
                CTop1.getAllStyles().setMarginBottom(25);
                CTop1.getAllStyles().setMarginRight(7);
                CTop1.getAllStyles().setMarginLeft(7);
               
         f.add(CTop1);
              
      
      }
    
    
        f.getToolbar().addCommandToRightBar("back", null, (ev)->{Affichage h;
            try {
                h = new Affichage(idLogged);
                 h.getF().show();
            } catch (IOException ex) {
               
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
