package utils;

import models.Hotel;

import java.util.Iterator;

public class LinkedList<T extends Comparable<T>> implements List<T> {
    private class Node<T extends Comparable<T>>{
        public  T Data;
        public Node<T> Link;
        public Node(T value, Node<T> address){
            Data=value;
            Link=address;
        }

        public void SetData(T data)
        {
            this.Data = data;
        }

        public int compareTo(T data) {
            return data.compareTo(this.Data);
        }
    }

    Node<T> Head;
    Node<T> Pointer;
    Node<T> Tail;


    @Override
    public int compareTo(T item) {
        return this.Pointer.compareTo(item);
    }

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
    public T get()
    {
        return Pointer.Data;
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


    public void sort()
    {
        if (Head == null)
        {
            return;
        }
        boolean done = true;
        while (done)
        {
            done = false;
            for (Node d = Head; d != null && d.Link != null; d = d.Link)
            {
                if (d.Data.compareTo(d.Link.Data) == 1)
                {
                    T temp = (T)d.Data;
                    d.Data = d.Link.Data;
                    d.Link.Data = temp;
                    done = true;
                }
            }
        }

//        Node maxValue;
//        for (Node d1 = Head; d1 != null; d1 = d1.Link)
//        {
//            maxValue = d1;
//            for (Node d2 = d1.Link; d2 != null; d2 = d2.Link)
//            {
//                if (d1.Data.compareTo(d2.Data) == -1)
//                {
//                    maxValue = d2;
//                }
//            }
//            T St = (T) d1.Data;
//            d1.Data = maxValue.Data;
//            maxValue.Data = St;
//        }

//        for (Pointer = Head; Pointer != null; Pointer = Pointer.Link)
//        {
//            Node<T> nodeToSwap = Pointer;
//            for (Node<T> anotherNode = Pointer.Link; anotherNode != null; anotherNode = anotherNode.Link)
//            {
//                if (anotherNode.compareTo(nodeToSwap.Data) == 1)
//                {
//                    nodeToSwap = anotherNode;
//                }
//            }
//            T curr = Pointer.Data;
//            Pointer.SetData(nodeToSwap.Data);
//            nodeToSwap.SetData(curr);
//        }
//        for (Pointer = Head; Pointer != null; Pointer = Pointer.Link)
//        {
//            Node<T> nodeToSwap = Pointer;
//            for (Node<T> anotherNode = Pointer.Link; anotherNode != null; anotherNode = anotherNode.Link)
//            {
//                if (anotherNode.compareTo(nodeToSwap.Data) == 1)
//                {
//                    nodeToSwap = anotherNode;
//                }
//            }
//            T curr = Pointer.Data;
//            Pointer.SetData(nodeToSwap.Data);
//            nodeToSwap.SetData(curr);
//        }
    }
    public LinkedList<Hotel> filterDuplicate()
    {
        Node<T> curr = Head;
        Node<T> next_next;
        for (curr = Head; curr != null; curr = curr.Link)
        {
            for (Node item = curr.Link; item != null; item = item.Link)
            {
                if (curr.Data.compareTo((T) item.Data) == 0)
                {
                    next_next = curr.Link.Link;
                    curr.Link = null;
                    curr.Link = next_next;
                }
            }
        }
        return null;
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
            }

            @Override
            public T next() {
                T data = Pointer.Data;
                Pointer = Pointer.Link;
                return data;
            }


        };
    }
}
