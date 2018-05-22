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
import static com.codename1.ui.Component.TOP;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Font;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import Entities.Recette;
import java.io.IOException;
import java.util.ArrayList;
import service.RecetteService;

/**
 *
 * @author Siala
 */
public class ClientProfil {
    Form f;
    SpanLabel lb;
   private Resources theme;
    Font l1_font = Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_LARGE);
    public ClientProfil(int idLogged) throws IOException {
       
        
        
     System.out.println(idLogged);   
    f = new Form("Mon Profile",BoxLayout.y());
    theme = UIManager.initFirstTheme("/RonRonTheme");
    ////////////////////////////////////////////////////////////
  /*  UserService US = new UserService();
    ArrayList<User> Ulist= US.MSUserById(idLogged);
    for(int j=0;j<Ulist.size();j++){
      Container C1=new Container(new BoxLayout(BoxLayout.Y_AXIS));  
      Label lBienvenue = new Label("Bienvenue ");
      Label lMail = new Label("            "+Ulist.get(j).getEmail());
      C1.add(lBienvenue);
      C1.add(lMail);
       f.add(C1);
    C1.getAllStyles().setBgTransparency(255);
    C1.getAllStyles().setBgColor(0xE3AFBC);
    C1.getAllStyles().setMarginBottom(10);
    C1.getAllStyles().setMarginRight(5);
    C1.getAllStyles().setMarginLeft(5);
    C1.getAllStyles().setMarginTop(10);
    }  */
    //////////////////////////////////////////////////////////// Add Recette
    Label AddRecette = new Label("Ajouter une nouvelle Recette ");
    AddRecette.getUnselectedStyle().setFgColor(0xFFFFFF);
    Container C2=new Container(new BoxLayout(BoxLayout.Y_AXIS)); 
    C2.add(AddRecette);
    f.add(C2);
    C2.getAllStyles().setBgTransparency(255);
    C2.getAllStyles().setBgColor(0x9A1750);
    C2.getAllStyles().setMarginBottom(10);
    C2.getAllStyles().setMarginRight(5);
    C2.getAllStyles().setMarginLeft(5);
    C2.getAllStyles().setMarginTop(10);
    //////////////////////////////////////////////////////////// Go to Stat
    Label GoStat = new Label("Stat: popularité de mes recettes ");
    GoStat.addPointerPressedListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                  MsStat ar = null;
            try {
                ar = new MsStat(idLogged);
            } catch (IOException ex) {
                //Logger.getLogger(Affichage.class.getName()).log(Level.SEVERE, null, ex);
            }
            ar.getF().show();
             
                 }
             });
    
    GoStat.getUnselectedStyle().setFgColor(0xFFFFFF);
    Container C3=new Container(new BoxLayout(BoxLayout.Y_AXIS)); 
    C3.add(GoStat);  
    f.add(C3);
    C3.getAllStyles().setBgTransparency(255);
    C3.getAllStyles().setBgColor(0xEE4C7C);
    C3.getAllStyles().setMarginBottom(10);
    C3.getAllStyles().setMarginRight(5);
    C3.getAllStyles().setMarginLeft(5);
    C3.getAllStyles().setMarginTop(10);
    //////////////////////////////////////////////////////////// Mes Recettes
    Container C4=new Container(new BoxLayout(BoxLayout.Y_AXIS)); 
    Label mesRecette = new Label("              Mes Recettes");
    mesRecette.getUnselectedStyle().setFont(l1_font);
    mesRecette.getUnselectedStyle().setFgColor(0xFFFFFF);
    C4.add(mesRecette);
    C4.getAllStyles().setBgTransparency(255);
    C4.getAllStyles().setBgColor(0x990033);
    C4.getAllStyles().setMarginBottom(10);
    C4.getAllStyles().setMarginRight(5);
    C4.getAllStyles().setMarginLeft(5);
    C4.getAllStyles().setMarginTop(10);
    RecetteService Rec= new RecetteService();
    ArrayList<Recette> Reclist= Rec.RecettesByUser(idLogged);
     if (Reclist.size()>0){
            for(int i=0; i<Reclist.size()  ;i++){
            
               Container C7=new Container(new BoxLayout(BoxLayout.Y_AXIS));
               Label Nom = new Label(Reclist.get(i).getNom()+" ");
              
               Nom.getUnselectedStyle().setFont(l1_font);
               Nom.setTextPosition(TOP);
               Nom.getUnselectedStyle().setFgColor(0xFA8072);
             
             
               Label Type = new Label("Type:  " + Reclist.get(i).getType()+"               "); 
               String nom_image = Reclist.get(i).getNom_image();
            
                Button btnConsulter = new Button("Consulter");
                Button btnModif = new Button("     Modifier    ");
                Button btnSupp = new Button("   Supprimer     ");
                 Container C6=new Container(new BoxLayout(BoxLayout.X_AXIS));
                 
                 C6.add(btnModif);
                 C6.add(btnSupp);
                ////////////////////////////////////////////////////// affichage de l'image
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
                C7.add(C6);
                C7.getAllStyles().setBgTransparency(255);
                C7.getAllStyles().setBgColor(0xFFFFFF);
                C7.getAllStyles().setMarginBottom(10);
                C7.getAllStyles().setMarginRight(15);
                C7.getAllStyles().setMarginLeft(15);
                C7.getAllStyles().setMarginTop(10);
                C4.add(C7);
    /////////////////////////////////////////////////////////Consult Recette gui    
            System.out.println(Reclist.get(i).getId());
            int idR = Reclist.get(i).getId();
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
    /////////////////////////////////////////////////////////////////////////// Ajouter Recette
    AddRecette.addPointerPressedListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                  AddRecette ar = null;
            try {
                ar = new AddRecette(idLogged);
            } catch (IOException ex) {
                //Logger.getLogger(Affichage.class.getName()).log(Level.SEVERE, null, ex);
            }
            ar.getF().show();
             
                 }
             });
    ///////////////////////////////////////////////////////////////////////// ////Supprimer Recette   
        btnSupp.addActionListener((e)->{
            RecetteService RecSer = new RecetteService();
            RecSer.SuppRecette(idR);
            Dialog.show("","Recette Supprimée!","OK",null);
                ClientProfil ar = null;
            try {
                ar = new ClientProfil(idLogged);
            } catch (IOException ex) {
                //Logger.getLogger(Affichage.class.getName()).log(Level.SEVERE, null, ex);
            }
            ar.getF().show();
             
                 
             });
    ///////////////////////////////////////////////////////////////////////// ////Modifier Recette  
        btnModif.addActionListener((e)->{
           
                ModifyRecette ar = null;
            try {
                ar = new ModifyRecette(idLogged,idR);
            } catch (IOException ex) {
                //Logger.getLogger(Affichage.class.getName()).log(Level.SEVERE, null, ex);
            }
            ar.getF().show();
             
                 
             });   
    ///////////////////////////////////////////////////////////////////////// ////
            }
    } else{
        Label noRecette = new Label("Vous n'avez pas de recette!");
        C4.add(noRecette);
    }
    ////////////////////////////////////////////////////////////
    f.add(C4);
    f.getToolbar().addCommandToRightBar("back", null, (ev)->{HomeForm h;
        h = new HomeForm(idLogged);
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
