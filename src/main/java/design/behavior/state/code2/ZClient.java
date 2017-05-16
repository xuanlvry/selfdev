package design.behavior.state.code2;

/**
 * @author Chengfei.Sun on 2016/10/19.
 */
public class ZClient {
    public static void main(String[] args){
        OrderState OrderState = new OrderStateImpl();

        OrderState.payment("orderNo");
        OrderState.waitDelivery("orderNo");
        OrderState.delivery("orderNo");
        OrderState.statement("orderNo");
    }
}
