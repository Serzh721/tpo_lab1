package main;

public class ArcsinCalculator {
    public double arcsin(double x, double eps) {
        if (Math.abs(x) > 1.0)
            return Double.NaN;
        double res = 0.0;
        double prev_res = 1.0;

        for (int n = 0; Math.abs(res - prev_res) > eps; n++) {
            prev_res = res;
            res += ((Math.pow(x, 2 * n + 1) * fact(2 * n)) / (Math.pow(4, n) * fact(n) * fact(n) * (2 * n + 1)));
        }
        return res;
    }

    private static double fact(int f) {
        if (f <= 1)
            return 1.0;
        else
            return f * fact(f - 1);
    }
}