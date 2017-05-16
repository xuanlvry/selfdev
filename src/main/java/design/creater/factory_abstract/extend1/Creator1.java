package design.creater.factory_abstract.extend1;

/**
 * @author Chengfei.Sun on 2016/10/21.
 */
public class Creator1 extends AbstractCreator {
    public AbstractProductA createProductA() {
        //return new ProductA1();
        return null;
    }

    public AbstractProductB createProductB() {
        //return new ProductB1();
        return null;
    }
}
