package xz.jingle;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//An exception can end a thread.Catching it and the thread will go on. and you can throw a RuntimeException to end the thread
public class ThreadTest {

	public static void main(String[] args) {
        Killer killer = new Killer();
        killer.action();
    }
}
class Killer{
    ExecutorService catchingMachines = Executors.newSingleThreadExecutor();
    ExecutorService killingMachines = Executors.newSingleThreadExecutor();
    private void catchMan(){
        while (true) {
            catchingMachines.execute(new CatchingMachine(this));
        }
    }
    public void killMan(String name){
        killingMachines.execute(new KillingMachine(this,name));
    }
    public void action(){
        catchMan();
    }
}
class CatchingMachine implements Runnable{
    Killer killer;
    public CatchingMachine(Killer killer) {
        this.killer = killer;
    }

    public void run() {
        int j = 0;
        try {
            Thread.sleep(500);
            int i = new Random().nextInt(3);
            System.out.println(i);
            j = 2/i;
			String name = j + " people";
			System.out.println(name +" was catched");
			killer.killMan(name);
        } catch (Exception e) {
            System.out.println("An exception occured and killer catch no one ");
            //throw a RuntimeException to end the thread
//            throw new RuntimeException("NO！NO！NO！！！I don't go to prison");
        }
    }
}
class KillingMachine implements Runnable{
    Killer killer;
    String name;
    public KillingMachine(Killer killer,String name) {
        this.killer = killer;
        this.name = name;
    }
    public void run() {
        System.out.println(name +" was killed !!!");
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
			if(i == 10){
				System.out.println(Thread.currentThread()+" :线程退出 "+i);
				System.exit(1);
			}
		}
		
	}
	
}
