package by.itstep.karnei.torch;

import by.itstep.karnei.battery.Battery;
import by.itstep.karnei.light.Light;

public class SimpleTorch implements Torch {
    protected    Battery battery;
    protected Light light;

    protected boolean enabled;

    public SimpleTorch() {
    }

    public SimpleTorch(Battery battery, Light light) {
        this.battery = battery;
        this.light = light;
    }

    @Override
    public boolean turnOn() {
        if (!enabled) {
            enabled = battery.getCharge(light.chargesToTurnOn());
            return enabled;
        } else {
            return enabled;
        }
    }

    @Override
    public void turnOff() {
        enabled = false;
    }
}
