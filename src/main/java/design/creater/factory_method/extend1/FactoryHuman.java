package design.creater.factory_method.extend1;

import design.creater.factory_method.Human;

/**
 * @author Chengfei.Sun on 2016/10/21.
 */
public class FactoryHuman {
    public static <T extends Human> T createHuman(Class<T> c) {
        Human human = null;
        try {
            human = (T) Class.forName(c.getName()).newInstance();
        } catch (Exception e) {
            System.out.println("人类生成错误");
        }
        return (T) human;
    }
}
