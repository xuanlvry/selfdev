package design.creater.factory_abstract;

/**
 * @author Chengfei.Sun on 2016/10/21.
 */
public abstract class Human_AbstractYellow implements Human {
    public void getColor() {
        System.out.println("黄色人种的皮肤颜色是黄的");
    }

    public void talk() {
        System.out.println("黄色人种会说话，一般说的是双字节");
    }
}
