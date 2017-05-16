package design.behavior.template.pattern2;

/**
 * @author Chengfei.Sun on 2016/10/24.
 */
public abstract class HummerModel {
    //可以发动
    protected abstract void start();

    //可以停止
    protected abstract void stop();

    //喇叭声音
    protected abstract void alarm();

    //引擎声
    protected abstract void engineBoom();

    protected abstract boolean isAlarm();

    //会跑
    public final void run() {
        this.start();
        this.engineBoom();
        if (this.isAlarm()) {
            this.alarm();
        }
        this.stop();
    }
}
