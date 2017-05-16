package design.structure.decorator.code2;

/**
 * @author Chengfei.Sun on 2016/10/19.
 */
public class Client {
    public static void main(String[] args) {
        /**
         * 如果装饰条件非常多，就要扩展子类
         */
        SchoolReport schoolReport = new SchoolReportSugarImpl();
        schoolReport.report();
        schoolReport.sign("xx");
    }
}
