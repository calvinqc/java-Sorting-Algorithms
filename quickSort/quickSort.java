package quickSort;

/**
 * This class will generate a sorting method for a list of integer with a given length
 * and provide a total number of comparision when we recursively call the sort method.
 * This sort method uses Quicksort algorithm, which run in O(n log(n)) in average and best time
 * and only use O(log(n)) space.
 *
 * @author CalvinNguyen
 * Github: https://github.com/NivlaCuong/Sorting-Algorithms/tree/master/quickSort
 */
public class quickSort {

    /**
     * Attributes
     */
    private int[] numbers;
    private int totalComparision;

    /**
     * A Constructor
     * @param input: given list
     */
    public quickSort(int input) {
        numbers = new int[input];
    }

    /**
     * Add the number of comparision for each recursive call
     */
    private void addTotalComparision(int input) {
        totalComparision += input;
    }

    /**
     * Choose the Pivot element. User has an option to choose the first pivot, middle pivot, and last pivot.
     */
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

    /**
     * Get the middle pivot's value: the value number X such that input[first] < X < input[last]
     */
    private int getMidValueindex(int first, int last) {
        if (first + last < 3) return first;
        return first + (last - first) / 2;
    }

    /**
     * Sort Method
     * @param input: a list
     */
    public void sort(int[] input) {
        sort(input, 0, input.length - 1);
    }

    /**
     * Sort method that will compare the number from the begining to the end of the list.
     * @param input: the list
     * @param lo: The start index
     * @param hi: the end index
     */
    private void sort(int[] input, int lo, int hi) {
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
        sort(input, lo, last - 1);
        sort(input, last + 1, hi);
    }

    /**
     * Compare and swap the elements in the given range
     * Uncomment to use different pivots.
     */
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

    /**
     * Swap the position of two given numbers.
     */
    private void swap(int[] array, int a, int b) {
        int temp = array[b];
        array[b] = array[a];
        array[a] = temp;
    }

    /**
     * Getter and Setter for the attributes.
     */
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
