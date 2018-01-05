package xz.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Pow {

	public static void main(String[] args) {
		int a = 1;
		int b = a;
		a = 2;
		System.out.println(b);
		System.out.println(pow(5,3));
		
	}
	static int pow(int x,int n){
		if(n > 0){
			return pow(x,n-1)*x;
		}else
			return x;
	}
	
}
