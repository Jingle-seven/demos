package xz.jingle;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.sun.org.apache.xalan.internal.lib.ExsltStrings.split;

/**
 * Created by Jinhua on 2016/11/23.
 */
public class RegTest {
	public static void main(String[] args) {
		String[] target =
				("task_1475907758598_12386_m_000002," +
						"task_1475907758598_1238_m_000002," +
						"task_1475907758598_1238_x_000002," +
						"task_1475907758598_1238_r_000002," +
						"task_1481934895002_0153_r_000001").split(",");
		String pattern = "_(m|r)_";
		
		Pattern r = Pattern.compile(pattern);
		for(String s:target){
			Matcher m = r.matcher(s);
			if(m.find())
				System.out.println(m.group(1));
			if (m.find() && "r".equals(m.group(1))) {
				System.out.println(m.group(1));
			} else if (m.find() && "m".equals(m.group(1))) {
				System.out.println("Is r "+m.group(1));
			}else{
				System.out.println("NOT FOUND");
			}
			
		}
	}
}
