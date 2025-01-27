class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap();
        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        boolean hasOdd = false;
        int length = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            length += (entry.getValue() / 2) * 2;
            if (entry.getValue() % 2 == 1) {
                hasOdd = true;
            } 
        }
        return hasOdd ? length + 1 : length;
    }
}

// basically count every chars and divide by 2, then multiple by 2
// if has odd number of chars => add 1

// aaabbb => abbba