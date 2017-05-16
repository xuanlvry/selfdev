package design.creater.builder.code2;

import design.creater.builder.code1.CarModel;

import java.util.ArrayList;

/**
 * @author Chengfei.Sun on 2016/10/28.
 */
public abstract class CarBuilder {
    public abstract void setSequence(ArrayList<String> sequence);

    public abstract CarModel getCarModel();
}
