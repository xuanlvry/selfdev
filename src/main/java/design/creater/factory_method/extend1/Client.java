package design.creater.factory_method.extend1;

import design.creater.factory_method.Human;
import design.creater.factory_method.Human_Black;
import design.creater.factory_method.Human_White;
import design.creater.factory_method.Human_Yellow;

/**
 * 工厂方法扩展：
 * 1.缩小为简单工厂模式/静态工厂模式。去掉接口FactoryHuman，同时把FactoryHumanImpl的方法设置为静态类型，简化创建过程(所以也叫做静态工厂模式)。
 *
 * @author Chengfei.Sun on 2016/10/21.
 */
public class Client {
    public static void main(String[] args) {
        Human blackHuman = FactoryHuman.createHuman(Human_Black.class);
        blackHuman.getColor();
        blackHuman.talk();
        
        Human whiteHuman = FactoryHuman.createHuman(Human_White.class);
        whiteHuman.getColor();
        whiteHuman.talk();

        Human yellowHuman = FactoryHuman.createHuman(Human_Yellow.class);
        yellowHuman.getColor();
        yellowHuman.talk();
    }
}
