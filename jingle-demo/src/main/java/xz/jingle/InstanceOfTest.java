package xz.jingle;

import xz.tools.YarnUtil;

import static javafx.scene.input.KeyCode.O;

/**
 * Created by Jinhua on 2016/10/28.
 */
public class InstanceOfTest {
	public static void main(String[] args) {
		Object o = new Object();
		System.out.println(o instanceof Long);
		System.out.println(String.valueOf(System.currentTimeMillis()).length());
		System.out.println(String.valueOf(YarnUtil.getDayBegin()).length());
		System.out.println(String.valueOf(1477383506422000L).length());
	}
}
