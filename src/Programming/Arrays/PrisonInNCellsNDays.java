package Programming.Arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PrisonInNCellsNDays {

    public static void main(String[] args) {
        int[] tempArray = {1, 0, 0, 0, 0, 1, 0, 1};
        PrisonInNCellsNDays prCell = new PrisonInNCellsNDays();
        int[] abc = prCell.prisonAfterNDays(tempArray, 4000000);
        System.out.println(Arrays.toString(abc));
    }

    private int[] prisonAfterNDays(int[] cells, int N) {

        /* This would be the obvious appriach and hence for large number there should be
        either some pattern or there would be some repretivtve cycle or some other O(logn) or O(n) solution
        for (int i = 0; i < N; i++) {
            cells = nextDayState(cells);
        }
        */

        /*
        Set<String> seenHashSet = new HashSet<>();
        boolean flag = false;
        int lengthForSamePattern = 0;

        for (int i = 0; i < N; i++) {
            int[] next = nextDayState(cells);
            String arrayString = Arrays.toString(next);
            if (seenHashSet.contains(arrayString)) {
                flag = true;
                break;
            }
            lengthForSamePattern++;
            seenHashSet.add(arrayString);
            cells = next;

        }

        if (flag) {
            return prisonAfterNDays(cells, N % lengthForSamePattern);
        }

        */

        // This shows that it repeats after every 14 count

        N = (N - 1) % 14 + 1;
        for (int i = 0; i < N; i++)
            cells = nextDayState(cells);
        return cells;

    }

    private int[] nextDayState(int[] cells) {

        int[] next = new int[cells.length];
        // first and last are always zero so we track remaining
        for (int i = 1; i < cells.length - 1; i++) {
            next[i] = (cells[i - 1] == cells[i + 1]) ? 1 : 0;
        }
        return next;
    }
}

