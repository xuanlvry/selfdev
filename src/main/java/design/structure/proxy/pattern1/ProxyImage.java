package design.structure.proxy.pattern1;

/**
 * 代理和被代理的要实现同一个接口，这样才知道哪些能做
 *
 * @author Chengfei.Sun on 2016/10/12.
 */
public class ProxyImage implements Image {
    private Image image;

    /**
     * 可以是任何Image类型的代理
     */
    public ProxyImage(Image image){
        this.image = image;
    }

    public ProxyImage(){
        /**
         * 默认是RealImage的代理
         */
        this.image = new RealImage();
    }

    public void display() {
        this.image.display();
    }
}
