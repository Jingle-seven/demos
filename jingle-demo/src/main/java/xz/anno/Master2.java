package xz.anno;

/**
 * Created by Jinhua on 2017/9/7 16:46.
 */
@XzController
public class Master2 {
    @XzInject
    private BlackCat cat;
    @XzInject
    private BlackDog dog;
    
    public void walkThePet(){
        System.out.println(this.getClass() + "walking pet");
        cat.miao();
        dog.bark();
    }
}
