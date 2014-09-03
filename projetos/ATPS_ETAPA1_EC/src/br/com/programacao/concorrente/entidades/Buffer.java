/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.programacao.concorrente.entidades;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Afonso
 */
public class Buffer {
    
    private Map<String,File> mapa;
    private List<String> chaves;
    private boolean lock = false;

    public Buffer(Map<String,File> mapa) {
        this.mapa = mapa;
        this.chaves = getListChaves(mapa);
    }
    
    public Buffer() throws FileNotFoundException, UnsupportedEncodingException {
        this.mapa = createMapa();
        this.chaves = getListChaves(mapa);
    }

    private Map<String, File> createMapa() throws FileNotFoundException, UnsupportedEncodingException {
        Map<String,File> map = new HashMap<String,File>();
         for (int i = 0; i < Constantes.QTD_FILES; i++) {
         	File file = new File(String.format("%04d", i)+".file");
         	PrintWriter writer = new PrintWriter(file, "UTF-8");
         	writer.println("The first line");
         	writer.println("The second line");
         	writer.close();
         	
             map.put(String.valueOf(i), file);
             file.delete();
         }
        return map;
     }

    private List<String> getListChaves(Map<String, File> mapa) {
        List<String> list = new ArrayList<String>();
        for (Map.Entry<String, File> entry : mapa.entrySet()) {
		 list.add(entry.getKey());
	}
       return list;
    }

    public File getFile(String chave) {
 	   return mapa.remove(chave);   
    }

    public String getNext() {
    	String retorno = null;
    	//if (!this.chaves.isEmpty()){
    	if (!lock && this.chaves.size() > 0){
    		lock = true;
    		retorno =  this.chaves.remove(0);
    	}
    	lock = false;
		return retorno;
    }
    

}
