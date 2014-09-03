/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.programacao.concorrente.entidades;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;


/**
 * 
 * @author Afonso
 */
public class Main {

	/**
	 * @param args
	 *            the command line arguments
	 */

	public static void main(String[] args) {
		Buffer buffer;
		try {
			buffer = new Buffer();
			Consumidor consumer = new Consumidor(buffer,1);
			for (int i = 0; i < Constantes.QTD_THREADS; i++) {
				Thread t = new Thread(consumer, "Aluno - " + i);
				t.start();
			}

		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			Log.getLogger(Main.class).error(e);
		}
	}

}
