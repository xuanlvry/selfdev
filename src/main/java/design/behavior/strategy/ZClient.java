package design.behavior.strategy;

/**
 * @author Chengfei.Sun on 2016/10/17.
 */
public class ZClient {
    public static void main(String[] args) {
        Context context = new Context(new Strategy1());
        System.out.println("10 + 5 = " + context.executeStrategy(10, 5));

        context = new Context(new Strategy2());
        System.out.println("10 - 5 = " + context.executeStrategy(10, 5));

        context = new Context(new Strategy3());
        System.out.println("10 * 5 = " + context.executeStrategy(10, 5));
    }
}
