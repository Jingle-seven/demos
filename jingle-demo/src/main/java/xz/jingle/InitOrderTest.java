package xz.jingle;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jinhua on 2017/4/26.
 */
public class InitOrderTest {
	
	@Test
	public void testStaticInit(){
		StaticClass.getNum();
	}
}

class StaticClass{
   private static int NUM = 5;
   static{
	   System.out.println("before static: "+NUM);
	   NUM = 10;
   }
	{
		System.out.println("before {}block: "+NUM);
		NUM = 20;
	}
	StaticClass(){
		System.out.println("before class init: "+NUM);
		NUM = 30;
	}
   public static int getNum(){
	   System.out.println("get: "+NUM);
	   return NUM;
   }
	public int getNumber(){
		System.out.println("class get: "+NUM);
		return NUM;
	}
}