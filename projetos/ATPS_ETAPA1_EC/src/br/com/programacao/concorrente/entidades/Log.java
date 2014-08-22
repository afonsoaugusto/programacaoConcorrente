package br.com.programacao.concorrente.entidades;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;


public class Log {
	
	public static Logger getLogger(Class clazz){
		return (Logger) LogManager.getLogger(clazz);
	}
}
