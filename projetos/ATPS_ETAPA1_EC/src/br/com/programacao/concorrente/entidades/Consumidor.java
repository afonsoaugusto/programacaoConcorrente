/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.programacao.concorrente.entidades;

import java.io.File;
import java.util.Calendar;
import java.util.Date;

import org.apache.logging.log4j.Level;
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
    	Log.getLogger(this.getClass()).debug("Inicio da thread"+" "+Thread.currentThread().getId()+" "+Calendar.getInstance().getTime());
        String next = buffer.getNext();
        //System.out.println("iniciou"+" "+Thread.currentThread().getId()+" "+next+" "+buffer);
		while(next != null){
            try {
                File file = buffer.getFile(next);
                long id = Thread.currentThread().getId();
                String inicioLog = "Thread #"+id +" Pedido #"+file.getName()+" Inicio:"+ Calendar.getInstance().getTime();
                Log.getLogger(this.getClass()).debug(inicioLog);
                Thread.sleep(Constantes.INTERVAL_THREAD);
                String fimLog = "Thread #"+id +" Pedido #"+file.getName()+" Termino:"+ Calendar.getInstance().getTime();
                Log.getLogger(this.getClass()).debug(fimLog);
            } catch (InterruptedException ex) {
            	Log.getLogger(this.getClass()).error(ex);
            }finally{            	
            	next = buffer.getNext();
            }
        }    
		Log.getLogger(this.getClass()).info("Termino da thread"+" "+Thread.currentThread().getId()+" "+Calendar.getInstance().getTime());
    }
}
