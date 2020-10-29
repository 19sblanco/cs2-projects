/**
 * Assignment 4 for CS 1410
 * This program evaluates the linear and binary searching, along
 * with comparing performance difference between the selection sort
 * and the built-in java.util.Arrays.sort.
 *
 */
public class EvaluationDriver {
    static final int MAX_VALUE = 1_000_000;
    static final int MAX_ARRAY_SIZE = 100_000;
    static final int ARRAY_INCREMENT = 20_000;
    static final int NUMBER_SEARCHES = 50_000;

    public static void main(String[] args) {
        demoLinearSearchUnsorted();
        demoLinearSearchSorted();
        demoBinarySearchSelectionSort();
        demoBinarySearchFastSort();
    }

    public static int[] generateNumbers(int howMany, int maxValue) {
        // check if valid input for list length
        if (howMany <= 0) {
            return null;
        }
        // create an array, append random values, from 0 to the max value to each cell
        int[] list = new int[howMany];
        for (int i = 0; i < list.length; i++) {
            int newNum = (int) (Math.random() * maxValue);
            list[i] = newNum;
        }
        return list;
    }

    public static boolean linearSearch(int[] data, int search) {
        // loop through each value, if found return true, otherwise return false
        for (int datum : data) {
            if (datum == search) {
                return true;
            }
        }
        return false;
    }

    public static boolean binarySearch(int[] data, int search) {
        // create max and min variables
        int max = data.length - 1;
        int min = 0;

        // loop if still searching, only exit if not in list
        while (min <= max) {
            // calculate new min every loop
            int mid = (int) ((max + min) / 2);

            // series of if statements to change bounds based on the size of "search"
            if (data[mid] == search) {
                return true;
            } else if (data[mid] > search) {
                max = mid - 1;
            } else if (data[mid] < search) {
                min = mid + 1;
            }
            // if not found return false
        }
        return false;
    }

    public static void selectionSort(int[] data) {
        // loop through each value, assuming its the min
        for (int i = 0; i < data.length; i++) {
            int minInx = i;
            // loop through things after, if you find something smaller set it to min
            for (int j = i + 1; j < data.length; j++) {
                if (data[minInx] > data[j]) {
                    minInx = j;
                }
            }
            // swap the values, so that the min val is in the right place
            int tempVal = data[i];
            data[i] = data[minInx];
            data[minInx] = tempVal;
        }
    }

    public static void demoLinearSearchUnsorted() {
        int found = 0;
        System.out.println("--- Linear Search Timing (unsorted) ---");

        // for each loop generate a list
        for (int i = ARRAY_INCREMENT; i <= MAX_ARRAY_SIZE; i += ARRAY_INCREMENT) {
            int[] list = generateNumbers(i, MAX_VALUE);
            double timeBefore = System.currentTimeMillis();
            for (int j = 0; j < NUMBER_SEARCHES; j++) {
                // generate random num, and find in list, if found add 1 to count
                int randomNum = (int) (Math.random() * MAX_VALUE);
                if (linearSearch(list, randomNum)) {
                    found += 1;
                }
            }
            // calculate items for output
            double timeAfter = System.currentTimeMillis();
            int totalSearchTime = (int) (timeAfter - timeBefore);

            // print output
            System.out.println("Number of items       : " + i);
            System.out.println("Times value was found : " + found);
            System.out.println("Total search time     : " + totalSearchTime + " ms");
            System.out.println("");
        }
    }

    public static void demoLinearSearchSorted() {
        int found = 0;
        System.out.println("--- Linear Search Timing (Selection Sorted) ---");

        // for each loop generate a list and sort
        for (int i = ARRAY_INCREMENT; i <= MAX_ARRAY_SIZE; i += ARRAY_INCREMENT) {
            int[] list = generateNumbers(i, MAX_VALUE);
            double timeBefore = System.currentTimeMillis();
            selectionSort(list);
            for (int j = 0; j < NUMBER_SEARCHES; j++) {
                // generate random num, and find in list, if found add 1 to count
                int randomNum = (int) (Math.random() * MAX_VALUE);
                if (linearSearch(list, randomNum)) {
                    found += 1;
                }
            }
            // calculate items for output
            double timeAfter = System.currentTimeMillis();
            int totalSearchTime = (int) (timeAfter - timeBefore);

            // print output
            System.out.println("Number of items       : " + i);
            System.out.println("Times value was found : " + found);
            System.out.println("Total search time     : " + totalSearchTime + " ms");
            System.out.println("");
        }
    }

    public static void demoBinarySearchSelectionSort() {
        int found = 0;
        System.out.println("--- Binary Search Timing (Selection Sort) ---");

        // for each loop generate a list and sort
        for (int i = ARRAY_INCREMENT; i <= MAX_ARRAY_SIZE; i += ARRAY_INCREMENT) {
            int[] list = generateNumbers(i, MAX_VALUE);
            double timeBefore = System.currentTimeMillis();
            selectionSort(list);
            for (int j = 0; j < NUMBER_SEARCHES; j++) {
                // generate random num, and find in list, if found add 1 to count
                int randomNum = (int) (Math.random() * MAX_VALUE);
                if (binarySearch(list, randomNum)) {
                    found += 1;
                }
            }
            // calculate items for output
            double timeAfter = System.currentTimeMillis();
            int totalSearchTime = (int) (timeAfter - timeBefore);

            // print output
            System.out.println("Number of items       : " + i);
            System.out.println("Times value was found : " + found);
            System.out.println("Total search time     : " + totalSearchTime + " ms");
            System.out.println("");
        }
    }

    public static void demoBinarySearchFastSort() {
        int found = 0;
        System.out.println("--- Binary Search Timing (Arrays.sort) ---");

        // for each loop generate a list and sort
        for (int i = ARRAY_INCREMENT; i <= MAX_ARRAY_SIZE; i += ARRAY_INCREMENT) {
            int[] list = generateNumbers(i, MAX_VALUE);
            double timeBefore = System.currentTimeMillis();
            java.util.Arrays.sort(list);
            for (int j = 0; j < NUMBER_SEARCHES; j++) {
                // generate random num, and find in list, if found add 1 to count
                int randomNum = (int) (Math.random() * MAX_VALUE);
                if (binarySearch(list, randomNum)) {
                    found += 1;
                }
            }
            // calculate items for output
            double timeAfter = System.currentTimeMillis();
            int totalSearchTime = (int) (timeAfter - timeBefore);

            // print output
            System.out.println("Number of items       : " + i);
            System.out.println("Times value was found : " + found);
            System.out.println("Total search time     : " + totalSearchTime + " ms");
            System.out.println("");
        }
    }
}
