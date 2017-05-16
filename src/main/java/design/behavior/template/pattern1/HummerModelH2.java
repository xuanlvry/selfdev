package design.behavior.template.pattern1;

/**
 * @author Chengfei.Sun on 2016/10/24.
 */
public class HummerModelH2 extends HummerModel {
    protected void start() {
        System.out.println("悍马H2发动...");
    }

    protected void stop() {
        System.out.println("悍马H2停车...");
    }

    protected void alarm() {
        System.out.println("悍马H2鸣笛...");
    }

    protected void engineBoom() {
        System.out.println("悍马H2引擎声...");
    }
}
