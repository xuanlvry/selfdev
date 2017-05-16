package design.creater.builder.pattern2;

/**
 * Created by Chengfei.Sun on 17/02/13.
 */
public class KFCWaiter {
    private MealBuilder mealBuilder;

    public void setMealBuilder(MealBuilder mealBuilder){
        this.mealBuilder = mealBuilder;
    }

    public Meal construct(){
        mealBuilder.buildFood();
        mealBuilder.buildDrink();

        return mealBuilder.getMeal();
    }
}
