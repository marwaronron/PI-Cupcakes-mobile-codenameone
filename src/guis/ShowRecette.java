/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guis;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import Entities.Commentaire;
import Entities.Recette;
import Entities.Vote;
import java.io.IOException;
import java.util.ArrayList;
import service.RecetteService;

/**
 *
 * @author Siala
 */
public class ShowRecette {
    Form f;
    SpanLabel lb;
     private Resources theme;
    public ShowRecette(int id,int idLogged) throws IOException {
        theme = UIManager.initFirstTheme("/RonRonTheme");
        f = new Form();
       RecetteService Rec=new RecetteService();
       ArrayList<Recette> lis=Rec.UneRecette(id);
       
//        Rec.UneRecette(id);
        for(int i=0; i<lis.size()  ;i++){
        f.setTitle(lis.get(i).getNom());
        RecetteService serviceTask=new RecetteService();
    
        Container C1=new Container(new BoxLayout(BoxLayout.Y_AXIS));
        Container C2=new Container(new BoxLayout(BoxLayout.Y_AXIS));
        Container C3=new Container(new BoxLayout(BoxLayout.Y_AXIS));
        Container C4=new Container(new BoxLayout(BoxLayout.Y_AXIS));
        Container C5=new Container(new BoxLayout(BoxLayout.Y_AXIS));
        Container C6=new Container(new BoxLayout(BoxLayout.Y_AXIS));
        ///////////////////////////////////////////////////
        Label lNom = new Label("Nom: "+lis.get(i).getNom());
   //    Label lUser = new Label("Proposée par:"+ lis.get(i).getIduser().getUsername());
    // Label lUser = new Label("Proposée par:");
        Label lType = new Label("Type: "+lis.get(i).getType());
         //////////////////////////////////////////////////////////////////// Vote
     //   double x=(double)v1/(double)v;
        ArrayList<Vote> lis2=Rec.NotesOfRecette(id);
        int SommeVotes=0;
         for(int k=0; k<lis2.size()  ;k++){
             SommeVotes=SommeVotes+ lis2.get(k).getRating();
             
         }
        double x=0;
        if(SommeVotes>0){
          x =(double)SommeVotes/(double)lis2.size();
        }
        
           Label lNote = new Label("Note:"+String.valueOf(x).substring(0,3)+"/5");
        ////////////////////////////////////////////////////////////////////////// Image
        String nomImg= lis.get(i).getNom_image();
        EncodedImage img = EncodedImage.createFromImage(Image.createImage(Display.getInstance().getDisplayWidth(),150), true);
        URLImage imgg= URLImage.createToStorage(img, "http://localhost/ansiw/web/images/"+nomImg, "http://localhost/ansiw/web/images/"+nomImg);
        imgg.fetch();
        ImageViewer imgv = new ImageViewer(imgg);
        int fiveMM = Display.getInstance().convertToPixels(20);
        final Image finalDuke = imgg.scaledWidth(fiveMM);
        //////////////////////////////////////////////////
        Label lIng = new Label("Ingrédients: ");
        TextArea Ing = new TextArea(lis.get(i).getIngredients());
        
        Label lEtapes = new Label("Etapes: ");
        TextArea Etapes = new TextArea(lis.get(i).getEtapes());
        ////////////////////////////////////////////////////////////////////////////////////////// COMMENTAIRES
        Label lComment = new Label("Commentaires sur cette recette");
         C6.add(lComment);
       Button AddComment = new Button("Ajouter un Commentaire");
            //Add Comment gui    
             
             AddComment.addActionListener((e)->{
                 AddComment Cm;
            try {
                Cm = new AddComment(id,idLogged);
                Cm.getF().show();
            } catch (IOException ex) {
               // Logger.getLogger(ShowRecette.class.getName()).log(Level.SEVERE, null, ex);
            }
              
            }); 
        // end of add Comment
       ArrayList<Commentaire> lis1=Rec.CommentsOfRecette(id);
       if(lis1.size()>0){
       for(int j=0; j<lis1.size()  ;j++){
           Container C7=new Container(new BoxLayout(BoxLayout.X_AXIS)); 
           Container C8=new Container(new BoxLayout(BoxLayout.Y_AXIS));
           Container C9=new Container(new BoxLayout(BoxLayout.Y_AXIS));
      //    Label lUserNom= new Label("comment de:"+lis1.get(j).getIduser().getUsername());
          ImageViewer imgUser = new ImageViewer(theme.getImage("msuser1.png"));
       
          C8.add(imgUser);
//          C8.add(lUserNom);
          
          TextArea com = new TextArea(lis1.get(j).getComment());
          C9.add(com );
          C7.add(C8);
          C7.add(C9);
          C6.add(C7);
        C8.getAllStyles().setBgTransparency(255);
        C8.getAllStyles().setBgColor(0xFFFFFF);
        C8.getAllStyles().setMarginBottom(10);
        C8.getAllStyles().setMarginRight(5);
        C8.getAllStyles().setMarginLeft(2);
        
        C9.getAllStyles().setBgTransparency(255);
        C9.getAllStyles().setBgColor(0x895061);
        C9.getAllStyles().setMarginBottom(10);
        C9.getAllStyles().setMarginRight(5);
        C9.getAllStyles().setMarginLeft(2);
       }
       }else{
               Label NoComment = new Label("aucune Commentaire!");
               C6.add(NoComment);
        } 
       
        //////////////////////////////////////////////////////////////////////////////////////////////::::
        C2.getAllStyles().setBgTransparency(255);
        C2.getAllStyles().setBgColor(0xFFFFFF);
        C2.getAllStyles().setMarginBottom(10);
        C2.getAllStyles().setMarginRight(5);
        C2.getAllStyles().setMarginLeft(5);
        //////////////////////////////////////////////
        C3.getAllStyles().setBgTransparency(255);
        C3.getAllStyles().setBgColor(0xEDB5BF);
        C3.getAllStyles().setMarginBottom(10);
        C3.getAllStyles().setMarginRight(5);
        C3.getAllStyles().setMarginLeft(5);
        //////////////////////////////////////////////
        C4.getAllStyles().setBgTransparency(255);
        C4.getAllStyles().setBgColor(0xFF6666);
        C4.getAllStyles().setMarginBottom(10);
        C4.getAllStyles().setMarginRight(5);
        C4.getAllStyles().setMarginLeft(5);
        //////////////////////////////////////////////
        C5.getAllStyles().setBgTransparency(255);
        C5.getAllStyles().setBgColor(0xFF6666);
        C5.getAllStyles().setMarginBottom(10);
        C5.getAllStyles().setMarginRight(5);
        C5.getAllStyles().setMarginLeft(5);
        //////////////////////////////////////////////
        C6.getAllStyles().setBgTransparency(255);
        C6.getAllStyles().setBgColor(0xFFFFFF);
        C6.getAllStyles().setMarginBottom(10);
        C6.getAllStyles().setMarginRight(5);
        C6.getAllStyles().setMarginLeft(5);
        //////////////////////////////////////////////
        C2.add(imgv);
        C1.add(C2);
        ////////////////////////////////////////////////////Vote
        Container C10=new Container(new BoxLayout(BoxLayout.X_AXIS));
        C10.getAllStyles().setBgTransparency(255);
        C10.getAllStyles().setBgColor(0xE1515F);
        C10.getAllStyles().setMarginBottom(10);
        C10.getAllStyles().setMarginRight(5);
        C10.getAllStyles().setMarginLeft(5);
          Label Noter = new Label("Noter Cette Recette !");
          Noter.addPointerPressedListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                  AddVote Vt;
            try {
                Vt = new AddVote(id,idLogged);
                Vt.getF().show();
            } catch (IOException ex) {
               // Logger.getLogger(ShowRecette.class.getName()).log(Level.SEVERE, null, ex);
            }
                
             
                 }
             });
               
           
          C10.add(Noter);
          
        ////////////////////////////////////////////////////////
        C3.add(lNom);
//        C3.add(lUser);
        C3.add(lType);
        C3.add(lNote);
        C1.add(C3);
      C1.add(C10);
        C4.add(lIng);
        C4.add(Ing);
        C1.add(C4);
        C5.add(lEtapes);
        C5.add(Etapes);
        C1.add(C5);
//        C6.add(lComment);
        C6.add(AddComment);
        C1.add(C6);
        
        f.add(C1);
         f.getToolbar().addCommandToRightBar("back", null, (ev)->{Affichage h;
            try {
                h = new Affichage(idLogged);
                h.getF().show();
            } catch (IOException ex) {
               // Logger.getLogger(ShowRecette.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        });
        }
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
}
