import java.util.Arrays;
import java.util.Random;

class MergeSort {
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

    // Executes Merge Sort on inputArray
    // Precon: inputArray containing values user entered in order user entered has been created
    // Postcon: Values of inputArray are in increasing order after sorted via Merge Sort.
    private void executesMergeSort(int[] inputArray) {
        int inputLength = inputArray.length;
        // 1. No need to do Merge Sort on array wth 1 element or empty array
        if (inputLength < 2) {
            return;
        }
    
        displaysLine();
        displaysArray("* inputArray before Merge Sort", inputArray);

        // 2. Obtain index of middle element (midIndex) of inputArray
        // Split inputArray into 2 arrays: leftPartitionArray and rightPartitionArray
        // leftPartitionArray comprises of elements 0 to midIndex of inputArray
        // rightPartitionArray comprises of elements from midIndex + 1 to lastArrayIterator of inputArray
        // Note: copyOfRange range is [from, to), meaning [from, to - 1]
        int midIndex = inputLength / 2;
        int[] leftPartitionArray = Arrays.copyOfRange(inputArray, 0, midIndex);
        int[] rightPartitionArray = Arrays.copyOfRange(inputArray, midIndex, inputLength);
        displaysArray("* leftPartitionArray", leftPartitionArray);
        displaysArray("* righttHalfArray", rightPartitionArray);

        // 3. Execute Merge Sort on the left and right partitions
        executesMergeSort(leftPartitionArray);
        executesMergeSort(rightPartitionArray);

        // 4. Combine the sub-array,
        // and assign each element in the combined sub-array to
        // the corresponding index of the input array
        executesMerge(inputArray, leftPartitionArray, rightPartitionArray);
    }

    // Executes merge of values in array
    // Precon: Values of array are sorted but not in inputArray
    // Post: Displays inputArray after Merge Sort
    private void executesMerge(int[] inputArray, int[] leftPartitionArray, int[] rightPartitionArray) {
        int inputArrayIterator = 0;                                 
        int leftPartitionArrayIterator = 0;                         
        int leftPartitionArraySize = leftPartitionArray.length;
        int rightPartitionArrayIterator = 0;                        
        int rightPartitionArraySize = rightPartitionArray.length;

        while (leftPartitionArrayIterator < leftPartitionArraySize && rightPartitionArrayIterator < rightPartitionArraySize) {
            // 1. Compare i-th element of leftPartitionArray with j-th element of rightPartitionArray
            if (leftPartitionArray[leftPartitionArrayIterator] <= rightPartitionArray[rightPartitionArrayIterator]) {
                // 1.1. i-th element of leftPartitionArray <= j-th element of rightPartitionArray,
                // so add i-th element of leftPartitionArray to k-th index of inputArray
                // and increment both iterators to refer to next element
                inputArray[inputArrayIterator++] = leftPartitionArray[leftPartitionArrayIterator++];
            } else {
                // 1.2. j-th element of rightPartitionArray < j-th element of rightPartitionArray,
                // so add j-th element of rightPartitionArray to k-th index of inputArray
                // and increment both iterators to refer to next element
                inputArray[inputArrayIterator++] = rightPartitionArray[rightPartitionArrayIterator++];
            }
        }

        // 2. At this point, it is possible that >= 1 element from at most one of the arrays
        // was not added to inputArray at correct index,
        // so add these elements into inputArray at correct index if it has not been done
        while (leftPartitionArrayIterator < leftPartitionArraySize) {
            inputArray[inputArrayIterator++] = leftPartitionArray[leftPartitionArrayIterator++];
        }

        while (rightPartitionArrayIterator < rightPartitionArraySize) {
            inputArray[inputArrayIterator++] = rightPartitionArray[rightPartitionArrayIterator++];
        }
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

    // Displays array for checking
    // Precon: inputArray split into 2 arrays of near-equal/equal length
    // Postcon: Executes Merge Sort
    private void displaysArray(String firstPartString, int[] subArray) {
        System.out.print(firstPartString + ": [");
        for (int i = 0; i < subArray.length - 1; i++) {
            System.out.print(subArray[i] + " ");
        }
        System.out.println(subArray[subArray.length - 1] + "]");
    }

    // Displays array before Merge Sort
    // Precon: Array not sorted before Merge Sort
    // Postcon: Executes Merge Sort on array
    private void displaysArrayBeforeSort(int[] inputArray) {
        displaysLine();
        displaysArray("Before Merge Sort", inputArray);
    }

    // Displays array after Merge Sort
    // Precon: Array is sorted via Merge Sort
    // Postcon: Nil
    private void displaysArrayAfterSort(int[] inputArray, int[] initialArray) {
        displaysLine();
        displaysArray("After Merge Sort", inputArray);
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

    private void run() {
        int[] inputArray = formsArray();
        int[] initialArray = storesInitialArray(inputArray);
        displaysArrayBeforeSort(inputArray);
        executesMergeSort(inputArray);
        displaysArrayAfterSort(inputArray, initialArray);
    }
    public static void main(String[] args) {
        MergeSort obj = new MergeSort();
        obj.run();
    }
}
