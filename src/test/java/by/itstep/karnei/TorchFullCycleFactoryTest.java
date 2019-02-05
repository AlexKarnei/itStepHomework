package by.itstep.karnei;

import by.itstep.karnei.torch.*;
import org.junit.Assert;
import org.junit.Test;


public class TorchFullCycleFactoryTest {

    private TorchFactory factory = new TorchFullCycleFactory();

    @Test
    public void chineseBatteryTorchTest() throws Exception {
        Torch torch = factory.createTorch(
                TorchFullCycleFactory.GLOW_LAMP,
                TorchFullCycleFactory.CHINESE_BATTERY);
        for (int i = 0; i < 5; i++) {
            Assert.assertTrue(torch.turnOn());
            torch.turnOff();
        }
        Assert.assertFalse(torch.turnOn());
        torch.turnOff();
        Assert.assertFalse(torch.turnOn());
        torch.turnOn();
    }

    @Test
    public void duracellBatteryTorchTest() throws Exception {
        Torch torch = factory.createTorch(
                TorchFullCycleFactory.GLOW_LAMP,
                TorchFullCycleFactory.DURACELL_BATTERY);
        for (int i = 0; i < 50; i++) {
            Assert.assertTrue(torch.turnOn());
            torch.turnOff();
        }
        Assert.assertFalse(torch.turnOn());
        torch.turnOff();
        Assert.assertFalse(torch.turnOn());
        torch.turnOff();
    }

    @Test
    public void accumulatorBatteryTorchTest() throws Exception {
        AccumulatorTorch torch = factory.createTorch(
                TorchFullCycleFactory.GLOW_LAMP);
        for (int i = 0; i < 70; i++) {
            Assert.assertTrue(torch.turnOn());
            torch.turnOff();
        }
        Assert.assertFalse(torch.turnOn());
        torch.turnOff();


        Assert.assertEquals(0, torch.getAccCharge());
        torch.getAccumulator().recharge();

        Assert.assertEquals(700, torch.getAccCharge());
        Assert.assertTrue(torch.turnOn());
    }

    @Test
    public void torchWithTwoDuracellBatteryTest() throws Exception {
        TorchWithTwoBattery torch = factory.createTorch(TorchFullCycleFactory.DURACELL_BATTERY,
                TorchFullCycleFactory.DURACELL_BATTERY, TorchFullCycleFactory.GLOW_LAMP);
        for (int i = 0; i < 100; i++) {
            Assert.assertTrue(torch.turnOn());
            torch.turnOff();
        }
        Assert.assertFalse(torch.turnOn());
        torch.turnOff();
        Assert.assertFalse(torch.turnOn());
        torch.turnOff();
    }

    @Test
    public void torchWithTwoChinesBatteryTest() throws Exception {
        TorchWithTwoBattery torch = factory.createTorch(TorchFullCycleFactory.CHINESE_BATTERY,
                TorchFullCycleFactory.CHINESE_BATTERY, TorchFullCycleFactory.GLOW_LAMP);
        for (int i = 0; i < 10; i++) {
            Assert.assertTrue(torch.turnOn());
            torch.turnOff();
        }
        Assert.assertFalse(torch.turnOn());
        torch.turnOff();
        Assert.assertFalse(torch.turnOn());
        torch.turnOff();
    }

    @Test
    public void torchWithTwoVariousBatteryTest() throws Exception {
        TorchWithTwoBattery torch = factory.createTorch(TorchFullCycleFactory.DURACELL_BATTERY,
                TorchFullCycleFactory.CHINESE_BATTERY, TorchFullCycleFactory.GLOW_LAMP);
        for (int i = 0; i < 10; i++) {
            Assert.assertTrue(torch.turnOn());
            torch.turnOff();
        }
        Assert.assertFalse(torch.turnOn());
        torch.turnOff();
        Assert.assertFalse(torch.turnOn());
        torch.turnOff();
    }

    @Test
    public void torchWithTwoAccumulatorBatteryTest() throws Exception {

        TorchWithTwoAccumulator torch = factory.createTorchTwoAcc(
                TorchFullCycleFactory.GLOW_LAMP);

        for (int i = 0; i < 140; i++) {
            Assert.assertTrue(torch.turnOn());
            torch.turnOff();
        }
        Assert.assertFalse(torch.turnOn());
        torch.turnOff();

        Assert.assertEquals(0, torch.getAccCharge());
        torch.getAccumulator().recharge();

        Assert.assertEquals(0, torch.getAccAccCharge());
        torch.getAccumulator1().recharge();

        Assert.assertEquals(700, torch.getAccCharge());
        Assert.assertEquals(700, torch.getAccAccCharge());
        Assert.assertTrue(torch.turnOn());
    }

