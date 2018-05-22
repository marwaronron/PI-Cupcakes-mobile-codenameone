/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guis;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import static com.codename1.ui.Component.CENTER;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import java.io.IOException;
import service.RecetteService;

/**
 *
 * @author Siala
 */
public class AddVote {
    Form f;
    SpanLabel lb;
      private Resources theme;
     public AddVote(int idRecette,int idLogged) throws IOException {
        
        theme = UIManager.initFirstTheme("/VoteTheme");
        
        f = new Form("Noter",new com.codename1.ui.layouts.FlowLayout(Component.CENTER,CENTER));
       
        Container C1=new Container(BoxLayout.y());
        Container C2= new Container(BoxLayout.x());
        Label Titre = new Label("Noter la Recette");
       
        Button S1 = new Button("1");
        Button S2 = new Button("2");
        Button S3 = new Button("3");
        Button S4 = new Button("4");
        Button S5 = new Button("5");
        ////////////////////////////////////////////
        S1.addActionListener((e)->{
            RecetteService ser = new RecetteService();
            ser.AddVotee(idRecette,1);
             Dialog.show("", "Merci d'avoir noté la recette", "ok", null);
             ShowRecette h;
            try {
                h = new ShowRecette(idRecette,idLogged);
                h.getF().show();
            } catch (IOException ex) {
               // Logger.getLogger(ShowRecette.class.getName()).log(Level.SEVERE, null, ex);
            }
            }); 
        /////////////////////////////////////////////////////
        S2.addActionListener((e)->{
            RecetteService ser = new RecetteService();
            ser.AddVotee(idRecette,2);
             Dialog.show("", "Merci d'avoir noté la recette", "ok", null);
             ShowRecette h;
            try {
                h = new ShowRecette(idRecette,idLogged);
                h.getF().show();
            } catch (IOException ex) {
               // Logger.getLogger(ShowRecette.class.getName()).log(Level.SEVERE, null, ex);
            }
            });
        /////////////////////////////////////////////////////
        S3.addActionListener((e)->{
            RecetteService ser = new RecetteService();
            ser.AddVotee(idRecette,3);
             Dialog.show("", "Merci d'avoir noté la recette", "ok", null);
             ShowRecette h;
            try {
                h = new ShowRecette(idRecette,idLogged);
                h.getF().show();
            } catch (IOException ex) {
               // Logger.getLogger(ShowRecette.class.getName()).log(Level.SEVERE, null, ex);
            }
            }); 
        /////////////////////////////////////////
        S4.addActionListener((e)->{
            RecetteService ser = new RecetteService();
            ser.AddVotee(idRecette,4);
             Dialog.show("", "Merci d'avoir noté la recette", "ok", null);
             ShowRecette h;
            try {
                h = new ShowRecette(idRecette,idLogged);
                h.getF().show();
            } catch (IOException ex) {
               // Logger.getLogger(ShowRecette.class.getName()).log(Level.SEVERE, null, ex);
            }
            });
        /////////////////////////////////////////////////////
        S5.addActionListener((e)->{
            RecetteService ser = new RecetteService();
            ser.AddVotee(idRecette,5);
             Dialog.show("", "Merci d'avoir noté la recette", "ok", null);
             ShowRecette h;
            try {
                h = new ShowRecette(idRecette,idLogged);
                h.getF().show();
            } catch (IOException ex) {
               // Logger.getLogger(ShowRecette.class.getName()).log(Level.SEVERE, null, ex);
            }
            });
        /////////////////////////////////////////////////////
        C1.getAllStyles().setBgTransparency(255);
        C1.getAllStyles().setBgColor(0xEDB5BF);
        C1.getAllStyles().setMarginBottom(10);
        C1.getAllStyles().setMarginRight(5);
        C1.getAllStyles().setMarginLeft(2);
        C1.add(Titre);
       
        C2.add(S1);
        C2.add(S2);
        C2.add(S3);
        C2.add(S4);
        C2.add(S5);
        C1.add(C2);
        f.add(C1);
        f.getToolbar().addCommandToRightBar("back", null, (ev)->{ShowRecette h;
            try {
                h = new ShowRecette(idRecette,idLogged);
                h.getF().show();
            } catch (IOException ex) {
               // Logger.getLogger(ShowRecette.class.getName()).log(Level.SEVERE, null, ex);
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
