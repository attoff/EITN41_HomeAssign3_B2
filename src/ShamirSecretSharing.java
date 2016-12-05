import sun.security.provider.SHA;

import java.math.BigInteger;


public class ShamirSecretSharing {
    private int k;
    private int n;
    private String polynomial;
    private int[] partialShares;
    private int[][] sharedResult;

    public ShamirSecretSharing(int k, int n, String polynomial, int[] partialShares, int[][] sharedResult) {
        this.k = k;
        this.n = n;
        this.polynomial = polynomial;
        this.partialShares = partialShares;
        this.sharedResult = sharedResult;
    }

    public void calculatePolynomial() {
        String[] splitted = polynomial.split("x\\^\\d+\\+?");
        for (String part : splitted) {
            partialShares[0] += Integer.valueOf(part);
        }

        for (int i : partialShares) {
            sharedResult[0][1] += i;
        }
    }

    public int calculateSecret() {
        double[] results = new double[k];

        for (int i = 0; i < results.length; i++) {
            int numerator = 1;
            int divider = 1;

            for (int j = 0; j < k; j++) {

                if (j != i) {
                    numerator *= sharedResult[j][0];
                    divider *= (sharedResult[j][0] - sharedResult[i][0]);
                }
            }
            results[i] = (numerator * sharedResult[i][1]) / divider;
        }

        double result = 0;
        for (double f : results) {
            result += f;
        }


        return (int) result;
    }


}
