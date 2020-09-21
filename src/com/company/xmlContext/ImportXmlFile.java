package com.company.xmlContext;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import javax.print.Doc;
import javax.swing.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class ImportXmlFile {

    public Document doc(String fullFileWay) throws JAXBException, FileNotFoundException{
       FileInputStream inputStream=new FileInputStream(fullFileWay);
       JAXBContext jaxbContext = JAXBContext.newInstance(Document.class);
       Unmarshaller jaxbUnmarhaller = jaxbContext.createUnmarshaller();

       return (Document)jaxbUnmarhaller.unmarshal(inputStream);

   }













}
