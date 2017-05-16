package design.behavior.state.code1;

/**
 * @author Chengfei.Sun on 2016/10/19.
 */
public class ZClient {
    public static void main(String[] args){
        OrderState orderState = new OrderStateImpl();
        orderState.updateOrderState("orderNo", OrderState.PAYMENT);
    }
}
