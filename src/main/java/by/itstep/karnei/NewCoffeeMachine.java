package by.itstep.karnei;

import by.itstep.karnei.coffee.Cappucino;
import by.itstep.karnei.coffee.Latte;
import by.itstep.karnei.exeptions.CoffeeMachineExceptions;

public interface NewCoffeeMachine extends CoffeeMachine {

    Latte makeLatte() throws CoffeeMachineExceptions;

    Cappucino makeCappucino() throws CoffeeMachineExceptions;

    void fillWithMilk(int milkInMl);
}
