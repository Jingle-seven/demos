package xz.jingle;

/**
 * 字符串判空性能大比较
 */
public class IsStrEmptyTest {

    String s = "";
    long n = 10000000;

    private void function1() {
        long startTime = System.currentTimeMillis();
        for (long i = 0; i < n; i++) {
            if (s == null || s.equals(""))
                ;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("function 1 use time: " + (endTime - startTime) + "ms");
    }

    private void function2() {
        long startTime = System.currentTimeMillis();
        for (long i = 0; i < n; i++) {
            if (s == null || s.length() <= 0)
                ;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("function 2 use time: " + (endTime - startTime) + "ms");
    }

    private void function3() {
        long startTime = System.currentTimeMillis();
        for (long i = 0; i < n; i++) {
            if (s == null || s.isEmpty())
                ;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("function 3 use time: " + (endTime - startTime) + "ms");
    }

    private void function4() {
        long startTime = System.currentTimeMillis();
        for (long i = 0; i < n; i++) {
            if (s == null || s == "")
                ;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("function 4 use time: " + (endTime - startTime) + "ms");
    }

    public static void main(String[] args) {
        IsStrEmptyTest test = new IsStrEmptyTest();
        test.function1();
        test.function2();
        test.function3();
        test.function4();
    }
}


