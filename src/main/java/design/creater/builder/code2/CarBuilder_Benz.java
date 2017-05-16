package design.creater.builder.code2;

import design.creater.builder.code1.CarModel;
import design.creater.builder.code1.CarModel_Benz;

import java.util.ArrayList;

/**
 * @author Chengfei.Sun on 2016/10/28.
 */
public class CarBuilder_Benz extends CarBuilder {
    private CarModel_Benz carModel = new CarModel_Benz();

    public void setSequence(ArrayList<String> sequence) {
        this.carModel.setSequence(sequence);
    }

    public CarModel getCarModel() {
        return this.carModel;
    }
}
