package design.behavior.state;

/**
 * @author Chengfei.Sun on 2016/10/18.
 */
public class OrderState_WaitDelivery extends OrderState{
    public void payment(String orderNo) {
        System.out.println("订单待发货状态：不能再次支付");
    }

    public void waitDelivery(String orderNo) {
        System.out.println("订单待发货状态：不能待发货");
    }

    public void delivery(String orderNo) {
        System.out.println("订单待发货状态：可以发货");
        System.out.println("....开始编写发货逻辑....");

        //如果要串联状态过度
        //设置当前状态
        super.context.setOrderState(Context.ORDERSTATE_DELIVERY);
    }

    public void statement(String orderNo) {
        System.out.println("订单待发货状态：不能已完成");
    }
}
