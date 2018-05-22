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
import java.io.IOException;
import java.io.InputStream;
import service.RecetteService;

/**
 *
 * @author Siala
 */
public class AddRecette {
 //    public static final String API_KEY =  "1ecc5615" ;
 //   public static final String API_SECRET = "P6davZ1wljxoE1U0";
      /*  curl -X POST  https://rest.nexmo.com/sms/json \ 
     -d api_key=1ecc5615 \
     -d api_secret=P6davZ1wljxoE1U0 \
     -d to=21654821045 \
     -d from="NEXMO" \
     -d text="Hello from Nexmo" 
  */
    Form f;
    SpanLabel lb;
    private Resources theme;
    
      private String imgName = "";
    private String imgPath = "";
    Font l1_font = Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_LARGE);
    
    public AddRecette(int idLogged) throws IOException {
        theme = UIManager.initFirstTheme("/RonRonTheme");
        f = new Form("Ajouter Recette");
        RecetteService Rec=new RecetteService();
        Container C1=new Container(new BoxLayout(BoxLayout.Y_AXIS));
        C1.getAllStyles().setBgTransparency(255);
        C1.getAllStyles().setBgColor(0xFFFFFF);
        C1.getAllStyles().setMarginTop(10);
        C1.getAllStyles().setMarginBottom(10);
        C1.getAllStyles().setMarginRight(5);
        C1.getAllStyles().setMarginLeft(5); 
        TextField tfNom =new TextField();
        ComboBox type = new ComboBox("Biscuits","Chocolat"," Gateux et Entremets","Cremes et Confitures","Tartes","Spécialités Tunisiennes","Traiteur(salé)","Pains et Viennoiseries","Recettes de base","Diététiques");
        
        Label AddImage = new Label("Ajouter une Image");
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
        TextField  tfIngredients = new TextField ();
        TextField  tfEtapes = new TextField ();
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
        Button Add = new Button("Ajouter!");
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
            if(tfNom.getText().isEmpty() ||type.getSelectCommandText().isEmpty() ||imgName.isEmpty() ||tfIngredients.getText().isEmpty() || tfEtapes.getText().isEmpty()  ){
                Dialog.show("Erreur", "Veuillez remplir tout les données", "accepter", null); 
            } else{
            ser.AddRecette( idLogged, tfNom.getText(),type.getSelectedItem().toString(),"msABC.jpg",tfIngredients.getText(),tfEtapes.getText());
            Dialog.show("", "Recette Ajoutée", "ok", null);
          
               
             /*   try {
                    sendSMS1();
                } catch (IOException ex) {
                   // Logger.getLogger(AddRecette.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NexmoClientException ex) {
                  //  Logger.getLogger(AddRecette.class.getName()).log(Level.SEVERE, null, ex);
                }
                */
             ClientProfil h;
            try {
                h = new ClientProfil(idLogged);
                h.getF().show();
            } catch (IOException ex) {
               // Logger.getLogger(ShowRecette.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        });
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
    
  /*   private void sendSMS1() throws  IOException, NexmoClientException{
        // 1 mettre un tableau string avec les astuces et choisir avec random
     
        //2 verifier si le num est valide
       
            //3 mettre le key pour s'authentifier au service
        AuthMethod auth = new TokenAuthMethod("1ecc5615", "P6davZ1wljxoE1U0");
        NexmoClient client = new NexmoClient(auth);
        //4 mettre les données de l'sms
        SmsSubmissionResult[] responses = client.getSmsClient().submitMessage(new TextMessage(
        "Cupcakes ",
        "21654821045",
        "Vous avez ajouté une nouvelle Recette!"));
        for (SmsSubmissionResult response : responses) {
            System.out.println(response);
        }
    } */
    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
}
