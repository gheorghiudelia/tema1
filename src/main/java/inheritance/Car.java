package inheritance;

public class Car extends Vehicle {
    private int doors;

    public Car(String brand, double speed, String id, int mileage, int doors)
    {
        super(brand, speed, id, mileage);
        this.doors = doors;
    }

    public int getDoors() { return doors; }
    public void setDoors(int doors) { this.doors = doors; }

    @Override
    public void move()
    {
        System.out.println("Car " + getBrand() + " is driving on the road at "
                + getSpeed() + " km/h");
    }

    @Override
    public boolean needsService()
    {
        return getMileage() > 0 && getMileage() % 10_000 == 0;
    }

    @Override
    public double rentalPrice(int days)
    {
        double price = 50 * days;
        if (doors >= 4) {
            price *= 1.10; // +10%
        }
        return price;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        if (!super.equals(o)) return false;
        Car car = (Car) o;
        return doors == car.doors;
    }

    @Override
    public int hashCode()
    {
        return super.hashCode() * 31 + doors;
    }
}
