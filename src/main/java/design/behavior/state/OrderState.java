package design.behavior.state;

/**
 * 对代码2优化
 *
 * 状态接口-定义状态行为集合
 * @author Chengfei.Sun on 2016/10/17.
 */
public abstract class OrderState {
    int WAIT_PAYMENT = 1;
    int PAYMENT = 2;
    int WAIT_DELIVERY = 3;
    int DELIVERY = 4;
    int STATEMENT = 5;

    Context context;

    public void setContext(Context context){
        this.context = context;
    }

    abstract void payment(String orderNo);

    abstract void waitDelivery(String orderNo);

    abstract void delivery(String orderNo);

    abstract void statement(String orderNo);
}
