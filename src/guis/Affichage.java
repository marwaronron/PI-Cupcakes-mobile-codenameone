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
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import java.io.IOException;
import java.util.ArrayList;
import service.RecetteService;

/**
 *
 * @author Siala
 */
public class Affichage {
     Form f;
    SpanLabel lb;
  
    public Affichage(int idLogged) throws IOException {
        
      f = new Form();
      f.setTitle("Recettes");
      //    //////////////////////////////////////////////////////////////////
        
      
 


        
        
        /////////////////////////////////////////:
        RecetteService serviceTask=new RecetteService();
        ArrayList<Recette> lis=serviceTask.getList2();
        Container C5=new Container(new BoxLayout(BoxLayout.Y_AXIS));
         
            TextField tfSearchR = new TextField();
            Button btnSearchR = new Button("Chercher une Recette ");
            C5.add(tfSearchR);
            C5.add(btnSearchR);
        //go to search gui    
        tfSearchR.addActionListener((e)->{
            final String nameRec= tfSearchR.getText();
            ResultRecherche RR = null;
            try {
                RR = new ResultRecherche(nameRec,idLogged);
            } catch (IOException ex) {
                //Logger.getLogger(Affichage.class.getName()).log(Level.SEVERE, null, ex);
            }
            RR.getF().show();
        });
        // end of search
        ///////////////////////// TOP 5
        /*  Button top5 = new Button("Consulter TOP5 Recette >");
         // top5.getAllStyles().setBgColor(0xBF4040);
            C5.add(top5);
              top5.addActionListener((e)->{
           
            Top top = null;
            try {
                top = new Top(idLogged);
            } catch (IOException ex) {
                //Logger.getLogger(Affichage.class.getName()).log(Level.SEVERE, null, ex);
            }
            top.getF().show();
        });*/
        Label top5=new Label("          Consulter TOP Recette ");
        Container Ctop=new Container(new BoxLayout(BoxLayout.Y_AXIS));
             Ctop.getAllStyles().setBgTransparency(255);
                Ctop.getAllStyles().setBgColor(0xE7717D);
                Ctop.getAllStyles().setMarginBottom(10);
                Ctop.getAllStyles().setMarginRight(5);
                Ctop.getAllStyles().setMarginLeft(5);
        Ctop.add(top5);
        C5.add(Ctop);
        top5.addPointerPressedListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                
              
                  Top top = null;
            try {
                top = new Top(idLogged);
            } catch (IOException ex) {
                //Logger.getLogger(Affichage.class.getName()).log(Level.SEVERE, null, ex);
            }
            top.getF().show();
             
                 }
             });
        ///////////////////////////////////////////////////////////////////////////////////:
        Label vid=new Label("         Vidéos de Recettes ");
        Container Ctop1=new Container(new BoxLayout(BoxLayout.X_AXIS));
        Style s = UIManager.getInstance().getComponentStyle("Title");
        FontImage icon = FontImage.createMaterial(FontImage.MATERIAL_VIDEO_LIBRARY, s);
             Ctop1.getAllStyles().setBgTransparency(255);
                Ctop1.getAllStyles().setBgColor(0xE7717D);
                Ctop1.getAllStyles().setMarginBottom(10);
                Ctop1.getAllStyles().setMarginRight(5);
                Ctop1.getAllStyles().setMarginLeft(5);
                Ctop1.add(icon);
        Ctop1.add(vid);
        C5.add(Ctop1);
        vid.addPointerPressedListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                  Videos top = null;
                try {
                    top = new Videos(idLogged); //Logger.getLogger(Affichage.class.getName()).log(Level.SEVERE, null, ex);
                    //  top.getF().show();
                } catch (IOException ex) {
                   // Logger.getLogger(Affichage.class.getName()).log(Level.SEVERE, null, ex);
                }
             
                 }
             });
        ///////////////////////////////////////////////////////////////////////////////////
           for(int i=0; i<lis.size()  ;i++){
            
               Container C7=new Container(new BoxLayout(BoxLayout.Y_AXIS));
               Label Nom = new Label(lis.get(i).getNom()+" ");
               Label Type = new Label("Type:  " + lis.get(i).getType()+"               "); // don't change this line
               String nom_image = lis.get(i).getNom_image();
            
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
                 Nom.getUnselectedStyle().setFgColor(0x990033);
                C7.add(Nom);
                C7.add(Type);
                C7.add(imgv);
                C7.add(btnConsulter);
                C7.getAllStyles().setBgTransparency(255);
                C7.getAllStyles().setBgColor(0xFFFFFF);
                C7.getAllStyles().setMarginBottom(10);
                C7.getAllStyles().setMarginRight(5);
                C7.getAllStyles().setMarginLeft(5);
                C5.add(C7);
             //Consult Recette gui    
            // System.out.println(lis.get(i).getId());
             int idR = lis.get(i).getId();
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
        f.add(C5);
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
