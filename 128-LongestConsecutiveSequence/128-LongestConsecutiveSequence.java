class Solution {

    private Map<Integer, Integer> fatherMap = new HashMap();
    private Map<Integer, Integer> sizeMap = new HashMap();
    private int longest = 0;

    public int find(int x) {
        if (fatherMap.get(x) == x) {
            return fatherMap.get(x);
        }

        // path compression
        fatherMap.put(x, find(fatherMap.get(x)));

        return fatherMap.get(x);
    }

    public void union(int x, int y) {
        int fatherX = find(x);
        int fatherY = find(y);
        if (fatherX != fatherY) {
            fatherMap.put(fatherX, fatherY);
            sizeMap.put(fatherY, sizeMap.get(fatherY) + sizeMap.get(fatherX));
        }
    }

    public int longestConsecutive(int[] nums) {
        // initiaize union found
        for(int n : nums) {
            fatherMap.put(n, n);
            sizeMap.put(n, 1);
        }

        for(int n : nums) {
            if (fatherMap.containsKey(n-1)) {
                union(n, n-1);
            } else if (fatherMap.containsKey(n+1)) {
                union(n, n+1);
            }
            
            longest = Math.max(longest, sizeMap.get(find(n)));
        }

        return longest;
    }
}

// initiaize father array and point to itself

// for each of the element
// if there is element-1, union them
// if not, if there is element+1, union them
// continue next
// after each union => count the number of element in the union & maintain a max value of it

// father map can be a Map<Integer, Integer> for each existing elements
// can avoid the set