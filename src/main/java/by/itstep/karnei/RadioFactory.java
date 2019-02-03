package by.itstep.karnei;

import by.itstep.karnei.radio.AccumulatorRadio;
import by.itstep.karnei.radio.Radio;

public interface RadioFactory {

    Radio createRadio(String battery, String station);

    AccumulatorRadio createRadio (String station);
}
