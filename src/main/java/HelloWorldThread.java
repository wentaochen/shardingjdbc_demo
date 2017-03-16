public class HelloWorldThread {

	public static void main(String[] args) throws InterruptedException {
		Thread myThread = new Thread() {
			public void run() {
				System.out.println("myThread");
			}
		};
		
		myThread.start();
		//Thread.yield();
		Thread.sleep(1);
		System.out.println("mainThread");
		myThread.join();
	}

}
