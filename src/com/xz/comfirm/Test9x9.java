package com.xz.comfirm;

public class Test9x9 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		new TestCFB().notByLoop(1);
//		new TestCFB().byLoop();
		new Test9x9().notByLoopDesc(9);
	}
	public int notByLoop(int m){
		if(m<=9){
			for (int i = 1; i <= 10-m; i++) {
				System.out.print(m*i+"\t");
			}
			System.out.println();
			return notByLoop(++m);
		}else{
			return 10;
		}
	}
	public int notByLoopDesc(int m){
		if(m==0){
			return 0;
		}else{
			for (int i = 1; i <= 10-m; i++) {
				System.out.print(m*i+"\t");
			}
			System.out.println();
			return notByLoopDesc(--m);
		}
	}
	public void byLoop(){
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 10-i; j++) {
				System.out.print(j*i+"\t");
			}
			System.out.println();
		}
	}
}
