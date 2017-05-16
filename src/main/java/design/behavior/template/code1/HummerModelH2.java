package design.behavior.template.code1;

import design.behavior.template.code1.HummerModel;

/**
 * @author Chengfei.Sun on 2016/10/24.
 */
public class HummerModelH2 implements HummerModel {
    public void start() {
        System.out.println("悍马H2发动...");
    }

    public void stop() {
        System.out.println("悍马H2停车...");
    }

    public void alarm() {
        System.out.println("悍马H2鸣笛...");
    }

    public void engineBoom() {
        System.out.println("悍马H2引擎声...");
    }

    public void run() {
        this.start();
        this.engineBoom();
        this.alarm();
        this.stop();
    }
}
