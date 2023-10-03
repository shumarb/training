import java.util.Arrays;
import java.util.Random;

class BinarySearch {
    private Random rand = new Random();

    // Forms array
    // Precon: Array not instantiated
    // Postcon: Array of a random size created, and it contains a random set of nubmers
    private int[] formsArray() {
        int inputArraySize = rand.nextInt(7, 12);
        int[] inputArray = new int[inputArraySize];
        for (int i = 0; i < inputArray.length; i++) {
            inputArray[i] = rand.nextInt(-10, 10);
        }
        Arrays.sort(inputArray);
        return inputArray;
    }

    // Displays line
    // Precon: Nil
    // Postcon: Nil
    private void displaysLine() {
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
    }

    // Displays array
    // Precon: Program is executing binary search
    // Postcon: Nil
    private void displaysArray(int[] inputArray) {
        System.out.print("** inputArray: [");
        for (int i = 0; i < inputArray.length - 1; i++) {
            System.out.print(inputArray[i] + " ");
        }
        System.out.println(inputArray[inputArray.length - 1] + "]");
    }

    // Executes Binary Search
    // Precon: Number to find not defined
    // Poston: Prints out if number to find has been found in array
    private void executesBinarySearch(int[] inputArray) {
        displaysLine();
        boolean isTargetFound = false;
        // lowIndex represents index of element <= middle index of array
        // highIndex represents index of element > middle index of array 
        int highIndex = inputArray.length - 1;
        int indexOfTargetNumber = 0;
        int lowIndex = 0;
        int numberOfIterations = 1;
        int targetNumber = rand.nextInt(-5, 5);
        while (lowIndex <= highIndex) {
            int midIndex = (highIndex + lowIndex) / 2;
            int middleElement = inputArray[midIndex];
            System.out.println("* Iteration #" + numberOfIterations++);
            displaysArray(inputArray);
            System.out.println("** lowIndex: " + lowIndex + ", middleIndex: " + midIndex + ", highIndex: " + highIndex);
            System.out.println("** targetNumber: " + targetNumber + ", middleElement: " + middleElement);
            if (middleElement == targetNumber) {
                indexOfTargetNumber = midIndex;
                isTargetFound = true;
                break;
            } else {
                if (middleElement < targetNumber) {
                    // currentElement < targetNumber
                    // hence ignore all elements <= middleElement
                    // by setting the low index to be index after middle index
                    lowIndex = midIndex + 1;
                    System.out.println("*** Ignore all elements both after and inclusive of index" + midIndex
                                        + ", next iteration start at index " + (lowIndex)
                    );
                } else {
                    // currentElement >= targetNumber
                    // hence ignore all elements > middleElement
                    // by setting the high index to be the index after middle index
                    highIndex = midIndex - 1;
                    System.out.println("*** Ignore all elements both after and inclusive of index " + midIndex
                                        + ", next iteration start at index " + (highIndex)
                    );
                }
            }
            displaysLine();
        }

        if (isTargetFound) {
            displaysLine();
            System.out.println("* Outcome: Found. TargetNumber: " + targetNumber 
                                + " | inputArray[" + indexOfTargetNumber
                                + "]: " + inputArray[indexOfTargetNumber]
            );
        } else {
            System.out.println("Outcome: " + targetNumber + " not found.");
        }
        displaysLine();
    }
    
    private void run() {
        int[] inputArray = formsArray();
        executesBinarySearch(inputArray);
    }

    public static void main(String[] args) {
        BinarySearch obj = new BinarySearch();
        obj.run();
    }
}
