/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guis;

import Entities.Utilisateurs_Adresses;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.MyApplication;
import java.io.IOException;
import service.AdresseService;

/**
 *
 * @author beryl kristina
 */
public class AddAdresse {
    
     Form f;
    SpanLabel lb;
    
    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
    
    public AddAdresse (int id,int idLogged ) throws IOException
            
    {
       
        f = new Form();
        f.setTitle("ajouter nouvelle adresse");
        
        Container C1=new Container(BoxLayout.y());
        
        TextField telephone = new TextField("telephone");
        TextField adresse = new TextField("adresse");
        TextField pays = new TextField("pays");
        TextField ville = new TextField("ville");
        TextField cp = new TextField("code postal");
        TextField complement = new TextField("complement");
        
        Button ajouter = new Button("ajouter");
        
        ajouter.addActionListener((e)->{
            AdresseService ser = new AdresseService();
            Utilisateurs_Adresses ua = new Utilisateurs_Adresses();
            
            ua.setAdresse(adresse.getText());
            ua.setTelephone(Integer.parseInt(telephone.getText()));
            ua.setCp(cp.getText());
            ua.setPays(pays.getText());
            ua.setVille(ville.getText());
            ua.setComplement(complement.getText());
            ua.setUser_id(MyApplication.user.get(id));
            ser.ajoutadresse(ua);
            
            adresse adre = null;
             try {
                adre = new adresse(id,idLogged);
                adre.getF().show();
                 } catch (IOException ex) {
                //Logger.getLogger(Affichage.class.getName()).log(Level.SEVERE, null, ex);
                 }
        });
         C1.add(telephone);
         C1.add(adresse);
         C1.add(pays);
         C1.add(ville);
         C1.add(cp);
         C1.add(complement);
         C1.add(ajouter);
         f.add(C1);
        
        
    
    }
}
