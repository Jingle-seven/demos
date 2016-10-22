package xz.jingle;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Jinhua on 2016/8/4.
 */
public class StreamTest {
	public static void main(String[] args) throws InterruptedException {

		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(6);
		list.stream()
		.filter(a -> a > 5)
		.forEach(System.out::print);

		ArrayList<Integer> al = new ArrayList<Integer>();
		for(int i = 0; i < 10; i++) {
			al.add(i);
		}
		String[] a1 = new String[2];
		String[] a2 = al.toArray(a1);
	}
}
