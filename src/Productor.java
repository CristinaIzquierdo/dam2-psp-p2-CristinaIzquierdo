
public class Productor extends Thread{
	
	private Cola cola;
	private String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	public Productor (Cola c) {
		cola = c;
	}
	
	public void run() {
		char c;
		
		for (int i = 0; i<10; i++) {
			c = abc.charAt((int)(Math.random()*26));
			cola.lanzar(c);
			System.out.println("Lanzado " +c+ " a la cola");
			try {
				sleep((int) Math.random()*100);
			}catch(InterruptedException e) {;}
		}
	}
	

}
