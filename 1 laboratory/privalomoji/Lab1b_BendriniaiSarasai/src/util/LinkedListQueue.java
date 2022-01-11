package util;

public class LinkedListQueue <E> implements Queue<E>{
    // implemented queue methods are described in queue interface class
    private class Node
    {
        public E Data;
        public Node Next;
        public Node(E data, Node next)
        {
            Data = data;
            Next = next;
        }
    }

    private Node first;
    private Node last;
    private Node current;

    @Override
    public void enqueue(E item) {
        Node newNode = new Node(item, null);
        if (first != null)
        {
            last.Next = newNode;
            last = newNode;
        }
        else
        {
            first = newNode;
            last = newNode;
        }
    }

    @Override
    public E dequeue() {
        E data = null;
        if (first == null) {
            System.out.println("List is empty");
        }
        else {
            data = first.Data;
            first = first.Next;
        }
        return data;
    }

    @Override
    public E peak() {
        if (first != null)
        {
            return first.Data;
        }
        else
            return null;
    }

    @Override
    public boolean isEmpty() {
        if(first == null)
            return true;
        else
            return false;
    }

    public void begin()
    {
        current = first;
    }

    public void next()
    {
        current = current.Next;
    }
    public boolean exist()
    {
        return current != null;
    }
    public E get()
    {
        return current.Data;
    }
}
