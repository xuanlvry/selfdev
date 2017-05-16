package design.structure.decorator.code1;

/**
 * @author Chengfei.Sun on 2016/10/19.
 */
public class Client {
    public static void main(String[] args) {
        SchoolReport schoolReport = new SchoolReportImpl();
        schoolReport.report();
        schoolReport.sign("xx");
    }
}
