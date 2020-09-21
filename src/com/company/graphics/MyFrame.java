package com.company.graphics;

import com.company.Hrany.HranaSiete;
import com.company.Petrinet;
import com.company.Prvky.Miesto;
import com.company.Prvky.Prechod;
import com.company.xmlContext.*;

import javax.jws.soap.SOAPBinding;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
//import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileOutputStream;

public class MyFrame extends JFrame implements ActionListener {
    Petrinet myPetrinet = new Petrinet();
   NetCanvas mycanvas = new NetCanvas(null);//= new NetCanvas();
    JButton Import_button = new JButton("Import siete");
    JButton Export_button = new JButton("Export siete");
    JButton Miesto_button = new JButton("Pridaj miesto");
    JButton Prechod_button = new JButton("Pridaj prechod");
    JButton Hrana_button = new JButton("Pridaj hranu");
    JButton Reset_button = new JButton("Pridaj reset h.");
    JButton Odober_button = new JButton("Odober prvok");
    JButton Vykonaj_button = new JButton("Spusti/Pridaj/Odober");

    public void setMycanvas(NetCanvas mycanvas) {
        this.mycanvas = mycanvas;
        this.add(mycanvas,"Center");
    }

    public void removeMycanvas(NetCanvas mycanvas){
        this.remove(mycanvas);
    }

    public MyFrame(){
    this.setSize(1000,1000);
    this.setTitle("Petriho siet");
    Panel panel = new Panel();
    panel.setLayout(new GridLayout(2,4));
    panel.add(this.Import_button);
    panel.add(this.Export_button);
    panel.add(this.Miesto_button);
    panel.add(this.Prechod_button);
    panel.add(this.Hrana_button);
    panel.add(this.Reset_button);
    panel.add(this.Odober_button);
    panel.add(this.Vykonaj_button);
    Panel mainPanel = new Panel();
    mainPanel.add(panel);
    this.add(mainPanel,"North");
    this.add(this.mycanvas,"Center");
    mycanvas.addMouseListener(mycanvas);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.Import_button.addActionListener(this);
    this.Export_button.addActionListener(this);
    this.Miesto_button.addActionListener(this);
    this.Prechod_button.addActionListener(this);
    this.Hrana_button.addActionListener(this);
    this.Reset_button.addActionListener(this);
    this.Odober_button.addActionListener(this);
    this.Vykonaj_button.addActionListener(this);
    this.setVisible(true);


}

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.Import_button){
            this.removeMycanvas(this.mycanvas);
            FileChooser chooser = new FileChooser();
            try{

                ImportXmlFile importer = new ImportXmlFile();
                Document dokument=importer.doc(chooser.getToOpen());
                TransformNet transformNet = new TransformNet();
                Petrinet petrinet; //new Petrinet();
                petrinet=transformNet.transform(dokument);
                NetCanvas canvas = new NetCanvas(petrinet);
                canvas.addMouseListener(canvas);
                this.setMycanvas(canvas);
                this.setMyPetrinet(petrinet);

                this.mycanvas.repaint();

            }
            catch (Exception ee){
                System.out.println("nemozlive importovat file");

            }



        }

        if(e.getSource()==this.Export_button){
            TransformDoc transformDoc = new TransformDoc();
            Document document;
            document=transformDoc.transform_Dokument(this.myPetrinet);
            try {
                JAXBContext jContext = JAXBContext.newInstance(Document.class);
                Marshaller marshallObj = jContext.createMarshaller();
                marshallObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
                marshallObj.marshal(document,new FileOutputStream("dokument.xml"));
            }catch (Exception ee){
                System.out.println("nemozlive exportovat dokument");
            }
        }

        if(e.getSource()==this.Miesto_button){
            if(this.mycanvas.petrinet==null){
                this.mycanvas.setPetrinet(myPetrinet);
            }
            mycanvas.setTypeOfAction(1);
           // this.setMyPetrinet(mycanvas.getPetrinet());
        }

        if(e.getSource()==this.Prechod_button){
            if(this.mycanvas.petrinet==null){
                this.mycanvas.setPetrinet(myPetrinet);
            }
            mycanvas.setTypeOfAction(2);
        }

        if(e.getSource()==this.Hrana_button){
            if(this.mycanvas.petrinet==null) {
                this.mycanvas.setPetrinet(myPetrinet);
            }
            mycanvas.setTypeOfAction(3);
        }
        if(e.getSource()==Reset_button){
            if(this.mycanvas.petrinet==null) {
                this.mycanvas.setPetrinet(myPetrinet);
            }
            mycanvas.setTypeOfAction(4);

        }
        if(e.getSource()==Odober_button){
            mycanvas.setTypeOfAction(6);
        }

        if(e.getSource()==this.Vykonaj_button){

            mycanvas.setTypeOfAction(5);
        }



    }



public void setMyPetrinet(Petrinet myPetrinet) {
        this.myPetrinet = myPetrinet;

    for(Prechod p:this.myPetrinet .getPrechody()){
        Stvorec stvorec = new Stvorec(p.getX(),p.getY(),p.isRunnable(),p.getName(),(int)p.getId(),p);

        this.mycanvas.vlozElement(stvorec);


    }
    for(Miesto m:this.myPetrinet.getMiesta()){
        Kruh kruh=new Kruh(m.getX(),m.getY(),m.getTokens(),m.getName(),(int)m.getId());

        this.mycanvas.vlozElement(kruh);
    }
    for(HranaSiete h:this.myPetrinet.getHrany()){
        Usecka usecka =new Usecka(0,0,h.getFrom(),h.getTo(),h.getWeight());
        h.setElement(usecka);
        usecka.setHranaSiete(h);
        this.mycanvas.vlozElement(usecka);
    }

    }



}
