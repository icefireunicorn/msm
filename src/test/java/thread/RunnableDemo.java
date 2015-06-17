package thread;

import java.util.concurrent.atomic.AtomicInteger;

public class RunnableDemo {

	public static void main(String[] args) {
		ThreadRunnable saleThread = new ThreadRunnable();
		Thread t1 = new Thread(saleThread, "1号窗");
		Thread t2 = new Thread(saleThread, "2号窗");
		Thread t3 = new Thread(saleThread, "3号窗");
		t1.start();
		t2.start();
		t3.start();
	}

}

class ThreadRunnable implements Runnable {

	private int ticket = 10;

	private AtomicInteger ticketCount = new AtomicInteger(10);

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			if (ticketCount.intValue() > 0) {
				System.out.println(Thread.currentThread().getName() + " 正在卖票; ");
				ticketCount.getAndDecrement();
				System.out.println(" 余票数：" + ticketCount.intValue());
			}
//			if (ticket > 0) {
//				// System.out.println( " 余票数：" + ticket--);
//				System.out.println(Thread.currentThread().getName() + " 正在卖票; ");
//			}
		}

	}

}