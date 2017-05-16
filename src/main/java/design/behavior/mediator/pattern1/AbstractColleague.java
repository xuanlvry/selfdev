package design.behavior.mediator.pattern1;

/**
 * Created by Chengfei.Sun on 17/02/16.
 */
public abstract class AbstractColleague {
    protected Mediator mediator;

    public AbstractColleague(Mediator mediator) {
        this.mediator = mediator;
    }
}
