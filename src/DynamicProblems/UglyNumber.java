package DynamicProblems;


public class UglyNumber {

    public static void main(String[] args) {

        UglyNumber un = new UglyNumber();
        int uglyNumber = un.generateUglyNumber(100);

        System.out.println(uglyNumber);
    }

    private int generateUglyNumber(int n) {

        int[] uglyArray = new int[n];
        int count = 1;
        uglyArray[0] = 1;

        // Initializing the indexCounter
        int index2Tracker = 0;
        int index3Tracker = 0;
        int index5Tracker = 0;

        while (count < n) {

            int nextNumberMultipleOf2 = uglyArray[index2Tracker] * 2;
            int nextNumberMultipleOf3 = uglyArray[index3Tracker] * 3;
            int nextNumberMultipleOf5 = uglyArray[index5Tracker] * 5;

            int nextUglyNumber = Math.min(Math.min(nextNumberMultipleOf2, nextNumberMultipleOf3), nextNumberMultipleOf5);

            if (nextUglyNumber == nextNumberMultipleOf2) {
                index2Tracker++;
            }
            if (nextUglyNumber == nextNumberMultipleOf3) {
                index3Tracker++;
            }
            if (nextUglyNumber == nextNumberMultipleOf5) {
                index5Tracker++;
            }

            uglyArray[count++] = nextUglyNumber;

        }
        return uglyArray[n - 1];
    }
}

