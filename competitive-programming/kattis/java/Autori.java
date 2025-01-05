import java.util.Scanner;

class Autori {
    
    private String getsResult() {
        Scanner sc = new Scanner(System.in);
        String val = sc.next();
        sc.close();
        
        String ans = "";
        ans += val.charAt(0);
        for (int i = 1; i < val.length() - 1; i++) {
            char curr = val.charAt(i);
            if (curr == '-') {
                char next = val.charAt(i + 1);
                ans += next;
            }
        }
        return ans;
    }
    
    private void displaysResult(String ans) {
        System.out.println(ans);
    }
    
    private void run() {
        String ans = getsResult();
        displaysResult(ans);
    }
    
    public static void main(String[] args) {
        Autori obj = new Autori();
        obj.run();
    }
}
