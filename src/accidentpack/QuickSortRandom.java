package accidentpack;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author Devin C
 * A QuickSort class based on example provided in chapter 8.9 of textbook
 * and modified to work with report objects.
 */
public class QuickSortRandom {
    /**
    * Sorts the ArrayList of report objects using the quicksort algorithm.
    * @param reports the ArrayList of report objects to be sorted
    */
    public static void quickSort(ArrayList<report> reports) {
        if (reports == null || reports.size() <= 1) {
            return; // Already sorted
        }
        quickSortHelper(reports, 0, reports.size() - 1);
    }
    
    /**
    * Helper method for quicksort. Recursively sorts the sub-array of report objects. 
    * @param reports the ArrayList of report objects to be sorted
    * @param first the index of the first element of the sub-array
    * @param last the index of the last element of the sub-array
    */
    private static void quickSortHelper(ArrayList<report> reports, int first, int last) {
        if (first < last) {
            int pivotIndex = partition(reports, first, last);
            quickSortHelper(reports, first, pivotIndex - 1);
            quickSortHelper(reports, pivotIndex + 1, last);
        }
    }
    
    /**
    * Partitions the ArrayList of report objects around a pivot element.
    * @param reports the ArrayList of report objects to be partitioned
    * @param first the index of the first element of the sub-array to be partitioned
    * @param last the index of the last element of the sub-array to be partitioned
    * @return the index of the pivot element after partitioning
    */
    private static int partition(ArrayList<report> reports, int first, int last) {
        Random rand = new Random();
        // Select random element as pivot value
        int pivotIndex = rand.nextInt(last);
        report pivot = reports.get(pivotIndex);
        // Swap pivot with first element
        swap(reports, first, pivotIndex);
        // Initialize pointers for partitioning
        int up = first + 1;
        int down = last;
        do {
            // Move the 'up' pointer to the right until finding 
            // an element greater than or equal to the pivot          
            while ((up < last) && (pivot.compareTo(reports.get(up)) >= 0)) {
                up++;
            }
            // Move the 'down' pointer to the left until 
            // finding an element less than the pivot
            while (pivot.compareTo(reports.get(down)) < 0) {
                down--;
            }
            // Swap elements if up is less than down
            if (up < down) {               
                swap(reports, up, down);
            }
        // Repeat while up is less than down    
        } while (up < down);
        // Swap the pivot element with the element at index 
        // 'down' to place the pivot in its correct position
        swap(reports, first, down);
        // Return the index of the pivot element
        return down;
    }
    
    /**
    * Swaps two elements in the ArrayList of report objects.
    * @param reports the ArrayList of report objects
    * @param i the index of the first element to be swapped
    * @param j the index of the second element to be swapped
    */
    private static void swap(ArrayList<report> reports, int i, int j) {
        report temp = reports.get(i);
        reports.set(i, reports.get(j));
        reports.set(j, temp);
    }
}
