package xz.jingle;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Jinhua on 2016/8/8.
 */
public class LinkedHsahMapTest {
	public static void main(String[] args) {
		Map<String,String> map = new LinkedHashMap<>();
		map.put("1","1");
		map.put("3","3");
		map.put("6","6");
		map.put("2","2");
		map.put("5","5");

		map.values().stream()
				.forEach(System.out::println);
		for (Map.Entry<String,String> e : map.entrySet()) {
			String key = e.getKey();
			String value = e.getValue();
			System.out.println("K: "+key+" V: "+ value);
		}
	}
}
