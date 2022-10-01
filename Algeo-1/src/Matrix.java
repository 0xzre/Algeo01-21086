import java.util.*;
import java.io.*;

public class Matrix {

    /* ATRIBUT MATRIX */
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
    public void readMatrixCLI(int rows, int cols){ // MEMBACA MASUKAN MATRIX VIA CLI
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

    public void readMatrixFILE(String FileName){ // MEMBACA MASUKAN MATRIX VIA FILE (.txt)
        try{
            int i,j;
            int nRows=0, nCols=0;
            String dir = "../test/input/" + FileName;
            File file = new File(dir);
            Scanner input = new Scanner(file);
            while(input.hasNextLine()){
                nRows ++;
                input.nextLine();
            }
            input.close();
            input = new Scanner(file);
            Scanner num = new Scanner(input.nextLine());
            while(num.hasNextDouble()){
                nCols ++;
                num.nextDouble();
            }
            num.close();
            input.close();
            input = new Scanner(file);
            this.rows = nRows;
            this.cols = nCols;
            matrix = new double[nRows][nCols];
            for(i=0; i<nRows; i++){
                for(j=0; j<nCols; j++){
                    this.matrix[i][j] = input.nextDouble();
                }
            }
            input.close();
            System.out.println("Matriks (file:"+FileName+") berhasil dibaca.");
        }catch(FileNotFoundException e){
            System.out.println("File tidak ditemukan.");
        }
    }

    public void displayMatrix(){ // MENCETAK MATRIX KE LAYAR
        int i, j;
        for(i=0;i<this.rows;i++){
            for(j=0;j<this.cols;j++){
                System.out.printf("%f ", this.matrix[i][j]);
            }
            System.out.println();
        }
    }

    public void createMatrix(int rows, int cols){ // MEMBENTUK MATRIX DENGAN MASUKAN nROWS dan nCOLS
        int i, j;
        for(i=0; i<this.rows; i++){
            for(j=0; j<this.cols; j++){
                this.matrix[i][j] = 0;
            }
        }
    }

    public Matrix copyMatrix(){ // MENYALIN ISI SEBUAH MATRIX
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

    public Matrix extendMatrix(int nRows, int nCols){ // MEMPERBESAR UKURAN MATRIX
        Matrix mOut = new Matrix(this.rows + nRows, this.cols + nCols);
        int i, j;
        if(this.rows <= mOut.rows && this.cols <= mOut.cols ){
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
        }
        else{
            for (i = 0; i < mOut.rows; i++) {
                for (j = 0; j < mOut.cols; j++) {
                    mOut.matrix[i][j] = this.matrix[i][j];
                }
            }
        }
        return mOut;
    }

    public boolean isRowsZero(int i){ // MENGECEK APAKAH SEBUAH BARIS BERISI 0
        boolean rowsZero = true;
        int j;
        for(j=0; j<this.cols; j++){
            if(!isZero(matrix[i][j], epsilon)){
                return false;
            }
        }
        return rowsZero;
    }

    public boolean isColsZero(int j){ // MENGECEK APAKAH SEBUAH KOLOM BERISI 0
        boolean colsZero = true;
        int i;
        for(i=0; i<this.rows; i++){
            if(!isZero(matrix[i][j], epsilon)){
                return false;
            }
        }
        return colsZero;
    }

    public boolean isAtLeastRowZero(){ // APAKAH ADA NILAI 0 DALAM SUATU BARIS
        int i;
        for(i = 0; i < this.rows; i++){
            if(isRowsZero(i)){
                return true;
            }
        }
        return false;
    }

    public boolean isAtLeastColZero(){ // APAKAH ADA NILAI 0 DALAM SUATU KOLOM
        int i;
        for(i = 0; i < this.cols; i++){
            if(isColsZero(i)){
                return true;
            }
        }
        return false;
    }

    public boolean isZero(double value, double threshold){ // MENGECEK SEBUAH NILAI APAKAH 0
        return value >= -threshold && value <= threshold;
    }

    public void corrZero(){ // MEMPERBAIKI NILAI -0 DENGAN SEBUAH RANGE
        int i,j;
        for(i = 0; i < this.rows; i++){
            for(j = 0; j < this.cols; j++){
                if(isZero(this.matrix[i][j], epsilon)){
                    this.matrix[i][j] = 0;
                }
            }
        }
    }

    public boolean isSegitigaAtas() { // MENGECEK APAKAH SEBUAH MATRIX ADALAH SEGITIGA ATAS
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

    public void reduceMatrix(double M[][], int i, int j){ // MEMPERKECIL UKURAN MATRIX
        int k,l,m,n;
        double T[][];
        T = new double[this.rows][this.cols];
        k=0;
        m=0;
        while(m<this.rows){
            if(k == i){
                m+=1;
            }
            if(m != this.rows){
                for(l=0; l<this.cols; l++){
                    T[k][l] = this.matrix[m][l];
                }
            }
            k += 1;
            m += 1;
        }
        l=0;
        n=0;
        while(n<this.cols){
            if(l==j){
                n+=1;
            }
            if(n != this.cols){
                for(k=0; k<this.rows; k++){
                    T[k][l] = T[k][n];
                }
            }
            l+=1;
            n+=1;
        }
        for(i=0; i<this.cols-1; i++){
            for(j=0; j<this.cols-1; j++){
                M[i][j] = T[i][j];
            }
        }
    }

    boolean isSquare(){ // MENGECEK APAKAH SEBUAH MATRIX ADALAH MATRIX PERSEGI (nROWS=nCOLS)
        return (this.rows == this.cols);
    }

    /* PRIMITIF UNTUK GAUSS */

    int jumlahSolusi(){ // MENGHITUNG JUMLAH SOLUSI DARI SEBUAH SPL GAUSS
        int i = 0;
        int jumlahSolusi;
        boolean nolPojok = true;
        boolean nolSebelahPojok = true;
        if((this.matrix[this.rows-1][this.cols-1]) != 0.0d){
            nolPojok = false;
        }
        while((i<this.cols-1) && nolSebelahPojok){
            if((this.matrix[this.rows-1][i])  != 0.0d){
                nolSebelahPojok = false;
            }
            i++;
        }
        if(nolPojok && nolSebelahPojok){
            jumlahSolusi = 2; // SOLUSI TAK HINGGA
        }else if(nolSebelahPojok && !nolPojok){
            jumlahSolusi = 0; // SOLUSI TAK ADA
        }else{
            jumlahSolusi = 1; // SOLUSI UNIK
        }
        return jumlahSolusi;
    }

    public void gauss(){ // METODE GAUSS
        //Inget bentuk augmented
//        if(isMatriksNol()){
//            Boolean allZero = true;
//            System.out.println("Nilai semua elemen 0, masukkan input yang valid!\n");
//            while(allZero){
//                readMatrixCLI(this.rows, this.cols);
//                if(!isMatriksNol()){
//                    allZero=false;
//                }
//            }
//        }
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

    public static HashMap<String, String> preSolusiGauss(Matrix mat){ // MENERAPKAN GAUSS KE MATRIX DAN MENCARI SOLUSI SPL GAUSS JORDAN-NYA
        mat.gauss();
        return solusiGaussJordan(mat);
    }

    public void gaussJordan(){ // METODE GAUSS JORDAN
        gauss();
        System.out.println();
        // System.out.println("Penyulihan Jordan");
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

                    }
                }
            }
        }
//        System.out.println("Hasil Gauss-Jordan:\n");
//        displayMatrix();
    }

