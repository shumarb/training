
import java.util.Arrays;
import java.util.Random;

class BubbleSort {
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
    // Postcon: Executes Bubble Sort
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

    // Displays array before Bubble Sort
    // Precon: Array not sorted before Bubble Sort
    // Postcon: Executes Bubble Sort on array
    private void displaysArrayBeforeSort(int[] inputArray) {
        displaysLine();
        displaysArray("Before Bubble Sort", inputArray);
        displaysLine();
    }

    // Displays array after Bubble Sort
    // Precon: Array is sorted via Bubble Sort
    // Postcon: Nil
    private void displaysArrayAfterSort(int[] inputArray, int[] initialArray) {
        displaysArray("After Bubble Sort", inputArray);
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

    // Swaps elements in array with one another
    // Precon: Bubble Sort in progress
    // Postcon: Continue Bubble Sort
    private void swapsElements(int[] inputArray, int firstIndex, int secondIndex) {
        int temp = inputArray[firstIndex];
        inputArray[firstIndex] = inputArray[secondIndex];
        inputArray[secondIndex] = temp; 
    }

    // Executes Bubble Sort on inputArray
    // Precon: inputArray containing values user entered in order user entered has been created
    // Postcon: Values of inputArray are in increasing order after sorted via Bubble Sort
    private void executesBubbleSort(int[] inputArray) {
        boolean isArraySorted = false;
        while (!isArraySorted) {
            isArraySorted = true;
            for (int i = 0; i < inputArray.length - 1; i++) {
                displaysArray(("* Iteration " + (i + 1) + "\n* Before check, inputArray").toString(), inputArray);
                if (inputArray[i] > inputArray[i + 1]) {
                    // A swap is required, so array is not sorted so far
                    isArraySorted = false;
                    System.out.println("* Swap: (Index: " + i 
                                        + ", element: " + inputArray[i] 
                                        + ") <--------> (Index " + (i + 1) 
                                        + " | element: " + inputArray[i + 1] + ")"
                    );
                    swapsElements(inputArray, i, i + 1);
                }

                // At this stage, if isArraySorted == true, no swap occurred after iterating all elements in 1 pass,
                // hence elements are sorted in increasing order, so no need to check elements any more
                displaysArray("* End of current iteration, inputArray", inputArray);
                displaysLine();
            }
        }
    }

    private void run() {
        int[] inputArray = formsArray();
        int[] initialArray = storesInitialArray(inputArray);
        displaysArrayBeforeSort(inputArray);
        executesBubbleSort(inputArray);
        displaysArrayAfterSort(inputArray, initialArray);
    }
    public static void main(String[] args) {
        BubbleSort obj = new BubbleSort();
        obj.run();
    }
}
