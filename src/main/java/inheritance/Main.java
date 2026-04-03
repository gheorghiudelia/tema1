package inheritance;

public class Main {
    public static void main(String[] args)
    {
        Vehicle[] vehicles = new Vehicle[3];
        vehicles[0] = new Car("Dacia", 180, "C1", 9_500, 4);
        vehicles[1] = new Motorcycle("Yamaha", 220, "M1", 5_800, false);
        vehicles[2] = new Truck("Volvo", 130, "T1", 14_900, 8_000);
        for (Vehicle v : vehicles)
        {
            v.move();
        }
        System.out.println("\n===== Step 4: equals() on Cars =====");
        Car car1 = new Car("BMW", 200, "C100", 5000, 4);
        Car car2 = new Car("BMW", 200, "C100", 9999, 4);
        Car car3 = new Car("Audi", 200, "C200", 5000, 2);
        System.out.println("car1.equals(car2) ? " + car1.equals(car2)); // true
        System.out.println("car1.equals(car3) ? " + car1.equals(car3)); // false
        System.out.println("\n===== Step 8: Garage demo =====");
        Garage garage = new Garage(10);
        garage.add(new Car("Dacia",180, "C1",9_500, 4));
        garage.add(new Car("Ford",190, "C2",10_000,2));
        garage.add(new Motorcycle("Yamaha",220,"M1",6_000, false));
        garage.add(new Motorcycle("Honda",210,"M2",3_000, true));
        garage.add(new Truck("Volvo",130,"T1",15_000,8_000));
        garage.add(new Truck("MAN",120,"T2",5_000, 12_000));
        // try to add a duplicate id -> should fail
        garage.add(new Car("Fake",100, "C1", 0, 4));
        System.out.println();
        garage.printAvailable();
        System.out.println();
        garage.printNeedsService();
        System.out.println("\n-- Renting 2 vehicles --");
        garage.rentById("C1");
        garage.rentById("M2");
        System.out.println("\n-- Try to rent C1 again (should throw) --");
        try {
            garage.rentById("C1");
        } catch (IllegalStateException e) {
            System.out.println("Caught: " + e.getMessage());
        }
        System.out.println("\n-- Returning M2 after 350 km --");
        garage.returnById("M2", 350);
        System.out.println("\n-- Try to return T2 (not rented, should throw) --");
        try {
            garage.returnById("T2", 100);
        } catch (IllegalStateException e) {
            System.out.println("Caught: " + e.getMessage());
        }
        System.out.println("\n-- Rental estimates --");
        garage.printRentalEstimate("C2", 5);
        garage.printRentalEstimate("M2", 3);
        garage.printRentalEstimate("T1", 4);
        System.out.println();
        garage.printAvailable();
    }
}
