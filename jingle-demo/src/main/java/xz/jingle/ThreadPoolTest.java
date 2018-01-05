package xz.jingle;

import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by Jinhua on 2016/11/24.
 */
public class ThreadPoolTest {
	public static void main(String[] args) throws FileNotFoundException {
//		ScheduledExecutorService pool = Executors.newScheduledThreadPool(2);
//		pool.scheduleAtFixedRate(new WaitNDoSomething(),2L,2L, TimeUnit.SECONDS);
		ExecutorService pool2 = Executors.newSingleThreadScheduledExecutor();
		ExecutorService pool3 = Executors.newFixedThreadPool(2);
		while (true) {
//			pool2.execute(new WaitNDoSomething());
			pool3.execute(new PrintPerSecond());
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private static class PrintPerSecond implements Runnable {
		public void run(){
			System.out.println("HA HA HA");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	private static class WaitNDoSomething implements Runnable {
		int count = 0;
		private int byZero(int x, int y) {
			int i = 0;
			try {
				i = x / y;
			}catch (Exception e){
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				System.out.println(count);
				if(count++<3){
					byZero(x,y);
				}else {
					System.out.println("Failed");
				}
			}
			return i;
		}
		
		public void run() {
			byZero(1,0);
			System.out.println(Thread.currentThread() + " do something");
		}
	}
}
