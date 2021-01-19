class Solution {
    public static int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int[][] edges = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {//边赋值
                edges[i][j] = Math.abs(points[i][1] - points[j][1]) + Math.abs(points[i][0] - points[j][0]);

            }
        }
        UnionFind uf = new UnionFind(n);
        int ans = 0, count = 0;//ans代表结果 count代表连通的边数
        while(count < n) {
            int i = findMin(edges)[0];
            int j = findMin(edges)[1];
            if(uf.union(i, j) == 1) {
                //count++;
                ans += edges[i][j];
            }
            count++;
            edges[i][j] = Integer.MAX_VALUE;
        }

        return ans;



    }
    public static int[] findMin(int[][] edges) {
        int n = edges.length;
        int min = Integer.MAX_VALUE;
        int[] minIJ = new int [2];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(edges[i][j] < min) {
                    minIJ[0] = i;
                    minIJ[1] = j;
                    min = edges[i][j];
                }

            }
        }
        return minIJ;
    }

    static class UnionFind {
        private int[] parent;
        private int[] rank;
        public UnionFind(int n) {
            parent = new int [n];
            rank = new int [n];
            for(int i = 0; i < n; i++) {
                rank[i] = 1;
                parent[i] = i;
            }
        }

        public int union (int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if(rootX == rootY) {
                return 0;
            }
            if(rank[rootX] == rank[rootY]) {
                parent[rootX] = rootY;
                rank[rootY]++;
            } else if(rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
            }
            return 1;
        }

        public int find(int x) {
            if(x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
    }

    public static void main(String[] args) {
        int[][] prob = {{1,1}, {2, 2}, {3, 4}};
        System.out.println(minCostConnectPoints(prob));
    }
}