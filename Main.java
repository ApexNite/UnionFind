class Main {
    public static void main(String[] args) {
        WeightedQuickUnionPathCompressionUF UnionFind = new WeightedQuickUnionPathCompressionUF(10);

        UnionFind.union(6, 8);
        UnionFind.union(7, 1);
        UnionFind.union(1, 8);
        UnionFind.union(6, 5);
        UnionFind.union(0, 3);
        UnionFind.union(5, 6);
        UnionFind.union(9, 4);
        UnionFind.union(2, 6);

        System.out.println(UnionFind.connected(1, 6) == true);
        System.out.println(UnionFind.connected(5, 1) == true);
        System.out.println(UnionFind.connected(9, 6) == false);
        System.out.println(UnionFind.connected(3, 4) == false);
        System.out.println(UnionFind.connected(7, 2) == true);
    }
}