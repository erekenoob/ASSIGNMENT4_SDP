package subsystem;
import exception.SubsystemException;

public class CoffeeMachine {
    private int waterMl = 400;
    private int beansGrams = 50;

    public void powerOn() {
        System.out.println("Coffee Machine: Powering on, heating up boiler");
    }

    public void checkAndPrepare(int requiredWater, int requiredBeans) {
        if (waterMl < requiredWater || beansGrams < requiredBeans) {
            throw new SubsystemException("Not enough water or coffee beans in the machine");
        }
        System.out.println("Coffee Machine: Resource check passed");
    }

    public void brewBatch(int ml) {
        System.out.println("Coffee Machine: Brewing batch-brew coffee (" + ml + " ml)");
        waterMl -= ml;
    }

    public void powerOff() {
        System.out.println("Coffee Machine: Rinsing and shutting down");
    }
}