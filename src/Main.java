/**
 * Created by vikto on 2016-11-28.
 */
public class Main {

    public static void main(String[] args) {

        int k = 4;
        int n = 6;

        int[] shared = new int[n];
        int[][] result = new int[k][2];

        shared[0] = 0;
        shared[1] = 63;
        shared[2] = 49;
        shared[3] = 49;
        shared[4] = 54;
        shared[5] = 43;
        //shared[6] = 54;
        //shared[7] = 43;

        result[0][0] = 1;
        result[0][1] = 0;
        result[1][0] = 3;
        result[1][1] = 2199;
        result[2][0] = 4;
        result[2][1] = 4389;
        result[3][0] = 6;
        result[3][1] = 12585;
        //result[4][0] = 7;
        //result[4][1] = 256422;

        String polynomial = "20x^1+11x^2+6x^3+20";

        ShamirSecretSharing sss = new ShamirSecretSharing(k, n, polynomial, shared, result);
        sss.calculatePolynomial();
        System.out.println(sss.calculateSecret());

    }
}
