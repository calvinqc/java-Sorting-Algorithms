package BottomUpMergesort;

public class bottomUpMergeSort {

    private int[] originalList;

    public bottomUpMergeSort(int size) {
        originalList = new int[size];
    }



    public bottomUpMergeSort(int[] unSortedList) {
        merge(unSortedList, 0, 0, 0);
    }

    private void merge(int[] unSortedList, int lo, int mid, int hi) {

    }




//  Merge
//  Partition

    private void swap(int[] list, int posA, int posB) {
        int temp = list[posA];
        list[posA] = list[posB];
        list[posB] = list[posA];
    }


    public int[] getOriginalList() {
        return originalList;
    }

    public void setOriginalList(int[] originalList) {
        this.originalList = originalList;
    }
}