package com.ktu;

import util.Ks;

import java.util.Locale;
import java.util.Scanner;

public class uzduotis_1 {

    public static void main(String... args) {
        String lineOfSymbols = new String();
        // read line of bracket symbols
        System.out.println("Įveskite simbolių eilutę");
        Scanner scanner = new Scanner(System.in);
        lineOfSymbols = scanner.next();
        Locale.setDefault(new Locale("LT"));
        new uzduotis_1().task(lineOfSymbols); // return true if bracket has a couple
                                              // return false if bracket has not a couple
    }

    void task(String lineOfSymbols) {
        if (checkOrBracketHasHisCouple(lineOfSymbols) == true)
        {
            Ks.oun("True");
        }
        else
        {
            Ks.oun("False");
        }
    }

    private static boolean checkOrBracketHasHisCouple(String line)
    {
        char[]array = line.toCharArray(); // string line convert to char elements massive
        char[]newArray = new char[line.length()]; // create new char elements massive the same length 'array'
        int count = 0; // count for opening and closing bracket

        for(int i = 0; i < array.length; i++)
        {
            // checking opening brackets
            if(array[i] == '(' || array[i] == '[' || array[i] == '{')
            {
                newArray[count++] = array[i];
            }
            // checking closing brackets
            else if(array[i] == ')' || array[i] == ']' || array[i] == '}')
            {
                // check or count is not less than 0, if I got in a char massive just one element(closing bracket) to return false
                if(count > 0)
                {
                    // check couple of brackets
                    if(newArray[count - 1] == '(' && array[i] == ')' || newArray[count - 1] == '{' && array[i] == '}' || newArray[count - 1] == '[' && array[i] == ']')
                    {
                        count--;
                    }
                    else
                    {
                        return false;
                    }
                }
                else {
                    return false;
                }
            }
        }
        if(count == 0) // all elements have correct bracket (opening and closing)
        {
            return true;
        }
        else {
            return false;
        }
    }
}
