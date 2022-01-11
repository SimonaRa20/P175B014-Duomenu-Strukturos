package util;

public interface Stack <E>{

    E pop(); // pirmo elemento esančio steke ištrynimui ir grąžinimui

    void push (E item); // naujo elemento įterpimui į steko pradžią

    E peak (); // pirmo elemento esančio steke grąžinimui

    boolean isEmpty(); // patikrinimui, ar stekas tuščias
}
