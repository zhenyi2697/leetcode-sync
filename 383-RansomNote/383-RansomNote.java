class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (magazine.length() < ransomNote.length()) {
            return false;
        }

        int[] charFreq = new int[26];
        Arrays.fill(charFreq, 0);
        for(char c : magazine.toCharArray()) {
            charFreq[c-'a']++;
        }

        for(char c : ransomNote.toCharArray()) {
            if (charFreq[c-'a'] <= 0) {
                return false;
            } else {
                charFreq[c-'a']--;   
            }
        }

        return true;
    }
}