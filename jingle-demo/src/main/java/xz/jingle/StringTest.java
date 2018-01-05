package xz.jingle;

/**
 * Created by Jinhua on 2016/11/30.
 */
public class StringTest {
	public static void main(String[] args) {
        testSpilit();
        testReplaceMany();
        System.out.println(reverse("End of the world"));
    }

    private static void testSpilit() {
        String s1 = "12,13,15,5847,87,8787,4787,8,58,71,648,46";
        String s2 = "12";
        System.out.println(s2.split(",").length);
        System.out.println(s1.split(",").length);
    }

    private static void testReplaceMany() {
        String str1 = "insert into `cloudins_field` (`id`, `name`, `company`, `remark`) " +
                "values (?, ?, ?, ?)','20170222150406','141',FALSE,FALSE)";
        System.out.println(str1.replace("`","").replace("\'",""));
    }

    public static String reverse(String originStr){
	    int originLength = originStr.length();
	    char[] resChars = new char[originLength];
        for (int i = 0; i < originLength; i++) {
            resChars[i] = originStr.charAt(originLength-1-i);
        }
        return new String(resChars);
	}
}
