package JavaConcepts.Overriding;

class A {
// DNA ->  A && Object
}

class B extends A {
// DNA ->A & B & Object
}

class C extends B {
 // DNA -> C  B & A & Object /// ERROR
}

public class OverLoading {

    static void overloadedMethod(B x) {
        System.out.println("TWO");
    }

    static void overloadedMethod(A x) {
        System.out.println("ONE");
    }

    static void overloadedMethod(Object x) {
        System.out.println("THREE");
    }

    public static void main(String[] args) {

        int a = 45;
        C input = new C();
        overloadedMethod(input); // humney A DNA wala object bheja hai
    }
}
