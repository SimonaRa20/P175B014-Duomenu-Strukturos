package com.ktu;

import util.Ks;
import util.LinkedListQueue;


import java.util.Locale;

public class TestLinkedListQueue {
    LinkedListQueue<Car> linkedListCar = new LinkedListQueue<>();

    void execute() {
        createArrayStackCarsTest();
    }

    void createArrayStackCarsTest() {
        println("LINKED LIST QUEUE TEST");

        Car c1 = new Car("Renault", "Laguna", 1997, 50000, 1700);
        Car c2 = new Car("Renault", "Megane", 2001, 20000, 3500);
        Car c3 = new Car("Toyota", "Corolla", 2001, 20000, 8500.8);
        Car c4 = new Car("Hyundai","Lantra",1998,9500,777);
        linkedListCar.enqueue(c1);
        linkedListCar.enqueue(c2);
        linkedListCar.enqueue(c3);

        println(linkedListCar);

        println("Enqueue method (Hyundai,Lantra,1998,9500,777)");
        linkedListCar.enqueue(c4);
        println(linkedListCar);

        println("Dequeue method (Renault,Laguna,1997,50000,1700)");
        linkedListCar.dequeue();
        println(linkedListCar);

        println("Peak method (Renault,Megane,2001,20000,3500)");

        printCar(linkedListCar.peak().toString());


        println("isEmpty method (a list has values)");
        if(linkedListCar.isEmpty()) {
            printCar("List is empty");
        }
        else {
            println(linkedListCar);
        }

        println("isEmpty method (a list has not values)");
        linkedListCar.dequeue();
        linkedListCar.dequeue();
        linkedListCar.dequeue();
        if (linkedListCar.isEmpty())
        {
            printCar("List is empty");
        }
        else{
            println(linkedListCar);
        }
    }

    public void println(LinkedListQueue<Car> list) {  // sąrašas spausdinamas į Ks.oun("");
        int eilNr = 1;
        if (list.isEmpty()) {
            Ks.oun("Sąrašas yra tuščias");
        }
        else {
            for (list.begin(); list.exist(); list.next()) {
                String printData = String.format("%3d: %s ", eilNr++, list.get().toString());
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
        new TestLinkedListQueue().execute();
    }
}
