package by.itstep.karnei.light;

public class LedLamp implements Light{
    @Override
    public int chargesToTurnOn() {
        return 10/3;
    }
}
