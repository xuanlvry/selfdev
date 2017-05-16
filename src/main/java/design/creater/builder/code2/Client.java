package design.creater.builder.code2;

import design.creater.builder.code1.CarModel;

import java.util.ArrayList;

/**
 * @author Chengfei.Sun on 2016/10/28.
 */
public class Client {
    public static void main(String[] args) {
        ArrayList<String> sequence = new ArrayList<String>();
        sequence.add("engine boom");
        sequence.add("start");
        sequence.add("stop");

        //要一个奔驰
        CarBuilder_Benz carBuilder_benz = new CarBuilder_Benz();
        carBuilder_benz.setSequence(sequence);

        CarModel carModel_benz = carBuilder_benz.getCarModel();
        carModel_benz.run();

        //再要一个宝马
        CarBuilder_BMW carBuilder_bmw = new CarBuilder_BMW();
        carBuilder_bmw.setSequence(sequence);

        CarModel carModel_bmw = carBuilder_bmw.getCarModel();
        carModel_bmw.run();
    }
}
