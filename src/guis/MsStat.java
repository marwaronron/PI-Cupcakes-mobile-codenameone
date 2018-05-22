/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guis;

import com.codename1.charts.ChartComponent;
import com.codename1.charts.models.CategorySeries;
import com.codename1.charts.renderers.DefaultRenderer;
import com.codename1.charts.renderers.SimpleSeriesRenderer;
import com.codename1.charts.util.ColorUtil;
import com.codename1.charts.views.PieChart;
import com.codename1.components.SpanLabel;
import com.codename1.io.ConnectionRequest;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.TextArea;
import com.codename1.ui.layouts.BoxLayout;
import Entities.Recette;
import java.io.IOException;
import java.util.ArrayList;
import service.RecetteService;

/**
 *
 * @author Siala
 */
public class MsStat {
    Form f;
    SpanLabel lb;
    /**
     * Creates a renderer for the specified colors.
     */
    private DefaultRenderer buildCategoryRenderer(int[] colors) {
        DefaultRenderer renderer = new DefaultRenderer();
        renderer.setLabelsTextSize(15);
        renderer.setLegendTextSize(15);
        renderer.setMargins(new int[]{20, 30, 15, 0});
        for (int color : colors) {
            SimpleSeriesRenderer r = new SimpleSeriesRenderer();
            r.setColor(color);
            renderer.addSeriesRenderer(r);
        }
        return renderer;
    }

    /**
     * Builds a category series using the provided values.
     *
     * @param titles the series titles
     * @param values the values
     * @return the category series
     */
    protected CategorySeries buildCategoryDataset(String title, double[] values) {
        CategorySeries series = new CategorySeries(title);
        int k = 0;
        //ServiceRandonnee sv = new ServiceRandonnee();
        
    for (double value : values) {
            series.add("Produit" + ++k, value);
        }

        return series;
    }
    public MsStat(int idLogged) throws IOException {
        
        f = new Form("Popularité de mes recettes",BoxLayout.y());
        Container C1=new Container(new BoxLayout(BoxLayout.Y_AXIS)); 
        TextArea lab = new TextArea("Suivre le nombre de mes recettes par rapport au recettes des autres utilisateurs");
    Container C2=new Container(new BoxLayout(BoxLayout.Y_AXIS)); 
    C2.add(lab);
   
    C2.getAllStyles().setBgTransparency(255);
    C2.getAllStyles().setBgColor(0x9A1750);
    C2.getAllStyles().setMarginBottom(5);
    C2.getAllStyles().setMarginRight(5);
    C2.getAllStyles().setMarginLeft(5);
    C2.getAllStyles().setMarginTop(10);
    f.add(C2);
    /////////////////////////////////////
 
    TextArea lab2 = new TextArea("Mes Recettes");
    Container C3=new Container(new BoxLayout(BoxLayout.Y_AXIS)); 
  
    C3.add(lab2);
    C3.getAllStyles().setBgTransparency(255);
    C3.getAllStyles().setBgColor(0x0000FF);
    C3.getAllStyles().setMarginBottom(5);
    C3.getAllStyles().setMarginRight(5);
    C3.getAllStyles().setMarginLeft(5);
    C3.getAllStyles().setMarginTop(5);
 //   f.add(C3);
    /////////////////////////////////////
   
    TextArea lab4 = new TextArea("Recettes des autres clients");
    Container C4=new Container(new BoxLayout(BoxLayout.Y_AXIS)); 
   
    C4.add(lab4);
    C4.getAllStyles().setBgTransparency(255);
    C4.getAllStyles().setBgColor(0xFF00FF);
    C4.getAllStyles().setMarginBottom(5);
    C4.getAllStyles().setMarginRight(5);
    C4.getAllStyles().setMarginLeft(5);
    C4.getAllStyles().setMarginTop(5);
   
     f.add(C3);
    f.add(C4);
       
    
        RecetteService Rec=new RecetteService();
        /////////////////////////////////////////////////////////////STAT
        ConnectionRequest req = new ConnectionRequest();
       
        //array for values
        double[] values = new double[2]; // create table same size as liste 
        
        // value 0 ; nomber of mes recettes
        ArrayList <Recette> le = Rec.RecettesByUser(idLogged);
        values[0]=le.size();
        // value 1 number of recette des autres
        ArrayList <Recette> all = Rec.getList2();
        values[1]=all.size()-le.size();
      
        // Design
        int[] colors = new int[]{ColorUtil.BLUE, ColorUtil.MAGENTA, ColorUtil.MAGENTA, ColorUtil.BLACK, ColorUtil.GRAY};
        DefaultRenderer renderer = buildCategoryRenderer(colors);
        renderer.setZoomButtonsVisible(true);
        renderer.setZoomEnabled(true);
        renderer.setChartTitleTextSize(20);
        renderer.setDisplayValues(true);
        renderer.setShowLabels(true);
        SimpleSeriesRenderer r = renderer.getSeriesRendererAt(0);
        r.setGradientEnabled(true);
        r.setGradientStart(0, ColorUtil.BLUE);
        r.setGradientStop(0, ColorUtil.BLACK);
        r.setHighlighted(true);
        
        SimpleSeriesRenderer r2 = renderer.getSeriesRendererAt(1);
        r2.setGradientEnabled(true);
        r2.setGradientStart(0, ColorUtil.MAGENTA);
        r2.setGradientStop(0, ColorUtil.GRAY);
        r2.setHighlighted(true);
        
        //Attribuer les valuers au chart
        PieChart chart = new PieChart(buildCategoryDataset("Recettes", values), renderer);
        ChartComponent c = new ChartComponent(chart);
        f.add(c);
        //////////////////////////////////////////////////////////
   
       // f.add(C1);
        f.getToolbar().addCommandToRightBar("back", null, (ev)->{ClientProfil h;
            try {
                h = new ClientProfil(idLogged);
                 h.getF().show();
            } catch (IOException ex) {
               
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
