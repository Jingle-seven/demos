package com.xz.comfirm;

public class TestParseNull {

	/**
	 * ǿ��ת����ָ��û���⣬��ʹ��ʱ������
	 */
	public static void main(String[] args) {
		
		String str = null;
		Object dog1 = new Dog("dog");
		dog1 = null;
		Dog dog2 = ((Dog)dog1);
		dog2.setName("");
	}

}
class Dog{
	public String name;

	public Dog(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}