package com.ktu;

import util.ArrayStack;
import util.Ks;
import util.LinkedListStack;

import java.util.Locale;

public class TestArrayStack {

    ArrayStack<Car> carArrayStack = new ArrayStack<>();

    void execute() {
        createArrayStackCarsTest();
    }

    void createArrayStackCarsTest() {
        println("ARRAY STACK TEST");

        Car c1 = new Car("Renault", "Laguna", 1997, 50000, 1700);
        Car c2 = new Car("Renault", "Megane", 2001, 20000, 3500);
        Car c3 = new Car("Toyota", "Corolla", 2001, 20000, 8500.8);
        Car c4 = new Car("Hyundai","Lantra",1998,9500,777);
        carArrayStack.push(c1);
        carArrayStack.push(c2);
        carArrayStack.push(c3);

        println(carArrayStack);

        println("Push method (Hyundai,Lantra,1998,9500,777)");
        carArrayStack.push(c4);
        println(carArrayStack);



        println("Pop method (Hyundai,Lantra,1998,9500,777)");
        carArrayStack.pop();
        println(carArrayStack);

        println("Peak method (Toyota,Corolla,2001,20000,8500,8)");
        carArrayStack.peak();
        printCar(carArrayStack.peak().toString());

        println("isEmpty method (a list has values)");
        if(carArrayStack.isEmpty()) {
            printCar("List is empty");
        }
        else {
            println(carArrayStack);
        }

        println("isEmpty method (a list has not values)");
        carArrayStack.pop();
        carArrayStack.pop();
        carArrayStack.pop();
        if (carArrayStack.isEmpty())
        {
            printCar("List is empty");
        }
        else{
            println(carArrayStack);
        }
    }

    public void println(ArrayStack<Car> list) {  // sąrašas spausdinamas į Ks.oun("");
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
        new TestArrayStack().execute();
    }
}
