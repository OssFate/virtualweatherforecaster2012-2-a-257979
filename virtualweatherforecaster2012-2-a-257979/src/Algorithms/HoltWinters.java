/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms;

/**
 *
 * @author Juan Pablo
 */
public class HoltWinters extends weatherAlgorithms{

    /**
* This method is the entry point. It calculates the initial values and
* returns the forecast for the future m periods.
*
* @param y - Time series data.
* @param alpha - Exponential smoothing coefficients for level, trend,
* seasonal components.
* @param beta - Exponential smoothing coefficients for level, trend,
* seasonal components.
* @param gamma - Exponential smoothing coefficients for level, trend,
* seasonal components.
* @param perdiod - A complete season's data consists of L periods. And we need
* to estimate the trend factor from one period to the next. To
* accomplish this, it is advisable to use two complete seasons;
* that is, 2L periods.
* @param m - Extrapolated future data points.
* - 4 quarterly,
* - 7 weekly,
* - 12 monthly
*
* @param debug - Print debug values. Useful for testing.
*
*/
    
    public  double[] forecast(int period, int m, boolean debug) {
        
        double alpha = 0.5;
        double beta = 0.5;
        double gamma = 0.5;
        int seasons = At.length / period;
        
        double a0 = calculateInitialLevel(At);
        double b0 = calculateInitialTrend(At, period);
        double[] initialSeasonalIndices = calculateSeasonalIndices(At, period,
                seasons);

        

        double[] forecast = calculateHoltWinters(At, a0, b0, alpha, beta, gamma,
                initialSeasonalIndices, period, m, debug); 

        return forecast;
    }

    public double[] forecast(double alpha, double beta, double gamma, int period, int m) {
        return forecast(At, alpha, beta, gamma, period, m, false);
    }

   

    /**
* This method realizes the Holt-Winters equations.

*/
    public double[] calculateHoltWinters(At, double a0, double b0,
            double alpha, double beta, double gamma,
            double[] initialSeasonalIndices, int period, int m, boolean debug) {

        double[] St = new double[At.length];
        double[] Bt = new double[At.length];
        double[] It = new double[At.length];
        double[] Ft = new double[At.length + m];

        // Initialize base values
        St[1] = a0;
        Bt[1] = b0;

        for (int i = 0; i < period; i++) {
            It[i] = initialSeasonalIndices[i];
        }

        // Start calculations
        for (int i = 2; i < y.length; i++) {

            // Calculate overall smoothing
            if ((i - period) >= 0) {
                St[i] = alpha * y[i] / It[i - period] + (1.0 - alpha)
                        * (St[i - 1] + Bt[i - 1]);
            } else {
                St[i] = alpha * y[i] + (1.0 - alpha) * (St[i - 1] + Bt[i - 1]);
            }

            // Calculate trend smoothing
            Bt[i] = gamma * (St[i] - St[i - 1]) + (1 - gamma) * Bt[i - 1];

            // Calculate seasonal smoothing
            if ((i - period) >= 0) {
                It[i] = beta * y[i] / St[i] + (1.0 - beta) * It[i - period];
            }

            // Calculate forecast
            if (((i + m) >= period)) {
                Ft[i + m] = (St[i] + (m * Bt[i])) * It[i - period + m];
            }

            if (debug) {
                System.out.println(String.format(
                        "i = %d, y = %d, S = %f, Bt = %f, It = %f, F = %f", i,
                        y[i], St[i], Bt[i], It[i], Ft[i]));
            }
        }

        return Ft;
    }

    /**
* See: http://robjhyndman.com/researchtips/hw-initialization/ 1st period's
* average can be taken. But y[0] works better.
*
* @return - Initial Level value i.e. St[1]
*/
    private double calculateInitialLevel(At) {
        return At[0];
    }

    /**
* See: http://www.itl.nist.gov/div898/handbook/pmc/section4/pmc435.htm
*
* @return - Initial trend - Bt[1]
*/
    private static double calculateInitialTrend(long[] y, int period) {

        double sum = 0;

        for (int i = 0; i < period; i++) {
            sum += (y[period + i] - y[i]);
        }

        return sum / (period * period);
    }

    /**
* See: http://www.itl.nist.gov/div898/handbook/pmc/section4/pmc435.htm
*
* @return - Seasonal Indices.
*/
    private double[] calculateSeasonalIndices(At, int period,
            int seasons) {

        double[] seasonalAverage = new double[seasons];
        double[] seasonalIndices = new double[period];

        double[] averagedObservations = new double[At.length];

        for (int i = 0; i < seasons; i++) {
            for (int j = 0; j < period; j++) {
                seasonalAverage[i] += At[(i * period) + j];
            }
            seasonalAverage[i] /= period;
        }

        for (int i = 0; i < seasons; i++) {
            for (int j = 0; j < period; j++) {
                averagedObservations[(i * period) + j] = At[(i * period) + j]
                        / seasonalAverage[i];
            }
        }

        for (int i = 0; i < period; i++) {
            for (int j = 0; j < seasons; j++) {
                seasonalIndices[i] += averagedObservations[(j * period) + i];
            }
            seasonalIndices[i] /= seasons;
        }

        return seasonalIndices;
    }
}

