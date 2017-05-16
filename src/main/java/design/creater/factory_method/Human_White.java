package design.creater.factory_method;

/**
 * 白色人种
 * @author Chengfei.Sun on 2016/10/21.
 */
public class Human_White implements Human {
    public void getColor() {
        System.out.println("白色人种的皮肤颜色是白色的");
    }

    public void talk() {
        System.out.println("白色人种会说话，一般都是单字节");
    }
}
