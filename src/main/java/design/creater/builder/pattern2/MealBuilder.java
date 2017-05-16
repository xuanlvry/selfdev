package design.creater.builder.pattern2;

/**
 * Created by Chengfei.Sun on 17/02/13.
 */
public abstract class MealBuilder {
    Meal meal = new Meal();

    public abstract void buildFood();

    public abstract void buildDrink();

    public Meal getMeal() {
        return meal;
    }
}
