class Solution {
    
    public boolean isPalindrome(int x) {
        boolean isTest = false;
        String strX = Integer.toString(x);
        int j = strX.length() - 1;
        for (int i = 0; i < strX.length() - 1; i++) {
            if (isTest) {
                System.out.println("compare: " + strX.charAt(i) + " vs " + strX.charAt(j));
            }
            if (strX.charAt(i) != strX.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}
