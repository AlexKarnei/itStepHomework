package by.itstep.karnei.torch;

import by.itstep.karnei.Station.Station;
import by.itstep.karnei.battery.Accumulator;
import by.itstep.karnei.light.Light;
import by.itstep.karnei.radio.AccumulatorRadio;
import by.itstep.karnei.radio.Radio;
import by.itstep.karnei.radio.SimpleRadio;

public class TorchWithRadio extends TorchWithTwoAccumulator implements AccumulatorTorch, Radio {

    protected Station station;

    public TorchWithRadio(Accumulator battery, Accumulator battery1, Light
            light, Station station) {
        super(battery, battery1, light);
        this.station = station;
    }

    public Accumulator getAccumulator1() {
        return accumulator1;
    }

    public int getAccAccCharge() {
        return accumulator1.getCharge();
    }


    @Override
    public Accumulator getAccumulator() {
        return accumulator;
    }

    @Override
    public int getAccCharge() {
        return super.getAccCharge();
    }

    public boolean radioTurnOn() {
        if (!enabled) {
            enabled = reproduceStation();
        }
        return enabled;
    }

    @Override
    public boolean turnOn() {
        return super.turnOn();
    }

    @Override
    public void turnOff() {
        super.turnOff();
    }

    @Override
    public boolean reproduceStation() {
        return battery.getCharge(station.chargesToTurnOn()/2)&battery1.getCharge(station.chargesToTurnOn()/2);
    }
}
