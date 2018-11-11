/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.saufgenossen.ehre.client.data;

/**
 *
 * @author sreis
 */
public class NetworkData {
    public static class EhreRequest {
        public int id;
        public int ehreChange;
    }
    
    public static class EhreUpdate {
        public int id;
        public int ehre;
    }
}
