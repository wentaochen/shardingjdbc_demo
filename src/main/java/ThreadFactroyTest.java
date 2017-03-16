import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadFactroyTest {

	private static class TestWork implements Runnable {

		public TestWork(int i) {
			System.out.println(i);
		}

		@Override
		public void run() {
			try {
				System.out.println(Thread.currentThread().getId());
				Thread.sleep(100000L);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) throws InterruptedException {
		// ThreadPoolExecutor te = new ThreadPoolExecutor(2, 5, 20,
		// TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(10));

		ThreadPoolExecutor te = (ThreadPoolExecutor) Executors
				.newCachedThreadPool();
		for (int i = 0; i < 1000; i++) {
			te.execute(new TestWork(i));
		}
		Thread.sleep(10000L);
		System.out.println("==============");
		for (;;) {
			System.out.println(te.getPoolSize());
			Thread.sleep(1000L);
		}
	}

}
