package design.structure.proxy.pattern1;

/**
 * @author Chengfei.Sun on 2016/10/12.
 */
public class RealImage implements Image{
    public void display() {
        System.out.println("real image display ...");
    }
}
