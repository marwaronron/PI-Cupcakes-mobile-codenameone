/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Entities.Commandes;
import Entities.Utilisateurs_Adresses;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Date;

/**
 *
 * @author beryl kristina
 */
public class CommandesServices {
    
     public void ajoutcommande(Commandes ta) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/kristina/cupcackes_pi/web/app_dev.php/addcomande/" + ta.getDate() + "/" +ta.getPrixtotal() + "/" + ta.getAdresse_id();
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
     
     public ArrayList<Commandes> getdate(Date date){    
        ArrayList<Commandes> listTasks = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/kristina/cupcackes_pi/web/app_dev.php/dateaffich/"+date);  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
              JSONParser jsonp = new JSONParser();
               try {
                    Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    System.out.println(tasks);
                    java.util.Date date_util = new java.util.Date();
                     //java.sql.Date date_sql = new java.sql.Date(date_util.getTime());
                    //System.out.println(tasks);
                    List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
                    for (Map<String, Object> obj : list) {
                        Commandes task = new Commandes();
                       
                        
                       task.setDate(date_util);
                        listTasks.add(task);
                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listTasks;
    
    }
}
