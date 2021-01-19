
public class Productor extends Thread{
	
	private Monitor monitor;
	private String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	public Productor (Monitor c) {
		monitor = c;
	}
	
	public void run() {
		char c;
		
		for (int i = 0; i<10; i++) {
			c = abc.charAt((int)(Math.random()*26));
			monitor.lanzar(c);
			System.out.println("Lanzado " +c+ " a la monitor");
			try {
				sleep((int) Math.random()*100);
			}catch(InterruptedException e) {;}
		}
	}
	

}
