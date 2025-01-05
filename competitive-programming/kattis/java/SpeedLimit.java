import java.util.Scanner;
import java.util.Vector;

class SpeedLimit {
    
    private boolean isTest = false;
    private Scanner sc = new Scanner(System.in);

    private void readsInputs(Vector <Pair> inputs, int n) {
        for (int i = 0; i < n; i++) {
            int speed = sc.nextInt();
            int time = sc.nextInt();
            Pair pair = new Pair(speed, time);
            inputs.add(pair);
        }
        if (isTest) {
            System.out.print("Inputs: ");
            displaysInputs(inputs);
        }
    }

    private void displaysInputs(Vector <Pair> inputs) {
        for (int i = 0; i < inputs.size(); i++) {
            System.out.print("(" + inputs.get(i).getsSpeed() + ", " + inputs.get(i).getsTime() + "), ");
        }
        System.out.println();
    }

    private void displaysDistance(int dist) {
        System.out.println(dist + " miles");
    }

    private int computesDistance(Vector <Pair> inputs) {
        Pair first = inputs.get(0);
        int totalDist = first.getsSpeed() * first.getsTime();
        int prevTime = first.getsTime();
        if (isTest) {
            System.out.println("totalDist = " + totalDist);
        }
        for (int i = 1; i < inputs.size(); i++) {
            Pair next = inputs.get(i);
            totalDist += (next.getsSpeed() * (next.getsTime() - prevTime));
            if (isTest) {
                System.out.println("So far, totalDist = " + totalDist);
            }
            prevTime = next.getsTime();
        }
        return totalDist;
    }

    private void run() {
        int n = sc.nextInt();
        while (n != -1) {
            Vector <Pair> inputs = new Vector <Pair> ();
            readsInputs(inputs, n);
            int distance = computesDistance(inputs);
            displaysDistance(distance);
            n = sc.nextInt();
        }
    }
    public static void main(String[] args) {
        SpeedLimit obj = new SpeedLimit();
        obj.run();
    }
}

class Pair {
    int _speed, _time;

    public Pair(int speed, int time) {
        this._speed = speed;
        this._time = time;
    }

    public int getsSpeed() {
        return this._speed;
    }

    public int getsTime() {
        return this._time;
    }
}
