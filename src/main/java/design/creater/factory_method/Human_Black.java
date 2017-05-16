package design.creater.factory_method;

/**
 * 黑色人种
 * @author Chengfei.Sun on 2016/10/21.
 */
public class Human_Black implements Human {
    public void getColor() {
        System.out.println("黑色人种的皮肤颜色是黑的");
    }

    public void talk() {
        System.out.println("黑人会说话，一般人听不懂");
    }
}
