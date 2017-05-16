package design.creater.factory_method.extend2;

import design.creater.factory_method.Human;
import design.creater.factory_method.Human_Yellow;

/**
 * @author Chengfei.Sun on 2016/10/21.
 */
public class Factory_YellowHuman implements FactoryHuman {
    public Human createHuman() {
        return new Human_Yellow();
    }
}
