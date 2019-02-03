package by.itstep.karnei.torch;

import by.itstep.karnei.battery.Battery;
import by.itstep.karnei.light.Light;

public class TorchWirhTreeBattery extends TorchWithTwoBattery implements Torch {

   private Battery battery2;

    public TorchWirhTreeBattery(Battery battery, Battery battery1, Battery battery2, Light light) {
        super(battery, battery1, light);
        this.battery2 = battery2;
    }


    @Override
    public boolean turnOn() {
        if (!enabled) {
            enabled = battery.getCharge(light.chargesToTurnOn() / 3) &
                    battery1.getCharge(light.chargesToTurnOn() / 3);// &
            battery2.getCharge(light.chargesToTurnOn() / 3);
            return enabled;
        } else {
            return enabled;
        }
    }

    @Override
    public void turnOff() {
        super.turnOff();
    }
}
