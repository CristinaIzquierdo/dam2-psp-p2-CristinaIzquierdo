
public class Main {

	public static void main(String[] args) {

		Monitor monitor = new Monitor();
        Productor p = new Productor(monitor);
        Consumidor c = new Consumidor(monitor);

        p.start();
        c.start();
	}

}
