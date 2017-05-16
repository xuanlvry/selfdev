package design.test;

/**
 * @author Chengfei.Sun on 2016/10/20.
 */
public class BuilderImpl implements Builder {
    public void builderPartA() {
        System.out.println("构建A部分");
    }

    public void builderPartB() {
        System.out.println("构建B部分");

    }

    public void builderPartC() {
        System.out.println("构建C部分");
    }
}
