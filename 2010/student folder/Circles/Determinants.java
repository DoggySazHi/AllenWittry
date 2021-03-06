 /*
  * review for IB Math
  */

 import java.text.DecimalFormat;
 import java.util.Arrays;

 public class Determinants {
     /*
      *   m is a square matrix of dimension > 1
      *
      *   returns the determinant of m
      *
      *   yes, you should not asume all matrices are 3x3, or even 4x4, or even 5x5
      *   you need to prepare for larger determinants, like 7 x 7 matrices
      *
      *   Oh yea - you should not assume all matrices are square matrices
      *            return 0 if the matrix is not a square matrix
      *
      *
      */

     // Who the hell at Oracle allowed this to happen?
     // I mean, I guess Neko Miko Reimu lyrics are here forever.
     public static double getDeterminant(double[][] neko) {
         if (neko.length != neko[0].length || !isRectangular(neko))
             return 0;
         if (neko.length == 1)
             return neko[0][0]; // Cute~~
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

     public static double dodgsonIdentity(double[][] neko) {
         if (neko.length != neko[0].length || !isRectangular(neko))
             return 0;
         // System.out.println("Original Mat");
         printMat(neko);
         double[][] tempA = neko;
         double[][] tempB = null;
         tempA = new double[neko.length - 1][neko[0].length - 1];
         calculateMinor(neko, tempA);
         while (neko.length != 1) {
             tempB = new double[tempA.length - 1][tempA[0].length - 1];
             calculateMinor(tempA, tempB);
             // System.out.println("First minor");
             printMat(tempA);
             // System.out.println("Second minor");
             printMat(tempB);
             for(int i = 0; i < tempB.length; i++)
                 for(int j = 0; j < tempB[0].length; j++)
                     tempB[i][j] /= neko[i + 1][j + 1];
             // System.out.println("Second minor after dividing");
             printMat(tempB);
             neko = tempA;
             tempA = tempB;
         }
         // System.out.println(neko[0][0]);
         return neko[0][0]; // Cute~~
     }

     public static double chiosMethod(double[][] neko) {
         if (neko.length != neko[0].length || !isRectangular(neko))
             return 0;
         // System.out.println("Original Mat");
         printMat(neko);
         var multiplier = 1.0;
         double[][] temp;
         do {
             var pivot = neko[neko.length - 1][neko[0].length - 1];
             // System.out.println("Pivot: " + convertDecimalToFraction(pivot));
             var frac = Math.pow(1.0/pivot, neko.length - 2);
             // System.out.println("Multiply by: " + convertDecimalToFraction(frac));
             multiplier *= frac;
             // System.out.println("Current multiplier: " + convertDecimalToFraction(multiplier));
             temp = new double[neko.length - 1][neko.length - 1];
             for(int i = 0; i < temp.length; i++)
                 for(int j = 0; j < temp[0].length; j++)
                     temp[i][j] = neko[i][j] * neko[neko.length - 1][neko[0].length - 1] - neko[i][neko[0].length - 1] * neko[neko.length - 1][j];
             // System.out.println("Matrix of Determinants (Minor-ish)");
             printMat(temp);
             neko = temp;
         } while (temp.length > 2);
         var determinant = multiplier * (neko[0][0] * neko[1][1] - neko[0][1] * neko[1][0]);
         // System.out.println("Determinant: " + convertDecimalToFraction(determinant));
         return determinant;
     }

     private static void calculateMinor(double[][] input, double[][] output) {
         for (int i = 0; i < input.length - 1; i++)
             for (int j = 0; j < input[0].length - 1; j++)
                 output[i][j] = (input[i][j] * input[i + 1][j + 1]) - (input[i + 1][j] * input[i][j + 1]);
     }

     public static double[][] getInverse(double[][] in) {
         var mat = new double[in.length][];
         for(int i = 0; i < in.length; i++)
             mat[i] = Arrays.copyOf(in[i], in[i].length);
         // System.out.println("Initial matrix: ");
         printMat(mat);
         if (mat.length != mat[0].length || !isRectangular(in)) {
             // System.err.println("Cannot find inverse of non-square matrix!");
             return null;
         }
         var determinant = getDeterminant(mat);
         // System.out.println("Determinant is " + determinant);
         if (determinant == 0) {
             // System.err.println("Matrix is singular!");
             return null;
         }

         int counter = 0;
         double[][] thing = null;
         double[][] finalMat = mat;
         var temp = new double[finalMat.length][finalMat[0].length];
         for (int idx = 0; idx < mat.length; idx++) {
             int bound = finalMat[0].length;
             for (int j = 0; j < bound; j++) {
                 double[][] ai = new double[finalMat.length - 1][finalMat.length - 1];
                 int a = 0;
                 for (int k = 0; k < finalMat.length; k++) {
                     if (k == idx)
                         continue;
                     int b = 0;
                     for (int l = 0; l < finalMat.length; l++) {
                         if (l != j)
                             ai[a][b++] = finalMat[k][l];
                     }
                     ++a;
                 }
                 // // System.out.println("Determinant of ");
                 // printMat(ai);
                 temp[idx][j] = getDeterminant(ai);
                 // // System.out.println("is " + temp[idx][j]);
                 // // System.out.println("Done " + ++counter + " determinants!");
             }
             thing = temp;
         }
         mat = thing;
         // System.out.println("Minors");
         printMat(mat);

         for(int i = 0; i < mat.length; i++)
             for(int j = 0; j < mat[0].length; j++)
                 mat[i][j] *= (((i + j) & 1) == 0) ? 1 : -1;

         // System.out.println("Cofactors");
         printMat(mat);

         temp = new double[mat.length][mat[0].length];

         for(int i = 0; i < mat.length; i++)
             for(int j = 0; j < mat[0].length; j++)
                 temp[i][j] = mat[j][i];
         mat = temp;

         // System.out.println("Adjugate");
         printMat(mat);

         for(int i = 0; i < mat.length; i++)
             for(int j = 0; j < mat[0].length; j++)
                 mat[i][j] /= determinant;

         // System.out.println("Final");
         printMat(mat);

         return mat;
     }

     public static boolean isRectangular(double[][] in) {
         var first = in[0].length;
         for (double[] doubles : in)
             if (first != doubles.length)
                 return false;
         return true;
     }

     public static double[][] cramer(double[][] in) {
         var mat = new double[in.length][];
         for(int i = 0; i < in.length; i++)
             mat[i] = Arrays.copyOf(in[i], in[i].length);
         // System.out.println("Initial matrix: ");
         printMat(mat);
         if (mat.length != mat[0].length - 1 || !isRectangular(in)) {
             // System.err.println("This is not a proper rectangular matrix!");
             return null;
         }
         var out = new double[in.length][1];
         var temp = new double[in.length][];
         for(int i = 0; i < in.length; i++)
             temp[i] = Arrays.copyOf(in[i], in[i].length - 1);
         var d = getDeterminant(temp);
         // System.out.println("Main determinant is " + d);
         if (d == 0) {
             // System.err.println("Matrix is singular!");
             return null;
         }
         for(int k = 1; k <= in.length; k++) {
             for(int i = 0; i < in.length; i++)
                 temp[i] = Arrays.copyOf(in[i], in[i].length - 1);
             for(int i = 0; i < in.length; i++)
                 temp[i][k - 1] = in[i][in[0].length - 1];
             var dd = getDeterminant(temp);
             // System.out.println("X" + k + " = " + convertDecimalToFraction(dd));
             out[k - 1][0] = dd;
         }
         // System.out.println("Output before dividing: ");
         printMat(out);
         for(int i = 0; i < out.length; i++)
             out[i][0] /= d;
         // System.out.println("Output after dividing: ");
         printMat(out);
         return out;
     }

     public static void main(String[] args) {
         /*

         dodgsonIdentity(new double[][] {

         });
         chiosMethod(new double[][] {
                 { , , },
                 { , , },
                 { , , }
         });
         getInverse(new double[][] {
                 { , , , },
                 { , , , },
                 { , , , },
                 { , , , }
         });
         cramer(new double[][] {
                 { , , , },
                 { , , , },
                 { , , , }
         });*/
         dodgsonIdentity(new double[][] {
                 {1,2,1,-1,2},
                 {1,-1,-2,-1,-1},
                 {2,1,-1,-2,-1},
                 {1,-2,-1,-1,2},
                 {2,-1,2,1,-3}
         });
     }

     private static void printMat(double[][] mat) {
         if (true)
             return;
         for(var a : mat) {
             for (var b : a)
                 System.out.print(convertDecimalToFraction(b) + " ");
             System.out.println();
         }
     }

     public static boolean isSingular(double[][] m) {
         return getDeterminant(m) == 0;
     }

     // stole this since i'm lazy lol
     static private String convertDecimalToFraction(double x){
         var decForm = new DecimalFormat("0.#");
         if (x < 0){
             return "-" + convertDecimalToFraction(-x);
         }
         double tolerance = 1.0E-6;
         double h1=1; double h2=0;
         double k1=0; double k2=1;
         double b = x;
         do {
             double a = Math.floor(b);
             double aux = h1; h1 = a*h1+h2; h2 = aux;
             aux = k1; k1 = a*k1+k2; k2 = aux;
             b = 1/(b-a);
         } while (Math.abs(x-h1/k1) > x*tolerance);

         if (k1 == 1)
             return decForm.format(h1);
         return decForm.format(h1)+"/"+decForm.format(k1);
     }
 }