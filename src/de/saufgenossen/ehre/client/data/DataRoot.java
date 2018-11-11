package de.saufgenossen.ehre.client.data;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(namespace = "de.saufgenossen.ehre")
public class DataRoot {

    @XmlElementWrapper(name = "genossen")
    @XmlElement(name = "genosse")
    public final ArrayList<Genosse> genossenListe = new ArrayList<Genosse>();

    @XmlElementWrapper(name = "ehrungen")
    @XmlElement(name = "ehrung")
    public final ArrayList<Ehrung> ehrungen = new ArrayList<Ehrung>();
}
