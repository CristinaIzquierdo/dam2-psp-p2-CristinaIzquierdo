
public class Monitor {
	
	private char buffer[] = new char[6];
	private int siguiente = 0;
	/*
	 * estos dos datos son privados para que ni el productor y ni el
	 * consumidor puedan acceder a ellos; evitando que el consumidor
	 * intente retirar datos de un buffer vacío y el productor 
	 * meter en un buffer lleno 
	 */
	private boolean estaLlena = false; //semaforo
	private boolean estaVacia = true;
	
	/*
	 * Los metodos sincronizados evitan que el productor y consumidor
	 * corrompan un objeto compartido. Mientras el productor está
	 * metiendo un producto, el consumidor no puede retirarlo 
	 * y viceversa
	 * 
	 * 
	 * Si sincronizamos la clase NADIE puede acceder a las variables 
	 * de la clase en pararelo, mientras que al sincronizar los métodos
	 * SI pueden acceder todas las variables que están fuera de los métodos
	 * que pertenecen a la clase.
	 */
	public synchronized char recoger() {
		while(estaVacia==true) {
			try {
				/*
				 * wait hace que el hilo quede a la espera de que le 
				 * llegue el notify() ya sea por el hilo de ejecucion
				 * o el sistema
				 */
				wait();
			} catch (InterruptedException e) {;}
		}
		
		siguiente--;
		if (siguiente == 0) estaVacia=true;
		estaLlena = false;
		/*
		 * notify avisa a cualquier proceso que esté esperando por el 
		 * objeto, entonces el proceso que ha estado esperando, intentará
		 * acceder de nuevo al objeto.
		 */
		notify();
		
		return(buffer[siguiente]);
	}
	
	public synchronized void lanzar(char c) {
		while(estaLlena == true) {
			try {
				wait();
			} catch (InterruptedException e) {;}			
		}
		buffer[siguiente] = c;
		siguiente++;
		if (siguiente==6) estaLlena = true;
		estaVacia=false;
		notify();
	}

}
