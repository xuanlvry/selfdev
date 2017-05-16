package design.structure.decorator.commoncode;

/**
 * Created by Chengfei.Sun on 17/02/14.
 */
public abstract class Decorator extends Component {
    private Component component = null;

    //通过构造函数传递被修饰者
    public Decorator(Component component) {
        this.component = component;
    }

    //委托给被修饰者执行
    public void operate() {
        this.component.operate();
    }
}
