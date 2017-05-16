package design.creater.factory_abstract;

/**
 * @author Chengfei.Sun on 2016/10/21.
 */
public interface FactoryHuman {
    //制造黄色人种
    Human createYellowHuman();

    //制造白色人种
    Human createWhiteHuman();

    //制造黑色人种
    Human createBlackHuman();
}
