/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Entities.Ligne_Commande;
import Entities.Utilisateurs_Adresses;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkManager;

/**
 *
 * @author beryl kristina
 */
public class LigneServices {
    
     public void ajoutligne(Ligne_Commande ta) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/kristina/cupcackes_pi/web/app_dev.php/addligne/" + ta.getCommande() + "/" +ta.getProduit() + "/" + ta.getQuantite() + "/" + ta.getPrixp();
        con.setUrl(Url);

        System.out.println("tt");

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
//            if (str.trim().equalsIgnoreCase("OK")) {
//                f2.setTitle(tlogin.getText());
//             f2.show();
//            }
//            else{
//            Dialog.show("error", "login ou pwd invalid", "ok", null);
//            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
    
}
