package inheritance;

import java.util.Objects;

public abstract class Vehicle {
    private String brand;
    private double speed;
    private String id;
    private int mileage;
    private boolean rented;

    public Vehicle(String brand, double speed, String id, int mileage)
    {
        this.brand = brand;
        this.speed = speed;
        this.id = id;
        this.mileage = mileage;
        this.rented = false;
    }

    public String getBrand()
    {
        return brand;
    }
    public void setBrand(String brand)
    {
        this.brand = brand;
    }

    public double getSpeed()
    {
        return speed;
    }
    public void setSpeed(double speed)
    {
        this.speed = speed;
    }

    public String getId()
    {
        return id;
    }
    public void setId(String id)
    {
        this.id = id;
    }

    public int getMileage()
    {
        return mileage;
    }
    public void setMileage(int mileage)
    {
        this.mileage = mileage;
    }

    public boolean isRented()
    {
        return rented;
    }
    public void setRented(boolean rented)
    {
        this.rented = rented;
    }
    public void move()
    {
        System.out.println(brand+ "is moving at " +speed + "km/h");
    }
    public void rent()
    {
        if (rented) {
            throw new IllegalStateException("Vehicle" + id + "is already rented.");
        }
        rented = true;
        System.out.println("Vehicle " + id + "(" + brand + ") has been rented.");
    }
    public void returnVehicle(int drivenKm)
    {
        if (!rented) {
            throw new IllegalStateException("Vehicle " + id + " is not currently rented.");
        }
        if (drivenKm <= 0) {
            throw new IllegalArgumentException("drivenKm must be > 0, got: " + drivenKm);
        }
        mileage += drivenKm;
        rented = false;
        System.out.println("Vehicle " + id + " returned. Driven: " + drivenKm + " km. Total mileage: " + mileage + " km.");
    }

    public abstract boolean needsService();
    public abstract double rentalPrice(int days);

    @Override
    public boolean equals(Object o) {
        if (this== o) return true;
        if (!(o instanceof Vehicle)) return false;
        Vehicle other =(Vehicle) o;
        return Double.compare(other.speed, speed) == 0
                && Objects.equals(brand, other.brand)
                && Objects.equals(id, other.id);
    }
    @Override
    public int hashCode()
    {
        return Objects.hash(brand, speed, id);
    }

    @Override
    public String toString()
    {
        return getClass().getSimpleName() + "{id='" + id + "', brand='" + brand + "', speed=" + speed + ", mileage=" + mileage + ", rented=" + rented + "}";
    }
}
