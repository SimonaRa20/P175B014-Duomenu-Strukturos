package com.ktu;

import util.Ks;
import util.LinkedListStack;

import java.util.Locale;

public class TestLinkedListStack {

    LinkedListStack<Car> linkedListCar = new LinkedListStack<Car>();

    void execute() {
        createArrayStackCarsTest();
    }

    void createArrayStackCarsTest() {
        println("LINKED LIST STACK TEST");

        Car c1 = new Car("Renault", "Laguna", 1997, 50000, 1700);
        Car c2 = new Car("Renault", "Megane", 2001, 20000, 3500);
        Car c3 = new Car("Toyota", "Corolla", 2001, 20000, 8500.8);
        Car c4 = new Car("Hyundai","Lantra",1998,9500,777);
        linkedListCar.push(c1);
        linkedListCar.push(c2);
        linkedListCar.push(c3);

        println(linkedListCar);

        println("Push method (Hyundai,Lantra,1998,9500,777)");
        linkedListCar.push(c4);
        println(linkedListCar);

        println("Pop method (Hyundai,Lantra,1998,9500,777)");
        linkedListCar.pop();
        println(linkedListCar);

        println("Peak method (Toyota,Corolla,2001,20000,8500,8)");
        //linkedListCar.peak();
        printCar(linkedListCar.peak().toString());

//        linkedListCar.forEach(System.out::println);
        println("isEmpty method (a list has values)");
        if(linkedListCar.isEmpty()) {
            printCar("List is empty");
        }
        else {
            println(linkedListCar);
        }

        println("isEmpty method (a list has not values)");
        linkedListCar.pop();
        linkedListCar.pop();
        linkedListCar.pop();
        if (linkedListCar.isEmpty())
        {
            printCar("List is empty");
        }
        else{
            println(linkedListCar);
        }
    }

    public void println(LinkedListStack<Car> list) {  // sąrašas spausdinamas į Ks.oun("");
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
        new TestLinkedListStack().execute();
    }
}
