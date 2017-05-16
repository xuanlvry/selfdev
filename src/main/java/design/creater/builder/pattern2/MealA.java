package design.creater.builder.pattern2;

/**
 * Created by Chengfei.Sun on 17/02/13.
 */
public class MealA extends MealBuilder {
    public void buildFood() {
        meal.setDrink("一盒薯条");
    }

    public void buildDrink() {
        meal.setDrink("一杯可乐");
    }
}
