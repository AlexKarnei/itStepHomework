package by.itstep.karnei.machines;

import by.itstep.karnei.NewCoffeeMachineWithGrainCoffee;
import by.itstep.karnei.coffee.Americano;
import by.itstep.karnei.coffee.Latte;
import by.itstep.karnei.exeptions.CoffeeMachineExceptions;
import by.itstep.karnei.exeptions.NoGrainCoffeeException;

public class NewEconomCoffeeMachineWhithGrainCoffee extends NewEconomCoffeeMachine implements NewCoffeeMachineWithGrainCoffee {

    private static final int GRAIN_COFFEE_LIMIT = 500;

    public NewEconomCoffeeMachineWhithGrainCoffee() {
        super();
        this.grainCoffee = 0;
    }

    public int getGrainCoffeeLimit() {
        return GRAIN_COFFEE_LIMIT;
    }

    public NewEconomCoffeeMachineWhithGrainCoffee(int coffee, int grainCoffee, int water, int milk) {
        super(coffee, water, milk);
        if (grainCoffee > this.getGrainCoffeeLimit()) {
            this.grainCoffee = this.getGrainCoffeeLimit();
        }
    }

    @Override
    public int getMilkLimit() {
        return MILK_LIMIT;
    }

    @Override
    public int getTankCapacity() {
        return TANK_CAPACITY;
    }

    @Override
    public int getWaterLimit() {
        return WATER_LIMIT;
    }

    @Override
    public int getCoffeeLimit() {
        return COFFEE_LIMIT + GRAIN_COFFEE_LIMIT;
    }

    @Override
    public Americano makeAmericano() throws CoffeeMachineExceptions {
        chekMakeCoffeWithGrainCoffee();
        makeCupOfCoffeeWithGrainCoffee();
        return new Americano();
    }

    public void makeCupOfCoffeeWithGrainCoffee() throws CoffeeMachineExceptions {
        makeCupOfCoffee(100);
        setGrainCoffee(getGrainCoffee() - 22);
    }

    public void chekMakeCoffeWithGrainCoffee() throws CoffeeMachineExceptions {
        chekMakeCoffe(100);
        if (getGrainCoffee() <= 0) {
            throw new NoGrainCoffeeException();
        }
    }


    @Override
    public Latte makeLatte() throws CoffeeMachineExceptions {
        int milkOnCup = 100;
        chekMakeCoffeeWithMilkWithGrainCoffee(milkOnCup);
        makeCupOfCoffeWithMilkWithGrainCoffee(milkOnCup);
        return new Latte();
    }

    public void makeCupOfCoffeWithMilkWithGrainCoffee(int milkOnCup) throws CoffeeMachineExceptions {
        makeCupOfCoffeeWithMilk(milkOnCup);
        setGrainCoffee(getGrainCoffee() - 22);
    }

    public void chekMakeCoffeeWithMilkWithGrainCoffee(int milkOnCup) throws CoffeeMachineExceptions {
        chekMakeCoffeeWithMilk(milkOnCup);
        if (getGrainCoffee() <= 0) {
            throw new NoGrainCoffeeException();
        }
    }

    public void fillWithCoffee(int coffeeInGramm, int grainCoffeeInGramm) {
        if ((coffeeInGramm + grainCoffeeInGramm + coffee) > (getCoffeeLimit() + getGrainCoffeeLimit())) {
            this.coffee = getCoffeeLimit() + getGrainCoffeeLimit();
        } else {
            grainCoffee = grainCoffeeInGramm;
            coffee = coffeeInGramm + grainCoffeeInGramm;
        }
    }
}

