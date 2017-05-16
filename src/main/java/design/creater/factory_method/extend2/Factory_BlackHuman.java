package design.creater.factory_method.extend2;

import design.creater.factory_method.Human;
import design.creater.factory_method.Human_Black;

/**
 * @author Chengfei.Sun on 2016/10/21.
 */
public class Factory_BlackHuman implements FactoryHuman{
    public Human createHuman() {
        return new Human_Black();
    }
}
