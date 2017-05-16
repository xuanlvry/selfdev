package design.structure.decorator;

/**
 * @author Chengfei.Sun on 2016/10/19.
 */
public class SchoolReportImpl implements SchoolReport {
    public void report() {
        System.out.println("尊敬的XXX家长：");
        System.out.println("  ....");
        System.out.println("  语文62 数学78 英语67");
        System.out.println("  ....");
        System.out.println("      家长签名：");
    }

    public void sign(String name) {
        System.out.println("家长签名为：" + name);
    }
}
