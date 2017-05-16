package design.structure.facade.pattern1;

/**
 * @author Chengfei.Sun on 2016/10/19.
 */
public interface LetterProcess {
    //写信内容
    void writeContext(String content);

    //写信封
    void fillEnvelope(String address);

    //信放到信封里
    void letterInfoEnvelope();

    //邮递
    void sendLetter();
}
