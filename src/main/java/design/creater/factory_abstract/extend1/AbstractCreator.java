package design.creater.factory_abstract.extend1;

/**
 * @author Chengfei.Sun on 2016/10/21.
 */
public abstract class AbstractCreator {
    //创建A产品家族
    public abstract AbstractProductA createProductA();

    //创建B产品家族
    public abstract AbstractProductB createProductB();
}
