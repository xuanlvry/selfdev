package design.creater.factory_method;

/**
 * @author Chengfei.Sun on 2016/10/21.
 */
public class FactoryHumanImpl implements FactoryHuman {
    public <T extends Human> T createHuman(Class<T> c) {
        Human human = null;
        try {
            human = c.newInstance();
        } catch (Exception e) {
            System.out.println("人类生成错误");
        }
        return (T) human;
    }
}
