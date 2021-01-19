
public class Consumidor extends Thread{
	private Monitor monitor;
	
	public Consumidor(Monitor c) {
		monitor = c;
	}
	
	public void run() {
		char c;
	
	
		for(int i=0; i < 10; i ++) {
			c = monitor.recoger();
			System.out.println("Recogido la letra: " +c);
			try {
				sleep((int)(Math.random()*2000));
			}catch(InterruptedException e) {;}
		}
	}

}
