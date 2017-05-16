package design.behavior.state.code1;

/**
 * 最原始的方法
 * @author Chengfei.Sun on 2016/10/19.
 */
public interface OrderState {
    int WAIT_PAYMENT = 1;
    int PAYMENT = 2;
    int WAIT_DELIVERY = 3;
    int DELIVERY = 4;
    int STATEMENT = 5;

    void updateOrderState(String orderNo, int orderState);
}
