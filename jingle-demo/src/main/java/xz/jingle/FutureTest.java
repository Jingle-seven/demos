package xz.jingle;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * Created by Jinhua on 2017/1/20.
 */
public class FutureTest {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		MyCallable myCallable = new MyCallable();
		FutureTask<Integer> ft1 = new FutureTask<>(myCallable);
		FutureTask<Integer> ft2 = new FutureTask<>(()->{
			System.out.println("子线程在进行计算");
			Thread.sleep(2000);
			int sum = 0;
			for (int i = 0; i < 100; i++)
				sum += i;
			return sum;
		});
		new Thread(ft1).start();
		System.out.println(ft1.get());
	}
}

class MyCallable implements Callable<Integer> {
	public Integer call() throws Exception {
		System.out.println("子线程在进行计算");
		Thread.sleep(3000);
		int sum = 0;
		for (int i = 0; i < 100; i++)
			sum += i;
		return sum;
	}
}