package design.behavior.template.pattern1;

/**
 * 本例说明：
 *      使用模板方法模式优化code1代码。
 *
 *
 * 定义一个操作中的算法的框架，而将一些步骤延迟到子类中。使得子类可以不改变一个算法的结构即可重定义算法的某些特定步骤。
 *
 * AbstractClass叫做抽象模板，它的方法分为两类：
 * (1)基本方法：基本方法也叫做基本操作，是由子类实现的方法，并且在模板方法被调用。
 *      ConcreteClass1和ConcreteClass2属于具体模板，实现父类所定义的一个或多个抽象方法，也就是父类定义的基本方法在子类中得以实现。
 *      注意：抽象模板中的基本方法尽量设计为protected类型，符合迪米特法则，不需要暴露的属性或方法不要设置为protected类型。实现类若非必要，尽量不要扩大父类中的访问权限。
 * (2)模板方法：可以有一个或几个，一般是一个具体方法，也就是一个框架，实现对基本方法的调度，完成固定的逻辑。
 *      注意：一般防止恶意的操作，一般模板方法都加上final关键字，不准被重写。
 *
 * 模板方法模式优点：
 *      封装不变部分，扩展可变部分：把认为是不变部分的算法封装到父类实现，而可变部分的则可以通过继承来继续扩展。
 *      提取公共代码，便于维护。
 *      行为由父类控制，子类实现。
 *
 * 模板方法模式场景：
 *      多个子类有公有的方法，并且基本逻辑相同时。
 *      重构时，模板方法模式把相同的代码抽取到父类中，然后通过钩子函数约束其行为。
 *      重要、复杂的算法，可以把核心算法设计为模板方法，周边的相关细节功能则由各个子类实现。
 *
 * @author Chengfei.Sun on 2016/10/24.
 */
public class Client {
    public static void main(String[] args) {
        HummerModel hummerModel1 = new HummerModelH1();
        hummerModel1.run();

        HummerModel hummerModel2 = new HummerModelH2();
        hummerModel2.run();
    }
}
