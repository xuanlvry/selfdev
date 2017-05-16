package design.structure.decorator;

/**
 * 装饰模式是在不必改变原类文件和使用继承的情况下，动态的扩展一个对象的功能。它是通过创建一个包装对象，也就是装饰来包裹真实的对象。
 * <p>
 * 这一个解释，引自百度百科，我们注意其中的几点。
 * 1，不改变原类文件。
 * 2，不使用继承。
 * 3，动态扩展。
 *
 * @author Chengfei.Sun on 2016/10/19.
 */
public class Decorator implements SchoolReport {
    private SchoolReport schoolReport;

    public Decorator(SchoolReport schoolReport) {
        this.schoolReport = schoolReport;
    }

    public void report() {
        schoolReport.report();
    }

    public void sign(String name) {
        schoolReport.sign(name);
    }
}
