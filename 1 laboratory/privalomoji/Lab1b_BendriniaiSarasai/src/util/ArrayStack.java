package util;

import java.util.ArrayList;

public class ArrayStack <E> implements Stack<E>{
    // implemented stack methods are described in stack interface class
    ArrayList<E> list = new ArrayList<>();

    public int count(){
        int size = 0;
        for(int i = 0; i < list.size(); i++)
            size++;
        return size;
    }

    @Override
    public E pop() {
        if(isEmpty()){
            System.out.println("Error: stack is empty");
            return null;
        }
        else{
            E value = null;
            value = list.get(0);
            list.remove(0);
            return value;
        }

    }

    @Override
    public void push(E item) {
        ArrayList<E>newList = new ArrayList<>();
        newList.add(0, item);
            for (int i = 0; i < list.size(); i++)
            {
                newList.add(i+1, list.get(i));
            }
            list = newList;
    }

    @Override
    public E peak() {
        if(isEmpty()){
            System.out.println("Error: stack is empty");
            return null;
        }
        else{
            return list.get(0);
        }
    }

    @Override
    public boolean isEmpty() {
        boolean flag = false;
        if(list.size() == 0){
            flag = true;
        }
        return flag;
    }

    // for testing get method by index
    public E get(int index){
        return list.get(index);
    }
}
