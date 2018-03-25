package quickSort;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;
/**
 * Created by CalvinNguyen on 7/18/17.
 */
public class quickSort {

    int[] numbers;
    int totalComparision;

    quickSort(int input) {
        numbers = new int[input];
    }

    public void addTotalComparision(int input) {
        totalComparision += input;
    }

    int chooseFirstElement(int[] input, int first) {
        return input[first];
    }
    int chooseLastElement(int[] input, int last) {
        return input[last];
    }
    int chooseMidEllement(int[] input, int first, int mid, int last) {
        int max = Math.max(input[first], Math.max(input[mid], input[last]));
        int min = Math.min(input[first], Math.min(input[mid], input[last]));
        if (input[mid] < max && input[mid] > min) return input[mid];
        if (input[first] < max && input[first] > min) return input[first];
        return input[last];
    }
    int getMidValueindex(int first, int last) {
        if (first + last < 3) return first;
        return first + (last - first) / 2;
    }

    void quickSort(int[] input) {
        quickSort(input, 0, input.length - 1);
    }
    void quickSort(int[] input, int lo, int hi) {
        if (hi <= lo) return;
//        int p = chooseFirstElement(input, lo);
//        int p = chooseLastElement(input, hi);
        int p = chooseMidEllement(input, lo, getMidValueindex(lo, hi), hi);
        partition(input, lo, hi);
        addTotalComparision(hi - lo);
        int last = lo;
        for (int i = lo; i < input.length; i++) {
            if (input[i] == p) break;
            last++;
        }
        quickSort(input, lo, last - 1);
        quickSort(input, last + 1, hi);
    }

    void partition(int[] input, int low, int hi) {
        int i = low + 1;
//        int p = chooseFirstElement(input, low);
//        int p = chooseLastElement(input, hi);
        int p = chooseMidEllement(input, low, getMidValueindex(low, hi), hi);
        if (input[getMidValueindex(low, hi)] == p) {
            swap(input, low, getMidValueindex(low, hi));
        }
        else if (input[hi] == p) {
            swap(input, low, hi);
        }
//        swap(input, low, hi);
//        swap(input, low, getMidValueindex(low, hi));
        for (int j = low + 1; j <= hi; j++) {
            if (input[j] < p) {
                swap(input, i, j);
                i++;
            }
        }
        swap(input, low, i - 1);
    }

    void swap(int[] array, int a, int b) {
        int temp = array[b];
        array[b] = array[a];
        array[a] = temp;
    }

    public static void main(String[] args)  {
        quickSort a = new quickSort(10000);

        try(Scanner in = new Scanner(new File("/Users/CalvinNguyen/Desktop/Computer Science/algorithm-Standford/assignment3.txt"))) {
            for (int i = 0; i < a.numbers.length; i++) {
                a.numbers[i] = in.nextInt();
            }
            a.quickSort(a.numbers);
            System.out.println(Arrays.toString(a.numbers));
            System.out.println("Print number of comparision:" + a.totalComparision);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
