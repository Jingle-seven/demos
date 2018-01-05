package xz.jingle;

import org.junit.Test;

/**
 * 简单比较if和try性能
 * 测试证明if比try更快
 * 异常较小时二者没什么差距
 * 在异常较多时,执行速度相差数倍
 * if只是多了个if判断
 * try只是多了层try嵌套
 * Created by Jinhua on 2017/6/22 14:20.
 */
public class CompareIfTryTest {
	@Test
	public void testIf(){
		int k = 0,l=0;
		for (int i = 0; i < 1000000; i++) {
			int j = (int)(Math.random()*30 - 1);
			if(j==0){
				k++;
				continue;
			}
			l = l + 10/j;
		}
		System.out.printf("%s %s \n",l,k);
	}
	
	@Test
	public void testTry(){
		int k = 0,l=0;
		for (int i = 0; i < 1000000; i++) {
			int j = (int)(Math.random()*30 - 1);
			try {
				l = l + 10/j;
			} catch (Exception e) {
				k++;
			}
		}
		System.out.printf("%s %s\n",l,k);
	}
}
