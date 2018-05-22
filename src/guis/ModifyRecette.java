/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guis;

import com.codename1.components.FloatingActionButton;
import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.io.FileSystemStorage;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import Entities.Recette;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import service.RecetteService;

/**
 *
 * @author Siala
 */
public class ModifyRecette {
    Form f;
    SpanLabel lb;
    private Resources theme;
    
      private String imgName = "";
    private String imgPath = "";
    Font l1_font = Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_LARGE);
    
    public ModifyRecette(int idLogged,int idR) throws IOException {
        theme = UIManager.initFirstTheme("/RonRonTheme");
        f = new Form("Modifier votre Recette");
        RecetteService Rec=new RecetteService();
        Container C1=new Container(new BoxLayout(BoxLayout.Y_AXIS));
        C1.getAllStyles().setBgTransparency(255);
        C1.getAllStyles().setBgColor(0xFFFFFF);
        C1.getAllStyles().setMarginTop(10);
        C1.getAllStyles().setMarginBottom(10);
        C1.getAllStyles().setMarginRight(5);
        C1.getAllStyles().setMarginLeft(5); 
        
        
        
        
        
        
        ArrayList<Recette> lis=Rec.UneRecette(idR);
       
//        Rec.UneRecette(id);
        for(int i=0; i<lis.size()  ;i++){
   //     f.setTitle(lis.get(i).getNom());
        
        
        TextField tfNom =new TextField(lis.get(i).getNom());
        ComboBox type = new ComboBox("Biscuits","Chocolat"," Gateux et Entremets","Cremes et Confitures","Tartes","Spécialités Tunisiennes","Traiteur(salé)","Pains et Viennoiseries","Recettes de base","Diététiques");
        type.setSelectedItem(lis.get(i).getType());
        Label AddImage = new Label("Modifier l'image ");
        AddImage.getUnselectedStyle().setFont(l1_font);
        AddImage.getUnselectedStyle().setFgColor(0xFF6666);
        ///////////////////////////////:
        FloatingActionButton fab = FloatingActionButton.createFAB(FontImage.MATERIAL_IMAGE);
        fab.addActionListener((ActionListener) (ActionEvent evt) -> {
           Display.getInstance().openGallery((ActionListener) (ActionEvent ev) -> {
                if (ev != null && ev.getSource() != null) {
                    imgPath = (String) ev.getSource();
                    int fileNameIndex = imgPath.lastIndexOf("/") + 1;
                    imgName = imgPath.substring(fileNameIndex);

                    try {

                        InputStream is = FileSystemStorage.getInstance().openInputStream(imgPath);
                        Image im = Image.createImage(is);
                        
                      //  Image listingMask = res.getImage("refimg2.jpg");

//                        profile.setIcon(im.fill(listingMask.getWidth(), listingMask.getHeight()));
//                        refreshTheme();
                        System.out.println(imgPath);
                        System.out.println(imgName);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }, Display.GALLERY_IMAGE);
            
        });
        ///////////////////////////////////
        TextField  tfIngredients = new TextField (lis.get(i).getIngredients());
        TextField  tfEtapes = new TextField (lis.get(i).getEtapes());
        Label lnom = new Label("Nom: ");
        Label ltype = new Label("Type: ");
        Label ling = new Label("Ingrédients: ");
        Label letapes = new Label("Etapes: ");
        lnom.getUnselectedStyle().setFont(l1_font);
        lnom.getUnselectedStyle().setFgColor(0xFF6666);
        ltype.getUnselectedStyle().setFont(l1_font);
        ltype.getUnselectedStyle().setFgColor(0xFF6666);
        ling.getUnselectedStyle().setFont(l1_font);
        ling.getUnselectedStyle().setFgColor(0xFF6666);
        letapes.getUnselectedStyle().setFont(l1_font);
        letapes.getUnselectedStyle().setFgColor(0xFF6666);
        Button Add = new Button("Modifier!");
        C1.add(lnom); 
        C1.add(tfNom);
        C1.add(ltype);
        C1.add(type);
           ImageViewer ab = new ImageViewer (theme.getImage("msABC.jpg"));
        C1.add(AddImage);
        C1.add(fab);
        C1.add(ling);
        C1.add(tfIngredients);
        C1.add(letapes);
        C1.add(tfEtapes);
        C1.add(Add);
        f.add(C1); 
        
        Add.addActionListener((e)->{
          
            RecetteService ser = new RecetteService();
            if(tfNom.getText().isEmpty() ||type.getSelectCommandText().isEmpty() ||tfIngredients.getText().isEmpty() || tfEtapes.getText().isEmpty()  ){
                Dialog.show("Erreur", "Veuillez remplir tout les données", "accepter", null); 
            } else{
            ser.ModifyRecette(idR, tfNom.getText(),type.getSelectedItem().toString(),"msABC.jpg",tfIngredients.getText(),tfEtapes.getText());
             Dialog.show("", "Recette Modifiée", "ok", null);
             ClientProfil h;
            try {
                h = new ClientProfil(idLogged);
                h.getF().show();
            } catch (IOException ex) {
               // Logger.getLogger(ShowRecette.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        });
        
        
        
        
        
        
        
        
        
        
        
        
        
    }    
        
        
        
        
         f.getToolbar().addCommandToRightBar("back", null, (ActionEvent ev)->{
          
             ClientProfil h;
            try {
                h = new ClientProfil(idLogged);
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
