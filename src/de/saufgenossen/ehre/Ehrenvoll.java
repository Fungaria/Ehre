/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.saufgenossen.ehre;

import de.saufgenossen.ehre.client.EhrenClient;
import de.saufgenossen.ehre.main.MainScreen;
import com.badlogic.gdx.Game;
import de.saufgenossen.ehre.client.data.DataHandler;
import de.saufgenossen.ehre.client.data.DataRoot;
import java.io.IOException;

/**
 *
 * @author sreis
 */
public class Ehrenvoll extends Game{

    public static MainScreen MAIN_SCREEN;
    public static Assets assets;
//    public static o9i6trEhrenvoll.DEINE_MOM_SINGLETONDÄEhrenClient client;
    public static EhrenClient client;
    
    public static DataHandler data;
    
    @Override
    public void create() {
        
        assets = new Assets();
        client = new EhrenClient();
        
        loadDataBase();
        
        try {
            client.connectToServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        MAIN_SCREEN = new MainScreen();
        setScreen(MAIN_SCREEN);
    }
    
    private void loadDataBase(){
        data = new DataHandler();
        data.load();
    }
    
}
