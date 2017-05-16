package design.structure.facade.code1;

/**
 * 调用方需要知道步骤的顺序，一旦出错，信寄不出去
 *
 * @author Chengfei.Sun on 2016/10/19.
 */
public class Client {
    public static void main(String[] args) {
        LetterProcess letterProcess = new LetterProcessImpl();
        letterProcess.writeContext("吃饭了没");
        letterProcess.fillEnvelope("月宫，嫦娥收");
        letterProcess.letterInfoEnvelope();
        letterProcess.sendLetter();
    }
}
