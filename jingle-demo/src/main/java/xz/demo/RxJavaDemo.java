package xz.demo;

import rx.Observable;
import rx.Observer;

/**
 * Created by Jinhua on 2017/1/20.
 */
public class RxJavaDemo {
	public static void main(String[] args) {
		
		//create Observable Object
		Observable<String> obsb = Observable.create(
				subscriber->{
				subscriber.onNext("create1"); //发射一个"create1"的String
				subscriber.onNext("create2"); //发射一个"create2"的String
				subscriber.onCompleted();//发射完成,这种方法需要手动调用onCompleted，才会回调Observer的onCompleted方法
			});
		
		//create Observe Object
		Observer<String> obs = new Observer<String>() {
			public void onCompleted() {
				System.out.println("Complete!");
			}
			
			public void onError(Throwable throwable) {
				throwable.printStackTrace();
			}
			
			public void onNext(String o) {
				System.out.println("Kill the "+o);
			}
		};
		
		obsb.subscribe(obs);
		obsb = Observable.just("Hello","RxJava");
		obsb.subscribe(obs);
		obsb = Observable.from("h,r".split(","));
		obsb.subscribe(obs);
		
		//只处理成功的时候可以传入只有一个 参数的方法
		//You can give subscribe a one param function(Action1) if dealing success case only
		obsb.subscribe(e-> System.out.println("Beat the"+e));
	}
}
