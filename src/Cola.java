
public class Cola {
	
	private char buffer[] = new char[6];
	private int siguiente = 0;
	private boolean estaLlena = false;
	private boolean estaVacia = true;
	
	public synchronized char recoger() {
		while(estaVacia==true) {
			try {
				wait();
			} catch (InterruptedException e) {;}
		}
		
		siguiente--;
		if (siguiente == 0) estaVacia=true;
		estaLlena = false;
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
