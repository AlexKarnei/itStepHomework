package by.itstep.karnei.torch;

import by.itstep.karnei.battery.Battery;
import by.itstep.karnei.light.Light;

public class TorchWithTwoBattery extends SimpleTorch {

    protected Battery battery1;

    public TorchWithTwoBattery(Battery battery, Battery battery1, Light light) {
        super(battery, light);
        this.battery1 = battery1;
    }

    @Override
    public boolean turnOn() {
        if (!enabled) {
            enabled = battery.getCharge(light.chargesToTurnOn() / 2) &
                    battery1.getCharge(light.chargesToTurnOn() / 2);
            return enabled;
        }
        return enabled;
    }

    @Override
    public void turnOff() {
        super.turnOff();
    }

}
