package design.behavior.mediator.pattern1;

import java.util.Random;

/**
 * 销售管理
 * Created by Chengfei.Sun on 17/02/15.
 */
public class Sale extends AbstractColleague {
    public Sale(Mediator mediator) {
        super(mediator);
    }

    //销售IBM电脑
    public void sellIBMComputer(int number) {
        System.out.println("销售IBM电脑" + number + "台");
        super.mediator.execute("sale.sell", number);
    }

    //反馈销售情况，0~100之间变化，0代表根本没人买，100代表非常畅销
    public int getSaleStatus() {
        Random random = new Random(System.currentTimeMillis());
        int saleStatus = random.nextInt(100);
        System.out.println("IBM电脑的销售情况为：" + saleStatus);
        return saleStatus;
    }

    //折价处理
    public void offSale() {
        //库房有多少卖多少
        super.mediator.execute("sale.offsell");
    }
}
