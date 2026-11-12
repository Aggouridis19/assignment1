import java.awt.*;

public abstract class Car {
    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    private double x;
    private double y;
    private String direction;

    protected Car (int nrDoors, double enginePower, Color color, String modelName) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        this.x = 0;
        this.y = 0;
        this.direction = "up";
        stopEngine();
    }

    public int getNrDoors() {
            return nrDoors;
        }
    public double getEnginePower() {
            return enginePower;
        }

    public double getCurrentSpeed() {
            return currentSpeed;
        }

    public Color getColor() {
            return color;
        }

    public double getX() {return x;}

    public double getY() {return y;}

    public String getDirection() {return direction;}

    public void setColor(Color clr) {
            color = clr;
        }

    public void startEngine() {
            currentSpeed = 0.1;
        }

    public void stopEngine() {
            currentSpeed = 0;
        }

    protected abstract double speedFactor();

    private void incrementSpeed(double amount) {
            currentSpeed = getCurrentSpeed() + speedFactor() * amount;
        }

    private void decrementSpeed(double amount) {
            currentSpeed = getCurrentSpeed() - speedFactor() * amount;
        }

    // TODO fix this method according to assignment instructions
    public void gas(double amount) {
            incrementSpeed(amount);
        }

    // TODO fix this method according to assignment instructions
    public void brake(double amount) {
            decrementSpeed(amount);
        }
}