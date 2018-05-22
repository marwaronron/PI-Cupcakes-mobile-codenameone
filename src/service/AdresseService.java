/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Entities.Produits;
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

/**
 *
 * @author beryl kristina
 */
public class AdresseService {
   
    
    public ArrayList<Utilisateurs_Adresses> getListadresse(int id){    
        ArrayList<Utilisateurs_Adresses> listTasks = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/ansiw/web/app_dev.php/recette/affichadress/"+id);  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
              JSONParser jsonp = new JSONParser();
               try {
                    Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    System.out.println(tasks);
                    //System.out.println(tasks);
                    List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
                    for (Map<String, Object> obj : list) {
                        Utilisateurs_Adresses task = new Utilisateurs_Adresses();
                        float id = Float.parseFloat(obj.get("id").toString());
                        float telephone = Float.parseFloat(obj.get("telephone").toString());
                        
                        task.setId((int) id);
                        task.setTelephone((int) telephone);
                       task.setAdresse(obj.get("adresse").toString());
                       task.setPays(obj.get("pays").toString());
                       task.setVille(obj.get("ville").toString());
                       task.setCp(obj.get("cp").toString());
                       task.setComplement(obj.get("complement").toString());
       
                       
                        listTasks.add(task);
                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listTasks;
    
    }
    
    public void ajoutadresse(Utilisateurs_Adresses ta) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/ansiw/web/app_dev.php/recette/addAdress/" + ta.getUser_id() + "/" +ta.getTelephone() + "/" + ta.getAdresse() + "/" + ta.getPays() + "/" + ta.getVille() + "/" + ta.getComplement();
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
