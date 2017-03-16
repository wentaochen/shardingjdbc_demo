import java.util.concurrent.ConcurrentHashMap;


public class JoinTest {


	private static ConcurrentHashMap  maps=new ConcurrentHashMap();
	
	public static void main(String[] args) throws InterruptedException {
		Thread t1=new Thread(){
			public void run(){
				System.out.println("t1 begin");
				try {
					Thread.sleep(2000L);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("t1 end");
			}
		};
		
		t1.start();
		t1.join();
		
		System.out.println("main thread end");
	}

}
