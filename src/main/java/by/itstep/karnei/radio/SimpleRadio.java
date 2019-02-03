package by.itstep.karnei.radio;

import by.itstep.karnei.Station.Station;
import by.itstep.karnei.battery.Battery;
import by.itstep.karnei.torch.SimpleTorch;

public class SimpleRadio  implements Radio  {
    protected Battery battery;
    protected Station station;

    protected boolean enabled;

    public SimpleRadio() {
    }

    public SimpleRadio(Battery battery, Station station) {
        this.battery = battery;
        this.station = station;
    }

    @Override
    public boolean turnOn() {
        if (!enabled) {
            enabled = reproduceStation();
            return enabled;
        } else {
            return enabled;
        }
    }

    @Override
    public void turnOff() {
        enabled = false;

    }

    @Override
    public boolean reproduceStation() {
        return battery.getCharge(station.chargesToTurnOn());
    }
}

