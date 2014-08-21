/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.programacao.concorrente.entidades;

import java.io.File;
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

    public Buffer(Map<String,File> mapa) {
        this.mapa = mapa;
        this.chaves = getListChaves(mapa);
    }
    
    public Buffer() {
        this.mapa = createMapa();
        this.chaves = getListChaves(mapa);
    }

    private Map<String, File> createMapa() {
       Map<String,File> map = new HashMap<String,File>();
        for (int i = 0; i < Constantes.QTD_FILES; i++) {
            map.put(String.valueOf(i), new File("file"+i));
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

    public synchronized String getNext() {
    	String retorno = null;
    	if (!this.chaves.isEmpty()){
    		retorno =  this.chaves.remove(0);
    	}
		return retorno;
    }
    

}
