package util;

public interface Queue <E>{
    void enqueue(E item); // naujo elemento pridėjimui į eilės galą
    E dequeue(); // pirmojo eilėje esančio elemento ištrynimui ir grąžinimui
    E peak(); // pirmo elemento esančiam steke gražinimui
    boolean isEmpty(); // patikrinimui, ar eilė tuščia
}
