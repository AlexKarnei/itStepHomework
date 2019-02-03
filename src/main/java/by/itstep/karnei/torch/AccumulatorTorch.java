package by.itstep.karnei.torch;

import by.itstep.karnei.battery.Accumulator;

public interface AccumulatorTorch extends Torch {

    Accumulator getAccumulator();

    int getAccCharge();

}
