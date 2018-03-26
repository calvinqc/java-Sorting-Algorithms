import BottomUpMergesort.bottomUpMergeSort;
import quickSort.quickSort;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        quickSort QuickSort = new quickSort(10000);
        bottomUpMergeSort BotUpMergeSort = new bottomUpMergeSort(10000);
        int[] quickSortList = QuickSort.getNumbers();
        int[] mergeSortList = BotUpMergeSort.getOriginalList();
        try(Scanner in = new Scanner(new File("/Users/CalvinNguyen/Desktop/Sorting-Algorithm/10,000numbers.txt"))) {
            for (int i = 0; i < QuickSort.getNumbers().length; i++) {
//                QuickSort.getNumbers()[i] = in.nextInt();
                BotUpMergeSort.getOriginalList()[i] = in.nextInt();
            }
            BotUpMergeSort.printList();
            BotUpMergeSort.sort(mergeSortList);
            System.out.println(Arrays.toString(mergeSortList));
//            QuickSort.quickSort(quickSortList);
//            System.out.println(Arrays.toString(quickSortList));
//            System.out.println("Print number of comparision:" + QuickSort.getTotalComparision());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}