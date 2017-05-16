package design.behavior.template.code1;

/**
 * 悍马模型
 * @author Chengfei.Sun on 2016/10/24.
 */
public interface HummerModel {
    //可以发动
    void start();

    //可以停止
    void stop();

    //喇叭声音
    void alarm();

    //引擎声
    void engineBoom();

    //会跑
    void run();
}
