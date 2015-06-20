package Equals;

//import java.util.Arrays to implement the method Arrays.equal which should be used to compare arrays.
import java.util.Arrays;
//import the static method equal (note - this just makes implementing equals in multiple classes easier (DRY principle)).
import static Equals.Equal.equal;

/**
 * Created by Jo on 20/06/2015.
 */
public class Alien {

    private String colour;
    private String colourOfSpots; //can be null if not of a spotted variety
    private int numberOfEyes;
    private boolean fromZorb; //true if the alien is from the planet Zorb
    private int[] legLengths; //some aliens have different length legs - leg lengths from left to right are stored in this array

    public Alien(String colour, String colourOfSpots, int numberOfEyes, boolean fromZorb, int[] legLengths){
        this.colour = colour;
        this.colourOfSpots = colourOfSpots;
        this.numberOfEyes = numberOfEyes;
        this.fromZorb = fromZorb;
        this.legLengths = legLengths;
    }

    //better to use Apache Commons EqualsBuilder to override equals.
    //start with the fields that have the most significance first, ie. ==, instanceOf, fields.
    @Override
    public boolean equals(Object object){

        if(this == object) return true;
        //instanceOf checks for null, and also supertypes (as opposed to object.getClass())
        //however, care with instanceOf and inheritance as it violates the rule of symmetry,
        //eg. objectOne.equals(objectTwo) == true IF AND ONLY IF objectTwo.equals(objectOne)
        //if objectTwo is a subclass of objectOne, then the first condition is true, but the second is false.
        //in this case you can either declare objectOne as final, or test for object == null && this.getClass() == object.getClass(), but this won't check for supertypes.
        if(!(object instanceof Alien)) return false;

        //at this point we know that object is of type Alien so we can cast it as such.
        Alien alien = (Alien) object;

        //then compare the fields -> compare only the fields that are relevant to determine if one object equals another.
        //note; the last comparison uses the method Arrays.equal for comparison of the array legLengths (ie. use this method for comparing arrays)
        return equal(this.colour, alien.colour) && equal(this.colourOfSpots, alien.colourOfSpots) && equal(this.numberOfEyes, alien.numberOfEyes) &&
                equal(this.fromZorb, alien.fromZorb) && Arrays.equals(this.legLengths, alien.legLengths);
    }

    //best to implement hashCode using Apache Commons HashCodeBuilder or an IDE.
    //To implement yourself;
    // 1) Take a prime number as a hash to result in a distinct hashCode for a distinct object.
    // 2) Take a different prime number as a multiplier.
    // 3) Compute the hashCode for each field that is used in equals, and add to the hash to calculate the final hash.
    // Check each field for null first to avoid a NullPointerException -> if a field is null then return zero.
    // If a field is a numeric data type simply convert to int, and add to the hash.
    // If the object is immutable then you can calculate the hashCode once and then cache it for increased performance.
    @Override
    public int hashCode(){
        int hash = 17;
        int result = 3;
        result = hash * result + (colour == null? 0 : colour.hashCode());
        result = hash * result + (colourOfSpots == null? 0 : colourOfSpots.hashCode());
        result = hash * result + numberOfEyes;
        result = hash * result + (fromZorb? 0 : 7);
        result = hash * result + (legLengths == null? 0 : legLengths.hashCode());
        return result;
    }
}
