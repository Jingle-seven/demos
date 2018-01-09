package xz.jingle;

import java.util.Random;

/**
 * Created by admin on 2018/1/6.
 */
public class ThreadTest {
    public static void main(String[] args) {
        Thread.currentThread().getState();
        ThreadTestNumber value = new ThreadTestNumber();
        for (int i = 0; i < 10; i++) {
            ThreadTestB r = new ThreadTestB();
            r.number = value;
            new Thread(r).start();

        }
    }
}
class ThreadTestA implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+" sleeping "+i);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" wake up "+i);
        }
    }
}
class ThreadTestB implements Runnable{
    public ThreadTestNumber number;

    public void action() throws InterruptedException {
        for (int j = 0; j < 10; j++) {
            synchronized (number) {
                number.plusOne();
                System.out.println(Thread.currentThread().getName() + "-" + number.getValue());
                if (number.getValue() % 50 == 0) {
                    System.out.println(Thread.currentThread().getName() + " notify!");
//                    number.notifyAll();
                }
                if (number.getValue() % 10 == 0) {
                    System.out.println(Thread.currentThread().getName() + " waiting!");
                    number.wait(100);
                }
            }
            int sleepTime = new Random().nextInt(100) + 100;
            System.out.println(Thread.currentThread().getName() + " sleep " + sleepTime);
            Thread.sleep(sleepTime);

        }
    }

    @Override
    public void run() {
        try {action();} catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class ThreadTestNumber{
    public int value = 0;
    public synchronized int getValue(){
        return value;
    }
    public synchronized void plusOne(){
        value++;
    }
}