package BottomUpMergesort;
import java.util.concurrent.ThreadLocalRandom;
public class bottomUpMergeSort {

    private int[] originalList;
    private int[] copyList;

    public bottomUpMergeSort(int size) {
        originalList = new int[size];
        copyList = new int[size];
//        generateRandList();
//        copyList(originalList);
    }

    public void sort(int[] list) {
        for(int size = 1; size < list.length; size *= 2) {
            for(int start = 0; start < list.length - 1; start += size * 2) {
                int mid = start + size - 1;
                int end = mid + size;
                merge(list, start, mid, Math.min(end, list.length - 1));
            }
        }
    }

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

    private void copyList(int[] list) {
        System.arraycopy(list, 0, copyList, 0, originalList.length);
    }

    private boolean isSorted(int[] list) {
        for(int i = 1; i < list.length; i++) {
            if (list[i - 1] > list[i]) return false;
        }
        return true;
    }

    private void generateRandList() {
        originalList[0] = 9;
        originalList[1] = 5;
        originalList[2] = 6;
        originalList[3] = 4;

//        for (int i = 0; i < originalList.length; i++) {
//            originalList[i] = 5;
//        }
    }

    public void printList() {
        for (int a : originalList) System.out.println(a);
    }

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