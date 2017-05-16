package design.creater.factory_abstract;

/**
 * 本例说明：
 *      该示例基于工厂方法的示例，现在要添加产品类，需要区分性别。
 *
 * 抽象工厂模式（代码通用示例code1）
 * 抽象工厂模式是工厂方法模式的升级，在有多个业务品种、业务分类时，通过抽象工厂模式产生需要的对象。
 * 注意：
 *      (1)有N个产品族，在抽象工厂类中就应该有N个创建方法。
 *      (2)有M个产品等级，就应该有M个实现工厂类。
 *  对于该示例，分为黄色、黑色、白色3个产品族，那么抽象工厂类中就有3个创建方法。分别为createYellowHuman()，createWhiteHuman()，createBlackHuman()。
 *  每个产品族，又有男性、女性2个产品等级，就有2个实现工厂类FactoryHuman_Female.class，FactoryHuman_Male.class。
 *
 * 优点：
 *      封装性。每个产品的实现类不是高层模块要关心的。他要关心的是接口，不关心对象是如何创建出来。
 *
 * @author Chengfei.Sun on 2016/10/21.
 */
public class Client {
    public static void main(String[] args) {
        FactoryHuman maleFactory = new FactoryHuman_Male();
        Human maleYellowHuman = maleFactory.createYellowHuman();
        maleYellowHuman.talk();
        maleYellowHuman.getColor();
        maleYellowHuman.getSex();

        FactoryHuman femaleFactory = new FactoryHuman_Female();
        Human femaleYellowHuman = femaleFactory.createYellowHuman();
        femaleYellowHuman.talk();
        femaleYellowHuman.getColor();
        femaleYellowHuman.getSex();
    }
}
