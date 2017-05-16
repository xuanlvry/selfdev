package design.creater.builder.pattern1;

/**
 * 具体的建造者
 *
 * @author Chengfei.Sun on 2016/10/17.
 */
public class Builder2 implements Builder {
    private Product product;

    public void createDoppelganger(String name) {
        product = new Product(name);
    }

    public Product getProduct() {
        try {
            return product;
        } finally {
            product = null;
        }
    }

    public void buildBody() {
        System.out.println("设置" + product.getName() + "的胖胖的身体");
        product.setBody("胖胖的身体");
    }

    public void buildHead() {
        System.out.println("设置" + product.getName() + "的大大的头");
        product.setHead("大大的头");
    }

    public void buildLeftArm() {
        System.out.println("设置" + product.getName() + "的胖胖的左胳膊");
        product.setLeftArm("胖胖的左胳膊");
    }

    public void buildLeftHand() {
        System.out.println("设置" + product.getName() + "的胖胖的左手");
        product.setLeftHand("胖胖的左手");
    }

    public void buildRightArm() {
        System.out.println("设置" + product.getName() + "的胖胖的右胳膊");
        product.setRightArm("胖胖的右胳膊");
    }

    public void buildRightHand() {
        System.out.println("设置" + product.getName() + "的胖胖的右手");
        product.setRightHand("胖胖的右手");
    }

    public void buildLeftLeg() {
        System.out.println("设置" + product.getName() + "的胖胖的左腿");
        product.setLeftLeg("胖胖的左腿");
    }

    public void buildLeftFoot() {
        System.out.println("设置" + product.getName() + "的大大的左脚");
        product.setLeftFoot("大大的左脚");
    }

    public void buildRightLeg() {
        System.out.println("设置" + product.getName() + "的胖胖的右腿");
        product.setRightLeg("胖胖的右腿");
    }

    public void buildRightFoot() {
        System.out.println("设置" + product.getName() + "的大大的右脚");
        product.setRightFoot("大大的右脚");
    }
}
