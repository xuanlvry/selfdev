package design.creater.builder.pattern1;

/**
 * 具体的建造者
 *
 * @author Chengfei.Sun on 2016/10/17.
 */
public class Builder1 implements Builder {
    private Product product;

    public void createDoppelganger(String name){
        product = new Product(name);
    }

    public Product getProduct(){
        try {
            return product;
        }finally{
            product = null;
        }
    }

    public void buildBody() {
        System.out.println("设置" + product.getName() + "的瘦瘦的身体");
        product.setBody("瘦瘦的身体");
    }

    public void buildHead() {
        System.out.println("设置" + product.getName() + "的小小的头");
        product.setHead("小小的头");
    }

    public void buildLeftArm() {
        System.out.println("设置" + product.getName() + "的瘦瘦的左胳膊");
        product.setLeftArm("瘦瘦的左胳膊");
    }

    public void buildLeftHand() {
        System.out.println("设置" + product.getName() + "的瘦瘦的左手");
        product.setLeftHand("瘦瘦的左手");
    }

    public void buildRightArm() {
        System.out.println("设置" + product.getName() + "的瘦瘦的右胳膊");
        product.setRightArm("瘦瘦的右胳膊");
    }

    public void buildRightHand() {
        System.out.println("设置" + product.getName() + "的瘦瘦的右手");
        product.setRightHand("瘦瘦的右手");
    }

    public void buildLeftLeg() {
        System.out.println("设置" + product.getName() + "的瘦瘦的左腿");
        product.setLeftLeg("瘦瘦的左腿");
    }

    public void buildLeftFoot() {
        System.out.println("设置" + product.getName() + "的小小的左脚");
        product.setLeftFoot("小小的左脚");
    }

    public void buildRightLeg() {
        System.out.println("设置" + product.getName() + "的瘦瘦的右腿");
        product.setRightLeg("瘦瘦的右腿");
    }

    public void buildRightFoot() {
        System.out.println("设置" + product.getName() + "的小小的右脚");
        product.setRightFoot("小小的右脚");
    }
}
