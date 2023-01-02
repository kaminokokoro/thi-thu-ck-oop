package trapezoidalrule.trapezoidalrule;

public class TrapezoidalRule {
    public static void main(String[] args) {
        /* TODO */
        System.out.println(integrate());
    }

    public static double f(double x) {
        /* TODO */
        return (Math.sin(x) * Math.sin(x) * Math.cos(x));
    }

    public static double integrate(int n) {
        double a = 0;
        double b = Math.PI / 2;
        double h = (b - a) / n;
        double result = 0;
        for (int i = 0; i <= n; i++) {
            double x = a + i * h;
            if (i == 0 || i == n) {
                result += f(x) / 2;
            } else {
                result += f(x);
            }
        }
        result = result * h;
        return result;
        /* TODO */
    }

    public static double integrate() {
        /* TODO */
        int n = 2;
        while (Math.abs(integrate(2 * n) - integrate(n)) >= 0.000001) {
            n *= 2;
        }
        return integrate(n);
    }
}