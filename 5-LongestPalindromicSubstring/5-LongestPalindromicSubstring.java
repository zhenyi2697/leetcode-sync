class Solution {
    public String longestPalindrome(String s) {
        int start = 0;
        int end = 0;

        for(int i = 0; i < s.length(); i++) {
            // odd center
            int oddLength = expand(i, i, s);
            if (oddLength > end - start + 1) {
                int dist = oddLength / 2;
                start = i - dist;
                end = i + dist;
            }

            // even center
            int evenLength = expand(i, i+1, s);
            if (evenLength > end - start + 1) {
                int dist = (evenLength / 2) - 1;
                start = i - dist;
                end = i + dist + 1;
            }
        }

        return s.substring(start, end + 1);
    }

    // return the lenght of the palindrome
    private int expand(int start, int end, String s) {
        int i = start, j = end;
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return j - i - 1;
    }
}

// for each index => expand from middle and check if equal
// need to check both odd and even number for the middle