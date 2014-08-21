/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.programacao.concorrente.entidades;

import java.io.File;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Afonso
 */
public class Consumidor implements Runnable{
    
    private Buffer buffer;
    public Consumidor(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        System.out.println("iniciou"+" "+Thread.currentThread().getId());
        String next = buffer.getNext();
        //System.out.println("iniciou"+" "+Thread.currentThread().getId()+" "+next+" "+buffer);
		while(next != null){
            try {
                File file = buffer.getFile(next);
                long id = Thread.currentThread().getId();
                System.out.println(file.getName()+" "+id);
                Thread.sleep(Constantes.INTERVAL_THREAD);
            } catch (InterruptedException ex) {
                Logger.getLogger(Consumidor.class.getName()).log(Level.SEVERE, null, ex);
            }finally{            	
            	next = buffer.getNext();
            }
        }    
        System.out.println("terminou"+" "+Thread.currentThread().getId());
    }
}
