package by.itstep.karnei.machines;

import by.itstep.karnei.CoffeeMachine;
import by.itstep.karnei.coffee.Americano;
import by.itstep.karnei.coffee.Espresso;
import by.itstep.karnei.exeptions.CoffeeMachineExceptions;
import by.itstep.karnei.exeptions.NoCoffeeExceptions;
import by.itstep.karnei.exeptions.NoTankCapacityExceptions;
import by.itstep.karnei.exeptions.NoWaterExceptions;
import org.junit.Assert;
import org.junit.Test;

public class EconomCoffeeMachineTest {

    @Test
    public void espressoPositiveTest() throws Exception {
        CoffeeMachine econom = new EconomCoffeeMachine();

        econom.fillWithCoffee(22);
        econom.fillWithWater(30);
        econom.enable();

        Espresso espresso = econom.makeEspresso();
        Assert.assertNotNull(espresso);
    }

    @Test
    public void americanoPositiveTest() throws Exception {
        CoffeeMachine econom = new EconomCoffeeMachine();

        econom.fillWithCoffee(22);
        econom.fillWithWater(100);
        econom.enable();

        Americano americano = econom.makeAmericano();
        Assert.assertNotNull(americano);
    }

    @Test
    public void espressoNegativeTest() throws Exception {
        CoffeeMachine econom = new EconomCoffeeMachine();
        econom.fillWithCoffee(10);
        econom.fillWithWater(10);
        econom.enable();
        Espresso espresso;
        try {
            espresso = econom.makeEspresso();
        } catch (CoffeeMachineExceptions coffeeMachineExceptions) {
            if (coffeeMachineExceptions instanceof NoCoffeeExceptions) {
                econom.fillWithCoffee(22);
            }
            try {
                espresso = econom.makeEspresso();
            } catch (CoffeeMachineExceptions coffeeMachineExceptions1) {
                if (coffeeMachineExceptions1 instanceof NoWaterExceptions) {
                    econom.fillWithWater(30);
                }
                espresso = econom.makeEspresso();
            }
        }
        Assert.assertNotNull(espresso);
    }

    @Test
    public void americanoNegativeTest() throws Exception {
        CoffeeMachine econom = new EconomCoffeeMachine();
        econom.fillWithCoffee(15);
        econom.fillWithWater(50);
        econom.enable();
        Americano americano;
        try {
            americano = econom.makeAmericano();
        } catch (CoffeeMachineExceptions coffeeMachineExceptions) {
            if (coffeeMachineExceptions instanceof NoCoffeeExceptions) {
                econom.fillWithCoffee(22);
            }
            try {
                americano = econom.makeAmericano();
            } catch (CoffeeMachineExceptions coffeeMachineExceptions1) {
                if (coffeeMachineExceptions1 instanceof NoWaterExceptions) {
                    econom.fillWithWater(100);
                }
                americano = econom.makeAmericano();
            }
        }
        Assert.assertNotNull(americano);
    }

    @Test(expected = NoCoffeeExceptions.class)
    public void espressoNegativeRealizedTest() throws Exception {
        CoffeeMachine econom = new EconomCoffeeMachine();
        econom.fillWithCoffee(800);
        econom.fillWithWater(35000);
        econom.enable();
        Espresso espresso = null;
        int i = 0;
        while (i < 100000) {
            try {
                espresso = econom.makeEspresso();
            } catch (CoffeeMachineExceptions coffeeMachineExceptions) {
                if (coffeeMachineExceptions instanceof NoTankCapacityExceptions) {
                    econom.cleanUp();
                }
            }
            espresso = econom.makeEspresso();
            i++;
        }
        Assert.assertNull(espresso);
    }

    @Test(expected = NoCoffeeExceptions.class)
    public void americanoNegativeRealizedTest() throws Exception {
        CoffeeMachine econom = new EconomCoffeeMachine();
        econom.fillWithCoffee(1550);
        econom.fillWithWater(20000);
        econom.enable();
        Americano americano = null;
        int i = 0;
        while (i < 1000000) {
            try {
                americano = econom.makeAmericano();
            } catch (CoffeeMachineExceptions coffeeMachineExceptions) {
                if (coffeeMachineExceptions instanceof NoTankCapacityExceptions) {
                    econom.cleanUp();
                }
                americano = econom.makeAmericano();
            }
            i++;
        }
        Assert.assertNull(americano);
    }

}