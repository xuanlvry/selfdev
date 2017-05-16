package design.structure.decorator;

/**
 * @author Chengfei.Sun on 2016/10/19.
 */
public class ZClient {
    public static void main(String[] args) {
        SchoolReport schoolReport = new SchoolReportImpl();
        schoolReport.report();

        schoolReport = new HighScoreDecorator(schoolReport);
        schoolReport.report();

        schoolReport = new SortDecorator(schoolReport);
        schoolReport.report();
        schoolReport.sign("xx");
    }
}