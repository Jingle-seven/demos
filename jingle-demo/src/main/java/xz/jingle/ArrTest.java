package xz.jingle;

/**
 * Created by Jinhua on 2016/12/5.
 */
public class ArrTest {
	public static void main(String[] args) {
		String[] ss = "123,,2".split(",");
		for(String s:ss){
			System.out.println(Long.parseLong(s));
		}
	}
}
