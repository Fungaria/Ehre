package de.saufgenossen.ehre.client;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import de.saufgenossen.ehre.Ehrenvoll;
import de.saufgenossen.ehre.client.data.DataRoot;

/**
 *
 * @author sreis
 */
public class DataListener extends Listener{

    @Override
    public void received(Connection connection, Object object) {
        if(object instanceof DataRoot){
            System.out.println("frghightriugtih");
            Ehrenvoll.data.setData((DataRoot)object);
        }
    }
}
