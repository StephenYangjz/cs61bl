import java.util.*;

public class PhoneBook {
    // TODO Add any instance variables necessary
    HashMap<Person, PhoneNumber> myMap = new HashMap(10, (float)0.75);
    /*
     * Adds a person with this name to the phone book and associates 
     * with the given PhoneNumber.
     */
    public void addEntry(Person personToAdd, PhoneNumber numberToAdd){
    	// TODO Add your own code
            myMap.put(personToAdd, numberToAdd);
    }

    /*
     * Access an entry in the phone book. 
     */
    public PhoneNumber getNumber(Person personToLookup){
    	// TODO Add your own code
        return myMap.get(personToLookup) == null ? null : myMap.get(personToLookup);
    }

}
