/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Entities.Commentaire;
import Entities.Recette;
import Entities.Vote;
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
 * @author Siala
 */
public class RecetteService {
    public ArrayList<Recette> getList2() {
        ArrayList<Recette> listTasks = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/ansiw/web/app_dev.php/recette/Moball");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();
                
                try {
                    Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                  //  System.out.println(tasks);
                    //System.out.println(tasks);
                    List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
                    for (Map<String, Object> obj : list) {
                        Recette task = new Recette();
                        float id = Float.parseFloat(obj.get("id").toString());
                        
                        task.setId((int) id);
                        task.setNom(obj.get("nom").toString());
                        task.setType(obj.get("type").toString());
                        task.setNom_image(obj.get("nomImage").toString());
                       
                     //   task.setIngredients(obj.get("ingredients").toString());
                      //  task.setEtapes(obj.get("etapes").toString());
                       // task.setDifficulte(obj.get("difficulte").toString());
                        listTasks.add(task);
                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listTasks;
    }
    
    
    public ArrayList<Recette> getSearchList(String nom){
        ArrayList<Recette> listTasks = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/ansiw/web/app_dev.php/recette/MobByName/"+nom);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();
                
                try {
                    Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                  //  System.out.println(tasks);
                    //System.out.println(tasks);
                    List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
                    for (Map<String, Object> obj : list) {
                        Recette task = new Recette();
                        float id = Float.parseFloat(obj.get("id").toString());
                        
                        task.setId((int) id);
                        task.setNom(obj.get("nom").toString());
                        task.setType(obj.get("type").toString());
                        task.setNom_image(obj.get("nomImage").toString());
                        System.out.println("test : "+ obj.get("nomImage").toString());
                        task.setIngredients(obj.get("ingredients").toString());
                        task.setEtapes(obj.get("etapes").toString());
                        task.setDifficulte(obj.get("difficulte").toString());
                        listTasks.add(task);
                    }
                } catch (IOException ex) {
                    
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listTasks; 
    }
    
    public ArrayList<Recette> UneRecette(int id){
         ArrayList<Recette> listTasks = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/ansiw/web/app_dev.php/recette/MobByID/"+id);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();
                
                try {
                    Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                  //  System.out.println(tasks);
                    //System.out.println(tasks);
                    List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
                    for (Map<String, Object> obj : list) {
                        Recette task = new Recette();
                        float id = Float.parseFloat(obj.get("id").toString());
                        
                        task.setId((int) id);
                       
                        task.setNom(obj.get("nom").toString());
                        task.setType(obj.get("type").toString());
                        task.setNom_image(obj.get("nomImage").toString());
                        System.out.println("test : "+ obj.get("nomImage").toString());
                        task.setIngredients(obj.get("ingredients").toString());
                        task.setEtapes(obj.get("etapes").toString());
                        task.setDifficulte(obj.get("difficulte").toString());
                        listTasks.add(task);
                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listTasks;      
    }
    
    public ArrayList<Commentaire> CommentsOfRecette(int id){
         ArrayList<Commentaire> listTasks = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/ansiw/web/app_dev.php/recette/MobCommentsOfRec/"+id);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();
                
                try {
                    Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                   // System.out.println(tasks);
                    //System.out.println(tasks);
                    List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
                    for (Map<String, Object> obj : list) {
                        Commentaire task = new Commentaire();
                        float id = Float.parseFloat(obj.get("id").toString());
                        
                        task.setId((int) id);
                      
                        task.setComment(obj.get("comment").toString());
                    
                        listTasks.add(task);
                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listTasks;      
    }
    
    public ArrayList<Vote> NotesOfRecette(int id){
         ArrayList<Vote> listTasks = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/ansiw/web/app_dev.php/recette/MobRecetteNote/"+id);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();
                
                try {
                    Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                 //   System.out.println(tasks);
                    //System.out.println(tasks);
                    List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
                    for (Map<String, Object> obj : list) {
                        Vote task = new Vote();
                        float id = Float.parseFloat(obj.get("id").toString());
                        
                        task.setId((int) id);
                      
                        task.setRating((int)Double.parseDouble((obj.get("rating").toString())));
                    
                        listTasks.add(task);
                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listTasks;      
    }
    
    public void AddCom(int idRecette,int  idLogged,String Com) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/ansiw/web/app_dev.php/recette/MobAddComment/" + idRecette + "/" + idLogged+ "/" + Com;
        con.setUrl(Url);

      //  System.out.println("tt");

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
        
    public void AddVotee(int idRecette,int laNote) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/ansiw/web/app_dev.php/recette/MobAddVote/" + idRecette + "/" + laNote;
        con.setUrl(Url);

      //  System.out.println("tt");

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
    ///////////////////////////////////////////////////////////////////////////////////TOP 
    public int Top1(){
        RecetteService serviceTask=new RecetteService();
        ArrayList<Recette> lis=serviceTask.getList2();
       
        int StartSomme=0;
        int idTop1=0;
        for(int i=0; i<lis.size()  ;i++){
            int id= lis.get(i).getId();
            ArrayList<Vote> lis2=serviceTask.NotesOfRecette(id);
            if(lis2.size()>0){
                int SommeVotes=0;
                for(int k=0; k<lis2.size()  ;k++){
                  SommeVotes=SommeVotes+ lis2.get(k).getRating();
                 }
                if(StartSomme<SommeVotes){
                    StartSomme=SommeVotes;
                    idTop1=id;
                }
            }
        }
        return idTop1;
    }
    
/*    public int Top2(){
        int idTop1=0;
        if(Top1()!=0){
           RecetteService serviceTask=new RecetteService();
           ArrayList<Recette> lis=serviceTask.getList2();
         
           int StartSomme=0;
          
           for(int i=0; i<lis.size()  ;i++){
               int id= lis.get(i).getId();
               ArrayList<Vote> lis2=serviceTask.NotesOfRecette(id);
               if(lis2.size()>0 && id!=Top1()){
                    int SommeVotes=0;
                    for(int k=0; k<lis2.size()  ;k++){
                     SommeVotes=SommeVotes+ lis2.get(k).getRating();
                    }
                   if(StartSomme<SommeVotes){
                    StartSomme=SommeVotes;
                    idTop1=id;
                    }
                }
           } 
        }
        return idTop1;
    }

    public int Top3(){
        int idTop1=0;
        if(Top2()!=0){
           RecetteService serviceTask=new RecetteService();
           ArrayList<Recette> lis=serviceTask.getList2();
         
           int StartSomme=0;
          
           for(int i=0; i<lis.size()  ;i++){
               int id= lis.get(i).getId();
               ArrayList<Vote> lis2=serviceTask.NotesOfRecette(id);
               if(lis2.size()>0 && id!=Top1()&& id!=Top2()){
                    int SommeVotes=0;
                    for(int k=0; k<lis2.size()  ;k++){
                     SommeVotes=SommeVotes+ lis2.get(k).getRating();
                    }
                   if(StartSomme<SommeVotes){
                    StartSomme=SommeVotes;
                    idTop1=id;
                    }
                }
           } 
        }
        return idTop1;
    }
    
    public int Top4(){
        int idTop1=0;
        if(Top3()!=0){
           RecetteService serviceTask=new RecetteService();
           ArrayList<Recette> lis=serviceTask.getList2();
          
           int StartSomme=0;
          
           for(int i=0; i<lis.size()  ;i++){
               int id= lis.get(i).getId();
               ArrayList<Vote> lis2=serviceTask.NotesOfRecette(id);
               if(lis2.size()>0 && id!=Top1()&& id!=Top2()&& id!=Top3()){
                    int SommeVotes=0;
                    for(int k=0; k<lis2.size()  ;k++){
                     SommeVotes=SommeVotes+ lis2.get(k).getRating();
                    }
                   if(StartSomme<SommeVotes){
                    StartSomme=SommeVotes;
                    idTop1=id;
                    }
                }
           } 
        }
        return idTop1;
    }
    
    public int Top5(){
        int idTop1=0;
        if(Top4()!=0){
           RecetteService serviceTask=new RecetteService();
           ArrayList<Recette> lis=serviceTask.getList2();
           
           int StartSomme=0;
          
           for(int i=0; i<lis.size()  ;i++){
               int id= lis.get(i).getId();
               ArrayList<Vote> lis2=serviceTask.NotesOfRecette(id);
               if(lis2.size()>0 && id!=Top1()&& id!=Top2()&& id!=Top3()&& id!=Top4()){
                    int SommeVotes=0;
                    for(int k=0; k<lis2.size()  ;k++){
                     SommeVotes=SommeVotes+ lis2.get(k).getRating();
                    }
                   if(StartSomme<SommeVotes){
                    StartSomme=SommeVotes;
                    idTop1=id;
                    }
                }
           } 
        }
        return idTop1;
    }  */
      public ArrayList<Recette> UneRecetteTop(int id){
         ArrayList<Recette> listTasks = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/ansiw/web/app_dev.php/recette/MobByID/"+id);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();
                
                try {
                    Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                  //  System.out.println(tasks);
                    //System.out.println(tasks);
                    List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
                    for (Map<String, Object> obj : list) {
                        Recette task = new Recette();
                        float id = Float.parseFloat(obj.get("id").toString());
                        
                        task.setId((int) id);
                       
                        task.setNom(obj.get("nom").toString());
                      
                        task.setNom_image(obj.get("nomImage").toString());
                       
                        listTasks.add(task);
                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listTasks;      
    }
      
   /////////////////////////::::::::::::::::: FIN TOP
    public ArrayList<Recette> RecettesByUser(int idLogged){
        ArrayList<Recette> listTasks = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/ansiw/web/app_dev.php/recette/MobRecByUser/"+idLogged);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();
                
                try {
                    Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                  //  System.out.println(tasks);
                    //System.out.println(tasks);
                    List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
                    for (Map<String, Object> obj : list) {
                        Recette task = new Recette();
                        float id = Float.parseFloat(obj.get("id").toString());
                        
                        task.setId((int) id);
                        task.setNom(obj.get("nom").toString());
                        task.setType(obj.get("type").toString());
                        task.setNom_image(obj.get("nomImage").toString());
                        System.out.println("test : "+ obj.get("nomImage").toString());
                        task.setIngredients(obj.get("ingredients").toString());
                        task.setEtapes(obj.get("etapes").toString());
                        task.setDifficulte(obj.get("difficulte").toString());
                        listTasks.add(task);
                    }
                } catch (IOException ex) {
                    
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listTasks; 
    }
    
    public void AddRecette(int idLogged,String  tfNom,String type,String imgName,String tfIngredients, String tfEtapes) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/ansiw/web/app_dev.php/recette/MobAddRecette/" + idLogged + "/" + tfNom+ "/" + type+ "/" +imgName+ "/" +tfIngredients+ "/" +tfEtapes;
        con.setUrl(Url);

      //  System.out.println("tt");

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
    
    public void SuppRecette(int idR) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/ansiw/web/app_dev.php/recette/MobSuppRecette/" + idR;
        con.setUrl(Url);

      //  System.out.println("tt");

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        }
        public void ModifyRecette(int idR,String  tfNom,String type,String imgName,String tfIngredients, String tfEtapes) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/ansiw/web/app_dev.php/recette/MobModifRecette/" +idR+ "/" + tfNom+ "/" + type+ "/" +imgName+ "/" +tfIngredients+ "/" +tfEtapes;
        con.setUrl(Url);

      //  System.out.println("tt");

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }  
}
