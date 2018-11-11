package de.saufgenossen.ehre.client.data;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author sreis
 */
public class DataHandler {

    private static final String XML_LOCATION = "files\\data.xml";

    public DataRoot root;
    private JAXBContext context;
    
    public void load() {
        try {
            context = JAXBContext.newInstance(DataRoot.class);
            Unmarshaller um = context.createUnmarshaller();
            root = (DataRoot) um.unmarshal(new FileReader(XML_LOCATION));
        } catch (JAXBException ex) {
            Logger.getLogger(DataHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DataHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void writeFile() throws JAXBException {
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        m.marshal(root, new File(XML_LOCATION));
    }

    public void setData(DataRoot dataRoot) {
        this.root = dataRoot;
        try {
            writeFile();
        } catch (JAXBException ex) {
            Logger.getLogger(DataHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
