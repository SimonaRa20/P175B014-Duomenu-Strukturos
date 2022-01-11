package utils;

import java.util.Iterator;

/*
Realizuokite visus interfeiso metodus susietojo sarašo pagrindu.
Nesinaudokite java klase LinkedList<E>, visa logika meginkite parasyti patys.
Jeigu reikia, galima kurti papildomus metodus ir kintamuosius.
*/
public class LinkedList<T> implements List<T> {
    private class Node<T>{
        public  T Data;
        public Node<T> Link;
        public Node(T value, Node<T> address){
            Data=value;
            Link=address;
        }
    }

    Node<T> Head;
    Node<T> Pointer;
    Node<T> Tail;

    @Override
    public void add(T item) {
        Node<T> newNode = new Node(item, null);
        if (Head != null)
        {
            Tail.Link = newNode;
            Tail = newNode;
        }
        else
        {
            Head = newNode; Tail = newNode;
        }
    }

    @Override
    public T get(int index) {
        Node<T> temp = Head;
        int count = 0;
        while(temp != null){
            if(count == index) {
                return temp.Data;
            }
            else{
                count++;
                temp = temp.Link;
            }
        }
        return null;
        //throw new UnsupportedOperationException("Metoda reikia realiztuoti");
    }


    @Override
    public boolean remove(T item) {
        Node<T>prev = Head;
        if(Head.Data.equals(item))
        {
            Head = Head.Link;
            return true;
        }
        else if(Head.Link == null) {
            return false;
        }
        else{
            Pointer = Head.Link;
            while(Pointer.Link !=null){
                if(Pointer.Data.equals(item)){
                    prev.Link = Pointer.Link;
                    return true;
                }
                prev = Pointer;
                Pointer = Pointer.Link;
            }
        }
        if(Tail.Data.equals(item)){
            prev.Link = null;
            Tail = prev;
            return true;
        }
        return false;

    }
    public boolean isEmpty(){
        return Pointer!=null;
    }
    public void start(){
        Pointer=Head;
    }
    public void next(){
        Pointer=Pointer.Link;
    }

    @Override
    public Iterator<T> iterator() {
        Pointer = Head;

        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return Pointer!= null;
                //throw new UnsupportedOperationException("Metoda reikia realiztuoti");
            }

            @Override
            public T next() {
                T data = Pointer.Data;
                Pointer = Pointer.Link;
                return data;
                 //throw new UnsupportedOperationException("Metoda reikia realiztuoti");
            }
        };
    }
}
