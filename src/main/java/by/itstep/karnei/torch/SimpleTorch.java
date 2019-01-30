package by.itstep.karnei.torch;

import by.itstep.karnei.battery.Battery;
import by.itstep.karnei.light.Light;

public class SimpleTorch implements Torch {
    private Battery battery;
    private Light light;

    private boolean enebled;

    public SimpleTorch() {
    }

    public SimpleTorch(Battery battery, Light light) {
        this.battery = battery;
        this.light = light;
    }

    public boolean turnOn() {
        if (!enebled) {
            enebled = battery.getCharge(light.chargeToTurnOn());
            return enebled;
        }
        return enebled;
    }

    public void turnOff() {
        enebled = false;
    }
}
