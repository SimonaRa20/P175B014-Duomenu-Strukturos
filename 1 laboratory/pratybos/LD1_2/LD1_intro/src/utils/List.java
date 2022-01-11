package utils;

public interface List<T> extends Iterable<T>, Comparable<T>{
    public void add(T item); // add item to the end
    T get();
    public boolean remove(T item); // remove item, if item removed return true, else return false
    public int compareTo(T item);
    public void sort ();
}
