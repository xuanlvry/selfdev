package design.behavior.template.code1;

/**
 * @author Chengfei.Sun on 2016/10/24.
 */
public class HummerModelH1 implements HummerModel {
    public void start() {
        System.out.println("悍马H1发动...");
    }

    public void stop() {
        System.out.println("悍马H1停车...");
    }

    public void alarm() {
        System.out.println("悍马H1鸣笛...");
    }

    public void engineBoom() {
        System.out.println("悍马H1引擎声...");
    }

    public void run() {
        this.start();
        this.engineBoom();
        this.alarm();
        this.stop();
    }
}
