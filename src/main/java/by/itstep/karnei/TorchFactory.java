package by.itstep.karnei;

import by.itstep.karnei.torch.*;

public interface TorchFactory {

    Torch createTorch(String lightType, String batteryType);

    AccumulatorTorch createTorch(String lightType);

    TorchWithTwoBattery createTorch(String batteryType, String batteryType1, String lightType);

    TorchWithTwoAccumulator createTorchTwoAcc(String lightType);

    TorchWithRadio createTorchWithRadio(String lightType, String station);

    TorchWithLedLight createTorchWithLedLight(String lightType);
}
