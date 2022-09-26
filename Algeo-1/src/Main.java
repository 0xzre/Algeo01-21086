

import java.util.Scanner;
import java.util.Arrays;
import java.lang.Math;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        // Matrix m = new Matrix(3,3);
        // m.readMatrixCLI(m.rows,m.cols);
        // System.out.println("\nTerbentuk Matriks :");
        // m.displayMatrix();
        // System.out.println("");
        // m.determinanOBE();;





        /* Interpolasi di main asyik */
        // int n;
        // Scanner input = new Scanner(System.in);
        // n = input.nextInt();
        // double[] solusiInterpolasi = new double[n];
     

        // int i,j;
        // Matrix xy = new Matrix(n, 2);
        // for(i = 0; i < n; i++){
        //     xy.matrix[i][0] = input.nextDouble();
        //     xy.matrix[i][1] = input.nextDouble();

        // }

        // Matrix m = new Matrix(n, n+1);

        // for(i = 0; i < m.rows; i++){
        //     for(j = 0; j < m.cols-1; j++){
        //         m.matrix[i][j] = Math.pow(xy.matrix[i][0], j);
        //     }
        //     m.matrix[i][m.cols-1] = xy.matrix[i][1];
        // }
        // System.out.printf("\nMatriks koefisien persamaan derajat %d :\n", n);
        // m.displayMatrix();

        // m.gaussJordan();

        // for(i = 0; i < n; i++){
        //     solusiInterpolasi[i] = m.matrix[i][m.cols-1];
        // }

        // System.out.printf("\nSolusi SPL f(x) = ");

        // System.out.printf("%f ", solusiInterpolasi[0]);
        
        // if (n >= 2){
        //     System.out.printf("+ %fx ", solusiInterpolasi[1]);
        // }

        // if ( n >= 3){
        //     for(i = 2; i < n; i++){
        //         System.out.printf(" + %fx^%d ", solusiInterpolasi[i],i);
        //     }
        // }
        // System.out.println();

        // System.out.printf("Masukan nilai x yang akan ditaksir : ");
        // double xTaksir = input.nextDouble();
        
        // double sum = 0;

        // for(i = 0; i < n ; i++){
        //     sum += solusiInterpolasi[i] * Math.pow(xTaksir, i);
        // }

        // System.out.printf("\nHasil interpolasi f(%f) = %f\n", xTaksir, sum);
        
        



        

        /* Bicubic  */
        // Matrix m = new Matrix(4, 4);
        // Matrix matX = new Matrix(16, 16);
        // Matrix a = new Matrix(4, 4);
        // int i,j,k,l;
        // double u,v,sum = 0;
        // Scanner input = new Scanner(System.in);
        // for(i = 0; i < 4; i++){
        //     for(j = 0; j < 4; j++){
        //         m.matrix[i][j] = input.nextDouble();
        //     }
        // }

        // u = input.nextDouble();
        // v = input.nextDouble();

        // for(i = 0 ; i < 4; i++){
        //     for(j = 0 ; j < 4; j++){
        //         for(k = 0; k < 4; k++){
        //             for(l = 0; l < 4; l++){
        //                 matX.matrix[(i)*4 +(j)][(k)*4 +(l)] = Math.pow((j -1 ),l )*Math.pow(i -1, k);
        //             }
        //         }
        //     }
        // }
        
        // Matrix matXAkhir = matX.extendMatrix(0, 1);

        // for(i = 0 ; i < 4; i++){
        //     for(j = 0 ; j < 4; j++){
        //     matXAkhir.matrix[i*4 + j][16] = m.matrix[i][j];
        //     }
        // }

        // matXAkhir.gaussJordan();

        // for(i = 0 ; i < 4; i++){
        //     for(j = 0 ; j < 4; j++){
        //     a.matrix[j][i] = matXAkhir.matrix[i*4 + j][16];
        //     }
        // }

        // for(i = 0 ; i < 4; i++){
        //     for(j = 0 ; j < 4; j++){
        //         sum += a.matrix[j][i] * Math.pow(u, j) * Math.pow(v, i);
        //     }
        // }

        // System.out.printf("\nMaka f(%f,%f) = %f",u,v,sum);
    }
}