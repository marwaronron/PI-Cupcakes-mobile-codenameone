/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guis;

import com.codename1.components.SpanLabel;
import com.codename1.maps.Coord;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import java.io.IOException;

/**
 *
 * @author beryl kristina
 */
public class afficheMap extends Form {
     Form f;
     private Form current;
    SpanLabel lb;
    
    public afficheMap()        
    {
       f = new Form();
       f.setTitle("Map Terre");
       f.setLayout(new BorderLayout());
       final MapContainer cnt = new MapContainer();
       
       f.addComponent(BorderLayout.CENTER, cnt);
       
       f.addCommand(new Command("bouger la Camera") {
            public void actionPerformed(ActionEvent ev) {
                cnt.setCameraPosition(new Coord(-33.867, 151.206));
            }
        });
       f.addCommand(new Command("Ajouter un Marker") {
            public void actionPerformed(ActionEvent ev) {
                try {
                    cnt.setCameraPosition(new Coord(41.889, -87.622));
                    cnt.addMarker(EncodedImage.create("/maps-pin.png"), new Coord(41.889, -87.622), "Hi marker", "Optional long description", new ActionListener() {
                        public void actionPerformed(ActionEvent evt) {
                            Dialog.show("Marker Cliqué !", "Tu as  clické sur le  marker", "OK", null);
                        }
                    });
                } catch(IOException err) {
                    // since the image is iin the jar this is unlikely
                    err.printStackTrace();
                }
            }
        });
       
       f.addCommand(new Command("Ajouter chemin") {
            public void actionPerformed(ActionEvent ev) {
                cnt.setCameraPosition(new Coord(-18.142, 178.431));
                cnt.addPath(new Coord(-33.866, 151.195), // Sydney
                    new Coord(-18.142, 178.431),  // Fiji
                    new Coord(21.291, -157.821),  // Hawaii
                    new Coord(37.423, -122.091)  // Mountain View
                );
            }
        });
       
       f.addCommand(new Command("Effacer tout") {
            public void actionPerformed(ActionEvent ev) {
                cnt.clearMapLayers();
            }
        });
       
       f.show();
      
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
    
}
