package design.creater.factory_abstract;

/**
 * @author Chengfei.Sun on 2016/10/21.
 */
public abstract class Human_AbstractWhite implements Human {
    public void getColor() {
        System.out.println("白色人种的皮肤颜色是白的");
    }

    public void talk() {
        System.out.println("白色人种会说话，一般说的是单字节");
    }
}
