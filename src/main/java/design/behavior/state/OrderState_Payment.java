package design.behavior.state;

/**
 * @author Chengfei.Sun on 2016/10/19.
 */
public class OrderState_Payment extends OrderState {
    public void payment(String orderNo) {
        System.out.println("订单已支付状态：不能再次支付");
    }

    public void waitDelivery(String orderNo) {
        System.out.println("订单已支付状态：可以待发货");
        System.out.println("....开始编写待发货逻辑....");

        //如果要串联状态过度
        super.context.setOrderState(Context.ORDERSTATE_WAITDELIVERY);
    }

    public void delivery(String orderNo) {
        System.out.println("订单已支付状态：不能已发货");
    }

    public void statement(String orderNo) {
        System.out.println("订单已支付状态：不能已完成");
    }
}
