package design.behavior.mediator.pattern1;

/**
 * Created by Chengfei.Sun on 17/02/16.
 */
public class Client {
    public static void main(String[] args) {
        Mediator mediator = new ConcreteMediator();
        //采购人员采购电脑
        System.out.println("----采购人员采购电脑----");
        Purchase purchase = new Purchase(mediator);
        purchase.buyIBMComputer(100);

        //销售人员销售电脑
        System.out.println("----销售人员销售电脑----");
        Sale sale = new Sale(mediator);
        sale.sellIBMComputer(1);

        //库房管理人员管理库存
        System.out.println("----库房人员清理库存");
        Stock stock = new Stock(mediator);
        stock.clearStock();
    }
}
