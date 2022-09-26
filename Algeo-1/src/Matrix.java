

import java.util.Scanner;



public class Matrix {

    /* Atribut Matrix */
    double[][] matrix;
    int rows;
    int cols;
    double epsilon = 0.000000001d;

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
        for(i=0; i< rows; i++){
            for(j=0; j< cols; j++){
                System.out.println("Masukkan nilai untuk baris ke-" + (i+1) + " kolom ke-" + (j+1) + ": ");
                ElType = input.nextDouble();
                this.matrix[i][j] = ElType;
            }
        }
    }

    // public void readMatrixTXT(String file){
    // }

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
        for (i = 0; i < this.rows; i++) {
            for (j = 0; j < this.cols; j++) {
                mOut.matrix[i][j] = this.matrix[i][j];
            }
        }
        for(i=this.rows; i<mOut.rows; i++){
            for(j=this.cols; j<mOut.cols; j++){
                mOut.matrix[i][j] = 0;
            }
        }
        return mOut;
    }

    /*Mengecek apakah pada row  */
    public boolean isRowsZero(int i){
        boolean rowsZero = true;
        
        int j;
        for(j=0; j<this.cols; j++){
            if(this.matrix[i][j] != 0){
                return false;
            }
        }
        return rowsZero;
    }

    public boolean isColsZero(int j){
        boolean colsZero = true;
        
        int i;
        for(i=0; i<this.rows; i++){
            if(this.matrix[i][j] != 0){
                return false;
            }
        }
        return colsZero;
    }

    public boolean isAtLeastRowZero(){
        int i;
        for(i = 0; i < this.rows; i++){
            if(isRowsZero(i)){
                return true;
            }
        }
        return false;
    }

    public boolean isAtLeastColZero(){
        int i;
        for(i = 0; i < this.cols; i++){
            if(isColsZero(i)){
                return true;
            }
        }
        return false;
    }

    public boolean isZero(double value, double threshold){
        return value >= -threshold && value <= threshold;
    }

    public void corrZero(){
        int i,j;
        for(i = 0; i < this.rows; i++){
            for(j = 0; j < this.cols; j++){
                if(isZero(this.matrix[i][j], epsilon)){
                    this.matrix[i][j] = 0;
                }
            }
        }
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
    

    public void gauss(){
        
        //Inget bentuk augmented
        

        if(isMatriksNol()){
            Boolean allZero = true;
            System.out.println("Nilai semua elemen 0, masukan input yang valid!\n");
            while(allZero){
                readMatrixCLI(this.rows, this.cols);
                if(!isMatriksNol()){
                    allZero=false;
                }
            }
        }

        
        int i,j,colNotZero;

        /* Cek elemen [0][0] apakah nilai 0 jika iya swap dengan baris lain */   
        if(firstZeroInRow(0) == 0){
            swapWithZeroRow(0, 0);

        }
        
        OBE(0);

        // Apakah dijamin kebentuk matriks segitiga(kalo gaada baris 0 semua)??

        /* Membuat menjadi nilai 1 di kolom palinng kiri non 0 di baris */
        for(i = 0; i < this.rows; i++){{
            if(firstNonZeroInRow(i) != -1 && firstNonZeroInRow(i) != this.cols-1){
                divideRow(i, this.matrix[i][firstNonZeroInRow(i)]);
            }
        }}

        /* Udah didapat matriks eselon augmented */   
        
        
    }

    public void gaussJordan(){
        gauss();

        System.out.println("Penyulihan Jordan");

        int i,notZero,j;
        double pengali;
        for(i = this.rows-1; i >= 0; i--){
            if(firstNonZeroInRow(i) != -1 && firstNonZeroInRow(i) != this.cols-1){ //tidak boleh mbagi kolom augment paling kanan 
                for(j = i-1; j >= 0; j--){
                    if(this.matrix[j][firstNonZeroInRow(i)] != 0){
                        pengali = this.matrix[j][firstNonZeroInRow(i)]/this.matrix[i][firstNonZeroInRow(i)];
                        addMultiplyRow(j, i, (-1)*pengali);
                        System.out.printf("\nKurangi baris ke-%d dengan %f kali baris ke-%d\n", (j+1), pengali , (i+1));
                        displayMatrix();
                        System.out.println();

                    }
                }
            }
        }

        

        System.out.println("Hasil Gauss-Jordan:\n");
        displayMatrix();
    }


    /*  Operasi OBE */

    public void addMultiplyRow (int row1, int row2, double n ) {
        /* Menambahkan suatu baris awal row1 dengan kelipatan n dari baris row2  */
        int i;
        for(i = 0; i < this.cols; i++){
            this.matrix[row1][i] += this.matrix[row2][i] * n;
            if(isZero(this.matrix[row1][i], epsilon)){
                this.matrix[row1][i] = 0;
            }
        }
    }

    public void swapRow(int row1, int row2){
        /* Menukarkan 2 baris */
        int i;
        double temp;
        for(i=0; i<this.cols; i++){
            temp = this.matrix[row1][i];
            this.matrix[row1][i] = this.matrix[row2][i];
            this.matrix[row2][i] = temp;
        }
    }

    public void divideRow(int row, Double n){
        /* Membagi baris dengan suatu bilangan n */
        int i;
        for( i = 0 ; i < this.cols; i++){
            this.matrix[row][i] /= n;
        }
        corrZero();
        System.out.printf("Bagi setiap elemen di baris ke-%d dengan %.2f\n", (row+1), n);
        displayMatrix();
        System.out.println();
    }


    
    public void OBE(int a){ //input a = 0 sebagai awal

        /* Prekondisi : Baris pertama matriks bukan baris nol, atau baris pertama merupakan baris dengan nilai non nol terkiri yang ada di matriks, solusinya pake swap matrix */
        

        /* Matriks akan dioperasikan sehingga menjadi segitiga atas */
        int i,colNotZero,j;
        double pengali;
        
        // REkurens
        if(a < this.rows){ //soalnya gaboleh operasiin paling kanan
            colNotZero = firstNonZeroInRow(a);
            if(colNotZero != -1 && colNotZero != this.cols){
                for(i=a+1; i<this.rows; i++){

                    // for(j = a; j < this.rows; j++){
    
                    // }
    
                    // System.out.println("Oke");
                    if(this.matrix[i][colNotZero] != 0){
                        pengali = this.matrix[i][colNotZero] / this.matrix[a][colNotZero];
                        addMultiplyRow(i,a, (-1)*pengali);
                        System.out.printf("\nKurangi baris ke-%d dengan %f kali baris ke-%d\n", (i+1), pengali , (colNotZero+1));
                        displayMatrix();
                        System.out.println();
                    }
    
                    
                }
            }

            if(colNotZero == this.cols){
                swapDown(a);
                OBE(a);
            }
            
            //REkursyi
            else{
                OBE(a+1);
            }
            
        }      
    
    
    }


    public int firstZeroInRow(int i){
        /* Mengembalikan nilai indeks pertama elemen 0 pada baris */
        
        int j;
        for(j = 0; j < this.cols; j++){
            if (isZero(this.matrix[i][j], epsilon)){
                return j;
            } 
        }
        return -1; /* Kasus tidak ditemukan nilai 0 maka return -1 */
    }

    public int firstNonZeroInRow(int i){
        /* Mengembalikan nilai indeks pertama elemen non 0 pada baris */
        
        int j;
        for(j = 0; j < this.cols; j++){
            
            if (!isZero(this.matrix[i][j], epsilon)){

                return j;
                
            } 
        }
        return -1; /* Kasus tidak ditemukan nilai selain 0 maka return -1 */
    }

    public void swapWithZeroRow(int i ,int j){ // i buat nandain baris yang mau diswap utama dan j buat indeks kolom yang bernilai 0
        /* Prekondisu sudah diketahui bahwa elemen i j bernilai 0 sehingga harus diswap agar tidak menimbulkan Nan atau Infinity */
        int init = i;
        int k;
         //Kasus penanganan buat swap baris [0]
            for(k = i; k < this.rows ; k++){
                if(firstZeroInRow(k) > firstZeroInRow(i) || firstZeroInRow(k) == -1 ){
                    swapRow(k, i);
                    i = k; // Buat pembanding nyari yang paling kiri
                }
            }
            
        if(init != i){ //Nampilinn kalo ada pertukaran aja
            System.out.printf("Tukar baris ke-%d dengan baris ke-%d\n", (init+1),(i+1));
        displayMatrix();
        }
        
        
    }

    public boolean isMatriksNol(){
        /* Mengecek appakah semua elemen nol */
        int i,j;
        for(i = 0; i < this.rows; i++){
            for(j = 0; j < this.cols; j++){
                if(this.matrix[i][j] != 0){
                    return false;
                }
            }
        }
        return true;
    }

    public void swapDown(int i){
        int j;
        int last  = i;

        for(j = this.rows-1; j > i ; j--){
            if(isRowAugZero(j) ){
                swapRow(i, j);
                last = j;
            }
        }
        if (last != i){
            System.out.printf("Tukar baris ke-%d dan baris ke-%d\n", i, last);
        }
        
    }

    public boolean isRowAugZero(int i){
        int j;
        for(j = 0; j < this.cols-1; j++){
            if(this.matrix[i][j] != 0){
                return false;
            }
        }
        return true;
    }

    public void inverseOBE(){
        /* Prekondisi matriks adalah persegi */

        if(isAtLeastRowZero() || isAtLeastColZero()){
            System.out.println("Salah satu baris atau kolom bernilai 0 semua, determinan : 0\n");
        }
        else {
            double det = 0;
            if(firstZeroInRow(0) == 0){
                swapWithZeroRow(0, 0);
                det = -1;
            }
            
            Matrix invMat = extendMatrix(0, this.cols);
            
            int i,j;
            for(i = 0; i < invMat.rows ; i++){
                invMat.matrix[i][this.cols+i] = 1;
                
            }

            System.out.println("Metode Matriks Balikan OBE :");
            invMat.displayMatrix();

            invMat.gaussJordan();

            if(!invMat.isInverseUrut()){
                
                for(i = 0; i < this.rows; i++){
                    if(isZero(invMat.matrix[i][i], epsilon) ){
                        for(j = i+1; j < this.rows; j++){
                            if(!isZero(invMat.matrix[j][i], epsilon) ){
                                invMat.swapRow(i, j);
                                System.out.printf("\nBaris ke-%d ditukar dengan baris ke-%d\n", i,j);
                                invMat.displayMatrix();
                            }
                        }
                    }
                }

            }

            Matrix invMatAkhir = copyMatrix();
            
            /* Mengopi sisi kanan dari matriks balikan ke matriks balikan baru */

            for(i = 0; i < this.rows; i++){
                for(j = 0; j < this.cols; j++){
                    invMatAkhir.matrix[i][j] = invMat.matrix[i][j+this.cols];
                }
            }

            System.out.println("\nDidapatkan Matriks Balikan :");
            invMatAkhir.displayMatrix();
            

            }
            
            

        
        

    }

    public boolean isInverseUrut(){
        int i;
        for(i = 0; i < this.rows; i++){
            if(isZero(this.matrix[i][i], epsilon)){
                return false;
            }
        }
        return true;
    }


    public void

}

