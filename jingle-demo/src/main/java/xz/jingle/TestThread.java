package xz.jingle;
import java.util.Random;


public class TestThread {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			Mr mr = new Mr(new Random().nextInt(500)+500);
			new Thread(mr).start();
		}
	}

}

class Mr implements Runnable{
	
	long sleepTime = 500;
	
	public Mr(long sleepTime) {
		this.sleepTime = sleepTime;
	}

	public void run() {
		for (int i = 0; i <100; i++) {
			System.out.println(Thread.currentThread()+" print: "+i);
			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(i == 15){
				System.out.println(Thread.currentThread()+"���ȴﵽ"+i);
				System.exit(1);
			}
		}
		
	}
	
}
