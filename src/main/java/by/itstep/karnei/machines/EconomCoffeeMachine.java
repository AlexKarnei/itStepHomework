package by.itstep.karnei.machines;

import by.itstep.karnei.coffee.Americano;
import by.itstep.karnei.coffee.Espresso;
import by.itstep.karnei.exeptions.CoffeeMachineExceptions;

public class EconomCoffeeMachine extends BusinessCoffeeMachine {
    protected static final int COFFEE_LIMIT = 1000;
    protected static final int WATER_LIMIT = 10000;
    protected static final int TANK_CAPACITY = 500;

    public EconomCoffeeMachine() {
        super();
    }

    public EconomCoffeeMachine(int coffee, int water) {
        super(coffee, water);
    }

    @Override
    public int getTankCapacity() {
        return TANK_CAPACITY;
    }

    @Override
    int getCoffeeLimit() {
        return COFFEE_LIMIT;
    }

    @Override
    int getWaterLimit() {
        return WATER_LIMIT;
    }

    public Espresso makeEspresso() throws CoffeeMachineExceptions {
        chekMakeCoffe(30);
        makeCupOfCoffee(30);
        return new Espresso();
    }

    public Americano makeAmericano() throws CoffeeMachineExceptions {
        chekMakeCoffe(100);
        makeCupOfCoffee(100);
        return new Americano();
    }
}
