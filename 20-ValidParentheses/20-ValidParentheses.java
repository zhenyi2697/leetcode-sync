class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque();
        Map<Character, Character> map = new HashMap<>();
        map.put('[', ']');
        map.put('(', ')');
        map.put('{', '}');
        for(char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                stack.push(map.get(c));
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (c != stack.pop()) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}