package AbstractClassVsInterface;

/**
 * Created by Jo on 21/06/2015.
 */
/*
Java 8 changed the capabilities of interfaces to align them more with abstract classes, but there are still distinct differences.
Reminder -  a class must be declared abstract if it contains one or more abstract methods (ie a method signature without a body).
An abstract class cannot be instantiated, it can only be used as a superclass.

 PRE-JAVA 8 - DIFFERENCES BETWEEN ABSTRACT CLASSES AND INTERFACES;
 1) By default an interface can only have public abstract methods which do not need to be declared public abstract.
    Abstract classes can have abstract and concrete methods, which can be declared public, protected, or public abstract.
    The keyword abstract is mandatory to declare abstract methods in abstract classes.
 2) An interface can have only static final variables (ie constant variables) -> static because Java interfaces
    cannot be instantiated in their own right, and final to ensure that the value cannot be reassigned by program code
    (ie it is a true constant).
    An abstract class can have static, final, and static final variables with any access modifier.
 3) Interfaces can only extend interfaces, and abstract classes can extend a class or an abstract class.
    Abstract classes should be used where an inheritance hierarchy would be beneficial.
 4) An interface can extend any number of interfaces,
    whereas an abstract class can extend only one class or one abstract class at a time.
 5) A class can implement any number of interfaces,
    whereas a class can extend only one abstract class.
    Interfaces can therefore be used as a substitute for multiple inheritance.
 6) An abstract class can have constructors, whereas an interface doesn't because it is not a class.
 7) A class must implement all methods of an interface, but doesn't have to implement all methods of an abstract class.

 WHEN TO USE ABSTRACT CLASSES AND INTERFACES;
 1) If you are planning on using inheritance then an abstract class is a good choice since it provides a common
    base class for sub-classes to be derived from. It should be used if you require a default implementation of
    one or more methods. So an abstract class should be used when a derived class should inherit the core properties
    of the abstract class, whereas an interface shares behaviour that doesn't necessarily define the core behaviour of
    a derived class.
 2) Choose a concrete class if you need non-public access modifiers to variables and methods,
    or if you don't want your variables to be static final.
 3) If you think you will need to add methods in the future then use an abstract class - if you add new methods to
    an interface then all classes implementing that interface will also have to be changed to implement the new method.
    Use interfaces if you don't think that the API will be changed for a while.
 4) Use interfaces if you need something similar to multiple inheritance.

 JAVA 8 - DIFFERENCES;
 1) You can add a default method to an interface (also known as an extension method), using the keyword default to
    declare it. This allows us to add a new default method to an interface without breaking pre-existing code based on
    the original interface. The default method provides an implementation of the method that will be used if no other
    implementation is explicitly provided.
    Default methods are also useful if we know that some classes implementing the interface will not require one of the
    methods -> pre - Java 8 the class would need to implement its own version of the method which does nothing
    (or throws an exception), whereas in Java 8 we can provide a default implementation in the interface that does nothing
    (or throws an exception), and any class requiring an implementation of that method can provide a different
    implementation of it, ie the implementation of the method is optional. Default methods are a way to provide
    optional functionality without the implementing class having to implement a placeholder method if that
    functionality is not required.
    The KEY DIFFERENCE of a Java 8 interface compared to an abstract class is that it cannot maintain state information,
    whereas an abstract class can <- this is why Java 8 still does not strictly support multiple inheritance.
 2) INHERITANCE - Java 8 makes it possible for a class to implement two different interfaces with the same default
    method name but with different implementations of it. In this case the following rules are applied;
        * If the implementing class has overridden the default method, then this implementation is used.
        * If the class doesn't provide its own implementation then an error will occur.
        * If one interface inherits another, then the inheriting interfaces default method takes precedence.
            eg if interface B extends interface A, then interfaces B's default method will be used.
 3) Java 8 interfaces can have static methods.
 4) Java 8 interface methods are still inherently public, and the variables are public static final, whereas abstract class
    methods can be public, protected, or private, and its variables can be static, final, or static final.

 */
public interface JavaInterface {

    //Fields must be static and final
    public static final int constantNum = 100;

    // A normal interface method declaration (this is public abstract by default and so doesn't need to be declared as such)
    //In an implementing class this method would need to be implemented.
    Double calculatePay();

    // A Java 8 default method (use keyword default to declare it)
    //An implementing class doesn't need to provide its own implementation of this class, although it can provide its
    //own implementation if required.
    default String getString(){
        return "A String";
    }

    // A Java 8 default method to provide an implementation of an optional method which can be used
    //depending on how the interface is used, eg if used by an immutable class this default method would provide
    //a reasonable default implementation since we don't require the method, whereas a mutable class may provide
    //its own implementation because the method is required.
    default void remove(){
        //DO NOTHING
        //OR throw an exception
        throw new UnsupportedOperationException("Class does not implement remove() from interface JavaInterface");
    }

    // Static methods are allowed in Java 8 interfaces
    static int getInterfaceNumber(){
        return constantNum;
    }
}
