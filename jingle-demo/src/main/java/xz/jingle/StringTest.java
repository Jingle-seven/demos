package xz.jingle;

/**
 * Created by Jinhua on 2016/11/30.
 */
public class StringTest {
	public static void main(String[] args) {
		String s1 = "12,13,15,5847,87,8787,4787,8,58,71,648,46";
		String s2 = "12";
		String[] sa1 = s2.split(",");
		System.out.println(sa1.length);
	}
}
