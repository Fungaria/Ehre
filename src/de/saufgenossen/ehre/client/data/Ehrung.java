/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.saufgenossen.ehre.client.data;

import java.util.Date;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author sreis
 */
@XmlRootElement(name = "ehrung")
public class Ehrung {
    public String name;
    public int value;
    @XmlElement(name = "timestamp", required = true) 
    @XmlJavaTypeAdapter(DateAdapter.class)
    public Date date;
    public int upvotes;
    public int downvotes;
}
