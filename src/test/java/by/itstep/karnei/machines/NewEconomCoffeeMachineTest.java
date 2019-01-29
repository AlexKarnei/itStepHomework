package by.itstep.karnei.machines;

import by.itstep.karnei.NewCoffeeMachine;
import by.itstep.karnei.coffee.Americano;
import by.itstep.karnei.coffee.Cappucino;
import by.itstep.karnei.coffee.Espresso;
import by.itstep.karnei.coffee.Latte;
import by.itstep.karnei.exeptions.*;
import org.junit.Assert;
import org.junit.Test;

public class NewEconomCoffeeMachineTest {


    @Test
    public void makeEspresso() throws Exception {
        NewCoffeeMachine newEconom = new NewEconomCoffeeMachine();

        newEconom.fillWithCoffee(30);
        newEconom.fillWithWater(100);
        newEconom.enable();

        Espresso espresso = newEconom.makeEspresso();
        Assert.assertNotNull(espresso);
    }

    @Test
    public void makeAmericano() throws Exception {
        NewCoffeeMachine newEconom = new NewEconomCoffeeMachine();

        newEconom.fillWithCoffee(30);
        newEconom.fillWithWater(150);
        newEconom.enable();

        Americano americano = newEconom.makeAmericano();
        Assert.assertNotNull(americano);
    }

    @Test
    public void makeLatte() throws Exception {

        NewCoffeeMachine newEconom = new NewEconomCoffeeMachine();

        newEconom.fillWithCoffee(30);
        newEconom.fillWithWater(30);
        newEconom.fillWithMilk(100);
        newEconom.enable();

        Latte latte = newEconom.makeLatte();
        Assert.assertNotNull(latte);
    }

    @Test

    public void latteNegativeTest() throws Exception {

        NewCoffeeMachine newEconom = new NewEconomCoffeeMachine();
        newEconom.fillWithCoffee(15);
        newEconom.fillWithWater(50);
        newEconom.fillWithMilk(50);
        newEconom.enable();

        Latte latte;

        try {
            latte = newEconom.makeLatte();
        } catch (CoffeeMachineExceptions coffeeMachineExceptions) {
            if (coffeeMachineExceptions instanceof NoCoffeeExceptions) {
                newEconom.fillWithCoffee(22);
            }
            try {
                latte = newEconom.makeLatte();
            } catch (CoffeeMachineExceptions coffeeMachineExceptions1) {
                if (coffeeMachineExceptions1 instanceof NoWaterExceptions) {
                    newEconom.fillWithWater(500);
                }
                try {
                    latte = newEconom.makeLatte();
                } catch (CoffeeMachineExceptions coffeeMachineExceptions2) {
                    if (coffeeMachineExceptions2 instanceof NoMilkException) {
                        newEconom.fillWithMilk(600);
                    }
                    latte = newEconom.makeLatte();
                }
            }
        }
        Assert.assertNotNull(latte);
    }

    @Test
    public void positiveCappucinoTest() throws Exception {

        NewCoffeeMachine newEconom = new NewEconomCoffeeMachine();

        newEconom.fillWithCoffee(50);
        newEconom.fillWithWater(100);
        newEconom.fillWithMilk(150);
        newEconom.enable();

        Cappucino cappucino = newEconom.makeCappucino();
        Assert.assertNotNull(cappucino);
    }

    @Test(expected = NoCoffeeExceptions.class)
    public void negativeCappucinoRealizaedTest() throws Exception {

        NewCoffeeMachine newEconom = new NewEconomCoffeeMachine();
        newEconom.fillWithCoffee(1200);
        newEconom.fillWithWater(10000);
        newEconom.fillWithMilk(50);
        newEconom.enable();

        Cappucino cappucino = null;
        int i = 0;
        while (i < 100000) {
            try {
                cappucino = newEconom.makeCappucino();
            } catch (CoffeeMachineExceptions coffeeMachineExceptions1) {
                if (coffeeMachineExceptions1 instanceof NoMilkException) {
                    newEconom.fillWithMilk(5000);
                }
                try {
                    cappucino = newEconom.makeCappucino();
                } catch (CoffeeMachineExceptions coffeeMachineExceptions2) {
                    if (coffeeMachineExceptions2 instanceof NoTankCapacityExceptions) {
                        newEconom.cleanUp();
                    }
                    cappucino = newEconom.makeCappucino();
                }
            }
          i++;
        }
        Assert.assertNull(cappucino);
    }
}
