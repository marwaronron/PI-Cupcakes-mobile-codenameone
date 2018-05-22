/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import com.codename1.io.ConnectionRequest;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.util.Resources;
import com.codename1.ui.util.UIBuilder;

/**
 *
 * @author Siala
 */
public class HomeGuide {
      Form f;
    EncodedImage encoded;
    Resources themeG,themeT;

    public HomeGuide(Resources theme) {

        UIBuilder uib = new UIBuilder();
        Container ctn = uib.createContainer(theme,"GUI 1");
        f = ctn.getComponentForm();
        ConnectionRequest con = new ConnectionRequest();
        f.show();
        
        
        
           UIBuilder ui = new UIBuilder();
       // Form f = ui.createContainer(theme,"GUI 2").getComponentForm();
    
       
    }
     public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
}
