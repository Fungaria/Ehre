/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.saufgenossen.ehre.client.data;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "genosse")
//@XmlType(propOrder = { "author", "name", "publisher", "isbn" })
public class Genosse {
    public int id;
    public String name;
    public int rank;
    public int ehre;
    public String pb;

    @Override
    public String toString() {
        return "Genosse{" + "id=" + id + ", name=" + name + ", rank=" + rank + ", ehre=" + ehre + ", pb=" + pb + '}';
    }
}
