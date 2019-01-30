package by.itstep.karnei;

import by.itstep.karnei.torch.Torch;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TorchFullCycleFactoryTest {

    TorchFactory factory = new TorchFullCycleFactory();

    @Test
    public void createTorchChineseBattery() throws Exception {
        Torch torch = factory.createTorch(
                TorchFullCycleFactory.CHINESE_BATTERY,
                TorchFullCycleFactory.GLOW_LAMP);
        for (int i=0;i<5;i++){
            Assert.assertTrue(torch.turnOn());
            torch.turnOff();
        }
    }
}