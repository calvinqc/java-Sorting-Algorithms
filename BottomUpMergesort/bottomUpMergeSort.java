package BottomUpMergesort;

/**
 * This class will generate a sorting method for a list of integer with a given length.
 * This sort method uses Bottom-up mergesort algorithm, which run in O(n log(n)) time.
 * @author CalvinNguyen
 * Github: https://github.com/NivlaCuong/Sorting-Algorithms/tree/master/BottomUpMergesort
 */
public class bottomUpMergeSort {

    /**
     * Attributes
     */
    private int[] originalList;
    private int[] copyList;

    /**
     * a constructor with a given size
     * @param size: size is provided by the user.
     */
    public bottomUpMergeSort(int size) {
        originalList = new int[size];
        copyList = new int[size];
    }


    /**
     * Sort Method will start to sort the list by size of 1, 2, 4, ... until each fully sorted
     * @param list: list that needs to be sorted
     */
    public void sort(int[] list) {
        if (!isSorted(list)) {
            for (int size = 1; size < list.length; size *= 2) {
                for (int start = 0; start < list.length - 1; start += size * 2) {
                    int mid = start + size - 1;
                    int end = mid + size;
                    merge(list, start, mid, Math.min(end, list.length - 1));
                }
            }
        }
    }

    /**
     * Compare, swap, and merge the list together
     * @param low: The starting position of the list
     * @param mid: the end of the first list
     * @param hi: The last number of the second list
     */
    private void merge(int[] list, int low, int mid, int hi) {
        if (!isSorted(list)) {
            int indexItem1 = low;
            int indexItem2 = mid + 1;
            copyList(list);
            for (int i = low; i <= hi; i++) {
                if (indexItem2 > hi || copyList[indexItem1] <= copyList[indexItem2]) {
                    list[i] = copyList[indexItem1];
                    indexItem1++;
                }
                else {
                    list[i] = copyList[indexItem2];
                    indexItem2++;
                }
            }
        }
    }

    /**
     * Copy the original list to a specific list.
     * @param list
     */
    private void copyList(int[] list) {
        System.arraycopy(list, 0, copyList, 0, originalList.length);
    }

    /**
     * Check if the list is sorted.
     * @param list: list to check
     * @return boolean
     */
    private boolean isSorted(int[] list) {
        for(int i = 1; i < list.length; i++) {
            if (list[i - 1] > list[i]) return false;
        }
        return true;
    }

    /**
     * Print all the items in the list
     */
    public void printList() {
        for (int a : originalList) System.out.println(a);
    }


    /**
     * Setter and Getter Method for original list and copy list
     */

    public int[] getOriginalList() {
        return originalList;
    }

    public void setOriginalList(int[] originalList) {
        this.originalList = originalList;
    }

    public int[] getCopyList() {
        return copyList;
    }

    public void setCopyList(int[] copyList) {
        this.copyList = copyList;
    }

}