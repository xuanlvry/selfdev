package design.behavior.state;

/**
 * @author Chengfei.Sun on 2016/10/17.
 */
public class ZClient {
    public static void main(String[] args) {
        Context context = new Context(Context.ORDERSTATE_WAITDELIVERY);

        context.payment("orderNo");
        context.waitDelivery("orderNo");
        context.delivery("orderNo");
        context.statement("orderNo");
    }
}
