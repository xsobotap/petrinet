package com.company.xmlContext;

import javax.accessibility.Accessible;
import javax.swing.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class FileChooser extends JComponent implements Accessible {


    public String getToOpen() {
        JFrame frame = new JFrame();
        JFileChooser fileChooser = new JFileChooser();
        int returnval = fileChooser.showOpenDialog(frame);

        String toOpen = "v skutoxnosti prazdny string";
        if (returnval == JFileChooser.APPROVE_OPTION) {
            toOpen = fileChooser.getSelectedFile().getAbsolutePath();
        }
        /*
        File file = new File(toOpen);

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Document.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Document doc = (Document) unmarshaller.unmarshal(file);
            System.out.println(doc);

        } catch (
                JAXBException e) {
            e.printStackTrace();
        }
            */
        return toOpen;
    }


        /*


    //frame.setVisible(true);






*/
}
