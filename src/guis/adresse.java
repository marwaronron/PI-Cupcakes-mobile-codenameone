   /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guis;

import Entities.Utilisateurs_Adresses;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.ButtonGroup;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.RadioButton;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.myapp.MyApplication;
import Entities.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import service.AdresseService;

/**
 *
 * @author beryl kristina
 */
public class adresse {
    
   Form f;
    SpanLabel lb;
    public static String choixAddr;
    public static Utilisateurs_Adresses adress;
    
    public adresse (int idp,int idLogged ) throws IOException 
    {
        f = new Form();
        f.setTitle("vos adresses");
        
        Container C1=new Container(new BoxLayout(BoxLayout.Y_AXIS));
        Button poursuivreC = new Button("poursuivre ma commande");
        Button Ajouter = new Button("ajouter adresse");
        Button map = new Button("Map");
        
        ArrayList<User> u1 = new ArrayList<>();
        
        List<Utilisateurs_Adresses> ua1 = new ArrayList<>();
        u1 = MyApplication.user;
        System.out.println("usr"+u1);
        
        AdresseService u = new AdresseService();
        ua1 = u.getListadresse(u1.get(idp).getId());
        
        //ArrayList<Utilisateurs_Adresses> list = u.getListadresse(u1.get(id).getId());
           
           ButtonGroup bt = new ButtonGroup();
         for (Utilisateurs_Adresses addr : ua1) 
         {
             AdresseService ui = new AdresseService();
             RadioButton btn = new RadioButton(addr.affichA());
            
             bt.add(btn);
             
             btn.addActionListener((e)->{
             
             if(btn.isSelected())
             {
             choixAddr=btn.getText();
             adress = addr;
             
             }
                 });
             C1.add(btn);
            
              
         }
          Ajouter.addActionListener((e)->{
        AddAdresse ad = null;
        try {
                ad = new AddAdresse(idp,idLogged);
                ad.getF().show();
                 } catch (IOException ex) {
                //Logger.getLogger(Affichage.class.getName()).log(Level.SEVERE, null, ex);
                 }
        
        });
          
           poursuivreC.addActionListener((e)->{
        
            Recapitulatif recap = null;
            
             try {
                recap = new Recapitulatif(idp,idLogged);
                recap.getF().show();
                 } catch (IOException ex) {
                //Logger.getLogger(Affichage.class.getName()).log(Level.SEVERE, null, ex);
                 }
        });
           
           map.addActionListener((e)->{
           afficheMap af = null;
           
                af = new afficheMap();
                af.getF().show();
                 
           });
        
    f.add(map);
    f.add(C1);
    f.add(poursuivreC);
    f.add(Ajouter);
     f.getToolbar().addCommandToRightBar("back", null, (ev)->{panier h;
            try {
                h = new panier(idp,idLogged);
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
