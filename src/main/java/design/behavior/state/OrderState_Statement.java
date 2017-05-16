package design.behavior.state;

/**
 * @author Chengfei.Sun on 2016/10/18.
 */
public class OrderState_Statement extends OrderState{
    public void payment(String orderNo) {
        System.out.println("订单已完成状态：不能再次支付");
    }

    public void waitDelivery(String orderNo) {
        System.out.println("订单已完成状态：不能待发货");
    }

    public void delivery(String orderNo) {
        System.out.println("订单已完成状态：不能再次发货");
    }

    public void statement(String orderNo) {
        System.out.println("订单已完成状态：不能再次完成");
    }
}
