package Day2CoreJava;

// Component classes
class Processor {
    private String model;
    private double clockSpeed;

    public Processor(String model, double clockSpeed) {
        this.model = model;
        this.clockSpeed = clockSpeed;
    }

    public void processTasks() {
        System.out.println("Processor " + model + " processing tasks at " + clockSpeed + " GHz");
    }
}

class Battery {
    private int capacitymAh;

    public Battery(int capacitymAh) {
        this.capacitymAh = capacitymAh;
    }

    public void supplyPower() {
        System.out.println("Supplying power from " + capacitymAh + "mAh battery");
    }

    public void chargeBattery() {
        System.out.println("Charging the battery...");
    }
}

class Camera {
    private int resolutionMP;

    public Camera(int resolutionMP) {
        this.resolutionMP = resolutionMP;
    }

    public void takePhoto() {
        System.out.println("Taking photo with " + resolutionMP + "MP camera");
    }

    public void recordVideo() {
        System.out.println("Recording video with " + resolutionMP + "MP camera");
    }
}

class Screen {
    private String type;
    private int sizeInches;

    public Screen(String type, int sizeInches) {
        this.type = type;
        this.sizeInches = sizeInches;
    }

    public void displayContent() {
        System.out.println("Displaying content on " + sizeInches + "-inch " + type + " screen");
    }
}

// Main class using composition
class Smartphone {
    private Processor processor;
    private Battery battery;
    private Camera camera;
    private Screen screen;

    public Smartphone(Processor processor, Battery battery, Camera camera, Screen screen) {
        this.processor = processor;
        this.battery = battery;
        this.camera = camera;
        this.screen = screen;
    }

    public void powerOn() {
        System.out.println("Powering on the smartphone...");
        battery.supplyPower();
        processor.processTasks();
        screen.displayContent();
        System.out.println("Smartphone is now ON.");
    }

    public void takePhoto() {
        System.out.println("Opening the camera app...");
        camera.takePhoto();
    }

    public void powerOff() {
        System.out.println("Powering off the smartphone...");
        battery.chargeBattery();  // Charge before shutting down
        System.out.println("Smartphone is now OFF.");
    }

    // Getter methods for components
    public Processor getProcessor() { return processor; }
    public Battery getBattery() { return battery; }
    public Camera getCamera() { return camera; }
    public Screen getScreen() { return screen; }
}

// Example usage
public class CompositeClass {
    public static void main(String[] args) {
        Processor processor = new Processor("Snapdragon 888", 2.84);
        Battery battery = new Battery(4500);
        Camera camera = new Camera(108);
        Screen screen = new Screen("AMOLED", 6);

        Smartphone myPhone = new Smartphone(processor, battery, camera, screen);

        myPhone.powerOn();
        System.out.println("\nTaking a picture...");
        myPhone.takePhoto();
        System.out.println();
        myPhone.powerOff();
    }
}
