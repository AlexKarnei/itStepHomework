package by.itstep.karnei;

import by.itstep.karnei.Station.Station;
import by.itstep.karnei.battery.Battery;
import by.itstep.karnei.battery.ChineseBattery;
import by.itstep.karnei.battery.DuracellBattery;
import by.itstep.karnei.battery.SimpleAccumulator;
import by.itstep.karnei.light.GlowLamp;
import by.itstep.karnei.light.LedLamp;
import by.itstep.karnei.light.Light;
import by.itstep.karnei.torch.*;

public class TorchFullCycleFactory extends RadioFullCycleFactory implements TorchFactory {

    public static final String CHINESE_BATTERY = "chinese_battery";
    public static final String DURACELL_BATTERY = "duracell_battery";
    public static final String ACCUMULATOR_700_BATTERY = "accumulator";


    public static final String GLOW_LAMP = "glow_lamp";
    public static final String LED_LAMP = "led lamp";

    @Override
    public Torch createTorch(String lightType, String batteryType) {
        Light lamp = getLamp(lightType);
        Battery battery = getBattery(batteryType);
        if (lamp != null && battery != null) {
            return new SimpleTorch(battery, lamp);
        } else {
            return null;
        }
    }

    @Override
    public AccumulatorTorch createTorch(String lightType) {
        Light lamp = getLamp(lightType);

        if (lamp != null) {
            return new SimpleAccumulatorTorch(new SimpleAccumulator(700), lamp);
        }
        return null;
    }

    @Override
    public TorchWithTwoBattery createTorch(String batteryType, String batteryType1, String lightType) {
        Light lamp = getLamp(lightType);
        Battery battery = getBattery(batteryType);
        Battery battery1 = getBattery(batteryType1);
        if (batteryType != CHINESE_BATTERY) {
            Battery bat = battery;
            battery = battery1;
            battery1 = bat;
        } else {

        }
        if (lamp != null && battery != null && battery1 != null) {
            return new TorchWithTwoBattery(battery, battery1, lamp);
        } else {
            return null;
        }
    }

    @Override
    public TorchWithTwoAccumulator createTorchTwoAcc(String lightType) {
        Light lamp = getLamp(lightType);

        if (lamp != null) {
            return new TorchWithTwoAccumulator(new SimpleAccumulator(700), new SimpleAccumulator(700), lamp);
        }
        return null;
    }

    @Override
    public TorchWithRadio createTorchWithRadio(String lightType, String stationName) {
        Light lamp = getLamp(lightType);
        Station station = RadioFullCycleFactory.getStationName(stationName);
        if (lamp != null && station != null) {
            return new TorchWithRadio(new SimpleAccumulator(700), new SimpleAccumulator(700), lamp, station);
        }
        return null;
    }

    @Override
    public TorchWithLedLight createTorchWithLedLight(String lightType) {
        Light lamp = getLamp(lightType);

        if (lamp != null) {
            return new TorchWithLedLight(new SimpleAccumulator(700),
                    new SimpleAccumulator(700),
                    new SimpleAccumulator(700), lamp);
        }
        return null;
    }

    public static Battery getBattery(String batteryType) {
        switch (batteryType) {
            case CHINESE_BATTERY:
                return new ChineseBattery();
            case DURACELL_BATTERY:
                return new DuracellBattery();
            case ACCUMULATOR_700_BATTERY:
                return new SimpleAccumulator(700);
            default:
                return null;
        }
    }

    public static Light getLamp(String lightType) {
        switch (lightType) {
            case GLOW_LAMP:
                return new GlowLamp();
            case LED_LAMP:
                return new LedLamp();
            default:
                return null;
        }

    }
}
