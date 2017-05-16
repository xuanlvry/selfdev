package design.structure.facade.code1;

/**
 * @author Chengfei.Sun on 2016/10/19.
 */
public class LetterProcessImpl implements LetterProcess {
    public void writeContext(String content) {
        System.out.println("填写信的内容：" + content);
    }

    public void fillEnvelope(String address) {
        System.out.println("填写收信人地址及姓名：" + address);
    }

    public void letterInfoEnvelope() {
        System.out.println("把信放到信封中");
    }

    public void sendLetter() {
        System.out.println("邮递信件");
    }
}
