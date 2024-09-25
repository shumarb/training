class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<> ();

        for (char c: magazine.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c: ransomNote.toCharArray()) {
            // If a character c in ransom note is not present in magazine,
            // or character is present but number of characters available to use is 0
            // the ransom note can't be formed frmo magazine
            if (!map.containsKey(c) || map.get(c) <= 0) {
                return false;
            }

            // A character c is in magazine
            // and can be used to form a ransom note, so reduce number of available characters c
            // in magazine by 1
            map.put(c, map.get(c) - 1);
        }

        return true;
    }
}
