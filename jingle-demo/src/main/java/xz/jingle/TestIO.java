package xz.jingle;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;



public class TestIO {

	public static void main(String[] args) throws IOException {
		String str = "发生了什么,memememememmeemmeememmememememememememememmem???\n";
		File file = new File("G:/temp/xx.txt");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 10; i++) {
			sb.append(str);
		}
		FileOutputStream fo = new FileOutputStream(file);
		
		Long before = System.currentTimeMillis();
		byte b[] =sb.toString().getBytes();
		fo.write(b);
		fo.flush();
		fo.close();
		Long after = System.currentTimeMillis();
		System.out.println("写文件消耗时间（毫秒）:"+(after-before));
		
	}

}
