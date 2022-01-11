package util;

import java.util.ArrayList;

public class ArrayQueue <E> implements Queue<E>{
    // implemented queue methods are described in queue interface class
    ArrayList<E>list = new ArrayList<>();
    public int count(){
        return list.size();
    }

    // for testing get method by index
    public E get(int index){
        return list.get(index);
    }

    @Override
    public void enqueue(E item) {
        list.add(item);
    }

    @Override
    public E dequeue() {
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
}
