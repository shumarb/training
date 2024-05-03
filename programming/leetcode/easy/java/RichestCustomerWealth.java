class Solution {
    public int maximumWealth(int[][] accounts) {
        int wealth = 0;
        for (int j = 0; j < accounts[0].length; j++) {
            wealth += accounts[0][j];
        }

        for (int i = 1; i < accounts.length; i++) {
            int newWealth = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                newWealth += accounts[i][j];
            }
            wealth = Math.max(wealth, newWealth);
        }
        return wealth;
    }
}
