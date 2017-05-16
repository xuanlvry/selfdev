package design.creater.factory_abstract;

/**
 * @author Chengfei.Sun on 2016/10/21.
 */
public abstract class Human_AbstractBlack implements Human {
    public void getColor() {
        System.out.println("黑色人种的皮肤颜色是黑的");
    }

    public void talk() {
        System.out.println("黑色人种会说话，一般人听不懂");
    }
}
