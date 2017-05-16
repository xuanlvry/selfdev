package design.structure.decorator;

/**
 * @author Chengfei.Sun on 2016/10/19.
 */
public class SortDecorator extends Decorator {
    public SortDecorator(SchoolReport schoolReport) {
        super(schoolReport);
    }

    //定义你要美化的方法
    private void reportSort() {
        System.out.println("装饰方法：这次排名38");
    }

    @Override
    public void report() {
        super.report();
        this.reportSort();
    }
}
