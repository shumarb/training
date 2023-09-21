import java.util.Scanner;

class Aaah {

    private String jon, doctor;

    private void readsString() {
        Scanner sc = new Scanner(System.in);
        jon = sc.next();
        doctor = sc.next();
    }

    private void displaysResult(boolean isResult) {
        if (isResult) {
            System.out.println("go");
        } else {
            System.out.println("no");
        }
    }

    private boolean computesResult() {
        return jon.length() >= doctor.length();
    }

    private void run() {
        readsString();
        boolean isResult = computesResult();
        displaysResult(isResult);    
    }

    public static void main(String[] args) {
        Aaah obj = new Aaah();
        obj.run();
    }
}

