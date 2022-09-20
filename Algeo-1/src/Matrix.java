import java.util.Scanner;

public class Matrix {
    double[][] matrix;
    int rows;
    int cols;

    public static void main(String[] args) {System.out.println("COBA"); }

    /* KONSTRUKTOR */
    public Matrix(int nRows, int nCols){
        this.rows = nRows;
        this.cols = nCols;
        this.matrix = new double[nRows][nCols];
    }

    /* PRIMITIF */
    public void readMatrixCLI(int rows, int cols){
        int i,j;
        double ElType;
        Scanner input = new Scanner(System.in);
        this.rows = rows;
        this.cols = cols;
        for(i=0; i<= rows; i++){
            for(j=0; j<=cols; j++){
                System.out.println("Masukkan nilai untuk baris ke-" + i+1 + " kolom ke-" + j+1 + ": ");
                ElType = input.nextDouble();
                this.matrix[i][j] = ElType;
            }
        }
    }

    public void readMatrixTXT(String file){
    }

    public void displayMatrix(){
        int i, j;
        for(i=0;i<this.rows;i++){
            for(j=0;j<this.cols;j++){
                System.out.printf("%f ", this.matrix[i][j]);
            }
            System.out.println();
        }
    }

    public void createMatrix(int rows, int cols){
        int i, j;
        Scanner input = new Scanner(System.in);
        for(i=0; i<this.rows; i++){
            for(j=0; j<this.cols; j++){
                this.matrix[i][j] = 0;
            }
        }
    }

    public Matrix copyMatrix(){
        Matrix mOut = new Matrix(this.rows, this.cols);
        int i, j;
        mOut.rows = this.rows;
        mOut.cols = this.cols;
        for(i=0; i<this.rows; i++){
            for(j=0; j<this.cols; j++){
                mOut.matrix[i][j] = this.matrix[i][j];
            }
        }
        return mOut;
    }

    public Matrix extendMatrix(int nRows, int nCols){
        Matrix mOut = new Matrix(this.rows + nRows, this.cols + nCols);
        int i, j;
        mOut = copyMatrix();
        for(i=this.rows; i<mOut.rows; i++){
            for(j=this.cols; j<mOut.cols; j++){
                mOut.matrix[i][j] = 0;
            }
        }
        return mOut;
    }

    public boolean isRowsZero(){
        boolean rowsZero = false;
        boolean cek = true;
        int i, j ;
        for(i=0; i<this.rows; i++){
            for(j=0; j<this.cols; j++){
                if(this.matrix[i][j] != 0 ){
                    cek = false;
                }
            }
            if(cek == true){
                return true;
            }
            cek = true;
        }
        return rowsZero;
    }

    public boolean isColsZero(){
        boolean colsZero = false;
        boolean cek = true;
        int i, j;
        for(j=0; j<this.cols; j++){
            for(i=0; i<this.rows; i++){
                if(this.matrix[i][j] != 0){
                    cek = false;
                }
            }
            if(cek == true){
                return true;
            }
            cek = true;
        }
        return colsZero;
    }

    public boolean isSegitigaAtas() {
        boolean cek = true;
        int i, j;
        if (this.rows < 2 || this.cols < 2) {
            return false;
        } else {
            for (i = 1; i < this.rows; i++) {
                for (j = 0; j < i; j++) {
                    if (this.matrix[i][j] != 0) {
                        cek = false;
                    }
                }
            }
        }
        return cek;
    }


        /* PRIMITIF UNTUK GAUSS */
        public void swapRow(int row1, int row2){
            int i;
            double temp;
            for(i=0; i<this.cols; i++){
                temp = this.matrix[row1][i];
                this.matrix[row1][i] = this.matrix[row2][i];
                this.matrix[row2][i] = temp;
            }
        }
    }

