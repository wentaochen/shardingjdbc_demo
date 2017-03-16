import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SingleScheduleTest {

	private static ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

	static class TestRunnable implements Runnable {

		@Override
		public void run() {
			System.out.println(new Date()+" "+Thread.currentThread().getId());
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
			}

		}
	}

	public static void main(String[] args) {
//		scheduledExecutorService.scheduleAtFixedRate(new TestRunnable(), 0L,
//				500L, TimeUnit.MILLISECONDS);
//		
//		scheduledExecutorService.scheduleAtFixedRate(new TestRunnable(), 0L,
//				500L, TimeUnit.MILLISECONDS);
//		
//		scheduledExecutorService.scheduleAtFixedRate(new TestRunnable(), 0L,
//				500L, TimeUnit.MILLISECONDS);
		
		scheduledExecutorService.schedule(new TestRunnable(), 0, TimeUnit.MINUTES);
		scheduledExecutorService.schedule(new TestRunnable(), 0, TimeUnit.MINUTES);
	
		scheduledExecutorService.schedule(new TestRunnable(), 0, TimeUnit.MINUTES);
		scheduledExecutorService.schedule(new TestRunnable(), 0, TimeUnit.MINUTES);
		
		scheduledExecutorService.shutdown();
	}

}
