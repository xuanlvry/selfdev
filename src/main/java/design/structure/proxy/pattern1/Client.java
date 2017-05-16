package design.structure.proxy.pattern1;

/**
 * @author Chengfei.Sun on 2016/10/12.
 */
public class Client {
    public static void main(String[] args) {
        Image image = new ProxyImage();
        image.display();
    }
}
