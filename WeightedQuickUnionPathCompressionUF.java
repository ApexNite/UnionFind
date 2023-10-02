public class WeightedQuickUnionPathCompressionUF {
    private int[] id;
    private int[] sz;

    public WeightedQuickUnionPathCompressionUF(int N) {
        id = new int[N];
        sz = new int[N];

        for (int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    private int rootOnePass(int i) {
        while (i != id[i]) {
            id[i] = id[id[i]];
            i = id[i];
        }

        return i;
    }

    // Alternative to rootOnePass, similar performance 
    // private int rootTwoPass(int i) {
    //     int r = i;

    //     while (r != id[r]) {
    //         r = id[r];
    //     }

    //     while (id[i] != r) {
    //         id[i] = r;
    //     }

    //     return r;
    // }

    public boolean connected(int p, int q) {
        return rootOnePass(p) == rootOnePass(q);
    }

    public void union(int p, int q) {
        int i = rootOnePass(p);
        int j = rootOnePass(q);

        if (i == j) {
            return;
        }

        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }
    }
}
