/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.programacao.concorrente.entidades;

import java.util.Date;



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
            
            
            Log.getLogger(Main.class).debug("Did it again!");
            Log.includeLogFile("1","sds", new Date());

            for (int i = 0; i < Constantes.QTD_THREADS; i++) {
                Thread t = new Thread(consumer);
                t.start();
            }
    }
    
}
