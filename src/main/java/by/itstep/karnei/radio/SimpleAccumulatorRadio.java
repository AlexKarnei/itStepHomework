package by.itstep.karnei.radio;

import by.itstep.karnei.Station.Station;
import by.itstep.karnei.battery.Accumulator;
import by.itstep.karnei.light.Light;
import by.itstep.karnei.torch.SimpleAccumulatorTorch;

public class SimpleAccumulatorRadio extends SimpleRadio implements AccumulatorRadio {

    private Accumulator accumulator;
    public SimpleAccumulatorRadio (Accumulator battery, Station station) {
        super(battery, station);
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
