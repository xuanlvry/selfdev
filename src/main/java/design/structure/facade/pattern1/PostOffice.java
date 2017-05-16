package design.structure.facade.pattern1;

/**
 * 一个子系统比较复杂，就可以封装出一个或多个门面来
 * <p>
 * 它为子系统中的一组接口提供一个统一的高层接口。这一接口使得子系统更加容易使用。
 *
 * @author Chengfei.Sun on 2016/10/19.
 */
public class PostOffice {
    private LetterProcess letterProcess = new LetterProcessImpl();

    public void sendLetter(String content, String address) {
        letterProcess.writeContext(content);
        letterProcess.fillEnvelope(address);
        letterProcess.letterInfoEnvelope();
        letterProcess.sendLetter();
    }
}
