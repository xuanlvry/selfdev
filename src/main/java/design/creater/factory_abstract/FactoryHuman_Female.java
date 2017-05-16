package design.creater.factory_abstract;

/**
 * @author Chengfei.Sun on 2016/10/21.
 */
public class FactoryHuman_Female implements FactoryHuman {
    public Human createYellowHuman() {
        return new Human_YellowFemale();
    }

    public Human createWhiteHuman() {
        return new Human_WhiteFemale();
    }

    public Human createBlackHuman() {
        return new Human_BlackFemale();
    }
}
