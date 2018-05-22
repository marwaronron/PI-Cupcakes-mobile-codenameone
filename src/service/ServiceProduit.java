/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import Entities.Produits;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author beryl kristina
 */
public class ServiceProduit {
    
     public ArrayList<Produits> getListproduit(String json) {

        ArrayList<Produits> listEtudiants = new ArrayList<>();

        try {
            System.out.println(json);
            JSONParser j = new JSONParser();

            Map<String, Object> etudiants = j.parseJSON(new CharArrayReader(json.toCharArray()));
            System.out.println(etudiants);
           
            List<Map<String, Object>> list = (List<Map<String, Object>>) etudiants.get("root");

            for (Map<String, Object> obj : list) {
                Produits e = new Produits();

                // System.out.println(obj.get("id"));
                float id = Float.parseFloat(obj.get("idProduits").toString());
                float prix = Float.parseFloat(obj.get("prix").toString());
                //e.setId(Integer.parseInt(obj.get("id").toString().trim()));
                e.setId((int) id);
                e.setNom(obj.get("nom").toString());
                 e.setImg(obj.get("nomImage").toString());
              //  e.setDescription(obj.get("description").toString());
                e.setPrix((float) prix);
                System.out.println(e);
                listEtudiants.add(e);

            }

        } catch (IOException ex) {
        }
        System.out.println(listEtudiants);
        return listEtudiants;

    }
    ArrayList<Produits> listTasks = new ArrayList<>();
    
    public ArrayList<Produits> getList2(){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/ansiw/web/app_dev.php/recette/allproduits");  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceProduit ser = new ServiceProduit();
                listTasks = ser.getListproduit(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listTasks;
    }
}
