package by.itstep.karnei.battery;

public interface Accumulator extends Battery {

    int getCharge();

    void recharge();
}