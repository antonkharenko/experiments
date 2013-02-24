
public class PercolationStats {

    private double mean;
    private double stddev;
    private double confidenceLo;
    private double confidenceHi;

    /** perform T independent computational experiments on an N-by-N grid */
    public PercolationStats(int N, int T) {
        if (N <= 0 || T <= 0) {
            throw new IllegalArgumentException();
        }

        double[] x = new double[T];
        for (int i = 0; i < T; i++) {
            Percolation perc = new Percolation(N);
            int openBlocks = 0;
            while (!perc.percolates()) {
                int row = randomGridIndex(N);
                int col = randomGridIndex(N);
                if (!perc.isOpen(row, col)) {
                    perc.open(row, col);
                    openBlocks++;
                }
            }
            x[i] = openBlocks / (double) (N * N);
        }

        mean = StdStats.mean(x);
        stddev = StdStats.stddev(x);
        double confidenceDiff = 1.96 * stddev / Math.sqrt(T);
        confidenceLo = mean - confidenceDiff;
        confidenceHi = mean + 1.96 * stddev / Math.sqrt(T);
    }

    private int randomGridIndex(int N) {
        return 1 + (int) (N * StdRandom.random());
    }

    /** sample mean of percolation threshold */
    public double mean() {
        return mean;
    }

    /** sample standard deviation of percolation threshold */
    public double stddev() {
        return stddev;
    }

    /** returns lower bound of the 95% confidence interval */
    public double confidenceLo() {
        return confidenceLo;
    }

    /** returns upper bound of the 95% confidence interval */
    public double confidenceHi() {
        return confidenceHi;
    }

    /** test client, described below */
    public static void main(String[] args) {
        if (args.length > 1) {
            int N = Integer.valueOf(args[0]);
            int T = Integer.valueOf(args[1]);

            PercolationStats stats = new PercolationStats(N, T);

            System.out.println("mean = " + stats.mean());
            System.out.println("stddev = " + stats.stddev());
            System.out.println("95% confidence interval = "
                    + stats.confidenceLo() + ", " + stats.confidenceHi());

        }
    }
}
