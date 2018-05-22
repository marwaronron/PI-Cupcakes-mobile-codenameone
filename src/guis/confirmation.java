/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guis;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Form;
import com.codename1.ui.Label;

/**
 *
 * @author beryl kristina
 */
public class confirmation {
    
     Form f;
    SpanLabel lb;

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
    
    public confirmation()
    {
    
         f = new Form();
        f.setTitle("confirmation");
        
        Label l = new Label("votre commande a ete enregistrée");
        f.add(l);
    }
    
}
