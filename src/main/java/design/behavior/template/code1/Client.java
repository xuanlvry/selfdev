package design.behavior.template.code1;

/**
 * 问题：两个run方法一样
 * @author Chengfei.Sun on 2016/10/24.
 */
public class Client {
    public static void main(String[] args){
        HummerModel hummerModel1 = new HummerModelH1();
        hummerModel1.run();

        HummerModel hummerModel2 = new HummerModelH2();
        hummerModel2.run();
    }
}
