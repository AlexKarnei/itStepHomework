package by.itstep.karnei.torch;

import by.itstep.karnei.battery.Accumulator;
import by.itstep.karnei.light.Light;

public class TorchWithTwoAccumulator extends TorchWithTwoBattery implements AccumulatorTorch {
    protected Accumulator accumulator;
    protected Accumulator accumulator1;


    public TorchWithTwoAccumulator(Accumulator battery, Accumulator battery1, Light light) {
        super(battery, battery1, light);
        this.accumulator = battery;
        this.accumulator1 = battery1;
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
}



