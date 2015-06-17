package thread;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Description:TODO
 * @author:caikx
 * @time:2015年6月5日 上午10:05:56
 */
public class ExecutorDemo {
	public static void main(String[] args) {
		ExecutorDemo executorDemo = new ExecutorDemo();
		// executorDemo.simple();
		executorDemo.futureTest3();
	}

	private void simple() {
		ExecutorService executorService = Executors.newFixedThreadPool(10);

		executorService.execute(new Runnable() {
			public void run() {
				System.out.println("Asynchronous task");
			}
		});

		executorService.shutdown();
	}

	private void futureTest() {
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		Future future = executorService.submit(new Runnable() {
			public void run() {
				System.out.println("Asynchronous task");
			}
		});
		// 如果任务结束执行则返回 null
		try {
			System.out.println("future.get()=" + future.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		executorService.shutdown();
	}

	private void futureTest2() {
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		Future<String> future = executorService.submit(new Callable<String>() {
			public String call() {
				return "hascalled";
			}
		});
		try {
			System.out.println(future.get());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		executorService.shutdown();
	}

	private void futureTest3() {
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		Set<Callable<String>> callables = new HashSet<Callable<String>>();

		callables.add(new Callable<String>() {
			public String call() throws Exception {
				return "Task 1";
			}
		});
		callables.add(new Callable<String>() {
			public String call() throws Exception {
				return "Task 2";
			}
		});
		callables.add(new Callable<String>() {
			public String call() throws Exception {
				return "Task 3";
			}
		});
		try {
			List<Future<String>> futureList = executorService.invokeAll(callables);
			for (Future<String> future : futureList) {
				try {
					System.out.println(future.get());
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		executorService.shutdown();
//		for (Iterator<Callable<String>> iterator = callables.iterator(); iterator.hasNext();) {
//			Callable<String> callable = (Callable<String>) iterator.next();
//			try {
//				System.out.println(executorService.submit(callable).get());
//			} catch (InterruptedException | ExecutionException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		} 
	}
	
	
	private void invokeAny(){
		ExecutorService executorService = Executors.newSingleThreadExecutor();  
		  
		Set<Callable<String>> callables = new HashSet<Callable<String>>();  
		  
		callables.add(new Callable<String>() {  
		    public String call() throws Exception {  
		        return "Task 1";  
		    }  
		});  
		callables.add(new Callable<String>() {  
		    public String call() throws Exception {  
		        return "Task 2";  
		    }  
		});  
		callables.add(new Callable<String>() {  
		    public String call() throws Exception {  
		        return "Task 3";  
		    }  
		});  
		  
		String result = null;
		try {
			result = executorService.invokeAny(callables);
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		  
		System.out.println("result = " + result);  
		  
		executorService.shutdown();  
	}
}
