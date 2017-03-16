import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutrueTaskCancelTest {

	public static void main(String[] args) throws InterruptedException {
		ExecutorService executorService = Executors.newCachedThreadPool();

		Future ft = executorService.submit(new WhileRun());

		Thread.sleep(1000L);

		System.out.println(ft.isCancelled() + " " + ft.isDone());

		System.out.println(ft.cancel(true));
		
		Thread.sleep(1000L);

		System.out.println(ft.isCancelled() + " " + ft.isDone());
	}

	public static class WhileRun implements Runnable {

		@Override
		public void run() {
			while (true) {
				System.out.println(Thread.currentThread().getId());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
