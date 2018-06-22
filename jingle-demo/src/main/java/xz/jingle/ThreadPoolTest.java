package xz.jingle;

import org.junit.Test;

import java.io.*;
import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by Jinhua on 2016/11/24.
 */
public class ThreadPoolTest {
//	@Test
	public void testWhat(){
		ExecutorService pool2 = Executors.newSingleThreadScheduledExecutor();
		ExecutorService pool3 = Executors.newFixedThreadPool(2);
		while (true) {
			pool2.execute(new WaitDoSomething());
			pool3.execute(()->System.out.println("HA HA HA"));
		}
	}
//    @Test//定时线程池不能用junit来测试
    public void testScheduledThreadPool(){
        ScheduledExecutorService pool = Executors.newSingleThreadScheduledExecutor();
        pool.scheduleAtFixedRate(()->System.out.println("HA HA HA"),0,2, TimeUnit.SECONDS);
    }

    public static void main(String[] args) {
        ScheduledExecutorService pool = Executors.newSingleThreadScheduledExecutor();
        //任务开始就计间隔时间
        pool.scheduleAtFixedRate(()->System.out.println(LocalDateTime.now()+" HA HA HA"),
                0,2, TimeUnit.MINUTES);
        //任务完成才计间隔时间
//        pool.scheduleWithFixedDelay(()->System.out.println("HA HA HA"),0,2, TimeUnit.SECONDS);
    }
	private class WaitDoSomething implements Runnable {
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
				if(count++<3){// 失败三次再输出异常,然后退出?
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
