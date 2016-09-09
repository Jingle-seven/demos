package com.xz.comfirm;

/**
 * Created by Jinhua on 2016/9/2.
 */
public class ExceptionTest {
	public static void main(String[] args) {
		try{
			int i = 2/0;
		}catch (Exception e){
			System.out.println(e);
		}
		
	}
}
