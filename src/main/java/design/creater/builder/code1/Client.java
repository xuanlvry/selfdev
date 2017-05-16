package design.creater.builder.code1;

import java.util.ArrayList;

/**
 * 本例说明：
 *      基于template示例，现要求客户自定义顺序。
 *
 * @author Chengfei.Sun on 2016/10/24.
 */
public class Client {
    public static void main(String[] args) {
        CarModel_Benz benz = new CarModel_Benz();
        ArrayList<String> sequence = new ArrayList<String>();
        sequence.add("engine boom");
        sequence.add("start");
        sequence.add("stop");

        benz.setSequence(sequence);
        benz.run();
    }
}
