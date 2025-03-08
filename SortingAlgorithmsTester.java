/*
// Title: SortingAlgorithmsTester Class
// Author: Ege Ottan
// ID: 10168090218
// Section: 02
// Assignment: 2
// Description: Tests the sorting algorithms provided in the cmpe242-sort01.jar package.
// Generates arrays of different types (ascending, descending, random),
// measures sorting times, and prints the results.
 */
import java.util.Arrays;
import java.util.Random;


public class SortingAlgorithmsTester {
	/*
	// Summary: Generates an array of integers in ascending order.
    // Precondition: size > 0.
    // Postcondition: Returns an array of size `size` where each element is in ascending order.
     */
    public static int[] generateAscendingArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i;
        }
        return array;
    }

    /*
    //Summary: Generates an array of integers in descending order.
    // Precondition: size > 0.
    // Postcondition: Returns an array of size `size` where each element is in descending order.
     */
    public static int[] generateDescendingArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = size - i;
        }
        return array;
    }

   /*
    //Summary: Generates an array of random integers.
    // Precondition: size > 0.
    // Postcondition: Returns an array of size `size` with randomly generated integers.
    */
    public static int[] generateRandomArray(int size) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt();
        }
        return array;
    }
    

    /*
    // Summary: Measures the execution time of a sorting algorithm on a given array.
    // Precondition: The input array and algorithm number are valid.
    // Postcondition: Returns the time in milliseconds taken to sort the array.
     */
    public static long measureSortingTime(int[] array, long studentID, int algorithm) {
        int[] copy = array.clone(); // Clone the array to avoid modification
        long startTime = System.currentTimeMillis();
        switch (algorithm) {
            case 1:
                SortingAlgorithms.sort1(copy, studentID);
                break;
            case 2:
                SortingAlgorithms.sort2(copy, studentID);
                break;
            case 3:
                SortingAlgorithms.sort3(copy, studentID);
                break;
            case 4:
                SortingAlgorithms.sort4(copy, studentID);
                break;
            case 5:
                SortingAlgorithms.sort5(copy, studentID);
                break;
            default:
                System.out.println("Invalid algorithm number.");
                return -1;
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

   /*
    // Summary: Main method to test sorting algorithms on arrays of different types and sizes.
    // Precondition: cmpe242-sort01.jar is correctly configured in the project.
    // Postcondition: Prints the median sorting time for each algorithm and array configuration.
    */
    public static void main(String[] args) {

        // Array sizes to test
        int[] sizes = {10000, 20000, 40000, 80000, 100000};

        // Sorting algorithms to test
        int[] algorithms = {1, 2, 3, 4, 5};

       
        long studentID = 1016809021L;

        // Array types to test: ascending, descending, and random
        String[] arrayTypes = {"Ascending", "Descending", "Random"};

     // Iterate through each array size, algorithm, and array type
        for (int size : sizes) {
            for (int algorithm : algorithms) {
                for (String arrayType : arrayTypes) {
                    long[] runTimes = new long[5]; // Array to store runtimes for median calculation.
                    for (int i = 0; i < 5; i++) { // Run the sorting algorithm 5 times for consistency.
                        int[] array;
                        if (arrayType.equals("Ascending")) {
                            array = generateAscendingArray(size);// Generate an ascending array.
                        } else if (arrayType.equals("Descending")) {
                            array = generateDescendingArray(size);// Generate a descending array.
                        } else {
                            array = generateRandomArray(size); // Generate a random array.
                        }
                        runTimes[i] = measureSortingTime(array, studentID, algorithm);// Measure runtime.
                    }
                    Arrays.sort(runTimes);// Sort runtimes to find the median.
                    long medianTime = runTimes[2]; // The median is the middle value.
                    System.out.println("Median time for " + arrayType + " array of size " + size +
                            " with algorithm " + algorithm + ": " + medianTime + " milliseconds");
                }
            }
        }
    }
}