    public static HashMap<String, String> solusiGaussJordan(Matrix m) { // MENENTUKAN SOLUSI SPL GAUSS JORDAN
        int jumlahsolusi;
        HashMap<String, String> solusi = new HashMap<>();
        m.gaussJordan();
        jumlahsolusi = m.jumlahSolusi();
        if (jumlahsolusi == 0) {
            return solusi;
        } else if (jumlahsolusi == 1) {
            for (int i = m.rows - 1; i >= 0; i--) {
                double elemen = m.matrix[i][m.cols - 1];
                String string = String.format("%.2f", elemen);
                solusi.put("X" + (i + 1), string);
            }
            return solusi;
        } else {
            solusi = m.toParametrik();
            return solusi;
        }
    }

    public static String displaySolusiGauss(HashMap<String, String> solusi){ // MENAMPILKAN SOLUSI SPL GAUSS & GAUSS-JORDAN
        String string = new String();
        if(solusi.isEmpty()){
            string = "SPL tidak memiliki solusi";
        }else{
            for(int i = 0; i< solusi.size(); i++){
                string = string.concat("X"+(i+1)+"="+solusi.get("X"+(i+1))+" ");
            }
        }
        return string;
    }
    HashMap<String, String> toParametrik(){ // MENCETAK SOLUSI PARAMETRIK SUATU MATRIX
        int i,j;
        HashMap<String, String> solusiParametrik = new HashMap<>();
        char variabel = 's';
        for(j=this.cols-2; j>=0; j--){
            boolean rowZero = true;
            for(i=this.rows-1; i>=0; i--){
                if(this.matrix[i][j] != 0){
                    rowZero = false;
                    break;
                }
            }
            if(rowZero || (this.matrix[i][j] != 1)){
                solusiParametrik.put("X"+(j+1), variabel+"");
                if(variabel == 'z'){
                    variabel -= 25;
                }
                else{
                    variabel++;
                }
            }
        }
        int countRowsNotZero = 0;
        i = 0;
        j = 0;
        boolean zero = true;
        while(i<this.rows){
            zero = true;
            while(zero && j<this.cols){
                if(this.matrix[i][j] != 0){
                    countRowsNotZero++;
                    zero = false;
                }
                j++;
            }
            i++;
        }
        for(i=0; i<countRowsNotZero; i++){
            j=0;
            while(this.matrix[i][j] != 1){
                j++;
            }
            solusiParametrik.put("X"+(j+1), "");
            if(j != this.cols-2){
                for(int k=j+1; k<this.cols; k++){
                    if(solusiParametrik.get("X"+(j+1)) != null && solusiParametrik.get("X"+(j+1)).equals("")){
                        if(k != this.cols-1){
                            if(this.matrix[i][k] > 0){
                                solusiParametrik.replace("X" + (j+1), solusiParametrik.get("X" + (j+1)) + "-" + String.format("%.2f", this.matrix[i][k]) + solusiParametrik.get("X"+(k+1)));
                            }
                            else if (this.matrix[i][k] < 0) {
                                solusiParametrik.replace("X" + (j+1), solusiParametrik.get("X" + (j+1)) + String.format("%.2f", (-1)*this.matrix[i][k]) + solusiParametrik.get("X"+(k+1)));
                            }
                        }else{
                            if(this.matrix[i][k] > 0 || this.matrix[i][k] < 0){
                                solusiParametrik.replace("X" + (j+1), solusiParametrik.get("X" + (j+1)) + String.format("%.2f", this.matrix[i][k]));
                            }
                        }
                    }else{
                        if(k != this.cols-1){
                            if(this.matrix[i][k] > 0){
                                solusiParametrik.replace("X" + (j+1), solusiParametrik.get("X" + (j+1)) + "-" + String.format("%.2f", this.matrix[i][k]) + solusiParametrik.get("X" + (k+1)));
                            }
                            else if (this.matrix[i][k] < 0) {
                                solusiParametrik.replace("X" + (j+1), solusiParametrik.get("X" + (j+1)) + "+" + String.format("%.2f", (-1)*this.matrix[i][k]) + solusiParametrik.get("X" + (k+1)));
                            }
                        }else{
                            if(this.matrix[i][k] > 0){
                                solusiParametrik.replace("X" + (j+1), solusiParametrik.get("X" + (j+1)) + "+" + String.format("%.2f", this.matrix[i][k]));
                            }else if(this.matrix[i][k] < 0){
                                solusiParametrik.replace("X" + (j+1), solusiParametrik.get("X" + (j+1)) + " " + String.format("%.2f", this.matrix[i][k]));
                            }
                        }
                    }
                }
            }else{
                solusiParametrik.replace("X" + (j+1), "" + String.format("%.2f", this.matrix[i][this.cols-1]));
            }
        }
        return solusiParametrik;
    }

