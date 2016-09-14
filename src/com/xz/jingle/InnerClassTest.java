package com.xz.jingle;
/**
 * Created by Jinhua on 2016/7/29.
 */
public class InnerClassTest {
	public static void main(String[] args) {
		Ao.Ai ai = new Ao().new Ai1();
		ai.p();
	}
}

class Ao{

	interface Ai{
		void p();
	}
	class Ai1 implements Ai{
		public void p() {
			System.out.println(this.toString());
		}
	}
	class Ai2 implements Ai{
		public void p() {
			System.out.println(this.toString()+" 第二");
		}
	}
}