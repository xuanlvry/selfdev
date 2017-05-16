package design.structure.decorator.commoncode;

/**
 * Created by Chengfei.Sun on 17/02/14.
 */
public class ConcreteDecorator1 extends Decorator {
    public ConcreteDecorator1(Component component) {
        super(component);
    }

    //定义自己的装饰方法
    private void method1() {
        System.out.println("method1 装饰");
    }

    //重写父类的operate方法
    public void operate() {
        this.method1();
        super.operate();
    }
}
