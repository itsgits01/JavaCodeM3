package Day2CoreJava;

class Car {
    private String make;
    private String model;
    private int year;
    private String regNumber;
    private boolean isElectric;

    // Parameterized constructor with all attributes
    public Car(String make, String model, int year, String regNumber, boolean isElectric) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.regNumber = regNumber;
        this.isElectric = isElectric;
    }

    // Parameterized constructor with essential attributes
    public Car(String make, String model, int year) {
        this(make, model, year, "Unknown", false); // Calls full constructor with default values
    }

    // Parameterized constructor for an electric car without known VIN
    public Car(String make, String model, boolean isElectric) {
        this(make, model, 2024, "Unknown", isElectric); // Assumes current year
    }

    // Copy constructor
    public Car(Car otherCar) {
        this(otherCar.make, otherCar.model, otherCar.year, otherCar.regNumber, otherCar.isElectric);
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", regNumber='" + regNumber + '\'' +
                ", isElectric=" + isElectric +
                '}';
    }
}

class MobilePhone {
    private String brand;
    private String model;
    private int storageGB;
    private double price;
    private String operatingSystem;

    // Parameterized constructor for creating a new phone
    public MobilePhone(String brand, String model, int storageGB, double price, String operatingSystem) {
        this.brand = brand;
        this.model = model;
        this.storageGB = storageGB;
        this.price = price;
        this.operatingSystem = operatingSystem;
    }

    // Parameterized constructor for basic phone information
    public MobilePhone(String brand, String model, int storageGB) {
        this(brand, model, storageGB, 0.0, "Unknown"); // Default price and operating system
    }

    // Copy constructor
    public MobilePhone(MobilePhone otherPhone) {
        this(otherPhone.brand, otherPhone.model, otherPhone.storageGB, otherPhone.price, otherPhone.operatingSystem);
    }

    @Override
    public String toString() {
        return "MobilePhone{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", storageGB=" + storageGB +
                ", price=" + price +
                ", operatingSystem='" + operatingSystem + '\'' +
                '}';
    }
}

public class ParaConstructor {
    public static void main(String[] args) {
        // Car examples
        Car car1 = new Car("Mercedes", "xyx", 2022, "DL122301", true);
        Car car2 = new Car("BMW", "Camry", 2021);
        Car car3 = new Car("Lamborgini", "Leaf", true);
        Car car4 = new Car(car1); // Using copy constructor

        System.out.println("Car Examples:");
        System.out.println(car1);
        System.out.println(car2);
        System.out.println(car3);
        System.out.println(car4);

        // MobilePhone examples
        MobilePhone phone1 = new MobilePhone("Apple", "iPhone 13", 256, 111999, "iOS");
        MobilePhone phone2 = new MobilePhone("Samsung", "Galaxy S21", 128);
        MobilePhone phone3 = new MobilePhone(phone1); // Using copy constructor

        System.out.println("\nMobile Phone Examples:");
        System.out.println(phone1);
        System.out.println(phone2);
        System.out.println(phone3);
    }
}

