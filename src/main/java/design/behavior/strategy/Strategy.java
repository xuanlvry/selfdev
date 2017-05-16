package design.behavior.strategy;

/**
 * 主要解决：在有多种算法相似的情况下，使用 if...else 所带来的复杂和难以维护。
 * @author Chengfei.Sun on 2016/10/17.
 */
public interface Strategy {
    int doOperation(int num1, int num2);
}
