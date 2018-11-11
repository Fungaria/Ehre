package de.saufgenossen.ehre.client;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import de.saufgenossen.ehre.client.data.DataRoot;
import de.saufgenossen.ehre.client.data.Genosse;
import de.saufgenossen.ehre.client.data.NetworkData.EhreRequest;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author sreis
 */
public class EhrenClient extends Client{
    private final int TIMEOUT = 5000;
    private final int TCP_PORT = 54777;
    private final int UDP_PORT = 54779;
    
    private final String ip = "localhost"; 

    public EhrenClient() {
        registerClasses();
        registerListeners();
    }

    public void connectToServer() throws IOException {
        super.start();
        super.connect(TIMEOUT, ip, TCP_PORT, UDP_PORT);
        
        super.addListener(new Listener(){
            @Override
            public void connected(Connection connection) {
            }
        });
    }
    
    public void registerClasses(){
        Kryo k = getKryo();
        
        k.register(EhreRequest.class);
        k.register(DataRoot.class);
        k.register(Genosse.class);
        k.register(ArrayList.class);
    }
    
    public void registerListeners(){
        super.addListener(new DataListener());
    }
}
