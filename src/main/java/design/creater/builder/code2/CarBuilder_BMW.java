package design.creater.builder.code2;

import design.creater.builder.code1.CarModel;
import design.creater.builder.code1.CarModel_BMW;

import java.util.ArrayList;

/**
 * @author Chengfei.Sun on 2016/10/28.
 */
public class CarBuilder_BMW extends CarBuilder {
    private CarModel_BMW carModel = new CarModel_BMW();

    public void setSequence(ArrayList<String> sequence) {
        this.carModel.setSequence(sequence);
    }

    public CarModel getCarModel() {
        return this.carModel;
    }
}
