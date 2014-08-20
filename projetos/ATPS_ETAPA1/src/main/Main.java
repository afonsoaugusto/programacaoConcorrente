/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import java.io.File;
import java.util.HashMap;
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
        Map<String,File> mapa = new HashMap<>();
        mapa.put("ds", new File("xc"));
        File file = mapa.remove("ds");
        System.out.println(file.toString());
    }
    
}
