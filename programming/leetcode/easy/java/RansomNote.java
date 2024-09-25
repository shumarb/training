class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<String, Integer> map = new HashMap<> ();
        for (int i = 0; i < magazine.length(); i++) {
            String letter = Character.toString(magazine.charAt(i));
            if (!map.containsKey(letter)) {
                map.put(letter, 1);
            } else {
                map.put(letter, 1 + map.get(letter));
            }
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            String letter = Character.toString(ransomNote.charAt(i));
            if (!map.containsKey(letter)) {
                return false;
            } else {
                if (map.get(letter) == 0) {
                    return false;
                } else {
                    map.put(letter, map.get(letter) - 1);
                }
            }
        }
        return true;
    }
}
