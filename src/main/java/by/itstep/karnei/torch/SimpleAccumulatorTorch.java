package by.itstep.karnei.torch;

import by.itstep.karnei.battery.Accumulator;
import by.itstep.karnei.light.Light;

public class SimpleAccumulatorTorch extends SimpleTorch implements AccumulatorTorch {

    protected  Accumulator accumulator;

    public SimpleAccumulatorTorch(Accumulator battery, Light light) {
        super(battery, light);
        this.accumulator = battery;
    }

    @Override
    public Accumulator getAccumulator() {
        return accumulator;
    }

    @Override
    public int getAccCharge() {
        return accumulator.getCharge();
    }

}
