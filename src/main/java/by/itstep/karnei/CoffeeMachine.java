package by.itstep.karnei;

import by.itstep.karnei.coffee.Americano;
import by.itstep.karnei.coffee.Cappucino;
import by.itstep.karnei.coffee.Espresso;
import by.itstep.karnei.coffee.Latte;
import by.itstep.karnei.exeptions.CoffeeMachineExceptions;

public interface CoffeeMachine {

    void enable();

    void disable();

    void cleanUp();

    Espresso makeEspresso() throws CoffeeMachineExceptions;

    Americano makeAmericano() throws CoffeeMachineExceptions;




    void fillWithWater(int waterInML);

    void fillWithCoffee(int coffeeInGramm);



}
