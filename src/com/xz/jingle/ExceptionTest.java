package com.xz.jingle;

/**
 * Created by Jinhua on 2016/9/2.
 */
public class ExceptionTest {
	public static void main(String[] args) {
		byZero();
		System.out.println("如果能到这里说明try-catch没有阻塞");
	}
	
	private static void byZero(){
		try{
			int i = 2/0;
		}catch (Exception e){
			System.out.println(e);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e1) {}
			byZero();
		}
	}
}
