import java.util.Arrays;
import java.util.Random;

class SelectionSort {
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
    // Postcon: Executes Selection Sort
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

    // Displays array before Selection Sort
    // Precon: Array not sorted before Selection Sort
    // Postcon: Executes Selection Sort on array
    private void displaysArrayBeforeSort(int[] inputArray) {
        displaysLine();
        displaysArray("Before Selection Sort", inputArray);
        displaysLine();
    }

    // Displays array after Selection Sort
    // Precon: Array is sorted via Selection Sort
    // Postcon: Nil
    private void displaysArrayAfterSort(int[] inputArray, int[] initialArray) {
        displaysArray("After Selection Sort", inputArray);
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
    // Precon: Selection Sort in progress
    // Postcon: Continue Selection Sort
    private void swapsElements(int[] inputArray, int firstIndex, int secondIndex) {
        int temp = inputArray[firstIndex];
        inputArray[firstIndex] = inputArray[secondIndex];
        inputArray[secondIndex] = temp; 
    }

    // Executes Selection Sort on array
    // Precon: inputArray containing values user entered in order user entered has been created
    // Postcon: Values of inputArray are in increasing order after sorted via Selection Sort.
    private void executesSelectionSort(int[] inputArray) {
        for (int startIndex = 0; startIndex < inputArray.length - 1; startIndex++) {
            boolean isSorted = true;
            System.out.println("* Iteration #" + (startIndex + 1));
            displaysArray("* Starting at (Index " + startIndex + ": " + inputArray[startIndex] + ") | inputArray before check", inputArray);
            
            // 2. Check if an element < any element after the element
            for (int nextIndex = startIndex + 1; nextIndex < inputArray.length; nextIndex++) {
                if (inputArray[nextIndex] < inputArray[startIndex]) {
                    System.out.println("* Swap: (Index " + startIndex + ": " 
                                 + inputArray[startIndex] + ") <------> (Index " 
                                 + (nextIndex) + ": " 
                                 + inputArray[nextIndex] 
                                 + ")"
                    );
                    // A swap occurs, so array is not sorted in increasing order
                    isSorted = false;
                    swapsElements(inputArray, nextIndex, startIndex);
                }
            }
            displaysArray("* End of iteration #" + (startIndex + 1) + ", current inputArray", inputArray);

            // 3. If isSorted is true, no swaps occured after traversing entire array
            // hence array is sorted in increasing order so exit loop
            if (isSorted) {
                break;
            }
            displaysLine();
        }
    }

    private void run() {
        int[] inputArray = formsArray();
        int[] initialArray = storesInitialArray(inputArray);
        displaysArrayBeforeSort(inputArray);
        executesSelectionSort(inputArray);
        displaysArrayAfterSort(inputArray, initialArray);
    }
    public static void main(String[] args) {
        SelectionSort obj = new SelectionSort();
        obj.run();
    }
}
