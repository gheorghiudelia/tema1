package inheritance;

public class Garage {
    private Vehicle[] fleet;
    private int size;

    public Garage(int capacity) {
        this.fleet = new Vehicle[capacity];
        this.size = 0;
    }

    public boolean add(Vehicle v)
    {
        if (size >= fleet.length)
        {
            System.out.println("Cannot add " + v.getId() + ": garage is full.");
            return false;
        }
        if (findById(v.getId()) != null) {
            System.out.println("Cannot add " + v.getId() + ": duplicate id.");
            return false;
        }
        fleet[size++] = v;
        return true;
    }
    public Vehicle findById(String id) {
        for (int i = 0; i < size; i++) {
            if (fleet[i].getId().equals(id)) {
                return fleet[i];
            }
        }
        return null;
    }

    public void rentById(String id)
    {
        Vehicle v = findById(id);
        if (v == null) {
            System.out.println("No vehicle with id " + id);
            return;
        }
        v.rent();
    }

    public void returnById(String id, int drivenKm)
    {
        Vehicle v = findById(id);
        if (v == null) {
            System.out.println("No vehicle with id " + id);
            return;
        }
        v.returnVehicle(drivenKm);
    }

    public void printAvailable() {
        System.out.println("---- Available vehicles ----");
        boolean any = false;
        for (int i = 0; i < size; i++) {
            if (!fleet[i].isRented()) {
                System.out.println(fleet[i]);
                any = true;
            }
        }
        if (!any) System.out.println("(none)");
    }

    public void printNeedsService() {
        System.out.println("---- Vehicles needing service ----");
        boolean any = false;
        for (int i = 0; i < size; i++) {
            if (fleet[i].needsService()) {
                System.out.println(fleet[i]);
                any = true;
            }
        }
        if (!any) System.out.println("(none)");
    }
    public void printRentalEstimate(String id, int days) {
        Vehicle v = findById(id);
        if (v == null) {
            System.out.println("No vehicle with id " + id);
            return;
        }
        double estimate = v.rentalPrice(days);
        System.out.println("Rental estimate for " + id + " (" + v.getBrand()
                + ") over " + days + " days: " + estimate + " EUR");
    }
    public int getSize() { return size; }
    public int getCapacity() { return fleet.length; }
}
