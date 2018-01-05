package xz.jingle;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jinhua on 2017/9/4 14:08.
 */
public class CloneTest {
    @Test
    public void test(){
        AgeDog dog1 = new AgeDog();
        AgeDog dog2 = dog1.clone();
        
        System.out.println("dog1"+dog1);
        System.out.println("dog2"+dog2);
        
        
        dog2.setAge(8).addNickName("胖狗").setName("亮亮");
        dog2.getFriend().setName("三脚猫");
        System.out.println("dog1"+dog1);
        System.out.println("dog2"+dog2);
    }
}
//包装类和String都支持浅克隆,但是对象和集合类需要深克隆
class AgeDog extends Animal implements Cloneable{
    private List<String> nickNames = new ArrayList<>();
    private Integer age = 0;
    private ThreeLegCat friend = new ThreeLegCat();
    
    public ThreeLegCat getFriend() {return friend;}
    public AgeDog setFriend(ThreeLegCat friend) {this.friend = friend;return this;}
    public Integer getAge() {return age;}
    public List<String> getNickNames() {return nickNames;}
    public AgeDog setNickNames(List<String> nickNames) {this.nickNames = nickNames;return this;}
    public AgeDog addNickName(String nickName) {this.nickNames .add(nickName);return this;}
    public AgeDog setAge(Integer age) {this.age = age;return this;}
    
    @Override
    public AgeDog clone() {
        try {
            AgeDog dog =  (AgeDog)super.clone();
            //复制(新建)集合,克隆持有对象
            dog.setNickNames(new ArrayList<>(getNickNames()));
            dog.setFriend(getFriend().clone());
            return dog;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
    
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AgeDog{");
        sb.append("name='").append(name).append('\'');
        sb.append(", nickNames=").append(nickNames);
        sb.append(", age=").append(age);
        sb.append(", friend=").append(friend);
        sb.append('}');
        return sb.toString();
    }
}

//深克隆的话,被克隆的对象所持有的对象也要重写clone方法,然后在被克隆的对象的clone方法里被调用
class ThreeLegCat extends Cat implements Cloneable{
    @Override
    public ThreeLegCat clone() {
        try {
            return (ThreeLegCat) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}