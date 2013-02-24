
public class Percolation {

    private final int N;
    private WeightedQuickUnionUF perculateModel;
    private WeightedQuickUnionUF fullModel;
    private boolean[] opens;

    /** create N-by-N grid, with all sites blocked */
    public Percolation(int N) {
        this.N = N;
        int size = N * N + 2;
        perculateModel = new WeightedQuickUnionUF(size);
        fullModel = new WeightedQuickUnionUF(size - 1); 
        opens = new boolean[size];
        opens[0] = true;
        opens[size - 1] = true;
    }

    /** open site (row i, column j) if it is not already */
    public void open(int i, int j) {
        checkRange(i, j);

        int ind = indexOf(i, j);

        if (opens[ind]) {
            return;
        }

        opens[ind] = true;

        // connect top block
        int topInd = Math.max(0, ind - N);
        if (opens[topInd]) {
            perculateModel.union(ind, topInd);
            fullModel.union(ind, topInd);
        }

        // connect bottom block
        int bottomInd = Math.min(N * N + 1, ind + N);
        if (opens[bottomInd]) {
            perculateModel.union(ind, bottomInd);
            if (i != N) {
                fullModel.union(ind, bottomInd);
            }
        }

        // connect left block
        if (j != 1 && opens[ind - 1]) {
            perculateModel.union(ind, ind - 1);
            fullModel.union(ind, ind - 1);
        }

        // connect right block
        if (j != N && opens[ind + 1]) {
            perculateModel.union(ind, ind + 1);
            fullModel.union(ind, ind + 1);
        }
    }

    /** is site (row i, column j) open? */
    public boolean isOpen(int i, int j) {
        checkRange(i, j);
        return opens[indexOf(i, j)];
    }

    /** is site (row i, column j) full? */
    public boolean isFull(int i, int j) {
        checkRange(i, j);
        int ind = indexOf(i, j);
        return opens[ind] && fullModel.connected(0, ind);
    }

    /** does the system percolate? */
    public boolean percolates() {
        return perculateModel.connected(0, N * N + 1);
    }

    private void checkRange(int i, int j) {
        if (i < 1 || i > N || j < 1 || j > N) {
            throw new IndexOutOfBoundsException();
        }
    }

    private int indexOf(int i, int j) {
        return (i - 1) * N + j;
    }

    /*
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (isFull(i, j)) {
                    sb.append("F");
                } else if (isOpen(i, j)) {
                    sb.append("O");
                } else {
                    sb.append("B");
                }
                sb.append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        Percolation perc = new Percolation(5);
        perc.open(1, 1);
        perc.open(2, 2);
        perc.open(3, 3);
        perc.open(4, 4);
        perc.open(5, 5);
        perc.open(1, 5);
        perc.open(2, 4);
        perc.open(2, 3);
        perc.open(1, 3);
        perc.open(4, 5);
        perc.open(4, 3);
        perc.open(2, 5);
        perc.open(3, 5);
        perc.open(5, 3);
        perc.open(4, 1);
        perc.open(5, 1);
        System.out.println(perc);
    }
    */

}
