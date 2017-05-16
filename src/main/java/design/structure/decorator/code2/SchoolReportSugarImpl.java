package design.structure.decorator.code2;

/**
 * @author Chengfei.Sun on 2016/10/19.
 */
public class SchoolReportSugarImpl extends SchoolReportImpl {
    //定义你要美化的方法
    private void reportHighScore(){
        System.out.println("这次语文最高是70，数学最高是82，英语最高是70");
    }

    @Override
    public void report(){
        this.reportHighScore();
        super.report();
    }
}
