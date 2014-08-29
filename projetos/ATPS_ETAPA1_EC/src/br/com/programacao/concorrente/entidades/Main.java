/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.programacao.concorrente.entidades;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import javax.swing.JOptionPane;

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
		//for (int i = 0; i <= Constantes.NUM_MAX_EXECUTION; i++) {
		int i = Integer.parseInt(JOptionPane.showInputDialog("Qual é o numero da execução?"));
			try {
				buffer = new Buffer();
				Consumidor consumer = new Consumidor(buffer,i);
				for (int j = 0; j < Constantes.QTD_THREADS; j++) {
					Thread t = new Thread(consumer);
					t.start();
				}
			} catch (FileNotFoundException e) {
				Log.getLogger(Main.class).error(e.getMessage());
			} catch (UnsupportedEncodingException e) {
				Log.getLogger(Main.class).error(e.getMessage());
			}
		//}
	}

}
