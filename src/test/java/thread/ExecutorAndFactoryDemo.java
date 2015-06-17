package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * @Description:TODO
 * @author:caikx
 * @time:2015年6月5日 下午2:25:44
 */
public class ExecutorAndFactoryDemo {

	public static void main(String[] args) {
		ExecutorService defaultExecutor = Executors.newCachedThreadPool();
		ExecutorService deamonExecutor = Executors.newCachedThreadPool(new DaemonThreadFactory());
		ExecutorService maxExecutor = Executors.newCachedThreadPool(new MaxPriorityThreadFactory());
		ExecutorService minExecutor = Executors.newCachedThreadPool(new MinPriorityThreadFactory());
		for (int i = 0; i < 3; i++) {
			deamonExecutor.execute(new MyThread(i));
		}
		for (int i = 10; i < 20; i++)
	           if (i == 10)
	        	   maxExecutor.execute(new MyThread(i));
	           else if (i == 11)
	        	   minExecutor.execute(new MyThread(i));
	           else
	        	   defaultExecutor.execute(new MyThread(i));
	}

	
}

class DaemonThreadFactory implements ThreadFactory {
	public Thread newThread(Runnable r) {
		Thread t = new Thread(r);
		t.setDaemon(true);
		return t;
	}
}

class MaxPriorityThreadFactory implements ThreadFactory {
	public Thread newThread(Runnable r) {
		Thread t = new Thread(r);
		t.setPriority(Thread.MAX_PRIORITY);
		return t;
	}
}

class MinPriorityThreadFactory implements ThreadFactory {
	public Thread newThread(Runnable r) {
		Thread t = new Thread(r);
		t.setPriority(Thread.MIN_PRIORITY);
		return t;
	}
}

class MyThread implements Runnable {
    private int count = 1, number;
 
    public MyThread(int num) {
       number = num;
       System.out.println("Create Thread-" + number);
    }
 
    public void run() {
       while (true) {
           System.out.println("Thread-" + number + " run " + count+" time(s)");
           if (++count == 3)
              return;
       }
    }
}
