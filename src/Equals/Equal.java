package Equals;

/**
 * Created by Jo on 20/06/2015.
 *//*  The == operator compares an objects location in memory.
    The default implementation of .equals also compares the memory location.
    Sometimes we want .equals to compare the objects state (data) instead -> we can do this by overriding the equals method to compare the objects fields.
    If we override .equals we also need to override hashCode so that it generates an equal hashcode for equal objects. This is important for hash based collections (eg. HashMap etc).
    When overriding hashCode you need to use the same set of fields used to compute .equals.
    Ensure that an appropriate definition of equals is implemented if Objects are placed in java collections (Lists, Sets, Maps).
 */
//To facilitate overriding equals, we can create an Equal class.
public class Equal {

    //handles a comparison of boolean fields
    static public boolean equal(boolean thisBoolean, boolean thatBoolean) {
        return thisBoolean == thatBoolean;
    }

    //handles a comparison of long, int, short, and byte fields -> note that int, short, and byte are handled by implicit conversion.
    static public boolean equal(long thisNum, long thatNum) {
        return thisNum == thatNum;
    }

    //handles a comparison of char fields
    static public boolean equal(char thisChar, char thatChar) {
        return thisChar == thatChar;
    }

    //handles a comparison of double fields
    //Double.doubleToLongBits(double val) returns a representation of the specified floating-point value according to the IEEE 754 floating-point "double format" bit layout (a long).
    static public boolean equal(double thisDouble, double thatDouble) {
        return Double.doubleToLongBits(thisDouble) == Double.doubleToLongBits(thatDouble);
    }

    //handles a comparison of Object fields including collections (but not Array -> Array has its own Array.equals() method)
    //uses the ternary operator -> if thisObj == null then return thatObj == null. If thisObj != null then return thisObj.equals(thatObj)
    //will therefore return true if both objects == null.
    static public boolean equal(Object thisObj, Object thatObj) {
        return thisObj == null ? thatObj == null : thisObj.equals(thatObj);
    }

    //Tested using the Alien class which overrides equals and utilises the Equal.java class above.
    public static void main(String[] args) {
        //create our aliens
        int[] threeLegsUneven = {2, 1, 2}; //threeLegsUneven aliens have the middle leg shorter than the others
        int[] threeLegsEven = {2, 2, 2}; //threeLegsEven aliens have equal length legs
        Alien one = new Alien("purple", null, 6, true, threeLegsUneven);
        Alien two = new Alien("purple", null, 6, true, threeLegsUneven); //same variety as alien one
        Alien three = new Alien("red", null, 6, true, threeLegsUneven); //is red in colour
        Alien four = new Alien("purple", "green", 6, true, threeLegsUneven); //has green spots
        Alien five = new Alien("purple", null, 2, true, threeLegsUneven); //has 2 eyes
        Alien six = new Alien("purple", null, 6, false, threeLegsUneven); //is not from planet Zorb
        Alien seven = new Alien("purple", null, 6, true, threeLegsEven); //has equal length legs

        //compare aliens to see if they equal the same variety as alien one
        System.out.println(one.equals(two));    //true
        System.out.println(one.equals(three));  //false
        System.out.println(one.equals(four));   //false
        System.out.println(one.equals(five));   //false
        System.out.println(one.equals(six));    //false
        System.out.println(one.equals(seven));  //false

    }
}