    /*  OPERASI OBE */

    public void addMultiplyRow (int row1, int row2, double n ) { // MENAMBAHKAN SUATU BARIS DENGAN KELIPATAN BARIS LAIN
        /* Menambahkan suatu baris awal row1 dengan kelipatan n dari baris row2  */
        int i;
        for(i = 0; i < this.cols; i++){
            this.matrix[row1][i] += this.matrix[row2][i] * n;
            if(isZero(this.matrix[row1][i], epsilon)){
                this.matrix[row1][i] = 0;
            }
        }
    }

    public void swapRow(int row1, int row2){ // MENUKAR 2 BARIS TERTENTU
        /* Menukarkan 2 baris */
        int i;
        double temp;
        for(i=0; i<this.cols; i++){
            temp = this.matrix[row1][i];
            this.matrix[row1][i] = this.matrix[row2][i];
            this.matrix[row2][i] = temp;
        }
    }

    public void divideRow(int row, Double n){ // MEMBAGI SEBUAH BARIS DENGAN KONSTANTA N
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

    public Matrix multiplyMatrix(Matrix m1, Matrix m2){ // MENGALIKAN 2 BUAH MATRIX
        int i,j,k;
        double sum;
        Matrix m3 = new Matrix(m1.rows,m2.cols);
        for ( i = 0; i < m1.rows; i++){
            for (j = 0; j < m2.cols; j++){
                sum = 0;
                for ( k = 0; k < m2.rows; k++){
                    sum += m1.matrix[i][k] * m2.matrix[k][j];
                }
            if(isZero(sum, epsilon)){
                sum = 0;
            }
            m3.matrix[i][j] = sum;
            }
        }
        return m3;
    }
    
    public void OBE(int a){ // METODE OPERASI BARIS ELEMENTER
        //input a = 0 sebagai awal
        /* Prekondisi : Baris pertama matriks bukan baris nol, atau baris pertama merupakan baris dengan nilai non nol terkiri yang ada di matriks, solusinya pake swap matrix */
        /* Matriks akan dioperasikan sehingga menjadi segitiga atas */
        int i,colNotZero,j;
        double pengali;
        // Rekurens
        if(a < this.rows){ //soalnya gaboleh operasiin paling kanan
            colNotZero = firstNonZeroInRow(a);
            if(colNotZero != -1 && colNotZero != this.cols-1){
                for(i=a+1; i<this.rows; i++){
                    // for(j = a; j < this.rows; j++){
                    // }
                    // System.out.println("Oke");
                    if(this.matrix[i][colNotZero] != 0){
                        pengali = this.matrix[i][colNotZero] / this.matrix[a][colNotZero];
                        addMultiplyRow(i,a, (-1)*pengali);
                         System.out.printf("Kurangi baris ke-%d dengan %f kali baris ke-%d\n", (i+1), pengali , (colNotZero+1));
                         displayMatrix();
                         System.out.println();
                    }
                }
            }
            corrZero();
            if(!isAllRowBelowZero(a)){
                if(colNotZero == this.cols-1 || colNotZero == -1){
                    swapWithZeroRow(a, 0);;
                    // displayMatrix();
                    OBE(a);
                }
                //Rekursi
                else{
                    OBE(a+1);
                }
            }
        }
    }


    public int firstZeroInRow(int i){ // MENGEMBALIKAN INDEKS 0 PERTAMA DALAM SUATU BARIS
        /* Mengembalikan nilai indeks pertama elemen 0 pada baris */
        int j;
        for(j = 0; j < this.cols; j++){
            if (isZero(this.matrix[i][j], epsilon)){
                return j;
            } 
        }
        return -1; /* Kasus tidak ditemukan nilai 0 maka return -1 */
    }

    public int lastZeroInRow(int i){ // MENGEMBALIKAN INDEKS 0 TERAKHIR DALAM SUATU BARIS
        /* Mengembalikan nilai indeks pertama elemen 0 pada baris */
        int j;
        int last = -1;
        for(j = 0; j < this.cols; j++){
            if (!isZero(this.matrix[i][j], epsilon)){
                return last;
            } 
            last = j;
        }
        return last; /* Kasus tidak ditemukan nilai 0 maka return -1 */
    }

    public int firstNonZeroInRow(int i){ // MENGEMBALIKAN INDEKS BUKAN 0 PERTAMA DALAM SUATU BARIS
        /* Mengembalikan nilai indeks pertama elemen non 0 pada baris */
        int j;
        for(j = 0; j < this.cols; j++){
            if (!isZero(this.matrix[i][j], epsilon)){
                return j;
            } 
        }
        return -1; /* Kasus tidak ditemukan nilai selain 0 maka return -1 */
    }

    public boolean isAllRowBelowZero(int i){ // MENGECEK NILAI 0 DI BAWAH SUATU ELEMEN INDEKS
        /* Mengembalikan nilai indeks pertama elemen 0 pada baris */
        int j;
        for(j = i+1; j < this.rows; j++){
            if (!isRowsZero(j)){
                return false;
            } 
        }
        return true; /* Kasus tidak ditemukan nilai 0 maka return -1 */
    }

    public void swapWithZeroRow(int i ,int j){ // MENUKAR DENGAN BARIS BERISI NILAI 0
        // i buat nandain baris yang mau diswap utama dan j buat indeks kolom yang bernilai 0
        /* Prekondisi sudah diketahui bahwa elemen i j bernilai 0 sehingga harus diswap agar tidak menimbulkan Nan atau Infinity */
        int init = i;
        int k;
         //Kasus penanganan buat swap baris [0]
            for(k = i; k < this.rows ; k++){
                if(lastZeroInRow(k) < lastZeroInRow(i) || firstZeroInRow(k) == -1 ){
                    swapRow(k, i);
                    i = k; // Buat pembanding nyari yang paling kiri
                }
            }
        if(init != i){ //Nampilinn kalo ada pertukaran aja
            // System.out.printf("Tukar baris ke-%d dengan baris ke-%d\n", (init+1),(i+1));
            // displayMatrix();
        }
    }

    public boolean isMatriksNol(){ // MENGECEK APAKAH SEMUA ELEMEN BERNILAI NOL
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

    public void swapDown(int i){ // MENUKAR SUATU BARIS DENGAN BARIS DI BAWAHNYA
        int j;
        int last  = i;
        for(j = this.rows-1; j > i ; j--){
            if(!isRowAugZero(j) ){
                swapRow(i, j);
                last = j;
            }
        }
        if (last != i){
            // System.out.printf("Tukar baris ke-%d dan baris ke-%d\n", i, last);
        }
    }

    public boolean isRowAugZero(int i){ // MENGECEK APAKAH SUATU BARIS BERISI 0
        int j;
        for(j = 0; j < this.cols-1; j++){
            if(!isZero(matrix[i][j], epsilon)){
                return false;
            }
        }
        return true;
    }

    public double inverseOBE(){ // MENCARI MATRIX BALIKAN MENGGUNAKAN OBE
        /* Prekondisi matriks adalah persegi */
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
            // System.out.println("Metode Matriks Balikan OBE :");
            invMat.displayMatrix();
            invMat.gaussJordan();
            if(!invMat.isInverseUrut()){
                for(i = 0; i < this.rows; i++){
                    if(isZero(invMat.matrix[i][i], epsilon) ){
                        for(j = i+1; j < this.rows; j++){
                            if(!isZero(invMat.matrix[j][i], epsilon) ){
                                invMat.swapRow(i, j);
                                // System.out.printf("\nBaris ke-%d ditukar dengan baris ke-%d\n", i,j);
                                // invMat.displayMatrix();
                            }
                        }
                    }
                }
            }
            /* Mengopi sisi kanan dari matriks balikan ke matriks balikan baru */
            for(i = 0; i < this.rows; i++){
                for(j = 0; j < this.cols; j++){
                    this.matrix[i][j] = invMat.matrix[i][j+this.cols];
                }
            }
            // System.out.println("\nDidapatkan Matriks Balikan :");
            // this.displayMatrix();
            Matrix temp = this;
            return temp.determinanOBE();
    }

    public void inverseSPL(){ // MENCARI SOLUSI SPL DENGAN MATRIX BALIKAN
        Matrix y = new Matrix(this.rows, 1);
        int i;
        for(i = 0; i < this.rows; i++){
                y.matrix[i][0] = this.matrix[i][this.cols-1];
        }
        Matrix newMat = this.extendMatrix(0, -1);
        newMat.inverseOBE();
        Matrix solusi =  multiplyMatrix(newMat, y);
        System.out.println("\nSolusi dari SPL tersebut adalah...");
        for(i = 0; i< newMat.cols; i++){
            System.out.printf("X%d = %f\n",i+1,solusi.matrix[i][0]);
        }
    }

    public boolean isInverseUrut(){ // MENGECEK APAKAH SUATU MATRIKS BALIKAN TELAH BERURUTAN
        int i;
        for(i = 0; i < this.rows; i++){
            if(isZero(this.matrix[i][i], epsilon)){
                return false;
            }
        }
        return true;
    }

    public boolean OBEdet(int a, boolean evenSwap){ // MENERAPKAN OBE UNTUK MENCARI DETERMINAN MATRIX
        //input a = 0 sebagai awal
        /* Prekondisi : Baris pertama matriks bukan baris nol, atau baris pertama merupakan baris dengan nilai non nol terkiri yang ada di matriks, solusinya pake swap matrix */
        /* Matriks akan dioperasikan sehingga menjadi segitiga atas */
        int i,colNotZero,j;
        double pengali;
        // REkurens
        if(a < this.rows){ //soalnya gaboleh operasiin paling kanan
            colNotZero = firstNonZeroInRow(a);
            if(colNotZero != -1 && colNotZero != this.cols) {
                for (i = a + 1; i < this.rows; i++) {
                    // for(j = a; j < this.rows; j++){
                    // }
                    // System.out.println("Oke");
                    if (this.matrix[i][colNotZero] != 0) {
                        pengali = this.matrix[i][colNotZero] / this.matrix[a][colNotZero];
                        addMultiplyRow(i, a, (-1) * pengali);
                        // System.out.printf("\nKurangi baris ke-%d dengan %f kali baris ke-%d\n", (i+1), pengali , (colNotZero+1));
                        // displayMatrix();
                        // System.out.println();
                        if (a == this.cols - 1) {
                            return evenSwap;
                        }
                        //apakah det dikali -1 atau 1
                    }
                }
            }
            if(colNotZero == this.cols){
                swapDown(a);
                evenSwap = OBEdet(a, !evenSwap);
            }
            //Rekursi
            else{
                evenSwap = OBEdet(a+1, evenSwap);
            }
        }      
        return evenSwap;
    }


    public double determinanOBE(){ // MENERAPKAN OBE UNTUK MENCARI DETERMINAN MATRIX
        /* Prekondisi matriks persegi */
        int i,j;
        double det = 1;
        boolean evenSwap;
        if(this.isAtLeastColZero() || this.isAtLeastRowZero()){
            return 0;
        }
        else{

            if(firstZeroInRow(0) == 0){
                swapWithZeroRow(0, 0);
                det *= -1; // Kemungkinan swap pertama
    
            }
            evenSwap = this.OBEdet(0,true);
            if(!this.isInverseUrut()){
                
                for(i = 0; i < this.rows; i++){
                    if(isZero(this.matrix[i][i], epsilon) ){
                        for(j = i+1; j < this.rows; j++){
                            if(!isZero(this.matrix[j][i], epsilon) ){
                                this.swapRow(i, j);
                                // System.out.printf("\nBaris ke-%d ditukar dengan baris ke-%d\n", i,j);
                                // this.displayMatrix();
                                det *= -1;
                            }
                        }
                    }
                }
            }
            for(i = 0; i < this.rows; i++){
                det *= this.matrix[i][i];
            }
            if(!evenSwap){
                det *= -1;
            }
//            System.out.printf("Determinan matriks :%.2f\n", det);
        }
        return det;
    }

    // FUNGSI KOFAKTOR DAN CRAMER
    void kofaktor(){ // METODE OPERASI KOFAKTOR
        int i,j;
        double temp;
        double[][] mNew;
        mNew = new double[this.rows-1][this.cols-1];
        Matrix m1 = new Matrix((this.rows-1),(this.cols-1));
        Matrix m2 = new Matrix((this.rows),(this.cols));
        if((this.rows == 2) && (this.cols ==2)){
            temp = this.matrix[0][0];
            this.matrix[0][0] = this.matrix[1][1];
            this.matrix[1][1] = temp;
            temp = this.matrix[0][1];
            this.matrix[0][1] = -(this.matrix[1][0]);
            this.matrix[1][0] = -(temp);
        }else{
            for(i=0; i<this.rows; i++){
                for(j=0; j<this.cols; j++){
                    this.reduceMatrix(mNew,i,j);
                    m1.copyMatrixInverse(mNew);
                    m2.matrix[i][j] = m1.determinanKofaktor();
                    if((i+j)%2 != 0){
                        m2.matrix[i][j] = -(m2.matrix[i][j]);
                    }
                }
            }
            for(i=0; i<this.rows; i++){
                for(j=0; j<this.cols; j++){
                    this.matrix[i][j] = m2.matrix[i][j];
                }
            }
        }
    }

    public double determinanKofaktor(){ // MENCARI NILAI DETERMINAN DENGAN KOFAKTOR
        double det=0;
        int i,j,k,x,y;
        Matrix matrixNew = new Matrix((this.rows-1),(this.cols-1));
        if(this.rows==2 && this.cols==2){ //BASIS
            det = ((this.matrix[0][0]*this.matrix[1][1])-(this.matrix[0][1]*this.matrix[1][0]));
            return det;
        }else{
            for(i=0; i<this.cols; i++){
                if(this.matrix[0][i] != 0){
                    y=0;
                    for(j=0; j<this.rows; j++){
                        x=0;
                        for(k=0; k<this.cols; k++){
                            if(k!=i){ //Membuat matrikskofaktor
                                matrixNew.matrix[y][x] = this.matrix[j][k];
                                x++;
                            }
                        }
                        if(j!=0){
                            y++;
                        }
                    }
                    if(i%2==0){
                        det += this.matrix[0][i] * matrixNew.determinanKofaktor();
                    }else{
                        det -= this.matrix[0][i] * matrixNew.determinanKofaktor();
                    }
                }
            }
            return det;
        }
    }


    void transpose(){ // MELAKUKAN TRANSPOSE MATRIX
        int i,j;
        double[][] mNew;
        mNew = new double[this.rows][this.cols];
        for(i=0; i<this.rows; i++){
            for(j=0; j<this.cols; j++){
                mNew[j][i] = this.matrix[i][j];
            }
        }
        for(i=0; i<this.rows; i++){
            for(j=0; j<this.cols; j++){
                this.matrix[i][j] = mNew[i][j];
            }
        }
    }

    void adjoin(){ // MENCARI MATRIX ADJOIN
        this.kofaktor();
        this.transpose();
    }

    void copyMatrixInverse(double M[][]){ // MELAKUKAN COPY MATRIX INVERSE
        int i,j;
        for(i=0; i<this.rows; i++){
            for(j=0; j<this.cols; j++){
                this.matrix[i][j] = M[i][j];
            }
        }
    }

    void invers(){ // MELAKUKAN INVERS TERHADAP SUATU MATRIX
        int i,j;
        double[][] mNew;
        mNew = new double[this.rows][this.cols];
        double det = this.determinanKofaktor();
        if(det !=0){
            this.adjoin();
            for(i=0; i<this.rows; i++){
                for(j=0; j<this.cols; j++){
                    mNew[i][j] = this.matrix[i][j]/det;
                }
            }
            this.copyMatrixInverse(mNew);
        }
    }

    String Cramer(double m[][]){ // METODE CRAMER
        int i, j;
        double mNew[][] = new double[this.rows][this.cols];
        double det1 = this.determinanKofaktor();
        double det2, res;
        String output = "";
        for(i=0; i<this.rows; i++){
            for(j=0; j<this.cols; j++){
                mNew[i][j] = this.matrix[i][j]; // membuat matriks baru hasil copy matrix asli
            }
        }
        if(det1 != 0){
            for(j=0; j<this.cols; j++){
                for(i=0; i<this.rows; i++){
                    this.matrix[i][j] = m[i][0]; // mengganti nilai dari tiap kolom matriks asli dengan nilai matriks masukan
                }
                det2 = this.determinanKofaktor();
                res = det2/det1; // X(N) = detKolomN/detMatriks
                if(j!=0){
                    output += ",X" + (j+1) + "=" + (res) + " "; // ,X2=* ,X3=*
                }
                else{
                    output += "X" + (j+1) + "=" + (res) + " "; // X1=*
                }

                for(i=0; i<this.rows; i++){
                    this.matrix[i][j] = mNew[i][j]; // menukar nilai matriks asli yang telah diubah per kolomnya menjadi nilai semula
                }
            }
        }
        return output; // mengembalikan String output
    }

    String multiplyInvers(double M[][]){ //METODE MATRIX BALIKAN UNTUK SPL (MENGALIKAN A^-1 DENGAN MATRIX B)
        // MENGALIKAN MATRIKS M DENGAN MATRIKS
        int i,j;
        double res;
        String string = "";
        this.invers();
        for(i=0; i<this.rows; i++){
            res = 0;
            for(j=0; j<this.cols; j++){
                res += this.matrix[i][j] * M[j][0];
            }
            if(i!=0){
                string += ",X" + (i+1) + "=" + (res) + " "; // ,X2=* ,X3=*
            }
            else{
                string += "X" + (i+1) + "=" + (res) + " "; // X1=*
            }
        }
        return string;
    }

}
