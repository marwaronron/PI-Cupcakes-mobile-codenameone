/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guis;

import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.myapp.MyApplication;
import java.io.IOException;

/**
 *
 * @author sana
 */
public class HomeForm {

    Form f;
    TextField tnom;
    TextField tetat;
    Button btnajout,btnaff,btnProfil,btnShop,btnPromo,btnEval,btnPanier,btnLogout;

    public HomeForm(int idLogged) {
        f = new Form("The Cupcakes Corner",BoxLayout.y());
      
       
        /////////////////////////////////////////Profil
        btnProfil=new Button("Profil");
        f.add(btnProfil);
        btnProfil.addActionListener((e)->{
         ClientProfil a = null;
            try {
                a = new ClientProfil(idLogged);
                 a.getF().show();
            } catch (IOException ex) {
              //  Logger.getLogger(HomeForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        ///////////////////////////////////////// Recettes
       btnaff=new Button("Recettes");
        f.add(btnaff);
        btnaff.addActionListener((e)->{
        Affichage a = null;
            try {
                a = new Affichage(idLogged);
                 a.getF().show();
            } catch (IOException ex) {
              //  Logger.getLogger(HomeForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        /////////////////////////////////////////Shop
        btnShop=new Button("Shop");
        f.add(btnShop);
        btnShop.addActionListener((e)->{
            shop s = null;
            try {
                s = new shop(idLogged);
                 s.getF().show();
            } catch (IOException ex) {
              //  Logger.getLogger(HomeForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        ////////////////////////////////////////Promotion
        btnPromo=new Button("Promotions");
        f.add(btnPromo);
        ////////////////////////////////////////Réclamation/Evaluation
        btnEval=new Button("Réclamation/Evaluation");
        f.add(btnEval);
        ///////////////////////////////////////Panier
     //   btnPanier=new Button("Panier");
      //  f.add(btnPanier);
       
         ///////////////////////////////////////Logout
       btnLogout=new Button("Logout");
        f.add(btnLogout);
        btnLogout.addActionListener((e)->{
           f.showBack();
       
        });
        //////////////////////////////////////////////////////////////////
        
       
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

    public TextField getTnom() {
        return tnom;
    }

    public void setTnom(TextField tnom) {
        this.tnom = tnom;
    }

}
