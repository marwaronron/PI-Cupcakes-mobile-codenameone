/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guis;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import java.io.IOException;
import service.RecetteService;

/**
 *
 * @author Siala
 */
public class AddComment {
     Form f;
    SpanLabel lb;
      private Resources theme;
     public AddComment(int idRecette,int idLogged) throws IOException {
        
        theme = UIManager.initFirstTheme("/RonRonTheme");
        f = new Form();
        Container C1=new Container(BoxLayout.y());
        Label Titre = new Label("Ajouter un Commentaire");
        TextArea Com= new TextArea("Votre Commentaire ici..");
        Button Add = new Button("Ajouter !");
        Add.addActionListener((e)->{
            RecetteService ser = new RecetteService();
            ser.AddCom(idRecette, idLogged, Com.getText());
             Dialog.show("", "Commentaire Ajoutée", "ok", null);
             ShowRecette h;
            try {
                h = new ShowRecette(idRecette,idLogged);
                h.getF().show();
            } catch (IOException ex) {
               // Logger.getLogger(ShowRecette.class.getName()).log(Level.SEVERE, null, ex);
            }
            }); 
        C1.getAllStyles().setBgTransparency(255);
        C1.getAllStyles().setBgColor(0x895061);
        C1.getAllStyles().setMarginBottom(10);
        C1.getAllStyles().setMarginRight(5);
        C1.getAllStyles().setMarginLeft(2);
        C1.getAllStyles().setMarginTop(10);
        C1.add(Titre);
        C1.add(Com);
        C1.add(Add);
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
