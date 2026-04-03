package inheritance;

public class Motorcycle extends Vehicle {
    private boolean hasSidecar;


    public Motorcycle(String brand, double speed, String id, int mileage, boolean hasSidecar)
    {
        super(brand, speed, id, mileage);
        this.hasSidecar = hasSidecar;
    }

    public boolean isHasSidecar()
    {
        return hasSidecar;
    }
    public void setHasSidecar(boolean hasSidecar)
    {
        this.hasSidecar = hasSidecar;
    }

    @Override
    public void move()
    {
        System.out.println("Motorcycle " + getBrand() + " is zooming at " + getSpeed() + " km/h");
    }

    @Override
    public boolean needsService()
    {
        return getMileage() > 0 && getMileage() % 6_000 == 0;
    }

    @Override
    public double rentalPrice(int days)
    {
        double price = 30 * days;
        if (hasSidecar) {
            price += 15 * days; // +15/day
        }
        return price;
    }
}
