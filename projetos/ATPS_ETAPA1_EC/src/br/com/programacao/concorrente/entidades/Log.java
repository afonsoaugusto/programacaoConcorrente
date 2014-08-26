package br.com.programacao.concorrente.entidades;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;


public class Log {
	
	private final static DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	
	public synchronized static Logger getLogger(Class clazz){
		return (Logger) LogManager.getLogger(clazz);
	}
	
	public synchronized static void includeLogFile(String threadID, String numPedido, Date horario){
		FileWriter writer = null;
		PrintWriter saida = null;
		try {
			 writer = new FileWriter(new File("logATPS.csv"),true);
			 saida = new PrintWriter(writer,true);
			 
			 saida.print(threadID);
			 saida.print(",");
			 
			 saida.print(numPedido);
			 saida.print(",");
			 
			 saida.println(dateFormat.format(horario.getTime()));
		} catch (IOException e) {
			Log.getLogger(Log.class).error(e.getMessage());
		}finally{
			try {
				saida.close();
				writer.close();
			} catch (IOException e) {
				Log.getLogger(Log.class).error(e.getMessage());
			} 
		} 
	}
}
