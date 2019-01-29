package by.itstep.karnei.machines;

import by.itstep.karnei.CoffeeMachine;
import by.itstep.karnei.exeptions.CoffeeMachineExceptions;
import by.itstep.karnei.exeptions.NoTankCapacityExceptions;


public abstract class AbstractCoffeeMachine implements CoffeeMachine {
    protected int coffee;
    protected int water;
    protected int tank;
    protected int milk;
    protected int grainCoffee;
    protected boolean isRunning = false;

    public AbstractCoffeeMachine() {
        this.coffee = 0;
        this.water = 0;
    }

    {
        tank = 0;
    }

    public AbstractCoffeeMachine(int coffee, int water) {
        if (coffee > this.getCoffeeLimit()) {
            this.coffee = this.getCoffeeLimit();
        }
        if (water > this.getWaterLimit()) {
            this.water = this.getWaterLimit();
        }
    }


    public void enable() {
        if (isRunning == false) {
            isRunning = true;
        }
    }

    public void disable() {
        isRunning = false;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void cleanUp() {
        tank = 0;
    }

    public void fillWithWater(int waterInMl) {
        if (waterInMl + water > getWaterLimit()) {
            this.water = getWaterLimit();
        } else {
            water += waterInMl;
        }
    }

    public void fillWithCoffee(int coffeeInGramm) {
        if (coffeeInGramm + coffee > getCoffeeLimit()) {
            this.coffee = getCoffeeLimit();
        } else {
            coffee += coffeeInGramm;
        }
    }


    abstract int getCoffeeLimit();

    abstract int getWaterLimit();

    abstract int getTankCapacity();


    boolean avaliableTank(int valueAdd) {
        return tank + valueAdd < getTankCapacity();
    }

    void collectGarbage(int valueAdd) throws CoffeeMachineExceptions {
        if (avaliableTank(valueAdd)) {
            tank += valueAdd;
        } else {
            throw new NoTankCapacityExceptions();
        }
    }

    public int getGrainCoffee() {
        return grainCoffee;
    }

    public void setGrainCoffee(int grainCoffee) {
        this.grainCoffee = grainCoffee;
    }

    public int getMilk() {
        return milk;
    }

    public void setMilk(int milk) {
        this.milk = milk;
    }

    public int getCoffee() {
        return coffee;
    }

    public int getWater() {
        return water;
    }


    public void setCoffee(int coffee) {
        this.coffee = coffee;
    }

    public void setWater(int water) {
        this.water = water;
    }

}
