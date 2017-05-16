package design.behavior.state.code1;

/**
 * @author Chengfei.Sun on 2016/10/19.
 */
public class OrderStateImpl implements OrderState {
    public void updateOrderState(String orderNo, int orderState) {
        //根据订单号，获取当前订单状态
        int currentState = WAIT_PAYMENT;

        if (currentState == WAIT_PAYMENT) {
            //判断orderState，编写业务逻辑
            if (orderState == WAIT_PAYMENT) {
                System.out.println("订单待支付状态：不能再次待支付");
            } else if (orderState == PAYMENT) {
                System.out.println("订单待支付状态：可以支付");
                System.out.println("....开始编写支付逻辑....");
            } else if (orderState == WAIT_DELIVERY) {
                System.out.println("订单待支付状态：不能待发货");
            } else if (orderState == DELIVERY) {
                System.out.println("订单待支付状态：不能已发货");
            } else if (orderState == STATEMENT) {
                System.out.println("订单待支付状态：不能已完成");
            }
        } else if (currentState == PAYMENT) {
            //判断orderState，编写业务逻辑
            if (orderState == WAIT_PAYMENT) {
                System.out.println("订单已支付状态：不能待支付");
            } else if (orderState == PAYMENT) {
                System.out.println("订单已支付状态：不能再次支付");
            } else if (orderState == WAIT_DELIVERY) {
                System.out.println("订单已支付状态：可以待发货");
                System.out.println("....开始编写待发货逻辑....");
            } else if (orderState == DELIVERY) {
                System.out.println("订单已支付状态：不能已发货");
            } else if (orderState == STATEMENT) {
                System.out.println("订单已支付状态：不能已完成");
            }
        } else if (currentState == WAIT_DELIVERY) {
            //判断orderState，编写业务逻辑
        } else if (currentState == DELIVERY) {
            //判断orderState，编写业务逻辑
        } else if (currentState == STATEMENT) {
            //判断orderState，编写业务逻辑
        }
    }


}
