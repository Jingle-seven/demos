package xz.jingle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Jinhua on 2016/9/9.
 */
public class RumtimeTest {
	public static void main(String[] args) throws IOException {
		Process process = Runtime.getRuntime().exec("tasklist /v");
		BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream(),"gbk"));
		br.lines().forEach(System.out::print);
	}
}
