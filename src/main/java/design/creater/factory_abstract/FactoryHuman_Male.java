package design.creater.factory_abstract;

/**
 * @author Chengfei.Sun on 2016/10/21.
 */
public class FactoryHuman_Male implements FactoryHuman {
    public Human createYellowHuman() {
        return new Human_YellowMale();
    }

    public Human createWhiteHuman() {
        return new Human_WhiteMale();
    }

    public Human createBlackHuman() {
        return new Human_BlackMale();
    }
}
