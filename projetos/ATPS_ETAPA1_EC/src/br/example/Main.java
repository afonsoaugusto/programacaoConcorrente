package br.example;

public class Main {
	public static void main(String[] args) {
	    Buffer bufferCompartilhado = new Buffer();
	    Produtor produtor1 = new Produtor(1, bufferCompartilhado, 100);
	    //Produtor produtor2 = new Produtor(2, bufferCompartilhado, 5);
	    /*Consumidor consumidor1 = new Consumidor(1, bufferCompartilhado, 2);
	    Consumidor consumidor2 = new Consumidor(2, bufferCompartilhado, 8);*/
	    
	    Consumidor consumidor1 = new Consumidor(1, bufferCompartilhado, 10);
	    Consumidor consumidor2 = new Consumidor(2, bufferCompartilhado, 10);
	    Consumidor consumidor3 = new Consumidor(3, bufferCompartilhado, 10);
	    Consumidor consumidor4 = new Consumidor(4, bufferCompartilhado, 10);
	 
	    produtor1.start();
	    consumidor1.start();
	    consumidor2.start();
	    consumidor3.start();
	    consumidor4.start();
	}

}
