package edu.ktu.ds.lab2.demo;

import edu.ktu.ds.lab2.utils.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Locale;

/*
 * Aibės testavimas be Gui
 * Dirbant su Intellij ir norint konsoleje matyti gražų pasuktą medį,
 * reikia FIle -> Settings -> Editor -> File Encodings -> Global encoding pakeisti į UTF-8
 *
 */
public class ManualTest {
    static AvlSet<Car> list = new AvlSet<Car>();

    public static void main(String[] args) throws CloneNotSupportedException {
        Locale.setDefault(Locale.US); // Suvienodiname skaičių formatus
        executeTest();
    }

    public static void executeTest() throws CloneNotSupportedException {

        // AVL medžio testavimas

        Car c1 = new Car("Renault", "Laguna", 2007, 50000, 1700);
        Car c2 = new Car.Builder()
                .make("Renault")
                .model("Megane")
                .year(2011)
                .mileage(20000)
                .price(3500)
                .build();
        Car c3 = new Car.Builder().buildRandom();
        Car c4 = new Car("Renault Laguna 2011 115900 700");
        Car c5 = new Car("Renault Megane 1946 365100 9500");
        Car c6 = new Car("Honda   Civic  2011  36400 80.3");
        Car c7 = new Car("Renault Laguna 2011 115900 7500");
        Car c8 = new Car("Renault Megane 1946 365100 950");
        Car c9 = new Car("Honda   Civic  2017  36400 850.3");
        Car c10 = new Car("Renault Laguna 2012 115900 700");
        Car c11 = new Car("Renault Megane 1943 365100 9500");
        Car c12 = new Car("Honda   Civic  2014  36400 80.3");
        Car c13 = new Car("Renault Laguna 2015 115900 7500");
        Car c14 = new Car("Renault Megane 1947 365100 950");
        Car c15 = new Car("Honda   Civic  2018  36400 850.3");
        Car c16 = new Car("Renault Laguna 2019 115900 7500");
        Car c17 = new Car("Renault Megane 1940 365100 950");
        Car c18 = new Car("Honda   Civic  2019  36400 850.3");

        list.add(c9);
        list.add(c7);
        list.add(c8);
        list.add(c16);
        list.add(c17);
        list.add(c18);
        list.add(c11);
        list.add(c5);
        list.add(c1);
        list.add(c6);
        list.add(c2);
        list.add(c10);
        list.add(c3);
        list.add(c4);
        list.add(c15);
        list.add(c12);
        list.add(c13);
        list.add(c14);

        Ks.oun("Automobilių aibė AVL-medyje:");

        Ks.ounn(list.toVisualizedString(""));

//        list.remove(c1);
//        Ks.oun("Po c1 pašalinimo (TA100)");
//        Ks.ounn(list.toVisualizedString(""));

//        list.remove(c15);
//        list.remove(c11);
//        list.remove(c10);
//        list.remove(c9);
//        Ks.oun("Po c15,c11,c10,c9 pašalinimo (TA114,TA110, TA109, TA108)");
//        Ks.ounn(list.toVisualizedString(""));


//        list.remove(c11);
//        list.remove(c13);
//        list.remove(c15);
//        list.remove(c14);
//        Ks.oun("Po c11,c13,c15,c14 pašalinimo (TA110,TA112, TA114, TA113)");
//        Ks.ounn(list.toVisualizedString(""));

        list.remove(c13);
        list.remove(c15);
        list.remove(c16);
        Ks.oun("Po c6 pašalinimo (TA105)");
        Ks.ounn(list.toVisualizedString(""));
    }
//
//    static Car[] cars;
//    static ParsableSortedSet<Car> cSeries = new ParsableBstSet<>(Car::new, Car.byPrice);
//
//    public static void main(String[] args) throws CloneNotSupportedException {
//        Locale.setDefault(Locale.US); // Suvienodiname skaičių formatus
//        executeTest();
//    }
//
//    public static void executeTest() throws CloneNotSupportedException {
//        Car c1 = new Car("Renault", "Laguna", 2007, 50000, 1700);
//        Car c2 = new Car.Builder()
//                .make("Renault")
//                .model("Megane")
//                .year(2011)
//                .mileage(20000)
//                .price(3500)
//                .build();
//        Car c3 = new Car.Builder().buildRandom();
//        Car c4 = new Car("Renault Laguna 2011 115900 700");
//        Car c5 = new Car("Renault Megane 2000 365100 9500");
//        Car c6 = new Car("Honda   Civic  2011  36400 80.3");
//        Car c7 = new Car("Renault Laguna 2011 115900 7500");
//        Car c8 = new Car("Renault Megane 2001 365100 950");
//        Car c9 = new Car("Honda   Civic  2017  36400 850.3");
//
//        Car[] carsArray = {c9, c7, c8, c5, c1, c6};
//
//        Ks.oun("Auto Aibė:");
//        ParsableSortedSet<Car> carsSet = new ParsableBstSet<>(Car::new);
//
//        for (Car c : carsArray) {
//            carsSet.add(c);
//            Ks.oun("Aibė papildoma: " + c + ". Jos dydis: " + carsSet.size());
//        }
//        Ks.oun("");
//        Ks.ounn(carsSet.toVisualizedString(""));
//
//        ParsableSortedSet<Car> carsSetCopy = (ParsableSortedSet<Car>) carsSet.clone();
//
//        carsSetCopy.add(c2);
//        carsSetCopy.add(c3);
//        carsSetCopy.add(c4);
//        Ks.oun("Papildyta autoaibės kopija:");
//        Ks.ounn(carsSetCopy.toVisualizedString(""));
//
//        c9.setMileage(10000);
//
//        Ks.oun("Originalas:");
//        Ks.ounn(carsSet.toVisualizedString(""));
//
//        Ks.oun("Ar elementai egzistuoja aibėje?");
//        for (Car c : carsArray) {
//            Ks.oun(c + ": " + carsSet.contains(c));
//        }
//        Ks.oun(c2 + ": " + carsSet.contains(c2));
//        Ks.oun(c3 + ": " + carsSet.contains(c3));
//        Ks.oun(c4 + ": " + carsSet.contains(c4));
//        Ks.oun("");
//
//        Ks.oun("Ar elementai egzistuoja aibės kopijoje?");
//        for (Car c : carsArray) {
//            Ks.oun(c + ": " + carsSetCopy.contains(c));
//        }
//        Ks.oun(c2 + ": " + carsSetCopy.contains(c2));
//        Ks.oun(c3 + ": " + carsSetCopy.contains(c3));
//        Ks.oun(c4 + ": " + carsSetCopy.contains(c4));
//        Ks.oun("");
//
//        Ks.oun("Automobilių aibė su iteratoriumi:");
//        Ks.oun("");
//        for (Car c : carsSet) {
//            Ks.oun(c);
//        }
//        Ks.oun("");
//        Ks.oun("Automobilių aibė AVL-medyje:");
//        ParsableSortedSet<Car> carsSetAvl = new ParsableAvlSet<>(Car::new);
//        for (Car c : carsArray) {
//            carsSetAvl.add(c);
//        }
//        Ks.ounn(carsSetAvl.toVisualizedString(""));
//
//        Ks.oun("Automobilių aibė su iteratoriumi:");
//        Ks.oun("");
//        for (Car c : carsSetAvl) {
//            Ks.oun(c);
//        }
//
//        Ks.oun("");
//        Ks.oun("Automobilių aibė su atvirkštiniu iteratoriumi:");
//        Ks.oun("");
//        Iterator<Car> iter = carsSetAvl.descendingIterator();
//        while (iter.hasNext()) {
//            Ks.oun(iter.next());
//        }
//
//        Ks.oun("");
//        Ks.oun("Automobilių aibės toString() metodas:");
//        Ks.ounn(carsSetAvl);
//
//        // Išvalome ir suformuojame aibes skaitydami iš failo
//        carsSet.clear();
//        carsSetAvl.clear();
//
//        Ks.oun("");
//        Ks.oun("Automobilių aibė DP-medyje:");
//        carsSet.load("data\\ban.txt");
//        Ks.ounn(carsSet.toVisualizedString(""));
//        Ks.oun("Išsiaiškinkite, kodėl medis augo tik į vieną pusę.");
//        Ks.oun("Nes automobiliai prieš pridėjimą yra surikiuoti, taigi DP-medis išsigimsta į tiesinį dinamiškąjį sąrašą");
//
//        Ks.oun("");
//        Ks.oun("Automobilių aibė AVL-medyje:");
//        carsSetAvl.load("data\\ban.txt");
//        Ks.ounn(carsSetAvl.toVisualizedString(""));
//
//        Set<String> carsSet4 = CarMarket.duplicateCarMakes(carsArray);
//        Ks.oun("Pasikartojančios automobilių markės:\n" + carsSet4);
//
//        Set<String> carsSet5 = CarMarket.uniqueCarModels(carsArray);
//        Ks.oun("Unikalūs automobilių modeliai:\n" + carsSet5);
//
//
//        // realizuotų metodų testavimas
//
//        // BstSet klasės
//
//        BstSet<Car> bstSetList = new BstSet<>();
//        bstSetList.add(c1);
//        bstSetList.add(c2);
//        bstSetList.add(c3);
//        Ks.oun("I nauja lista idedami trys elementai");
//        Ks.ounn(bstSetList.toVisualizedString(""));
//
//        bstSetList.remove(c1);
//        Ks.oun("Is listo pasalinamas pirmasis elementas TA100");
//        Ks.ounn(bstSetList.toVisualizedString(""));
//
//
//
//        Car[] newCarlist = {c3,c4,c5,c6};
//        Set<Car>list = new BstSet<>();
//        for(Car car:newCarlist)
//            list.add(car);
//        bstSetList.addAll(list);
//        Ks.oun("Atliekamas addAll metodas (pridedami keturi elementai)");
//        Ks.ounn(bstSetList.toVisualizedString(""));
//
//        if(bstSetList.containsAll(list) == true)
//            Ks.oun("Aibeje egzistuoja visi nurodyti elementai is aibes");
//        else
//            Ks.oun("Aibeje neegzistuoja visi nurodyti elementai is aibes");
//
//        Ks.oun("Aibe pries patikrinima");
//        Ks.ounn(bstSetList.toVisualizedString(""));
//        bstSetList.retainAll(list);
//        Ks.oun("Aibe po patikrinimo (atliktas retainAll(Set<E>set) metodas)");
//        Ks.ounn(bstSetList.toVisualizedString(""));
//
//        Ks.oun("headSet(E e) metodas. Grazinama aibe iki c5, tai yra atspausdinimas c3, c4");
//
//        SortedSet<Car> testHeadSet = bstSetList.headSet(c5);
//        Ks.ounn(testHeadSet.toVisualizedString(""));
//
//        Ks.oun("tailSet(E e) metodas. Grazinama aibe iki c4, tai yra atspausdinimas c4, c5, c6");
//
//        SortedSet<Car> testTailSet = bstSetList.tailSet(c4);
//        Ks.ounn(testTailSet.toVisualizedString(""));
//
//        Ks.oun("subSet(E element1, E element2) metodas. Grazinama aibe nuo c4 iki c6, tai yra atspausdinimas c4, c5");
//
//        SortedSet<Car> testSubSet = bstSetList.subSet(c4, c6);
//        Ks.ounn(testSubSet.toVisualizedString(""));
//
//
//        Ks.oun("Aibe is kurios bus grazinamas didziausias elementas");
//        Ks.ounn(bstSetList.toVisualizedString(""));
//
//        Ks.oun("Grazinamas paskutinis(didžiausias) aibes elemenhtas");
//        Ks.oun(bstSetList.last());
//
//
//        Ks.oun("Aibe is kurios bus grazinamas didziausias elementas");
//        Ks.ounn(bstSetList.toVisualizedString(""));
//
////        bstSetList.remove(c3);
////        bstSetList.remove(c4);
////        bstSetList.remove(c5);
////        bstSetList.remove(c6);
////        Ks.oun("Grazinamas tuscios aibes paskutinis elementas");
////        Ks.oun(bstSetList.last());
//
//
//
//
////        // AvlSet klasės
////        AvlSet<Car> avlSetList = new AvlSet<>();
////        avlSetList.add(c7);
////        avlSetList.add(c8);
////        avlSetList.add(c9);
////
////        Ks.oun("Pradinis avl medis");
////        Ks.ounn(avlSetList.toVisualizedString(""));
////
////        avlSetList.remove(c8);
////        Ks.oun("Pasalinamas c8 elementas");
////        Ks.ounn(avlSetList.toVisualizedString(""));
////
//
//    }
//
//    static ParsableSortedSet<Car> generateSet(int kiekis, int generN) {
//        cars = new Car[generN];
//        for (int i = 0; i < generN; i++) {
//            cars[i] = new Car.Builder().buildRandom();
//        }
//        Collections.shuffle(Arrays.asList(cars));
//
//        cSeries.clear();
//        Arrays.stream(cars).limit(kiekis).forEach(cSeries::add);
//        return cSeries;
//    }
}