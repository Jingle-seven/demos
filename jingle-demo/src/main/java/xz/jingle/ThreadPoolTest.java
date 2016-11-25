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
		ScheduledExecutorService pool = Executors.newScheduledThreadPool(2);
		pool.scheduleAtFixedRate(new WaitNDoSomething(),2L,2L, TimeUnit.SECONDS);
	}
	private static class WaitNDoSomething implements Runnable{
		
		public void run() {
			System.out.println(Thread.currentThread()+" is ready");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread()+" do something");
		}
	}
}
