class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int maxLength = 0;
        for (int start = 0; start < s.length(); start++) {
            Set<Character> checkedLetters = new HashSet<> ();
            int currentLength = 0;
            for (int end = start; end < s.length(); end++) {
                char letter = s.charAt(end);
                // Longest substring that starts at index start
                // and has unique characters has been formed
                if (checkedLetters.contains(letter)) {
                    break;
                }
                checkedLetters.add(letter);
                currentLength++;
                maxLength = Math.max(maxLength, currentLength);
            }
        }

        return maxLength;
    }
}
