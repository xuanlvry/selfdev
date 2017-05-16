package design.behavior.strategy.pattern2;

/**
 * Created by Chengfei.Sun on 17/02/15.
 */
public class Client {
    public static void main(String[] args) {
        //声明一个具体的策略
        Strategy strategy1 = new ConcreteStrategy1();
        //环境对象
        Context context = new Context();
        context.setStrategy(strategy1);
        //执行封装后的方法
        context.doAnything();

        //声明具体策略2
        Strategy strategy2 = new ConcreteStrategy2();
        context.setStrategy(strategy2);
        context.doAnything();
    }
}
