package quickSort;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;
/**
 * Created by CalvinNguyen on 7/18/17.
 */
public class quickSort {

    private int[] numbers;
    private int totalComparision;

    public quickSort(int input) {
        numbers = new int[input];
    }

    private void addTotalComparision(int input) {
        totalComparision += input;
    }

    private int chooseFirstElement(int[] input, int first) {
        return input[first];
    }
    private int chooseLastElement(int[] input, int last) {
        return input[last];
    }
    private int chooseMidEllement(int[] input, int first, int mid, int last) {
        int max = Math.max(input[first], Math.max(input[mid], input[last]));
        int min = Math.min(input[first], Math.min(input[mid], input[last]));
        if (input[mid] < max && input[mid] > min) return input[mid];
        if (input[first] < max && input[first] > min) return input[first];
        return input[last];
    }

    private int getMidValueindex(int first, int last) {
        if (first + last < 3) return first;
        return first + (last - first) / 2;
    }

    public void quickSort(int[] input) {
        quickSort(input, 0, input.length - 1);
    }

    private void quickSort(int[] input, int lo, int hi) {
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

    private void partition(int[] input, int low, int hi) {
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

    private void swap(int[] array, int a, int b) {
        int temp = array[b];
        array[b] = array[a];
        array[a] = temp;
    }

    public int getTotalComparision() {
        return totalComparision;
    }

    public void setNumbers(int[] numbers) {
        this.numbers = numbers;
    }

    public int[] getNumbers() {
        return numbers;
    }

    public void setTotalComparision(int totalComparision) {
        this.totalComparision = totalComparision;
    }
}
