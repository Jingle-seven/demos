package xz.jingle;

import org.junit.Test;

/**
 * Created by Jinhua on 2016/11/30.
 */
public class StringTest {

    @Test
    public void testSpilit() {
        String s1 = "12,13,15,5847,87,8787,4787,8,58,71,648,46";
        String s2 = "12";
        System.out.println(s2.split(",").length);
        System.out.println(s1.split(",").length);
    }

    @Test
    public void testReplaceMany() {
        String str1 = "insert into `cloudins_field` (`id`, `name`, `company`, `remark`) " +
                "values (?, ?, ?, ?)','20170222150406','141',FALSE,FALSE)";
        System.out.println(str1.replace("`","").replace("\'",""));
        System.out.println(str1.replaceAll("\\d","x"));
    }

    @Test
    public void reverse(){
        String originStr = "End of the world";
	    int originLength = originStr.length();
	    char[] resChars = new char[originLength];
        for (int i = 0; i < originLength; i++) {
            resChars[i] = originStr.charAt(originLength-1-i);
        }
        System.out.println(new String(resChars));
	}
    @Test
    public void testIntern(){
        String s1 = "hello";
        String s2 = "hell"+"o";
        String s3 = new StringBuilder("hell").append("o").toString();//toString实际上调用了new String（）构造器
        String s4 = new String("hello");
        String s5 = new String("hello");
        String s6 = new String("hell") +"o";//字符串连接操作会在jvm内部转换为StringBuilder的append和toString
        System.out.println(s1==s2);
        System.out.println(s1==s3);
        System.out.println(s2==s3);
        System.out.println(s1==s4);
        System.out.println(s4==s5);
        System.out.println(s1==s6);
        System.out.println(s1==s1.intern());
        System.out.println(s1==s4.intern());
    }
    @Test
    public void testIntern2(){
        String s1 = "hell";
        String s2 = "o";
        String s3 = s1 + s2;
        //此时常量池中还没有“hello”，intern把s3的引用复制了一份到常量池，接下来s4引用到常量池中的“hello”，即s3的引用
        //如果去掉这句，s4的创建语句会根据字面量创建一个全新的不同于s3引用的“hello”
        //此解释适用于java7及以后的版本
        s3.intern();
        String s4 = "hello";
        System.out.println(s4==s3);
    }
    @Test
    public void testParseLong(){
        //空和空白字符串都会报错
        System.out.println(Long.parseLong(""));
        System.out.println(Long.parseLong(null));
    }
}
