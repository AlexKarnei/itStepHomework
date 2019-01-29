package by.itstep.karnei.machines;

import by.itstep.karnei.NewCoffeeMachineWithGrainCoffee;
import by.itstep.karnei.coffee.Americano;
import by.itstep.karnei.coffee.Latte;
import by.itstep.karnei.exeptions.CoffeeMachineExceptions;
import by.itstep.karnei.exeptions.NoCoffeeExceptions;
import by.itstep.karnei.exeptions.NoGrainCoffeeException;
import by.itstep.karnei.exeptions.NoWaterExceptions;
import org.junit.Assert;
import org.junit.Test;

public class NewEconomCoffeeMachineWhithGrainCoffeeTest {

    @Test
    public void makeAmericanoPositiveTest() throws Exception {

        NewCoffeeMachineWithGrainCoffee newEconom = new NewEconomCoffeeMachineWhithGrainCoffee();

        newEconom.fillWithCoffee(30, 1);
        newEconom.fillWithWater(150);
        newEconom.enable();

        Americano americano = newEconom.makeAmericano();
        Assert.assertNotNull(americano);
    }

    @Test
    public void makeAmericanoNegativeTest() throws Exception {

        NewCoffeeMachineWithGrainCoffee newEconom = new NewEconomCoffeeMachineWhithGrainCoffee();

        newEconom.fillWithCoffee(0, 0);
        newEconom.fillWithWater(15);
        newEconom.enable();

        Americano americano;

        try {
            americano = newEconom.makeAmericano();
        } catch (CoffeeMachineExceptions coffeeMachineExceptions) {
            if (coffeeMachineExceptions instanceof NoCoffeeExceptions || coffeeMachineExceptions instanceof NoGrainCoffeeException) {
                newEconom.fillWithCoffee(100, 100);
            }
            try {
                americano = newEconom.makeAmericano();
            } catch (CoffeeMachineExceptions coffeeMachineExceptions1) {
                if (coffeeMachineExceptions1 instanceof NoWaterExceptions) {
                    newEconom.fillWithWater(200);
                }
                americano = newEconom.makeAmericano();
            }
        }
        Assert.assertNotNull(americano);
    }

    @Test
    public void makeLattePositiveTest() throws Exception {

        NewCoffeeMachineWithGrainCoffee newEconom = new NewEconomCoffeeMachineWhithGrainCoffee();

        newEconom.fillWithCoffee(30, 1);
        newEconom.fillWithWater(150);
        newEconom.fillWithMilk(300);
        newEconom.enable();

        Latte latte = newEconom.makeLatte();
        Assert.assertNotNull(latte);
    }

    @Test(expected = NoGrainCoffeeException.class)
    public void makeLatteNegativeRealizedTest() throws Exception {

        NewCoffeeMachineWithGrainCoffee econom = new NewEconomCoffeeMachineWhithGrainCoffee();

        econom.fillWithCoffee(100, 0);
        econom.fillWithWater(100000);
        econom.fillWithMilk(50000);
        econom.enable();

        Latte latte = null;
        int i = 0;
        while (i < 10) {
            latte = econom.makeLatte();
            i++;
        }
        Assert.assertNull(latte);
    }
}
