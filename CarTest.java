import java.awt.*;
public class CarTest {
    private static void reportResult(String testName, boolean success) {
        IO.println((success ? "SUCCESS: " : "FAILURE: ") + testName);
    }

    /** Tests whether a Saab95 with turbo enabled
     *  gains more speed than one without.
     */
    private static void testTurbo() {
        Saab95 slowSaab = new Saab95();
        Saab95 fastSaab = new Saab95();
        fastSaab.setTurboOn();
        slowSaab.setTurboOff();
        fastSaab.gas(0.5);
        slowSaab.gas(0.5);
        boolean result = slowSaab.getCurrentSpeed() < fastSaab.getCurrentSpeed();
        reportResult("Turbo yields more speed", result);
    }
    private static void testVolvoDoors()
    {
        Volvo240 volvo240 = new Volvo240();
        boolean result = volvo240.getNrDoors() == 4;
        reportResult("Volvo240 has 4 doors", result);
    }
    private static void testSaabdoors()
    {
        Saab95 saab = new Saab95();
        boolean result = saab.getNrDoors() == 2;
        reportResult("Saabdoors has 2 doors", result);
    }
    private static void testVolvoColour()
    {
        Volvo240 volvo240 = new Volvo240();
        boolean result = volvo240.getColor() == Color.black;
        reportResult("Volvo240 has black color", result);
    }
    private static void testEnginePower()
    {
        Volvo240 volvo240 = new Volvo240();
        boolean result = volvo240.getEnginePower() == 100;
        reportResult("Volvo240 has 100 enginePower", result);
    }
    static void main() {
        testTurbo();
        testVolvoDoors();
        testSaabdoors();
        testVolvoColour();
        testEnginePower();
    }
}

