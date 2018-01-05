package xz.jingle;

import org.junit.Test;


/**
 * Created by Jinhua on 2017/8/16 10:57.
 */
public class SetterTest {
    
    //这种情况下直接更改public的属性值没有问题,
    // 但如果对象是由spring管理的话, 似乎行不通, 要用setter
    @Test
    public void test(){
        Dog dog = new Dog();
        dog.nickName = "kitty";
        System.out.println(dog);
        dog.setNickName("hello");
        System.out.println(dog);
    }
}

