package design.structure.decorator.commoncode;

/**
 * Created by Chengfei.Sun on 17/02/14.
 */
public class Client {
    public static void main(String[] args) {
        Component component = new ConcreteComponent();
        //第一次修饰
        component = new ConcreteDecorator1(component);
        //第二次修饰
        component = new ConcreteDecorator2(component);
        //修饰后执行
        component.operate();
    }
}
