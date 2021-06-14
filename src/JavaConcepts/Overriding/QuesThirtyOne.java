package JavaConcepts.Overriding;

class Ar {
    static void methodOne() {
        System.out.println("AAA");
    }
}

class Br extends Ar {
    static void methodOne() {
        System.out.println("BBB abc");
        System.out.println("BBB asbc");
    }
}

public class QuesThirtyOne {
    public static void main(String[] args) {
        Br a = new Br();

        a.methodOne();
    }
}

