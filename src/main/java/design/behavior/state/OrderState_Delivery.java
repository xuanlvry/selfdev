package design.behavior.state;

/**
 * @author Chengfei.Sun on 2016/10/18.
 */
public class OrderState_Delivery extends OrderState{

    public void payment(String orderNo) {
        System.out.println("订单已发货状态：不能再次支付");
    }

    public void waitDelivery(String orderNo) {
        System.out.println("订单已发货状态：不能待发货");
    }

    public void delivery(String orderNo) {
        System.out.println("订单已发货状态：不能再次发货");
    }

    public void statement(String orderNo) {
        System.out.println("订单已发货状态：可以完成");
        System.out.println("....开始编写已完成逻辑....");

        //如果要串联状态过度
        super.context.setOrderState(Context.ORDERSTATE_STATEMENT);
    }
}
