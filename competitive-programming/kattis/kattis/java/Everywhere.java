import java.util.HashSet;
import java.util.Scanner;

class Everywhere {
    
    private Scanner sc = new Scanner(System.in);

    private int readsT() {
        int T = sc.nextInt();
        return T;
    }
    
    private void displaysAns(int ans) {
        System.out.println(ans);
    }
    
    private int processesQuery() {
        int Q = sc.nextInt();
        HashSet <String> distinctCities = new HashSet <String> ();
        for (int i = 0; i < Q; i++) {
            String city = sc.next();
            if (!distinctCities.contains(city)) {
                distinctCities.add(city);
            }
        }
        return distinctCities.size();
    }
    
    private void run() {
        int T = readsT();
        for (int i = 0; i < T; i++) {
            int ans = processesQuery();
            displaysAns(ans);
        }
    }
    
    public static void main(String[] args) {
        Everywhere obj = new Everywhere();
        obj.run();
    }    
}