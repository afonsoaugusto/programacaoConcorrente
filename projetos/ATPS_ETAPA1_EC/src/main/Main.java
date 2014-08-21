/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Afonso
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            Buffer buffer = new Buffer();
            Consumidor consumer = new Consumidor(buffer);
            
            for (int i = 0; i < Constantes.QTD_THREADS; i++) {
                Thread t = new Thread(consumer);
                t.start();
            }
    }
    
}
