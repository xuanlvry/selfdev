package design.creater.builder.pattern1;

/**
 * @author Chengfei.Sun on 2016/10/17.
 */
public class ZClient {
    public static void main(String[] args) {
        //制造一个瘦小的看守所的人员
        Director soul = new Director(new Builder1());
        System.out.println("获得了" + soul.createDoppelganger("看守所人员1"));

        System.out.println("----------------------------------------");

        //制造一个胖胖的看守所的人员
        soul = new Director(new Builder2());
        System.out.println("获得了" + soul.createDoppelganger("看守所人员2"));
    }
}
