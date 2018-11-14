package xz.jingle;

import org.junit.Test;

import java.io.*;

/**
 * Created by Jinhua on 2016/9/2.
 */
public class FileTest {
//	@Test
	public  void main() throws IOException {
//		String path = "G:/temp/0/4.txt";
//		File dir = new File(path.substring(0,path.lastIndexOf("/")));
//		File file = new File(path);
//		dir.mkdirs();
//		file.createNewFile();
//		System.out.println("123456".substring(3));
//		System.out.print(System.getProperty("file.encoding"));
//		String str = new File("conf/config.prop").getAbsolutePath();
//		new File("conf/config.prop").mkdirs();
//		System.out.println(str);
		
//		File f = new File("conf/qwe*adf.txt");
//		new File("conf").mkdirs();
//		String s = checkFileName(f.getAbsolutePath());
//		OutputStream outs =  new BufferedOutputStream(new FileOutputStream(new File("conf/qwe*adf.txt")));
		File dir = new File("/home/xjh/etc/");
		System.out.println(dir.mkdirs());
		File fileSize = new File("G:\\temp\\zipkin分解\\zipkin-server-1.13.1.jar");
		int MB = 1024 *1024;
		System.out.println(fileSize.length()/MB);
	}
//    @Test
    public String checkFileName() {
        String str = "what";
        if (str != null && !str.isEmpty()) {
            String[] fbsArr = {":", "?", "*", "<", ">", "|" };
            for (String key : fbsArr) {
                if (str.contains(key)) {
                    str = str.replace(key, "");
                }
            }
        }
        System.out.println(str);
        return str;
    }
    @Test
    public  void checkFileExist() {
	    String s = null;
//	    File file1 = new File(s);
//        System.out.println(file1.exists());
        File file2 = new File("G:\\temp\\zipkin分解\\zipkin-server-1.13.1.jar");
        System.out.println(file2.exists());
    }
    @Test
    public  void checkIf() {
	    int a=1,b=1;
	    boolean abEqualsZero = a==0 && b==0;
        System.out.println(abEqualsZero);
        a=0;b=0;
        boolean abEqualsZero2 = a==0 && b==0;
        System.out.println(abEqualsZero);
        System.out.println(abEqualsZero2);
        System.out.println(3/4);
    }
}