    @Test
    public void torchWithRadioTest() throws Exception {
        TorchWithRadio torch = factory.createTorchWithRadio(
                TorchFullCycleFactory.GLOW_LAMP,
                RadioFullCycleFactory.STATION_NAME);

        // Test flashlight with simultaneous turning on the radio

        for (int i = 0; i <= (1400 / ((int) (10 + 10 / 1.5))); i++) {
            if (torch.turnOn()) {
                Assert.assertTrue(torch.turnOn());
                torch.turnOff();
                Assert.assertTrue(torch.radioTurnOn());
                torch.turnOff();
            } else if (torch.radioTurnOn()) {
                Assert.assertTrue(torch.radioTurnOn());
                torch.turnOff();
            }
        }

        Assert.assertFalse(torch.turnOn());
        torch.turnOff();

        Assert.assertFalse(torch.radioTurnOn());
        torch.turnOff();

        Assert.assertEquals(1, torch.getAccCharge());
        torch.getAccumulator().recharge();

        Assert.assertEquals(1, torch.getAccAccCharge());
        torch.getAccumulator1().recharge();

        Assert.assertEquals(700, torch.getAccCharge());
        Assert.assertEquals(700, torch.getAccAccCharge());
        Assert.assertTrue(torch.turnOn());
        torch.turnOff();
        Assert.assertTrue(torch.radioTurnOn());
        torch.turnOff();

        torch.getAccumulator().recharge();
        torch.getAccumulator1().recharge();
        Assert.assertEquals(700, torch.getAccCharge());
        Assert.assertEquals(700, torch.getAccAccCharge());

        //Flashlight test without turning on the radio

        for (int i = 0; i < 140; i++) {
            Assert.assertTrue(torch.turnOn());
            torch.turnOff();
        }
        Assert.assertFalse(torch.turnOn());
        torch.turnOff();

        Assert.assertEquals(0, torch.getAccCharge());
        torch.getAccumulator().recharge();

        Assert.assertEquals(0, torch.getAccAccCharge());
        torch.getAccumulator1().recharge();

        Assert.assertEquals(700, torch.getAccCharge());
        Assert.assertEquals(700, torch.getAccAccCharge());
        Assert.assertTrue(torch.turnOn());

        torch.getAccumulator().recharge();
        torch.getAccumulator1().recharge();
        Assert.assertEquals(700, torch.getAccCharge());
        Assert.assertEquals(700, torch.getAccAccCharge());

        // Test of turning on the radio without turning on the flashlight

        for (int i = 0; i <= (1400 / ((int) (10 / 1.5))); i++) {
            Assert.assertTrue(torch.radioTurnOn());
            torch.turnOff();
        }

        Assert.assertFalse(torch.radioTurnOn());
        torch.turnOff();

        Assert.assertEquals(1, torch.getAccCharge());
        torch.getAccumulator().recharge();

        Assert.assertEquals(1, torch.getAccAccCharge());
        torch.getAccumulator1().recharge();

        Assert.assertEquals(700, torch.getAccCharge());
        Assert.assertEquals(700, torch.getAccAccCharge());
        Assert.assertTrue(torch.radioTurnOn());
    }

    @Test
    public void torchWithLedLightTest() throws Exception {
        TorchWithLedLight torch = factory.createTorchWithLedLight(
                TorchFullCycleFactory.LED_LAMP);

        // Test flashlight with simultaneous turning on the radio

        for (int i = 0; i < 120; i++) {
            Assert.assertTrue(torch.turnOn());
            torch.turnOff();
        }
        torch.showCurrentCharge();
        torch.getAccumulator().recharge();
        torch.getAccumulator1().recharge();
        torch.getAccumulator2().recharge();

        for (int i = 0; i < 700; i++) {
            Assert.assertTrue(torch.turnOn());
            torch.turnOff();
        }

        Assert.assertFalse(torch.turnOn());
        torch.turnOff();

        Assert.assertEquals(0, torch.getAccCharge());
        torch.getAccumulator().recharge();

        Assert.assertEquals(0, torch.getAccAccCharge());
        torch.getAccumulator1().recharge();

        Assert.assertEquals(0, torch.getAccAccAccCharge());
        torch.getAccumulator2().recharge();

        Assert.assertEquals(700, torch.getAccCharge());
        Assert.assertEquals(700, torch.getAccAccCharge());
        Assert.assertEquals(700, torch.getAccAccAccCharge());
        Assert.assertTrue(torch.turnOn());
        torch.turnOff();
    }
}