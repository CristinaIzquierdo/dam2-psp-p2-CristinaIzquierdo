
public class Consumidor extends Thread{
	private Cola cola;
	
	public Consumidor(Cola c) {
		cola = c;
	}
	
	public void run() {
		char c;
	
	
		for(int i=0; i < 10; i ++) {
			c = cola.recoger();
			System.out.println("Recogido la letra: " +c);
			try {
				sleep((int)(Math.random()*2000));
			}catch(InterruptedException e) {;}
		}
	}

}
