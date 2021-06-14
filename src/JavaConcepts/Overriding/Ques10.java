package JavaConcepts.Overriding;

class X {
    void calculate(int a, int b) {
        System.out.println("Class X");
    }
}

class Y extends X {
    @Override
    void calculate(int a, int b) {
        System.out.println("Class Y");
    }
}

class Z extends Y {
    @Override
    void calculate(int a, int b) {
        System.out.println("Class Z");
    }
}

public class Ques10 {
    public static void main(String[] args) {
        X x = new Y(); // Y object

        x.calculate(10, 20);

        Y y = (Y) x;
        y.calculate(50, 100);

        Z z = (Z) y;

        z.calculate(100, 200);
    }
}