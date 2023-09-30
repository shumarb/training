import java.util.Arrays;
import java.util.Random;

class QuickSort {
    // Randomly generate values for array
    // Precon: Array not created
    // Postcon: Array containing randomly-generated values created
    private int[] formsArray() {
        Random rand = new Random();
        int arraySize = rand.nextInt(5, 12);
        int[] inputArray = new int[arraySize];
        for (int i = 0; i < inputArray.length; i++) {
            inputArray[i] = rand.nextInt(-10000, 10000);
        }
        return inputArray;
    }

    // Displays array for checking
    // Precon: inputArray split into 2 arrays of near-equal/equal length
    // Postcon: Executes Quick Sort
    private void displaysArray(String firstPartString, int[] subArray) {
        System.out.print(firstPartString + ": [");
        for (int i = 0; i < subArray.length - 1; i++) {
            System.out.print(subArray[i] + " ");
        }
        System.out.println(subArray[subArray.length - 1] + "]");
    }

    // Displays line for easier readibility
    // Precon: Nil
    // Postcon: Nil
    private void displaysLine() {
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    // Copies inputArray into another array
    // Precon: Initial values of inputArray not stored in ordered form another array
    // Post Initial values of inputArray stored in ordered form another array
    private int[] storesInitialArray(int[] inputArray) {
        return Arrays.copyOf(inputArray, inputArray.length);
    }

    // Displays array before Quick Sort
    // Precon: Array not sorted before Quick Sort
    // Postcon: Executes Quick Sort on array
    private void displaysArrayBeforeSort(int[] inputArray) {
        displaysLine();
        displaysArray("Before Quick Sort", inputArray);
        displaysLine();
    }

    // Displays array after Quick Sort
    // Precon: Array is sorted via Quick Sort
    // Postcon: Nil
    private void displaysArrayAfterSort(int[] inputArray, int[] initialArray) {
        displaysArray("After Quick Sort", inputArray);
        displaysLine();   
        System.out.print("Change: [");
        for (int i = 0; i < initialArray.length - 1; i++) {
            System.out.print(initialArray[i] + " ");
        }
        System.out.print(initialArray[initialArray.length - 1] + "] -----------------> [");
        for (int i = 0; i < inputArray.length - 1; i++) {
            System.out.print(inputArray[i] + " ");
        }
        System.out.println(inputArray[inputArray.length - 1] + "]");
        displaysLine();
    }

    // Swaps 2 elements
    // Precon: Quick Sort is currently being executed
    // Postcon: Elements are swapped
    private void swapsElements(int[] inputArray, int firstIndex, int secondIndex) {
        int temp = inputArray[firstIndex];
        inputArray[firstIndex] = inputArray[secondIndex];
        inputArray[secondIndex] = temp;
    }

    // Sets partition
    // Precon: lowIndex < highIndex
    // Postcon: Executes Quick Sort
    private int executesPartition(int[] inputArray, int lowIndex, int highIndex) {
        displaysArray("* array before partition", inputArray);
        
        // 1. Randomly choose pivot to reduce chances of worst average performance for quick sort
        // and swap this element with the last element of the partition
        // then select last element of partition as pivot
        int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;
        swapsElements(inputArray, pivotIndex, highIndex);
        int pivot = inputArray[highIndex];

        // 2. Create 2 variables,
        // with 1 pointing to the element at the lowIndex of partition,
        // and the other 1 pointing to the element at the highIndex of the partition
        int leftPointer = lowIndex;
        int rightPointer = highIndex;
        while (leftPointer < rightPointer) {
            // 2a. For 2 while loops, 2nd part of condition is in case
            // leftPointer does not come across any element larger than pivot
            // and rightPointer does not come across any element smaller than pivot
            while (inputArray[leftPointer] <= pivot && leftPointer < rightPointer) {
                leftPointer++;
            }

            while (inputArray[rightPointer] >= pivot && leftPointer < rightPointer) {
                rightPointer--;
            }

            // 2b. Swap an element <= pivot with an element >= pivot
            // If condition in case leftPointer and rightPointer
            // do not encounter an element > pivot and <= pivot respectively
            if (leftPointer < rightPointer) {
                swapsElements(inputArray, leftPointer, rightPointer);
            }
        }

        // 3. Now, both leftPointer and rightPointer represents 
        // correct index that pivot has to be and highIndex represents current index of pivot
        // because at the start of program, the pivot is the last element of the partition at highIndex
        swapsElements(inputArray, leftPointer, highIndex);
        System.out.println("* pivot: " + pivot);
        displaysArray("* array after partition", inputArray);
        displaysLine();

        // 4. Return index of pivot, which can be either leftPointer or rightPointer
        // because both pointers are pointing to the index of the partition
        return leftPointer;
    }

    // Executes Quick Sort on inputArray
    // Precon: inputArray containing values user entered in order user entered has been created
    // Postcon: Values of inputArray are in increasing order after sorted via Quick Sort.
    private void executesQuickSort(int[] inputArray, int lowIndex, int highIndex) {
        // 1. No need to execute quick sort for partition of only 1 element
        if (lowIndex >= highIndex) {
            return;
        }

        // 2. Select partitioning index such that
        // elements smaller than pivot are on the left of the pivot and
        // elements larger than the pivot are on the right 
        int pivotIndex = executesPartition(inputArray, lowIndex, highIndex);

        // 3. Execute quick sort on all elements to the left of the pivot
        executesQuickSort(inputArray, lowIndex, pivotIndex - 1);

        // 4. Execute quick sort on all elements to the right of the pivot
        executesQuickSort(inputArray, pivotIndex + 1, highIndex);
    }

    private void run() {
        int[] inputArray = formsArray();
        int[] initialArray = storesInitialArray(inputArray);
        displaysArrayBeforeSort(inputArray);
        executesQuickSort(inputArray, 0, inputArray.length - 1);
        displaysArrayAfterSort(inputArray, initialArray);
    }
    public static void main(String[] args) {
        QuickSort obj = new QuickSort();
        obj.run();
    }
}
