import java.util.Scanner;

public class Coba {
    int rows,cols;
    double[][] Matrix;

    public Matrix(int nRows, int nCols){
        this.rows = nRows;
        this.cols = nCols;
        this.matrix = new double[nRows][nCols];
    }

    public static void main(String[] args) {
        int i,j;
        double ElType;
        Scanner input = new Scanner(System.in);
        this.rows = rows;
        this.cols = cols;
        for(i=0; i<= rows; i++){
            for(j=0; j<=cols; j++){
                System.out.println("Masukkan nilai untuk baris ke-" + (i+1) + " kolom ke-" + (j+1) + ": ");
                ElType = input.nextDouble();
                this.matrix[i][j] = ElType;
            }
        }
    }
}
