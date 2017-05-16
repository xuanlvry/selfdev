package design.behavior.state;

/**
 * 环境角色，串联状态的过度
 * @author Chengfei.Sun on 2016/10/17.
 */
public class Context {
    public final static OrderState ORDERSTATE_PAYMENT = new OrderState_Payment();
    public final static OrderState ORDERSTATE_WAITDELIVERY = new OrderState_WaitDelivery();
    public final static OrderState ORDERSTATE_DELIVERY = new OrderState_Delivery();
    public final static OrderState ORDERSTATE_STATEMENT = new OrderState_Statement();

    //定义一个当前订单状态
    private OrderState orderState;

    //构造器1
    public Context() {

    }

    //构造器2
    public Context(OrderState orderState) {
        this.orderState = orderState;
        this.orderState.setContext(this);
    }

    public OrderState getOrderState() {
        return orderState;
    }

    public void setOrderState(OrderState orderState) {
        this.orderState = orderState;
        this.orderState.setContext(this);
    }

    //对外方法
    public void payment(String orderNo) {
        this.orderState.payment(orderNo);
    }

    public void waitDelivery(String orderNo) {
        this.orderState.waitDelivery(orderNo);
    }

    public void delivery(String orderNo) {
        this.orderState.delivery(orderNo);
    }

    public void statement(String orderNo) {
        this.orderState.statement(orderNo);
    }

}
