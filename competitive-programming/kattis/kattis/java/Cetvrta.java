import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Scanner;

class Cetvrta {
    
    private boolean isTest = false;

    private void readsCoordinates(int[] coordinates) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < coordinates.length; i++) {
            coordinates[i] = sc.nextInt();
        }
        if (isTest) {
            System.out.print("Coordinates: ");
            for (int i = 0; i < coordinates.length; i += 2) {
                System.out.print("(" + coordinates[i] + ", " + coordinates[i + 1] + "), ");
            }
            System.out.println();
        }
        sc.close();
    }

    private int computesNumOccurrences(HashMap <Integer, Integer> numOccurrences, int[] coordinates, int start) {
        for (int i = start; i < coordinates.length; i += 2) {
            if (numOccurrences.containsKey(coordinates[i]) == false) {
                numOccurrences.put(coordinates[i], 1);
            } else {
                numOccurrences.put(coordinates[i], numOccurrences.get(coordinates[i]) + 1);
            }
        }
        if (isTest) {
            System.out.println("numOccurrences: " + numOccurrences);
        }
        Set numSet = numOccurrences.keySet();
        if (isTest) {
            System.out.println("numSet: " + numSet);
        }
        Iterator iter = numSet.iterator();
        while (iter.hasNext()) {
            Integer num = (Integer) iter.next();
            Integer val = (Integer) numOccurrences.get(num);
            if (isTest) {
                System.out.println(num + " --> " + val);
            }
            if (val.intValue() == 1) {
                return num.intValue();
            }
        }
        return 0;
    }

    private void displaysCoordinates(int x, int y) {
        System.out.println(x + " " + y);
    }

    private void clearsNumOccurrences(HashMap <Integer, Integer> numOccurrences) {
        numOccurrences.clear();
    }

    private void run() {
        int[] coordinates = new int[6];
        readsCoordinates(coordinates);
        HashMap <Integer, Integer> numOccurrences = new HashMap <Integer, Integer> ();
        int xCoord = computesNumOccurrences(numOccurrences, coordinates, 0);
        clearsNumOccurrences(numOccurrences);
        int yCoord = computesNumOccurrences(numOccurrences, coordinates, 1);
        displaysCoordinates(xCoord, yCoord);
    }

    public static void main(String[] args) {
        Cetvrta obj = new Cetvrta();
        obj.run();
    }
}
