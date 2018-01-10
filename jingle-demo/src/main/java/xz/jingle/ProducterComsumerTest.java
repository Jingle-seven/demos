package xz.jingle;

import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by admin on 2018/1/9.
 */
public class ProducterComsumerTest {
    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingQueue q = new LinkedBlockingQueue();
        Comsumer c1 = new Comsumer(q);
        Comsumer c2 = new Comsumer(q);
        Producter p1 = new Producter(q);
        new Thread(c1).start();
        new Thread(c1).start();
        new Thread(p1).start();
        while (true){
            System.out.println(q.size());
            Thread.sleep(2000);
        }
    }
    static class Producter implements Runnable{
        public Producter(LinkedBlockingQueue<Integer> queue) {
            this.queue = queue;
        }
        
        LinkedBlockingQueue<Integer> queue;
        public void run() {
            try {
                while (true) {
                    queue.put(new Random().nextInt(100));
                    System.out.println(Thread.currentThread().getName()+" product ...");
                    Thread.sleep(new Random().nextInt(2000));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    static class Comsumer implements Runnable{
        public Comsumer(LinkedBlockingQueue<Integer> queue) {
            this.queue = queue;
        }

        LinkedBlockingQueue<Integer> queue;
        public void run() {
            try {
                while (true) {
                    System.out.println(Thread.currentThread().getName()+" "+(queue.take() + 50));
                    Thread.sleep(new Random().nextInt(5000));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
