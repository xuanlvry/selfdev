package design.creater.builder.pattern2;

/**
 * Created by Chengfei.Sun on 17/02/13.
 */
public class MealB extends MealBuilder {
    public void buildFood() {
        meal.setFood("三个鸡翅");
    }

    public void buildDrink() {
        meal.setDrink("一杯柠檬果汁");
    }
}
