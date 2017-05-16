package design.structure.decorator.commoncode;

/**
 * Created by Chengfei.Sun on 17/02/14.
 */
public class ConcreteDecorator2 extends Decorator {
    public ConcreteDecorator2(Component component) {
        super(component);
    }

    //定义自己的装饰方法
    private void method2() {
        System.out.println("method2 装饰");
    }

    //重写父类的operate方法
    public void operate() {
        this.method2();
        super.operate();
    }
}
