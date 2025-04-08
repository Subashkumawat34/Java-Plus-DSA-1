
import java.awt.Color;

class Car {

    String brand;
    String color;
    String model;
    boolean isABSPresent;
    int speed;

    Car(String brand, String color, String model, boolean isABS, int speed) {
        System.out.println("Parameterised constructor is called");
        this.brand = brand;
        this.color = color;
        this.model = model;
        isABSPresent = isABS;
        this.speed = speed;
    }

    Car() {
        System.out.println("Default contructor is called");
        this.brand = "Scorpio";
        this.color = "white";
        this.model = "2026";
        isABSPresent = true;
        this.speed = 150;
    }

    Car(Car newCar) {
        System.out.println("copy constructor is called: ");
        this.brand = newCar.brand;
        this.color = newCar.color;
        this.model = newCar.model;
        isABSPresent = newCar.isABSPresent;
        this.speed = newCar.speed;
    }

    public void drive() {
        System.out.println("Driving");
    }

    public void speedUp(int newSpeed) {
        speed = newSpeed;
        System.out.println("speed up:");
    }

}

public class oops {

    public static void main(String[] args) {

        //parameterised constructor is called
        Car object1 = new Car("Scorpio", "white", "2026", true, 230);
        System.out.println("Speed is: " + object1.speed);

        Car object2 = new Car(); //default constructor is called
        System.out.println("Speed is: " + object2.speed);

        Car object3 = new Car(object1);// copy constructor is called
        System.out.println("Speed is: " + object3.speed);
        //Deep copy----> copy the values only
        object1.speed = 500;
        System.out.println("Speed is: " + object2.speed);
        System.out.println("Speed is: " + object3.speed);

        //pointing same references in memory
        //shalow copy---> copy the reference 
        Car object4 = object1;
        System.out.println("Speed is object4: " + object4.speed);
        System.out.println("Speed is object1 : " + object1.speed);
        object4.speed = 1000;
        System.out.println("Speed is object4: " + object4.speed);
        System.out.println("Speed is object1 : " + object1.speed);
    }
}
