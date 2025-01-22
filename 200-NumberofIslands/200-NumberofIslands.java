class Solution {
    public class Cell {
        public int x;
        public int y;
        public Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        int result = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    bfsSearch(grid, i, j, visited);
                    result++;
                }
            }
        }

        return result;
    }

    public void bfsSearch(char[][] grid, int startX, int startY, boolean[][] visited) {
        int[] deltaX = new int[]{ -1, 0, 1, 0 };
        int[] deltaY = new int[] { 0, 1, 0, -1 };
        
        Queue<Cell> queue = new ArrayDeque();
        queue.add(new Cell(startX, startY));
        visited[startX][startY] = true;

        while(!queue.isEmpty()) {
            Cell cell = queue.poll();
            for(int i = 0; i < 4; i++) {
                int newX = cell.x + deltaX[i];
                int newY = cell.y + deltaY[i];
                if (isIsland(grid, newX, newY, visited)) {
                    queue.add(new Cell(newX, newY));
                    visited[newX][newY] = true;
                }
            }
        }
    }

    private boolean isIsland(char[][] grid, int x, int y, boolean[][] visited) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && !visited[x][y] && grid[x][y] == '1';
    }
}