package by.itstep.karnei;

import by.itstep.karnei.Station.RadioStation;
import by.itstep.karnei.Station.Station;
import by.itstep.karnei.battery.Battery;
import by.itstep.karnei.battery.SimpleAccumulator;
import by.itstep.karnei.radio.AccumulatorRadio;
import by.itstep.karnei.radio.Radio;
import by.itstep.karnei.radio.SimpleAccumulatorRadio;
import by.itstep.karnei.radio.SimpleRadio;

public class RadioFullCycleFactory implements RadioFactory {

    public static final String STATION_NAME = "radio grodno";

    public Radio createRadio(String batteryType, String stationName) {
        Battery battery = TorchFullCycleFactory.getBattery(batteryType);
        Station station = getStationName(stationName);

        if (battery != null && station != null) {
            return new SimpleRadio(battery, station);
        }
        return null;
    }

    @Override
    public AccumulatorRadio createRadio(String stationName) {
        Station station = getStationName(stationName);

        if(station!=null){
            return new SimpleAccumulatorRadio(new SimpleAccumulator(700),station);
        }
        return  null;
    }


    public static Station getStationName(String stationName) {
        switch (stationName) {
            case STATION_NAME:
                return new RadioStation();
            default:
                return null;
        }

    }
}






