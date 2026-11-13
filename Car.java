import java.awt.*;

public abstract class Car implements Movable {
    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    private double x;
    private double y;
    private String direction;

    protected Car(int nrDoors, double enginePower, Color color, String modelName) {
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

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public String getDirection() {
        return direction;
    }

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
        if (currentSpeed > enginePower) {
            currentSpeed = enginePower; // If you went over the limit, it snap backs to the limit
        }
    }

    private void decrementSpeed(double amount) {
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
        if (currentSpeed < 0)
        {
            currentSpeed = 0;
        }
    }

    public void gas(double amount) {
        if (amount >=0 && amount <=1)
        {
            incrementSpeed(amount);
        }

    }

    public void brake(double amount) {
        if (amount >=0 && amount <=1)
        {
            decrementSpeed(amount);
        }

    }

    @Override
    public void move() {
        if ("up".equals(direction)) {
            y += currentSpeed;
        } else if ("down".equals(direction)) {
            y -= currentSpeed;
        } else if ("left".equals(direction)) {
            x -= currentSpeed;
        } else if ("right".equals(direction)) {
            x += currentSpeed;
        }
    }

    @Override
    public void turnLeft() {
        if ("up".equals(direction)) {
            direction = "left";
        } else if ("down".equals(direction)) {
            direction = "right";
        } else if ("left".equals(direction)) {
            direction = "down";
        } else if ("right".equals(direction)) {
            direction = "up";
        }
    }

    @Override
    public void turnRight() {
        if ("up".equals(direction)) {
            direction = "right";
        } else if ("down".equals(direction)) {
            direction = "left";
        } else if ("left".equals(direction)) {
            direction = "up";
        } else if ("right".equals(direction)) {
            direction = "down";
        }
    }


}
