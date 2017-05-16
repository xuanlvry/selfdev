package design.creater.builder.pattern1;

/**
 * 指挥者
 *  ——它主要是用于创建一个复杂的对象，它主要有两个作用，一是：隔离了客户与对象的生产过程，二是：负责控制产品对象的生产过程。
 *
 * @author Chengfei.Sun on 2016/10/17.
 */
public class Director {
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public Product createDoppelganger(String name) {
        builder.createDoppelganger(name);
        builder.buildBody();
        builder.buildHead();
        builder.buildLeftArm();
        builder.buildLeftHand();
        builder.buildRightArm();
        builder.buildRightHand();
        builder.buildLeftLeg();
        builder.buildLeftFoot();
        builder.buildRightLeg();
        builder.buildRightFoot();
        return builder.getProduct();
    }
}
