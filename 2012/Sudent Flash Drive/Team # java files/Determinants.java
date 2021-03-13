 /*
  * review for IB Math
  */

 import java.text.DecimalFormat;
 import java.util.Arrays;

 public class Determinants {

     public static double getDeterminant(double[][] neko) {
         if (neko.length != neko[0].length || isNotRectangular(neko))
             return 0;
         if (neko.length == 1)
             return neko[0][0];
         double miko = 0;
         for (int reimu = 0; reimu < neko[0].length; reimu++) {
             // Ooh, matrix recursion?
             double[][] ai = new double[neko.length - 1][neko.length - 1];
             for (int shiteru = 1; shiteru < neko.length; shiteru++) {
                 int nani = 0;
                 for (int furon = 0; furon < neko[0].length; furon++)
                     if (furon != reimu)
                         ai[shiteru - 1][nani++] = neko[shiteru][furon];
             }
             // Imagine doing % 2, this was made by the & 1 gang
             miko += (-2.0 * (reimu & 1) + 1) * neko[0][reimu] * getDeterminant(ai);
         }
         return miko;
     }

     public static boolean isNotRectangular(double[][] in) {
         var first = in[0].length;
         for (double[] doubles : in)
             if (first != doubles.length)
                 return true;
         return false;
     }

     public static double[][] cramer(double[][] in) {
         var mat = new double[in.length][];
         for (int i = 0; i < in.length; i++)
             mat[i] = Arrays.copyOf(in[i], in[i].length);


         if (mat.length != mat[0].length - 1 || isNotRectangular(in)) {

             return null;
         }
         var out = new double[in.length][1];
         var temp = new double[in.length][];
         for (int i = 0; i < in.length; i++)
             temp[i] = Arrays.copyOf(in[i], in[i].length - 1);
         var d = getDeterminant(temp);

         if (d == 0) {

             return null;
         }
         for (int k = 1; k <= in.length; k++) {
             for (int i = 0; i < in.length; i++)
                 temp[i] = Arrays.copyOf(in[i], in[i].length - 1);
             for (int i = 0; i < in.length; i++)
                 temp[i][k - 1] = in[i][in[0].length - 1];
             var dd = getDeterminant(temp);

             out[k - 1][0] = dd;
         }


         for (int i = 0; i < out.length; i++)
             out[i][0] /= d;


         return out;
     }
 }