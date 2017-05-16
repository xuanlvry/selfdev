package design.behavior.state.code2;

/**
 * @author Chengfei.Sun on 2016/10/19.
 */
public class OrderStateImpl implements OrderState {

    public void payment(String orderNo) {
        //根据订单号，获取当前订单状态
        int currentState = WAIT_PAYMENT;

        if (currentState == WAIT_PAYMENT) {
            System.out.println("订单待支付状态：可以支付");
            System.out.println("....开始编写支付逻辑....");
        } else if (currentState == PAYMENT) {
            System.out.println("订单支付状态：不能再次支付");
        } else if (currentState == WAIT_DELIVERY) {
            System.out.println("订单待发货状态：不能再次支付");
        } else if (currentState == DELIVERY) {
            System.out.println("订单已发货状态：不能再次支付");
        } else if (currentState == STATEMENT) {
            System.out.println("订单已完成状态：不能再次支付");
        }
    }

    public void waitDelivery(String orderNo) {
        //根据订单号，获取当前订单状态
        int currentState = WAIT_PAYMENT;

        if (currentState == WAIT_PAYMENT) {
            System.out.println("订单待支付状态：不能待发货");
        } else if (currentState == PAYMENT) {
            System.out.println("订单已支付状态：可以待发货");
            System.out.println("....开始编写待发货逻辑....");
        } else if (currentState == WAIT_DELIVERY) {
            System.out.println("订单待发货状态：不能再次待发货");
        } else if (currentState == DELIVERY) {
            System.out.println("订单已发货状态：不能待发货");
        } else if (currentState == STATEMENT) {
            System.out.println("订单已完成状态：不能待发货");
        }

    }

    public void delivery(String orderNo) {
        //判断当前订单状态，编写业务逻辑
    }

    public void statement(String orderNo) {
        //判断当前订单状态，编写业务逻辑
    }
}
