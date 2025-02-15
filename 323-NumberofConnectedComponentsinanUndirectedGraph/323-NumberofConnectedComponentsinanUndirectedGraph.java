class Solution {

    private int[] father;
    private int count;

    private int find(int x) {
        if (father[x] == x) {
            return x;
        }

        // path compression
        father[x] = find(father[x]);
        return father[x];
    }

    private void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            father[rootX] = father[rootY];
            count--;
        }
    }

    public int countComponents(int n, int[][] edges) {
        count = n; // count of connected components

        father = new int[n];
        // initialize union find
        for(int i = 0; i < n; i++) {
            father[i] = i;
        }

        for(int[] operation : edges) {
            union(operation[0], operation[1]);
        }

        return count;
    }
}