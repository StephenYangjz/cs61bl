import java.util.*;
public class IntSorter {
    public static int reverseCompare(Integer i1, Integer i2) {
        return -(Integer.compare(i1, i2));
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        //Arrays.sort(arr, IntSorter::reverseCompare);
        System.out.println(Arrays.toString(arr)); // [3, 2, 1]
    }
}