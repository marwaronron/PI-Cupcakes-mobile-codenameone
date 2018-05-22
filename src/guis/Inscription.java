/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guis;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.MyApplication;
import java.io.IOException;
import service.RecetteService;
import service.UserService;

/**
 *
 * @author Siala
 */
public class Inscription {
        Form f;
    SpanLabel lb;
      private Resources theme;
     public Inscription() throws IOException {
        
        theme = UIManager.initFirstTheme("/RonRonTheme");
        f = new Form();
        f.setTitle("Inscription");
        Container C1=new Container(BoxLayout.y());
        Label lUsername = new Label("Username:");
        TextField tfUsername= new TextField();
        Label lMdp = new Label("Mot de passe :");
        TextField tfMdp= new TextField();
        
         Label lMdp2 = new Label("Mot de passe 2éme essay:");
        TextField tfMdp2= new TextField();
        Label lMail = new Label("Email:");
        TextField tfMail= new TextField();
        ComboBox Role = new ComboBox("Client","Responsable");
        
        Button Add = new Button("S'inscrire!");
        Add.addActionListener((e)->{
            String x=""; 
            if(Role.getSelectedItem().toString()=="Client"){
                x="a:1:{i:0;s:11:\"ROLE_CLIENT\";}";
            }else 
                 if(Role.getSelectedItem().toString()=="Responsable"){
                x="a:1:{i:0;s:16:\"ROLE_RESPONSABLE\";}";
            }
            if(tfMdp2.getText()==tfMdp.getText()){
            UserService ser = new UserService();
            ser.AddUser(tfUsername.getText(), tfMdp.getText(), tfMail.getText(),x);
             Dialog.show("", "Bienvenue dans cupcakes", "ok", null);
             MyApplication h;
             h = new  MyApplication(); // Logger.getLogger(ShowRecette.class.getName()).log(Level.SEVERE, null, ex);
             f.showBack();
            }
            }); 
        C1.getAllStyles().setBgTransparency(255);
        C1.getAllStyles().setBgColor(0x895061);
        C1.getAllStyles().setMarginBottom(10);
        C1.getAllStyles().setMarginRight(5);
        C1.getAllStyles().setMarginLeft(2);
        C1.getAllStyles().setMarginTop(10);
      C1.add(lUsername);
       C1.add(tfUsername);
        C1.add(lMdp);
         C1.add(tfMdp);
          C1.add(lMdp2);
           C1.add(tfMdp2);
            C1.add(lMail);
            C1.add(tfMail);
           C1.add(Role);
           
            
        C1.add(Add);
        f.add(C1);
        f.getToolbar().addCommandToRightBar("back", null, (ev)->{ShowRecette h;
           f.showBack();
        
        });
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    } 
}
