import DoublyLinkedList.*;
import InsertionSort.*;
import SelectionSort.*;
import quickSort.*;
import BottomUpMergesort.*;
import TopDownMergeSort.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        DoublyLinkedList sortedValues;
        insertionSort insertionSort = new insertionSort();
        selectionSort selectionSort = new selectionSort();
        TopDownMergeSort topDownMergeSort = new TopDownMergeSort();
        quickSort QuickSort = new quickSort(10000);
        bottomUpMergeSort BotUpMergeSort = new bottomUpMergeSort(10000);
        int[] quickSortList = QuickSort.getNumbers();
        int[] mergeSortList = BotUpMergeSort.getOriginalList();

        try(Scanner in = new Scanner(new File("/Users/CalvinNguyen/Desktop/Sorting-Algorithm/numbers.txt"))) {
            for (int i = 0; i < QuickSort.getNumbers().length; i++) {
//                QuickSort.getNumbers()[i] = in.nextInt();
//                BotUpMergeSort.getOriginalList()[i] = in.nextInt();
//                insertionSort.getList().addToFront(in.nextInt());
//                selectionSort.getList().addToFront(in.nextInt());
                topDownMergeSort.getList().addToFront(in.nextInt());
            }


            System.out.println(topDownMergeSort.getList());
            sortedValues = topDownMergeSort.sort(topDownMergeSort.getList());
            System.out.print("After merge sort: ");
            System.out.println(sortedValues);

//            BotUpMergeSort.printList();
//            BotUpMergeSort.sort(mergeSortList);
//            System.out.println(Arrays.toString(mergeSortList));

//            QuickSort.sort(quickSortList);
//            System.out.println(Arrays.toString(quickSortList));
//            System.out.println("Print number of comparision:" + QuickSort.getTotalComparision());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
