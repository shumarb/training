import java.util.Random;

class LinearSearch {
    private Random myRandom = new Random();

    // Forms array
    // Precon: No inputArray
    // Postcon: inputArray contains >= 1 element
    private int[] formsArray() {
        int arraySize = myRandom.nextInt(5, 12);
        int[] inputArray = new int[arraySize];
        for (int i = 0; i < inputArray.length; i++) {
            inputArray[i] = myRandom.nextInt(-10, 10);
        }
        return inputArray;
    }

    // Executes Linear Search
    // Precon: inputArray has >= 1 elements
    // Postcon: End of program
    private void executesLinearSearch(int[] inputArray) {
        boolean isFound = false;
        int targetNumber = myRandom.nextInt(-10, 10);
        int targetNumberIndex = 0;

        displaysLine();
        System.out.print("inputArray: [");
        displaysInputArray(inputArray);

        for (int i = 0; i < inputArray.length; i++) {
            displaysLine();
            System.out.println("* Iteration " + (i + 1));
            System.out.print("** inputArray: [");
            displaysInputArray(inputArray);
            System.out.println("** Target Number: " + targetNumber 
                                + " | inputArray[" + i 
                                + "]: " + inputArray[i]
            );

            if (inputArray[i] == targetNumber) {
                targetNumberIndex = i;
                isFound = true;
                break;
            }
        }

        if (isFound) {
            displaysLine();
            System.out.println("Outcome: Found. | Target Number of " 
                                + targetNumber + " found at index " 
                                + targetNumberIndex
            );
            displaysLine();
        } else {
            displaysLine();
            System.out.println("Outcome: " + targetNumber + " not found.");
            displaysLine();
        }
    }

    // Displays line
    // Precon: Nil
    // Postcon: Nil
    private void displaysLine() {
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
    }

    // Displays input array
    // Precon: inputArray has >= 1 element
    // Postcon: Nil
    private void displaysInputArray(int[] inputArray) {
        for (int i = 0; i <inputArray.length - 1; i++) {
            System.out.print(inputArray[i] + " ");
        }
        System.out.println(inputArray[inputArray.length - 1] + "]");
    }

    private void run() {
        int[] inputArray = formsArray();
        executesLinearSearch(inputArray);

    }
    public static void main(String[] args) {
        LinearSearch obj = new LinearSearch();
        obj.run();
    }
}