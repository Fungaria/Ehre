///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package de.saufgenossen.ehre.client;
//
//import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.utils.XmlReader;
//import com.badlogic.gdx.utils.XmlReader.Element;
//import java.io.IOException;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
///**
// *
// * @author sreis
// */
//public class DataReader {
//    
//    private XmlReader reader;
//    private Element data;
//    
//    public DataReader() {
//        reader = new XmlReader();
//    }
//    
//    public Database load(){
//        loadFile();
//        
//        Database base = new Database();
//        loadGenossen(base);
//        return base;
//    }
//    
//    private void loadFile(){
//        try {
//            data = reader.parse(Gdx.files.internal("data.xml"));
//        } catch (IOException ex) {
//            Logger.getLogger(DataReader.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    
//    private void loadGenossen(Database base){
//        Element genossenElement = data.getChildByName("genossen");
//        for (int i = 0; i < genossenElement.getChildCount(); i++) {
//            Element gen = genossenElement.getChild(i);
//            Genosse genosse = new Genosse();
//            genosse.ehre = gen.getInt("ehre");
//            genosse.name = gen.get("name");
//            genosse.pb = gen.get("pb");
//            genosse.rank = gen.getInt("rank");
//            
//            base.genossen.add(genosse);
//        }
//    }
//}
