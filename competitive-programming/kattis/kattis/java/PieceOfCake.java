import java.util.Scanner;

class PieceOfCake {

    private boolean isTest = false;

    // Method reads in 3 values from user
    // length of sides of cake, distance of horizontal cut from top edge of cake,
    // and distance of vertical cut from left edge of cake
    // Precon: values array is empty
    // Postcon values array contains 3 values entered from user
    private void readsValues(int[] values) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < values.length; i++) {
            int value = sc.nextInt();
            values[i] = value;
        }
        
        if (isTest) {
            System.out.print("values: ");
            for (int i = 0; i < values.length; i++) {
                System.out.print(values[i] + " ");
            }
            System.out.println();
        }
        sc.close();
    }

    // Method computes largest volume of cake
    // Precon: readsValeus method has been executed
    // Postcon: Largest volume of cake computes
    private int computesLargestVolume(int[] values) {
        int[] volumes = new int[4];
        int l = values[0], h = values[1], v = values[2], t = 4, largest;
        volumes[0] = h * v * t;
        volumes[1] = (l - v) * h * t;
        volumes[2] = (l - h) * (l - v) * t;
        volumes[3] = (l - h) * v * t;
        if (isTest) {
            System.out.print("volumes: ");
            for (int i = 0; i < volumes.length; i++) {
                System.out.print(volumes[i] + " ");
            }
            System.out.println();
        }

        // Obtain largest volume
        largest = volumes[0];
        for (int i = 1; i < volumes.length; i++) {
            if (volumes[i] > largest) {
                largest = volumes[i];
            }
        }
        return largest;
    }

    // Method displays largest volume of largest cake
    // Precon: computesLargestVolume method has been executed
    // Postcon: Nil
    private void displaysLargestVolume(int largestVolume) {
        System.out.println(largestVolume);
    }

    private void run() {
        int[] values = new int[3];
        int largestVolume;
        readsValues(values);
        largestVolume = computesLargestVolume(values);
        displaysLargestVolume(largestVolume);
    }
    
    public static void main(String[] args) {
        Cake obj = new Cake();
        obj.run();
    }
}
