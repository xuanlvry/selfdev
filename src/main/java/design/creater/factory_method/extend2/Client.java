package design.creater.factory_method.extend2;

import design.creater.factory_method.Human;

/**
 * 工厂方法中已经不需要传递相关参数了，因为每一个具体的工厂都已经非常明确自己的职责：创建自己负责的产品类对象。
 *
 * @author Chengfei.Sun on 2016/10/21.
 */
public class Client {
    public static void main(String[] args) {
        FactoryHuman blackHumanFactory = new Factory_BlackHuman();
        Human blackHuman = blackHumanFactory.createHuman();
        blackHuman.getColor();
        blackHuman.talk();

        FactoryHuman whiteHumanFactory = new Factory_WhiteFactory();
        Human whiteHuman = whiteHumanFactory.createHuman();
        whiteHuman.getColor();
        whiteHuman.talk();

        FactoryHuman yellowHumanFactory = new Factory_YellowHuman();
        Human yellowHuman = yellowHumanFactory.createHuman();
        yellowHuman.getColor();
        yellowHuman.talk();
    }
}
