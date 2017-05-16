package design.creater.factory_method;

/**
 * 工厂方法优点：
 * 良好的封装性，代码结构清晰。
 * 一个调用者需要一个具体的产品对象，只要知道这个产品的类名(或约束字符串)就可以了。不用知道创建对象的过程，降低模块间的耦合。
 * 调用者不关心产品类的创建过程，只需要关心产品的接口，只要接口保持不变，系统的上层模块就不会发生变化。
 *
 * 工厂方法扩展：
 * 1.缩小为简单工厂模式。去掉接口FactoryHuman，同时把FactoryHumanImpl的方法设置为静态类型，简化创建过程（所以也叫做静态工厂模式）（代码见extend1）。
 * 2.升级为多个工厂类。（代码见extend2）
 *      场景：当一个产品类有多个具体实现，而且每个实现类初始化都不相同，写在一个工厂方法中，导致方法巨大无比。
 *      解决：为每个产品类都定义一个工厂，然后由调用者去选择与哪个工厂方法关联。
 *      注意：工厂方法中已经不需要传递相关参数了，因为每一个具体的工厂都已经非常明确自己的职责：创建自己负责的产品类对象。
 *
 * @author Chengfei.Sun on 2016/10/21.
 */
public class Client {
    public static void main(String[] args) {
        FactoryHuman humanFactory = new FactoryHumanImpl();

        Human blackHuman = humanFactory.createHuman(Human_Black.class);
        blackHuman.getColor();
        blackHuman.talk();
        
        Human whiteHuman = humanFactory.createHuman(Human_White.class);
        whiteHuman.getColor();
        whiteHuman.talk();

        Human yellowHuman = humanFactory.createHuman(Human_Yellow.class);
        yellowHuman.getColor();
        yellowHuman.talk();
    }
}
