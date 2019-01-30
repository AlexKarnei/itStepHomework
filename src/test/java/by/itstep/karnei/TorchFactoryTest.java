package by.itstep.karnei;

import by.itstep.karnei.torch.Torch;
import org.junit.Assert;
import org.junit.Test;

public class TorchFactoryTest {

    private TorchFactory factory = new TorchFullCycleFactory();

    @Test
    public void chineseTorchTest() throws Exception {
        Torch torch = factory.createTorch(
                TorchFullCycleFactory.CHINESE_BATTERY,
                TorchFullCycleFactory.GLOW_LAMP);
        for (int i = 0; i < 5; i++) {
            Assert.assertTrue(torch.turnOn());
            torch.turnOff();
        }
        Assert.assertFalse(torch.turnOn());
        torch.turnOff();
        Assert.assertFalse(torch.turnOn());
        torch.turnOff();
    }

    @Test
    public void duracellTorchTest() throws Exception {
        Torch torch = factory.createTorch(
                TorchFullCycleFactory.DURACELL_BATTERY,
                TorchFullCycleFactory.GLOW_LAMP);
        for (int i = 0; i < 50; i++) {
            Assert.assertTrue(torch.turnOn());
            torch.turnOff();
        }
        Assert.assertFalse(torch.turnOn());
        torch.turnOff();
        Assert.assertFalse(torch.turnOn());
        torch.turnOff();
    }
}