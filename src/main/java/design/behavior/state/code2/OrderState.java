package design.behavior.state.code2;

/**
 * 对代码1优化，将updateOrderState()方法拆分
 * @author Chengfei.Sun on 2016/10/19.
 */
public interface OrderState {
    int WAIT_PAYMENT = 1;
    int PAYMENT = 2;
    int WAIT_DELIVERY = 3;
    int DELIVERY = 4;
    int STATEMENT = 5;

    void payment(String orderNo);

    void waitDelivery(String orderNo);

    void delivery(String orderNo);

    void statement(String orderNo);
}
