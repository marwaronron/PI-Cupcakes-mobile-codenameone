/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guis;

import com.codename1.components.MediaPlayer;
import com.codename1.io.Log;
import com.codename1.media.Media;
import com.codename1.media.MediaManager;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import java.io.IOException;

/**
 *
 * @author Siala
 */
public class Videos {
        Font l1_font = Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_LARGE);
      public Videos(int idLogged) throws IOException {
      final Form f = new Form("MediaPlayer", new BorderLayout());
f.setToolbar(new Toolbar());
Style s = UIManager.getInstance().getComponentStyle("Title");

 Label x=new Label("Recette Gateau Chocolat");
 x.getUnselectedStyle().setFgColor(0x660033);
 x.getUnselectedStyle().setFont(l1_font);
 //Label y=new Label("Recette Cupcakes");
// y.getUnselectedStyle().setFgColor(0x660033);
// y.getUnselectedStyle().setFont(l1_font);

//FontImage icon = FontImage.createMaterial(FontImage.MATERIAL_VIDEO_LIBRARY, s);
//f.getToolbar().addCommandToRightBar(new Command("", icon) {
  //  @Override
   // public void actionPerformed(ActionEvent evt) {
    //    Display.getInstance().openGallery((e) -> {
          //  if(e != null && e.getSource() != null) {
              //  String file = (String)e.getSource();
              //  try {
             
                    Media video = MediaManager.createMedia("file:/C:/Users/Siala/Desktop/Recette.mp4", true);
                   // Media video2= MediaManager.createMedia("file:/C:/Users/Siala/Desktop/francais/1.mp4", true);
                    f.removeAll();
                    f.add(BorderLayout.NORTH,x);
                    f.add(BorderLayout.CENTER, new MediaPlayer(video));
                   // f.add(BorderLayout.SOUTH,y);
                   // f.add(BorderLayout.SOUTH, new MediaPlayer(video2));
                    f.revalidate();
                    
                    
                    
                
              //  } 
                //catch(IOException err) {
                //    Log.e(err);
                //} 
          //  }
      //  }, Display.GALLERY_VIDEO);
   // }
//});



 f.getToolbar().addCommandToRightBar("back", null, (ev)->{Affichage h;
            try {
                h = new Affichage(idLogged);
                 h.getF().show();
            } catch (IOException ex) {
               
            }
       
        });

f.show(); 
    }

  /*  public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    } */
}
