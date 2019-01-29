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

public class BusinessCoffeeMachineTest {

    @Test
    public void espressoPositiveTest() throws Exception {
        CoffeeMachine business = new BusinessCoffeeMachine();

        business.fillWithCoffee(22);
        business.fillWithWater(30);
        business.enable();

        Espresso espresso = business.makeEspresso();
        Assert.assertNotNull(espresso);
    }

    @Test
    public void americanoPositiveTest() throws Exception {
        CoffeeMachine business = new BusinessCoffeeMachine();

        business.fillWithCoffee(22);
        business.fillWithWater(100);
        business.enable();

        Americano americano = business.makeAmericano();
        Assert.assertNotNull(americano);
    }

    @Test
    public void espressoNegativeTest() throws Exception {
        CoffeeMachine business = new BusinessCoffeeMachine();
        business.fillWithCoffee(10);
        business.fillWithWater(10);
        business.enable();
        Espresso espresso;
        try {
            espresso = business.makeEspresso();
        } catch (CoffeeMachineExceptions coffeeMachineExceptions) {
            if (coffeeMachineExceptions instanceof NoCoffeeExceptions) {
                business.fillWithCoffee(22);
            }
            try {
                espresso = business.makeEspresso();
            } catch (CoffeeMachineExceptions coffeeMachineExceptions1) {
                if (coffeeMachineExceptions1 instanceof NoWaterExceptions) {
                    business.fillWithWater(30);
                }
                espresso = business.makeEspresso();
            }
        }
        Assert.assertNotNull(espresso);
    }

    @Test
    public void americanoNegativeTest() throws Exception {
        CoffeeMachine business = new BusinessCoffeeMachine();
        business.fillWithCoffee(15);
        business.fillWithWater(50);
        business.enable();
        Americano americano;
        try {
            americano = business.makeAmericano();
        } catch (CoffeeMachineExceptions coffeeMachineExceptions) {
            if (coffeeMachineExceptions instanceof NoCoffeeExceptions) {
                business.fillWithCoffee(22);
            }
            try {
                americano = business.makeAmericano();
            } catch (CoffeeMachineExceptions coffeeMachineExceptions1) {
                if (coffeeMachineExceptions1 instanceof NoWaterExceptions) {
                    business.fillWithWater(100);
                }
                americano = business.makeAmericano();
            }
        }
        Assert.assertNotNull(americano);
    }

    @Test (expected = NoCoffeeExceptions.class)
    public void espressoNegativeRealizedTest() throws Exception {
        CoffeeMachine business = new BusinessCoffeeMachine();
        business.fillWithCoffee(10000);
        business.fillWithWater(200000);
        business.enable();
        Espresso espresso = null;
        int i = 0;
        while (i < 100000) {
            try{
                espresso = business.makeEspresso();
            }catch (CoffeeMachineExceptions coffeeMachineExceptions){
                if (coffeeMachineExceptions instanceof NoTankCapacityExceptions){
                    business.cleanUp();
                }
            }
            espresso=business.makeEspresso();
            i++;
            }
        Assert.assertNull(espresso);
    }

    @Test (expected = NoCoffeeExceptions.class)
    public void americanoNegativeRealizedTest() throws Exception {
        CoffeeMachine business = new BusinessCoffeeMachine();
        business.fillWithCoffee(3500);
        business.fillWithWater(200000);
        business.enable();
        Americano americano = null;
        int i = 0;
        while (i < 100000) {
            try{
                americano = business.makeAmericano();
            }catch (CoffeeMachineExceptions coffeeMachineExceptions){
                if (coffeeMachineExceptions instanceof NoTankCapacityExceptions){
                    business.cleanUp();
                }
            }
            americano = business.makeAmericano();
            i++;
        }
        Assert.assertNull(americano);
    }
}