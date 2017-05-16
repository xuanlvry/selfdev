package design.creater.builder.pattern2;

/**
 * Created by Chengfei.Sun on 17/02/13.
 */
public class Client {
    public static void main(String args[]){
        //服务员
        KFCWaiter waiter = new KFCWaiter();
        //套餐A
        MealA a = new MealA();
        //服务员准备套餐A
        waiter.setMealBuilder(a);
        //获得套餐A
        Meal mealA = waiter.construct();

        //套餐B
        MealB b = new MealB();
        waiter.setMealBuilder(b);
        Meal mealB = waiter.construct();
    }
}
