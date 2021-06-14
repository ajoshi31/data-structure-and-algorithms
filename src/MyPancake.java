import java.util.ArrayList;
import java.util.List;

public class MyPancake implements Pancake {

    public static void main(String[] args) {
        List<String> x = new ArrayList<>();
        x.add("1");
        x.add("23");
        x.add("12");
        List<String> y = new MyPancake().doStuff(x);
        System.out.println(y);
    }

    @Override
    public List<String> doStuff(List<String> z) {
        z.add("9");
        return z;
    }
}

interface Pancake {
    List<String> doStuff(List<String> s);
}
