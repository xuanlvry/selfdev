package design.structure.decorator;

/**
 * @author Chengfei.Sun on 2016/10/19.
 */
public interface SchoolReport {
    //成绩单
    void report();

    //家长签名
    void sign(String name);
}
