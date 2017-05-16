package design.behavior.template.pattern2;

/**
 * @author Chengfei.Sun on 2016/10/24.
 */
public class HummerModelH1 extends HummerModel {
    private boolean alarmFlag = true;

    protected void start() {
        System.out.println("悍马H1发动...");
    }

    protected void stop() {
        System.out.println("悍马H1停车...");
    }

    protected void alarm() {
        System.out.println("悍马H1鸣笛...");
    }

    protected void engineBoom() {
        System.out.println("悍马H1引擎声...");
    }

    protected boolean isAlarm() {
        return this.alarmFlag;
    }

    public void setAlarm(boolean alarmFlag) {
        this.alarmFlag = alarmFlag;
    }
}
