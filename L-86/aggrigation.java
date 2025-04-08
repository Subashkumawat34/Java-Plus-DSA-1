
public class aggrigation {

    public static void main(String[] args) {
        MyCar c = new MyCar();
        Driver d = new Driver(c);
        d.print();
        c.Drive();
        c.Drop();

    }
}

class MyCar {

    public void Drive() {
        System.out.println("You can drive the car");
    }

    protected void Drop() {
        System.out.println("Dropped is.... ");
    }
}

class Driver {
    //Has a relationship --> association 

    MyCar object;

    Driver(MyCar object) {
        this.object = object;
    }

    void print() {
        object.Drive();
        object.Drop();
    }
}
