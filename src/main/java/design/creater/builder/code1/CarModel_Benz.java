package design.creater.builder.code1;

/**
 * @author Chengfei.Sun on 2016/10/24.
 */
public class CarModel_Benz extends CarModel {
    protected void start() {
        System.out.println("奔驰车启动是这个样子...");
    }

    protected void stop() {
        System.out.println("奔驰车应该这样停车...");
    }

    protected void alarm() {
        System.out.println("奔驰车的喇叭是这个样子...");
    }

    protected void engineBoom() {
        System.out.println("奔驰车引擎是这个声音...");
    }
}
