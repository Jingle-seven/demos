package com.xz.demo;

/**
 * Created by Jinhua on 2016/8/22.
 */
public class FourYuan {
	public static void main(String[] args) {
		for(int x1=-100;x1<100;x1++){
			for(int x2=-100;x2<100;x2++){
				for(int y1=-100;y1<100;y1++){
					for(int y2=-100;y2<100;y2++){
						if( x1+x2==8 & y1+y2==6 & x1+y1==13 & x2+y2==8)
							System.out.println();
					}
				}
			}
		}
		System.out.println("end");
	}
}
