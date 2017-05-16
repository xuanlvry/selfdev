package design.behavior.mediator.pattern1;

/**
 * 采购管理
 * 定义了采购电脑的标准：如果销售情况比较好，大于80分，你让我采购多少我就采购多少；销售情况不好，你让我采购100台，我就采购50台，对折采购。电脑采购完毕，
 * 需要放到库房中，调用库存的方法，增加库存电脑数量。
 * Created by Chengfei.Sun on 17/02/15.
 */
public class Purchase extends AbstractColleague {

    public Purchase(Mediator mediator) {
        super(mediator);
    }

    //采购IBM电脑
    public void buyIBMComputer(int number) {
        super.mediator.execute("purchase.buy", number);
    }

    //不再采购IBM电脑
    public void refuseBuyIBM() {
        System.out.println("不再采购IBM电脑");
    }
}
