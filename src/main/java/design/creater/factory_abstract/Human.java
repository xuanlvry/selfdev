package design.creater.factory_abstract;

/**
 * 人类
 * @author Chengfei.Sun on 2016/10/21.
 */
public interface Human {
    //每个人种的皮肤都有相应的颜色
    void getColor();

    //人类会说话
    void talk();

    //每个人都有性别
    void getSex();
}
