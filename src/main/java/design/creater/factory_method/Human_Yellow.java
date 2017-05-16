package design.creater.factory_method;

/**
 * 黄色人种
 * @author Chengfei.Sun on 2016/10/21.
 */
public class Human_Yellow implements Human {
    public void getColor() {
        System.out.println("黄色人种的皮肤颜色是黄色的");
    }

    public void talk() {
        System.out.println("黄色人种会说话，一般都是双字节");
    }
}
