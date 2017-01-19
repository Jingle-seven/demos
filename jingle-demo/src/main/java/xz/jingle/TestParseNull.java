package xz.jingle;

public class TestParseNull {

	/**
	 * ǿ��ת����ָ��û���⣬��ʹ��ʱ������
	 */
	public static void main(String[] args) {
		
		Object dog1 = null;
		
		Dog dog2 = ((Dog)dog1);
		System.out.println(dog2.name);
	}

}
