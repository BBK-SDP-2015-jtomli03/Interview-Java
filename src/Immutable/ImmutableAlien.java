package Immutable;

import java.util.Date;

/**
 * Created by Jo on 20/06/2015.
 */
/*
An immutable objects state cannot change after construction.
String and Integer are examples of immutable objects.
Advantages;
    1) Automatically thread-safe for concurrency.
    2) HashCode can use lazy initialization, and be cached for increased performance.
    3) Defensive copies of the object are not required since you cannot change an immutable objects state.

How to implement;
    1) Make the class final or make the constructor private and construct instances using factory methods only. This ensures that the class cannot be overridden with subtypes that allow state to change.
    2) Don't provide setter methods, or any other methods that can change the state of the object.
    3) Make all fields private and final, so that they are not accessible outside the class and you cannot accidentally change them.
    4) Declaring mutable fields final (such as Date or List) will not work -> you must return defensive copies from their getters so that their state isn't mutated by a calling method.
 */


public final class ImmutableAlien {

    private final Date dateOfDiscovery;
    private final String colour;
    private final Integer numberOfEyes;
    // cache the hashCode after it has first been calculated.
    // this field cannot be declared as final since it is lazily evaluated, ie. initially is = 0, and once calculated its value is assigned, therefore its value changes (NOT final).
    // instead hashCode is declared volatile to aid concurrency -> it acts like synchronized.
    private volatile int hashCode = 0;

    public ImmutableAlien(Date dateOfDiscovery, String colour, Integer numberOfEyes){
        // make a new copy of Date since it is mutable and we don't want it to change.
        this.dateOfDiscovery = new Date(dateOfDiscovery.getTime());
        this.colour = colour;
        this.numberOfEyes = numberOfEyes;
    }

    //NO SETTERS

    // dateOfDiscovery is a mutable field, so return a defensive copy,
    // ie. NOT a reference to the original object since this could then be changed using the Date setter methods.
    public Date getDateOfDiscovery(){
        return new Date(dateOfDiscovery.getTime());
    }

    // this is an immutable String so we can return the field as it is.
    public String getColour(){
        return colour;
    }

    // Integer is immutable so we can return the field as it is.
    public int getNumberOfEyes(){
        return numberOfEyes;
    }

    //lazy initialization of hashCode (ie, initially not calculated until it is requested)
    //and caching of the hashCode so that it is only ever calculated once (to increase performance) -> note hashCode is a private final field.
    @Override
    public int hashCode(){
        //if hashCode != 0 then it has already been calculated and cached (as the variable hashCode), so return the cached result.
        if(hashCode != 0) return hashCode;
        //else calculate the hasCode and cache it.
        int hash = 17;
        int result = 3;
        result = hash * result + dateOfDiscovery.hashCode(); //note date cannot be null.
        result = hash * result + (colour == null? 0 : colour.hashCode());
        result = hash * result + numberOfEyes;
        hashCode = result;
        return result;
    }
}
