import java.util.Scanner;

class Apaxians {
    
    private String readsName() {
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        sc.close();
        return name;
    }
    
    private void displaysCompactName(String compactName) {
        System.out.println(compactName);
    }
    
    private String getsCompactName(String name) {
        String compactName = "";
        compactName += name.charAt(0); // Add first character to compact name
        for (int i = 1; i < name.length(); i++) {
            char currChar = name.charAt(i);
            char prevChar = name.charAt(i - 1);
            if (currChar != prevChar) {
                compactName += currChar;
            }
        }
        return compactName;
    }
    
    private void run() {
        String name = readsName();
        String compactName = getsCompactName(name);
        displaysCompactName(compactName);
    }
    
    public static void main(String[] args) {
        Apaxians obj = new Apaxians();
        obj.run();
    }
}
