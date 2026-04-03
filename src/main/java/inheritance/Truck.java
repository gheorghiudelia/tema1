package inheritance;

public class Truck extends Vehicle {
    private double loadCapacity; // in kg


    public Truck(String brand, double speed, String id, int mileage, double loadCapacity)
    {
        super(brand, speed, id, mileage);
        this.loadCapacity = loadCapacity;
    }

    public double getLoadCapacity()
    {
        return loadCapacity;
    }
    public void setLoadCapacity(double loadCapacity)
    {
        this.loadCapacity = loadCapacity;
    }

    @Override
    public void move()
    {
        System.out.println("Truck " + getBrand() + " is rolling heavily at "
                + getSpeed() + " km/h, carrying up to " + loadCapacity + " kg");
    }

    @Override
    public boolean needsService()
    {
        return getMileage() > 0 && getMileage() % 15_000 == 0;
    }

    @Override
    public double rentalPrice(int days)
    {
        // (80 + 0.02 * loadCapacity) * days
        return (80 + 0.02 * loadCapacity) * days;
    }
}
