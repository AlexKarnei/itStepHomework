package by.itstep.karnei.torch;

import by.itstep.karnei.battery.Accumulator;
import by.itstep.karnei.light.Light;

public class TorchWithLedLight extends TorchWirhTreeBattery implements AccumulatorTorch {
    private Accumulator accumulator;
    private Accumulator accumulator1;
    private Accumulator accumulator2;


    public TorchWithLedLight(Accumulator battery, Accumulator battery1, Accumulator battery2, Light light) {
        super(battery, battery1, battery2, light);
        this.accumulator = battery;
        this.accumulator1 = battery1;
        this.accumulator2 = battery2;
    }

    @Override
    public boolean turnOn() {
        displayCharge();
        return super.turnOn();
    }

    @Override
    public void turnOff() {
        super.turnOff();
    }


    public Accumulator getAccumulator2() {
        return accumulator2;
    }

    public int getAccAccAccCharge() {
        return accumulator2.getCharge();
    }

    @Override
    public Accumulator getAccumulator() {
        return accumulator;
    }

    @Override
    public int getAccCharge() {
        return accumulator.getCharge();
    }

    public Accumulator getAccumulator1() {
        return accumulator1;
    }

    public int getAccAccCharge() {
        return accumulator1.getCharge();
    }

    public void displayCharge() {
        System.out.printf("Current charge: %d\n", accumulator.getCharge() + accumulator1.getCharge() + accumulator2.getCharge());
    }
}
