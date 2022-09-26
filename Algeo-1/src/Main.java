

import java.util.Scanner;
import java.util.Arrays;
import java.lang.Math;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        Matrix m = new Matrix(3,3);
        m.readMatrixCLI(m.rows,m.cols);
        System.out.println("\nTerbentuk Matriks :");
        m.displayMatrix();
        System.out.println("");
        m.inverseOBE();
    }
}