class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charToNextIndex = new HashMap();
        int maxLength = 0;
        int i = 0;
        for(int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            if (charToNextIndex.containsKey(c)) {
                i = Math.max(charToNextIndex.get(c), i);
            }
            maxLength = Math.max(maxLength, j - i + 1);
            charToNextIndex.put(c, j + 1);
        }
        return maxLength;
    }
}