package thread;

public class ThreadDemo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thead1 t1 = new Thead1();
		Thead2 t2 = new Thead2();
		t1.start();
		t2.start();
		
//		t1.run();
//		t2.run();
	}

}

class Thead1 extends Thread{
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("Thead1.run()");
		}
	}
}

class Thead2 extends Thread{
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("Thead2.run()");
		}
	}
}