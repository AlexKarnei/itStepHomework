package by.itstep.karnei;

import by.itstep.karnei.torch.Torch;

public interface TorchFactory {

    Torch createTorch(String battery, String lightType);
}
