package design.structure.decorator;

/**
 * @author Chengfei.Sun on 2016/10/19.
 */
public class HighScoreDecorator extends Decorator {
    public HighScoreDecorator(SchoolReport schoolReport) {
        super(schoolReport);
    }

    //定义你要美化的方法
    private void reportHighScore() {
        System.out.println("装饰方法：这次语文最高是70，数学最高是82，英语最高是70");
    }

    @Override
    public void report() {
        this.reportHighScore();
        super.report();
    }
}
