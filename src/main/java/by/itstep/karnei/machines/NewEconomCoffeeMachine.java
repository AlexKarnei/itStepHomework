package by.itstep.karnei.machines;

import by.itstep.karnei.NewCoffeeMachine;
import by.itstep.karnei.coffee.Americano;
import by.itstep.karnei.coffee.Cappucino;
import by.itstep.karnei.coffee.Espresso;
import by.itstep.karnei.coffee.Latte;
import by.itstep.karnei.exeptions.CoffeeMachineExceptions;
import by.itstep.karnei.exeptions.NoMilkException;

public class NewEconomCoffeeMachine extends EconomCoffeeMachine implements NewCoffeeMachine {

    protected static final int MILK_LIMIT = 5000;

    public NewEconomCoffeeMachine() {
        super();
        this.milk = 0;
    }

    public NewEconomCoffeeMachine(int coffee, int water, int milk) {
        super(coffee, water);
        if (milk > this.getMilkLimit()) {
            this.milk = this.getWaterLimit();
        }
    }


    public int getMilkLimit() {
        return MILK_LIMIT;
    }

    @Override
    public int getTankCapacity() {
        return TANK_CAPACITY;
    }

    @Override
    int getWaterLimit() {
        return WATER_LIMIT;
    }

    @Override
    int getCoffeeLimit() {
        return COFFEE_LIMIT;
    }


    public void fillWithMilk(int milkInMl) {
        if (milkInMl + milk > getMilkLimit()) {
            this.milk = getMilkLimit();
        } else {
            milk += milkInMl;
        }
    }


    @Override
    public Espresso makeEspresso() throws CoffeeMachineExceptions {
        return super.makeEspresso();
    }

    @Override
    public Americano makeAmericano() throws CoffeeMachineExceptions {
        return super.makeAmericano();
    }

    public Latte makeLatte() throws CoffeeMachineExceptions {
        int milkOnCup = 100;
        chekMakeCoffeeWithMilk(milkOnCup);
        makeCupOfCoffeeWithMilk(milkOnCup);
        return new Latte();
    }

    public void makeCupOfCoffeeWithMilk(int milkOnCup) throws CoffeeMachineExceptions {
        makeCupOfCoffee(30);
        setMilk(getMilk() - milkOnCup);
    }

    public Cappucino makeCappucino() throws CoffeeMachineExceptions {
        int milkOnCup = 150;
        chekMakeCoffeeWithMilk(milkOnCup);
        makeCupOfCoffeeWithMilk(milkOnCup);
        return new Cappucino();
    }

    public void chekMakeCoffeeWithMilk(int milkOnCup) throws CoffeeMachineExceptions {
        chekMakeCoffe(30);
        if (getMilk() < milkOnCup) {
            throw new NoMilkException();
        }
    }
}
