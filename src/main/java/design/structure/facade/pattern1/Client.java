package design.structure.facade.pattern1;

/**
 * @author Chengfei.Sun on 2016/10/19.
 */
public class Client {
    public static void main(String[] args) {
        PostOffice postOffice = new PostOffice();

        String content = "吃饭了没";
        String address = "月宫，嫦娥收";
        postOffice.sendLetter(content, address);
    }
}
