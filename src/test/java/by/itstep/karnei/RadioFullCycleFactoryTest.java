package by.itstep.karnei;

import by.itstep.karnei.radio.AccumulatorRadio;
import by.itstep.karnei.radio.Radio;
import org.junit.Assert;
import org.junit.Test;

public class RadioFullCycleFactoryTest {

    private RadioFactory factory = new RadioFullCycleFactory();

    @Test
    public void chineseBatteryRadioTest() throws Exception {
        Radio radio = factory.createRadio(
                TorchFullCycleFactory.CHINESE_BATTERY,
                RadioFullCycleFactory.STATION_NAME);
        for (int i = 0; i < Math.ceil(5*1.5); i++) {
            Assert.assertTrue(radio.turnOn());
            radio.turnOff();
        }
        Assert.assertFalse(radio.turnOn());
        radio.turnOff();
        Assert.assertFalse(radio.turnOn());
        radio.turnOff();
    }

    @Test
    public void duracellBatteryRadioTest() throws Exception {
        Radio radio = factory.createRadio(
                TorchFullCycleFactory.DURACELL_BATTERY,
                RadioFullCycleFactory.STATION_NAME);
        for (int i = 0; i < (500/((int)(10/1.5))); i++){
            Assert.assertTrue(radio.turnOn());
            radio.turnOff();
        }
        Assert.assertFalse(radio.turnOn());
        radio.turnOff();
        Assert.assertFalse(radio.turnOn());
        radio.turnOff();
    }

    @Test
    public void accumulatorRadioTest() throws Exception {
        AccumulatorRadio radio = factory.createRadio(
                RadioFullCycleFactory.STATION_NAME);
        for (int i = 0; i <(700/((int)(10/1.5))); i++){
            Assert.assertTrue(radio.turnOn());
            radio.turnOff();
        }
        Assert.assertFalse(radio.turnOn());
        radio.turnOff();

        Assert.assertEquals(4,radio.getAccCharge());
        radio.getAccumulator().recharge();

        Assert.assertEquals(700,radio.getAccCharge());
        Assert.assertTrue(radio.turnOn());
    }
}