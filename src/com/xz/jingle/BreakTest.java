package com.xz.jingle;

/**
 * Created by Jinhua on 2016/8/26.
 */
public class BreakTest {
	public static void main(String[] args) {
		outer:for(int i =0;i<9;i++){
			for(int j =0;j<9;j++){
				if(j==3){
					continue outer;
				}
				System.out.println(""+i+j);
			}
			System.out.println("外层"+i);
		}
	}
}
