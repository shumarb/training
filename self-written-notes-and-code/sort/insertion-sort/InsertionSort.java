import java.util.Arrays;
import java.util.Random;

class InsertionSort {
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

    // Displays line for easier readibility
    // Precon: Nil
    // Postcon: Nil
    private void displaysLine() {
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    // Displays array for checking
    // Precon: inputArray split into 2 arrays of near-equal/equal length
    // Postcon: Executes Insertion Sort
    private void displaysArray(String firstPartString, int[] subArray) {
        System.out.print(firstPartString + ": [");
        for (int i = 0; i < subArray.length - 1; i++) {
            System.out.print(subArray[i] + " ");
        }
        System.out.println(subArray[subArray.length - 1] + "]");
    }

    // Copies inputArray into another array
    // Precon: Initial values of inputArray not stored in ordered form another array
    // Post Initial values of inputArray stored in ordered form another array
    private int[] storesInitialArray(int[] inputArray) {
        return Arrays.copyOf(inputArray, inputArray.length);
    }

    // Displays array before Insertion Sort
    // Precon: Array not sorted before Insertion Sort
    // Postcon: Executes Insertion Sort on array
    private void displaysArrayBeforeSort(int[] inputArray) {
        displaysLine();
        displaysArray("Before Insertion Sort", inputArray);
    }

    // Displays array after Insertion Sort
    // Precon: Array is sorted via Insertion Sort
    // Postcon: Nil
    private void displaysArrayAfterSort(int[] inputArray, int[] initialArray) {
        displaysLine();
        displaysArray("After Insertion Sort", inputArray);
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

    // Executes Insertion Sort on inputArray
    // Precon: inputArray containing values user entered in order user entered has been created
    // Postcon: Values of inputArray are in increasing order after sorted via Insertion Sort.
    private void executesInsertionSort(int[] inputArray) {
        // 1. Start from 2nd element because comparison made
        // is based on all elements behind current element
        for (int i = 1; i < inputArray.length; i++) {
            int currentElement = inputArray[i];
            displaysLine();
            displaysArray("* before check, inputArray", inputArray);
            System.out.println();

            // j is iterator from first value to value before current value
            // Guaranteed j >= 0 because i >= 1
            int j = i - 1;
            
            // 2. While loop has 2 conditions
            // First condition is ensure loop stops at first element so that no array out of bounds exception thrown
            // Second condition is that there exists an element before current element 
            // that is > current element so that a swap can occur
            // While loop breaks if current index < 0 (hence first element reahed), 
            // or an current element <= currentElement
            while (j >= 0 && inputArray[j] > currentElement) {
                // 3. Shift element at index <= j to the right
                // Eg: Set element at index 2 to be element at index 1
                // Decrement j to proceed to element before j
                System.out.println("* currentElement: " + currentElement 
                                     + " | inputArray[" + j 
                                     + "]: " + inputArray[j] 
                                     + " >= " + currentElement 
                                     + " -----------------> shifting " + inputArray[j] 
                                     + " to the right by 1 spot..."
                );
                inputArray[j + 1] = inputArray[j--];
                displaysArray("* shift done. so far, inputArray", inputArray);
                System.out.println();
            } 
            
            inputArray[j + 1] = currentElement;
            displaysArray("* current iteration done. inputArray", inputArray);
        }
    }

    private void run() {
        int[] inputArray = formsArray();
        int[] initialArray = storesInitialArray(inputArray);
        displaysArrayBeforeSort(inputArray);
        executesInsertionSort(inputArray);
        displaysArrayAfterSort(inputArray, initialArray);
    }
    public static void main(String[] args) {
        InsertionSort obj = new InsertionSort();
        obj.run();
    }
}
