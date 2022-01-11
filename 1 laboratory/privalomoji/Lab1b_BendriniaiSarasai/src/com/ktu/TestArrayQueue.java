package com.ktu;
import util.ArrayQueue;
import util.Ks;
import java.util.Locale;

public class TestArrayQueue {

    ArrayQueue<Car> carArrayQueue = new ArrayQueue<>();

    void execute() {
        createArrayStackCarsTest();
    }

    void createArrayStackCarsTest() {
        println("ARRAY QUEUE TEST");

        Car c1 = new Car("Renault", "Laguna", 1997, 50000, 1700);
        Car c2 = new Car("Renault", "Megane", 2001, 20000, 3500);
        Car c3 = new Car("Toyota", "Corolla", 2001, 20000, 8500.8);
        Car c4 = new Car("Hyundai","Lantra",1998,9500,777);
        carArrayQueue.enqueue(c1);
        carArrayQueue.enqueue(c2);
        carArrayQueue.enqueue(c3);

        println(carArrayQueue);

        println("Enqueue method (Hyundai,Lantra,1998,9500,777)");
        carArrayQueue.enqueue(c4);
        println(carArrayQueue);

        println("Dequeue method (Renault,Laguna,1997,50000,1700)");
        carArrayQueue.dequeue();
        println(carArrayQueue);

        println("Peak method (Renault,Megane,2001,20000,3500)");
        carArrayQueue.peak();
        printCar(carArrayQueue.peak().toString());

        println("isEmpty method (a list has values)");
        if(carArrayQueue.isEmpty()) {
            printCar("List is empty");
        }
        else {
            println(carArrayQueue);
        }

        println("isEmpty method (a list has not values)");
        carArrayQueue.dequeue();
        carArrayQueue.dequeue();
        carArrayQueue.dequeue();
        if (carArrayQueue.isEmpty())
        {
            printCar("List is empty");
        }
        else{
            println(carArrayQueue);
        }
    }

    public void println(ArrayQueue<Car> list) {  // sąrašas spausdinamas į Ks.oun("");
        int eilNr = 1;
        if (list.isEmpty()) {
            Ks.oun("Sąrašas yra tuščias");
        }
        else {
            for (int i = 0; i < list.count(); i++) {
                String printData = String.format("%3d: %s ", eilNr++, list.get(i).toString());
                Ks.oun(printData);
            }
        }
    }

    public void println(String title) { // spausdinant galima nurodyti antraštę
        Ks.oun("========" + title + "=======");
    }

    public void printCar(String car){
        Ks.oun(car);
    }

    public static void main(String... args) {
        // suvienodiname skaičių formatus pagal LT lokalę (10-ainis kablelis)
        Locale.setDefault(new Locale("LT"));
        new TestArrayQueue().execute();
    }
}
