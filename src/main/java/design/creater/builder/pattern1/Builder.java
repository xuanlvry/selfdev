package design.creater.builder.pattern1;

/**
 * 建造者模式主要是将一个复杂对象的构建与表示分离，使得同样的构建过程可以创建不同的表示。适用于那些产品对象的内部结构比较复杂。
 * 主要解决在软件系统中，有时候面临着"一个复杂对象"的创建工作，其通常由各个部分的子对象用一定的算法构成；使得相同的创建过程能够创建不同的产品。
 * 若几个产品之间存在较大的差异，则不适用建造者模式。
 *
 * 常用场景：需要构建一批构建过程相同但表示不同的产品，而构建过程非常复杂。
 *
 * 建造者接口
 * @author Chengfei.Sun on 2016/10/17.
 */
public interface Builder {
    void createDoppelganger(String name);

    void buildBody();

    void buildHead();

    void buildLeftArm();

    void buildLeftHand();

    void buildRightArm();

    void buildRightHand();

    void buildLeftLeg();

    void buildLeftFoot();

    void buildRightLeg();

    void buildRightFoot();

    Product getProduct();
}
