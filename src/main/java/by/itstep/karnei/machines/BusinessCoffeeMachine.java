package by.itstep.karnei.machines;

import by.itstep.karnei.coffee.Americano;
import by.itstep.karnei.coffee.Espresso;
import by.itstep.karnei.exeptions.CoffeeMachineExceptions;
import by.itstep.karnei.exeptions.NoCoffeeExceptions;
import by.itstep.karnei.exeptions.NoWaterExceptions;

public class BusinessCoffeeMachine extends AbstractCoffeeMachine {
    protected static final int COFFEE_LIMIT = 5000;
    protected static final int WATER_LIMIT = 50000;
    protected static final int TANK_CAPACITY = 3000;


    public BusinessCoffeeMachine() {
        super();
    }


    public BusinessCoffeeMachine(int coffee, int water) {
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
        if (chekMakeCoffe(30)) return null;
        makeCupOfCoffee(30);
        return new Espresso();
    }

    public void makeCupOfCoffee(int i) throws CoffeeMachineExceptions {
        collectGarbage(22);
        setCoffee(getCoffee() - 22);
        setWater(getWater() - i);
    }

    public boolean chekMakeCoffe(int i) throws CoffeeMachineExceptions {
        if (!isRunning()) {
            return true;
        }
        if (getCoffee() < 22) {
            throw new NoCoffeeExceptions();
        }
        if (getWater() < i) {
            throw new NoWaterExceptions();
        }
        return false;
    }

    public Americano makeAmericano() throws CoffeeMachineExceptions {
        if (chekMakeCoffe(100)) return null;
        makeCupOfCoffee(100);
        return new Americano();
    }
}


