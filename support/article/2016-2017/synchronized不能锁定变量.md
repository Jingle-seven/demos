## synchronized不能锁定变量  
同步方法或者同步代码块调用的变量，仍可以被其他线程访问并且修改。可能是因为这个原因，变量推荐使用private修饰符，用同步的set、get方法访问。这样可以在对象被锁的时候，变量不会被非法访问。

下面是验证代码：三个线程和一个主线程共享一个资源ts 。可以看到在Thread-0 获得对象锁后，主线程依然可以读取ts的成员变量num的值，但是由于setNum方法是同步方法，所以主线程被阻塞，只能在Thread-0 切换到Thread-1 的瞬间被执行，将num设置为0。
```
	/**	每个对象都有唯一的对象锁，只要调用同步方法便获得此对象锁,此时这个对象内所有synchronized方法和语句块只能被对象锁持有者访问
	 * 
	 */
public class TestSync {

	private int num = 0;
	public  int getNum() {
		return num;}
	public synchronized int setNum(int num) {
		this.num = num;
		return num;}

	public static void main(String[] args) throws InterruptedException {

		TestSync ts = new TestSync();
		new MyThread(ts).start();
		new MyThread(ts).start();
		new MyThread(ts).start();
		
		for (int i = 0; i < 5; i++) {
			Thread.sleep(1000);
			System.out.println("main:num="+ts.getNum() );
			ts.setNum(0);
		}
	}

	// 方法锁定后，在整个for循环期间，全局变量num只能由当前线程操作
	public synchronized void put() {
		for (int i = 0; i < 5; i++) {
			System.out.println("num:"+setNum(getNum()+1) + "\tfrom " + Thread.currentThread().getName());

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	//getPut()调用put()，这两个方法任何一个是synchronized都会导致锁定
	public void getPut(){	
		put();	
	}
}

class MyThread extends Thread {
	
	TestSync ts;

	MyThread(TestSync ts) {
		this.ts = ts;}

	public void run() {
		ts.getPut();}
}
```
输出如下  
![output](https://github.com/Jingle-seven/demos/blob/master/support/article/img/6631239289514483457.png)    
