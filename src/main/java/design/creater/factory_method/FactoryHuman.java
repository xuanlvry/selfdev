package design.creater.factory_method;

/**
 * @author Chengfei.Sun on 2016/10/21.
 */
public interface FactoryHuman {
    <T extends Human> T createHuman(Class<T> c);
}
