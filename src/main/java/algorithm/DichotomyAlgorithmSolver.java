package algorithm;
import java.util.List;

/**
 * Dichotomy algorithm solver.
 * Find root
 * */

public class DichotomyAlgorithmSolver {

    private double intervalA;
    private double intervalB;
    private List<Double> coefficients;
    private double solution;
    private double accuracyEpsilon;


    public DichotomyAlgorithmSolver(double intervalA,
                                    double intervalB,
                                    List<Double> coefficients,
                                    double solution,
                                    double accuracyEpsilon) {
        this.intervalA = intervalA;
        this.intervalB = intervalB;
        this.coefficients = coefficients;
        this.solution = solution;
        this.accuracyEpsilon = accuracyEpsilon;
    }

    /**
     * find root
     * */

    public double getResult() {
        double result = 0.0;

        if (equationFormula(intervalA) == 0) return intervalA;
        if (equationFormula(intervalB) == 0) return intervalB;
        while (Math.abs(equationFormula(intervalB) - equationFormula(intervalA)) > accuracyEpsilon) {
            result = (intervalB + intervalA) / 2;
            if (equationFormula(result) == 0 || Math.abs(equationFormula(result)) < accuracyEpsilon) break;

            if (equationFormula(intervalA) * equationFormula(result) > 0)
                intervalA = result;
            else
                intervalB = result;
        }
        return result;
    }

    /**
     * insert in formula
     * */
    private double equationFormula(double x) {
        return coefficients.get(0) * Math.pow(x, 3) +
                coefficients.get(1) * Math.pow(x, 2) +
                coefficients.get(2) * x +
                coefficients.get(3) - solution;
    }

}





