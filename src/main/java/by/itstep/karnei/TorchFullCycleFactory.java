package by.itstep.karnei;

import by.itstep.karnei.battery.Battery;
import by.itstep.karnei.battery.ChineseBattery;
import by.itstep.karnei.battery.DuracellBattery;
import by.itstep.karnei.light.GlowLamp;
import by.itstep.karnei.light.Light;
import by.itstep.karnei.torch.SimpleTorch;
import by.itstep.karnei.torch.Torch;

public class TorchFullCycleFactory implements TorchFactory {

    public static final String CHINESE_BATTERY = "chinese battery";
    public static final String DURACELL_BATTERY = "duracell battery";

    public static final String GLOW_LAMP = "glow lamp";

    public Torch createTorch(String batteryType, String lightType) {
        Battery battery = getBattery(batteryType);
        Light lamp = getLight(lightType);
        if (lamp != null && battery != null) {
            return new SimpleTorch(battery, lamp);
        }
            return null;
    }

    private Light getLight(String lightType) {
        switch (lightType) {
            case GLOW_LAMP:
                return new GlowLamp();
            default:
                return null;
        }
    }

    private Battery getBattery(String batteryType) {
        switch (batteryType) {
            case CHINESE_BATTERY:
                return new ChineseBattery();
            case DURACELL_BATTERY:
                return new DuracellBattery();
            default:
                return null;
        }
    }
}
