package Searching;

/*
An element is majority if it appears more than n/2 times.
Give an algorithm takes an array of n elements as arguments and idetifies the majority if exist
 */

public class CheckMajority {
    void printMajority(int a[], int size) {
        /* Find the candidate for Majority*/
        int cand = findCandidate(a, size);

        /* Print the candidate if it is Majority*/
        System.out.println("Candidate " + cand);
        if (isMajority(a, size, cand))
            System.out.println(" " + cand + " ");
        else
            System.out.println("No Majority Element");
    }

    /* Function to find the candidate for Majority */
    int findCandidate(int a[], int size) {
        int maj_index = 0, count = 1;
        int i;
        for (i = 1; i < size; i++) {
            if (a[maj_index] == a[i])
                count++;
            else
                count--;
            if (count == 0) {
                maj_index = i;
                count = 1;
            }
        }
        return a[maj_index];
    }

    /* Function to check if the candidate occurs more
       than n/2 times */
    boolean isMajority(int a[], int size, int cand) {
        int i, count = 0;
        for (i = 0; i < size; i++) {
            if (a[i] == cand)
                count++;
        }
        if (count > size / 2)
            return true;
        else
            return false;
    }

    /* Driver program to test the above functions */
    public static void main(String[] args) {
        CheckMajority majorelement = new CheckMajority();
        int[] a = {1, 2, 1, 2, 1, 4, 1, 1, 6, 1, 7};
        int size = a.length;
        majorelement.printMajority(a, size);
    }
}

