package design.behavior.strategy.pattern2;

/**
 * Created by Chengfei.Sun on 17/02/15.
 */
public class Context {
    //抽象策略
    private Strategy strategy;

    //设置具体策略
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void doAnything() {
        this.strategy.doSomething();
    }
}
