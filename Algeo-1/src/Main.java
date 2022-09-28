

import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.Arrays;
import java.lang.Math;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
//        Matrix m = new Matrix(3,3);
//        m.readMatrixCLI(m.rows,m.cols);
//        System.out.println("\nTerbentuk Matriks :");
//        m.displayMatrix();
//        System.out.println("");
//        m.inverseOBE();
        MainMenu();
    }

    public static void MainMenu(){
        try{
            int pilihan; // variabel masukan pilihan menu dari user
            Scanner input = new Scanner(System.in);
            System.out.println("--------------------------------");
            System.out.println("          TUBES ALGEO-01        ");
            System.out.println("        KELOMPOK SERINGAI       ");
            System.out.println("--------------------------------");
            System.out.println("           Menu Utama           ");
            System.out.println("--------------------------------");
            System.out.println("1. Sistem Persamaan Linear(SPL)");
            System.out.println("2. Determinan");
            System.out.println("3. Matriks Balikan");
            System.out.println("4. Interpolasi Polinom");
            System.out.println("5. Interpolasi Bicubic");
            System.out.println("6. Regresi linear berganda");
            System.out.println("7. Keluar");
            System.out.println("--------------------------------");
            System.out.println("Masukkan pilihan menu Anda: ");
            pilihan = input.nextInt();

            switch(pilihan){
                case 1:
                    subMenuSPL();
                    break;
                case 2:
                    subMenuDet();
                    break;
                case 3:
                    subMenuInv();
                    break;
                case 4:
                    subMenuInterPol();
                    break;
                case 5:
                    subMenuInterBic();
                    break;
                case 6:
                    subMenuRLB();
                    break;
                case 7:
                    penutup();
                default:
                    System.out.println("Masukkan menu tidak valid, silahkan ulangi.");
                    MainMenu();
            }
        } catch (Exception e){
            System.out.println("Masukkan menu tidak valid, silahkan ulangi.");
            MainMenu();
        }
    }

    public static void subMenuSPL(){
        try{
            int i,j,metode,nRows,nCols;
            int sumber =0;
            String res = "";
            double b[][];
            String namaFile = null;
            Matrix mat = new Matrix(0,0);
            Matrix matA = new Matrix(0,0);
            double[][] matB = new double[0][0];
            Scanner input = new Scanner(System.in);

            System.out.println("--------------------------------");
            System.out.println("              Menu              ");
            System.out.println(" 1.Sistem Persamaan Linear(SPL) ");
            System.out.println("--------------------------------");
            System.out.println("         Pilihan Metode:        ");
            System.out.println("1. Metode Eliminasi Gauss");
            System.out.println("2. Metode Eliminasi Gauss-Jordan");
            System.out.println("3. Metode Matriks balikan");
            System.out.println("4. Kaidah Cramer");
            System.out.println("5. Kembali ke Menu Utama");
            System.out.println("--------------------------------");
            System.out.println("Masukkan pilihan metode Anda: ");
            metode = input.nextInt();

            switch(metode){
                case 1:
                    System.out.println("--------------------------------");
                    System.out.println("             Metode             ");
                    System.out.println("    1. Metode Eliminasi Gauss   ");
                    System.out.println("--------------------------------");
                    sumber = pilihanMasukan(1);

                    

                    break;
                case 2:
                    System.out.println("--------------------------------");
                    System.out.println("             Metode             ");
                    System.out.println("2. Metode Eliminasi Gauss-Jordan");
                    System.out.println("--------------------------------");
                    sumber = pilihanMasukan(1);

                    

                    break;
                case 3:
                    System.out.println("--------------------------------");
                    System.out.println("             Metode             ");
                    System.out.println("    3. Metode Matriks Balikan   ");
                    System.out.println("--------------------------------");
                    sumber = pilihanMasukan(1);

                    
                    


                    break;
                case 4:
                    System.out.println("--------------------------------");
                    System.out.println("             Metode             ");
                    System.out.println("        4. Kaidah Cramer        ");
                    System.out.println("--------------------------------");
                    sumber = pilihanMasukan(1);
                    break;
                case 5:
                    MainMenu();
                default:
                    System.out.println("Masukan metode tidak valid, silahkan ulangi");
                    subMenuSPL();
            }

            switch(sumber){
                case 1:
                    System.out.println("--------------------------------");
                    System.out.println("             Sumber             ");
                    System.out.println("       1. Masukan dari CLI      ");
                    System.out.println("--------------------------------");
                    System.out.println("Masukkan jumlah baris: ");
                    nRows = input.nextInt();
                    System.out.println("Masukkan jumlah kolom: ");
                    nCols = input.nextInt();
                    mat = new Matrix(nRows,nCols);
                    System.out.println("Masukkan matriks: ");
                    mat.readMatrixCLI(nRows,nCols);
                    System.out.println("\nMatriks berhasil dibaca.");

                    
                    break;
                case 2:
                    System.out.println("--------------------------------");
                    System.out.println("             Sumber             ");
                    System.out.println("    2. Masukan dari file .txt   ");
                    System.out.println("--------------------------------");
                    System.out.println("Masukkan nama file (.txt) dalam folder test: ");
                    namaFile = input.next();
                    // FUNGSI BACA MATRIKS TXT
                    System.out.println("Matriks (file:"+namaFile+") berhasil dibaca.");
                    break;
                case 3:
                    subMenuSPL();
                default:
                    System.out.println("Masukan sumber tidak valid, silahkan ulangi.");
                    subMenuSPL();
            }
            System.out.println("--------------------------------");
            System.out.println("Matriks yang dibaca: ");
            mat.displayMatrix();

            if(metode == 1){
                
                System.out.println();
                Matrix matTemp = mat;
                matTemp.gauss();
                                
                double pengali;
                for(i = mat.rows-1; i >= 0; i--){
                    if(mat.firstNonZeroInRow(i) != -1 && mat.firstNonZeroInRow(i) != mat.cols-1){ //tidak boleh mbagi kolom augment paling kanan 
                        for(j = i-1; j >= 0; j--){
                            if(mat.matrix[j][mat.firstNonZeroInRow(i)] != 0){
                                pengali = mat.matrix[j][mat.firstNonZeroInRow(i)]/mat.matrix[i][mat.firstNonZeroInRow(i)];
                                mat.addMultiplyRow(j, i, (-1)*pengali);
                                // System.out.printf("\nKurangi baris ke-%d dengan %f kali baris ke-%d\n", (j+1), pengali , (i+1));
                                mat.displayMatrix();
                                System.out.println();

                            }
                        }
                    }
                }

                System.out.println("Solusi dari SPL tersebut adalah...");
                for(i = 0; i < mat.rows; i++){
                    System.out.printf("X%d = %f\n",i+1,mat.matrix[i][mat.cols-1]);
                }
            }

            else if(metode == 2){
                
                System.out.println();
                mat.gaussJordan();

                System.out.println("Solusi dari SPL tersebut adalah...");
                for(i = 0; i < mat.rows; i++){
                    System.out.printf("X%d = %f\n",i+1,mat.matrix[i][mat.cols-1]);
                }

            }

            else if(metode == 3){
                
                System.out.println();
                mat.inverseSPL();
            }

            

            subMenuSPL();


        }catch (Exception e){
            System.out.println("Masukkan menu tidak valid, silahkan ulangi.");
            subMenuSPL();
        }
    }

    public static void subMenuDet(){
        try{
            int metode,ukuran;
            int sumber =0;
            double res =0;
            String namaFile = null;
            Matrix mat = new Matrix(0,0);
            Scanner input = new Scanner(System.in);

            System.out.println("--------------------------------");
            System.out.println("              Menu              ");
            System.out.println("          2.Determinan          ");
            System.out.println("--------------------------------");
            System.out.println("         Pilihan Metode:        ");
            System.out.println("1. Metode Eliminasi Gauss");
            System.out.println("2. Metode Eliminasi Gauss-Jordan");
            System.out.println("3. Kembali ke Menu Utama");
            System.out.println("--------------------------------");
            System.out.println("Masukkan pilihan metode Anda: ");
            metode =  input.nextInt();

        
        
        



        

        

            switch(metode){
                case 1:
                    System.out.println("--------------------------------");
                    System.out.println("             Metode             ");
                    System.out.println("    1. Metode Eliminasi Gauss   ");
                    System.out.println("--------------------------------");
                    sumber = pilihanMasukan(1);
                    break;
                case 2:
                    System.out.println("--------------------------------");
                    System.out.println("             Metode             ");
                    System.out.println("2. Metode Eliminasi Gauss-Jordan");
                    System.out.println("--------------------------------");
                    sumber = pilihanMasukan(1);
                    break;
                case 3:
                    MainMenu();
                default:
                    System.out.println("Masukan metode tidak valid, silahkan ulangi");
                    subMenuDet();
            }

            switch(sumber){
                case 1:
                    System.out.println("--------------------------------");
                    System.out.println("             Sumber             ");
                    System.out.println("       1. Masukan dari CLI      ");
                    System.out.println("--------------------------------");
                    System.out.println("Masukkan ukuran matriks persegi (NxN) N: ");
                    ukuran = input.nextInt();
                    mat = new Matrix(ukuran,ukuran);
                    System.out.println("Masukkan matriks: ");
                    mat.readMatrixCLI(ukuran,ukuran);
                    System.out.println("Matriks berhasil dibaca.");
                    break;
                case 2:
                    System.out.println("--------------------------------");
                    System.out.println("              Sumber            ");
                    System.out.println("    2. Masukan dari file .txt   ");
                    System.out.println("--------------------------------");
                    System.out.println("Masukkan nama file (.txt) dalam folder test: ");
                    namaFile = input.next();
                    // FUNGSI BACA MATRIKS TXT
                    System.out.println("Matriks (file:"+namaFile+".txt) berhasil dibaca.");
                    break;
                case 3:
                    subMenuDet();
                default:
                    System.out.println("Masukan sumber tidak valid, silahkan ulangi.");
                    subMenuDet();
            }
            System.out.println("--------------------------------");
            System.out.println("Matriks yang dibaca: ");
            mat.displayMatrix();
        }catch (Exception e){
            System.out.println("Masukkan menu tidak valid, silahkan ulangi.");
            subMenuDet();
        }
    }
    public static void subMenuInv(){
        try{
            int metode, ukuran;
            int sumber=0;
            String namaFile = null;
            Matrix mat = new Matrix(0,0);
            Matrix inv = new Matrix(0,0);
            Scanner input  = new Scanner(System.in);

            System.out.println("--------------------------------");
            System.out.println("              Menu              ");
            System.out.println("       3. Matriks Balikan       ");
            System.out.println("--------------------------------");
            System.out.println("         Pilihan Metode:        ");
            System.out.println("1. Metode Eliminasi Gauss");
            System.out.println("2. Metode Eliminasi Gauss-Jordan");
            System.out.println("3. Kembali ke Menu Utama");
            System.out.println("--------------------------------");
            System.out.println("Masukkan pilihan metode Anda: ");
            metode =  input.nextInt();

            switch(metode){
                case 1:
                    System.out.println("--------------------------------");
                    System.out.println("             Metode             ");
                    System.out.println("    1. Metode Eliminasi Gauss   ");
                    System.out.println("--------------------------------");
                    sumber = pilihanMasukan(1);
                    break;
                case 2:
                    System.out.println("--------------------------------");
                    System.out.println("             Metode             ");
                    System.out.println("2. Metode Eliminasi Gauss-Jordan");
                    System.out.println("--------------------------------");
                    sumber = pilihanMasukan(1);
                    break;
                case 3:
                    MainMenu();
                default:
                    System.out.println("Masukan metode tidak valid, silahkan ulangi");
                    subMenuInv();
            }

            switch(sumber){
                case 1:
                    System.out.println("--------------------------------");
                    System.out.println("             Sumber             ");
                    System.out.println("       1. Masukan dari CLI      ");
                    System.out.println("--------------------------------");
                    System.out.println("Masukkan ukuran matriks persegi (NxN) N: ");
                    ukuran = input.nextInt();
                    mat = new Matrix(ukuran,ukuran);
                    System.out.println("Masukkan matriks: ");
                    mat.readMatrixCLI(ukuran,ukuran);
                    System.out.println("Matriks berhasil dibaca.");
                    break;
                case 2:
                    System.out.println("--------------------------------");
                    System.out.println("              Sumber            ");
                    System.out.println("    2. Masukan dari file .txt   ");
                    System.out.println("--------------------------------");
                    System.out.println("Masukkan nama file (.txt) dalam folder test: ");
                    namaFile = input.next();
                    // FUNGSI BACA MATRIKS TXT
                    System.out.println("Matriks (file:"+namaFile+".txt) berhasil dibaca.");
                    break;
                case 3:
                    subMenuInv();
                default:
                    System.out.println("Masukan sumber tidak valid, silahkan ulangi.");
                    subMenuInv();
            }
            System.out.println("--------------------------------");
            System.out.println("Matriks yang dibaca: ");
            mat.displayMatrix();
        }catch (Exception e){
            System.out.println("Masukkan menu tidak valid, silahkan ulangi.");
            subMenuInv();
        }

    }
    public static void subMenuInterPol(){
        try{
            int sumber;
            String namaFile = null;
            Matrix mat = new Matrix(0,0);
            Scanner input = new Scanner(System.in);
            int i,j;
            
            int n;

            System.out.println("--------------------------------");
            System.out.println("              Menu              ");
            System.out.println("     4. Interpolasi Polinom     ");
            System.out.println("--------------------------------");
            sumber = pilihanMasukan(0);

            switch(sumber){
                case 1:
                    System.out.println("--------------------------------");
                    System.out.println("             Sumber             ");
                    System.out.println("       1. Masukan dari CLI      ");
                    System.out.println("--------------------------------");
                    // MEMINTA MASUKAN TITIK DAN CREATE TITIK
                    
                    
                    
                    
                    break;
                case 2:
                    System.out.println("--------------------------------");
                    System.out.println("              Sumber            ");
                    System.out.println("    2. Masukan dari file .txt   ");
                    System.out.println("--------------------------------");
                    System.out.println("Masukkan nama file (.txt) dalam folder test: ");
                    namaFile = input.next();
                    // FUNGSI BACA MATRIKS TXT
                    System.out.println("Matriks (file:"+namaFile+".txt) berhasil dibaca.");
                    // NILAI TITIK
                    break;
                default:
                    System.out.println("Masukan sumber tidak valid, silahkan ulangi.");
                    subMenuInterPol();
            }

                /* Interpolasi di main asyik */
            System.out.printf("Masukkan banyaknya titik sampel (X,Y) = ");
            n = input.nextInt();
            double[] solusiInterpolasi = new double[n];
            Matrix xy = new Matrix(n, 2);
                    for(i = 0; i < n; i++){
                        System.out.printf("\nMasukkan X%d = ",i+1);
                        xy.matrix[i][0] = input.nextDouble();
                        System.out.printf("\nMasukkan Y%d = ",i+1);
                        xy.matrix[i][1] = input.nextDouble();

                    }
            Matrix m = new Matrix(n, n+1);

            for(i = 0; i < m.rows; i++){
                for(j = 0; j < m.cols-1; j++){
                    m.matrix[i][j] = Math.pow(xy.matrix[i][0], j);
                }
                m.matrix[i][m.cols-1] = xy.matrix[i][1];
            }
            System.out.printf("\nMatriks koefisien dari persamaan derajat %d :\n", n);
            m.displayMatrix();

            m.gaussJordan();

            for(i = 0; i < n; i++){
                solusiInterpolasi[i] = m.matrix[i][m.cols-1];
            }

            System.out.printf("\nSolusi SPL f(x) = ");

            System.out.printf("%f ", solusiInterpolasi[0]);
            
            if (n >= 2){
                System.out.printf("+ %fx ", solusiInterpolasi[1]);
            }

            if ( n >= 3){
                for(i = 2; i < n; i++){
                    System.out.printf(" + %fx^%d ", solusiInterpolasi[i],i);
                }
            }
            System.out.println();

            System.out.printf("Masukan nilai x yang akan ditaksir : ");
            double xTaksir = input.nextDouble();
            
            double sum = 0;

            for(i = 0; i < n ; i++){
                sum += solusiInterpolasi[i] * Math.pow(xTaksir, i);
            }

            System.out.printf("\nHasil interpolasi f(%f) = %f\n", xTaksir, sum);
        }catch (Exception e){
            System.out.println("Masukkan menu tidak valid, silahkan ulangi.");
            subMenuInterPol();
        }
    }
    public static void subMenuInterBic(){
        try{
            int sumber;
            String namaFile = null;
            Matrix mat = new Matrix(0,0);
            Scanner input = new Scanner(System.in);

            System.out.println("--------------------------------");
            System.out.println("              Menu              ");
            System.out.println("     5. Interpolasi Bicubic     ");
            System.out.println("--------------------------------");
            sumber = pilihanMasukan(0);

            switch(sumber){
                case 1:
                    System.out.println("--------------------------------");
                    System.out.println("             Sumber             ");
                    System.out.println("       1. Masukan dari CLI      ");
                    System.out.println("--------------------------------");
                    // MEMINTA MASUKAN TITIK DAN CREATE TITIK
                    break;
                case 2:
                    System.out.println("--------------------------------");
                    System.out.println("              Sumber            ");
                    System.out.println("    2. Masukan dari file .txt   ");
                    System.out.println("--------------------------------");
                    System.out.println("Masukkan nama file (.txt) dalam folder test: ");
                    namaFile = input.next();
                    // FUNGSI BACA MATRIKS TXT
                    System.out.println("Matriks (file:"+namaFile+".txt) berhasil dibaca.");
                    // NILAI TITIK
                    break;
                default:
                    System.out.println("Masukan sumber tidak valid, silahkan ulangi.");
                    subMenuInterBic();
            }

                /* Bicubic  */
            Matrix m = new Matrix(4, 4);
            Matrix matX = new Matrix(16, 16);
            Matrix a = new Matrix(4, 4);
            int i,j,k,l;
            double u,v,sum = 0;
          
            for(i = 0; i < 4; i++){
                for(j = 0; j < 4; j++){
                    System.out.printf("Masukkan nilai f(%d,%d) = ", (i-1), (j-1));
                    m.matrix[i][j] = input.nextDouble();
                }
            }

            System.out.println("\nUntuk mencari nilai f(a,b) dengan interpolasi...");
            System.out.printf("Masukkan a = ");
            u = input.nextDouble();
            System.out.printf("Masukkan b = ");
            v = input.nextDouble();

            for(i = 0 ; i < 4; i++){
                for(j = 0 ; j < 4; j++){
                    for(k = 0; k < 4; k++){
                        for(l = 0; l < 4; l++){
                            matX.matrix[(i)*4 +(j)][(k)*4 +(l)] = Math.pow((j -1 ),l )*Math.pow(i -1, k);
                        }
                    }
                }
            }
            
            Matrix matXAkhir = matX.extendMatrix(0, 1);

            for(i = 0 ; i < 4; i++){
                for(j = 0 ; j < 4; j++){
                matXAkhir.matrix[i*4 + j][16] = m.matrix[i][j];
                }
            }

            matXAkhir.gaussJordan();

            for(i = 0 ; i < 4; i++){
                for(j = 0 ; j < 4; j++){
                a.matrix[j][i] = matXAkhir.matrix[i*4 + j][16];
                }
            }

            for(i = 0 ; i < 4; i++){
                for(j = 0 ; j < 4; j++){
                    sum += a.matrix[j][i] * Math.pow(u, j) * Math.pow(v, i);
                }
            }

            System.out.printf("\nMaka f(%f,%f) = %f",u,v,sum);
            
        }catch (Exception e){
            System.out.println("Masukkan menu tidak valid, silahkan ulangi.");
            subMenuInterBic();
        }
    }
    public static void subMenuRLB(){
        try{
            int sumber;
            String namaFile = null;
            Matrix mat = new Matrix(0,0);
            Scanner input = new Scanner(System.in);

            System.out.println("--------------------------------");
            System.out.println("              Menu              ");
            System.out.println("   5. Regresi Linear Berganda   ");
            System.out.println("--------------------------------");
            sumber = pilihanMasukan(0);

            if( sumber == 1){
                /* Input CLI RLB */
                int peubahX,nSampel;
                System.out.printf("Masukkan banyak peubah x : ");
                peubahX = input.nextInt();
                System.out.printf("Masukkan jumlah sampel :");
                nSampel = input.nextInt();

                Matrix x = new Matrix(nSampel, peubahX+1);
                double[] xTaksir = new double[peubahX+1];
                Matrix y = new Matrix(nSampel, 1);
                Matrix yNEE = new Matrix(peubahX+1, 1);
                Matrix matRLB = new Matrix(peubahX+1, peubahX+1);
                double yTaksir = 0;

                int i,j,k;
                for( i = 0; i < nSampel; i++){
                    for( j = 0; j < peubahX+2; j++){
                        if(j == 0){
                            x.matrix[i][0] = 1;
                        }
                        else{
                            if(j == peubahX+1){
                                System.out.printf("Masukkan nilai y untuk sampel %d : ", i+1);
                                y.matrix[i][0] = input.nextDouble();
                            }
                            else{
                                System.out.printf("Masukkan nilai X%d untuk sampel %d : ", j,i+1);
                                x.matrix[i][j] = input.nextDouble();
                            }
                            
                        }
                        
                    }
                }

                System.out.println("\nMasukkan nilai-nilai X yang akan ditaksir...\n");
                for( i = 0; i < peubahX+1; i++){
                    if( i == 0 ){
                        xTaksir[0] = 1;
                    }
                    else{
                        System.out.printf("Nilai X%d : ",i);
                        xTaksir[i] = input.nextDouble();
                    }
                    
                }
                    
                for( i = 0; i < peubahX+1; i++){
                    for( j = 0; j < peubahX+1; j++){
                        matRLB.matrix[i][j] = 0;
                        
                        for(k = 0; k < nSampel; k++){
                            matRLB.matrix[i][j] += x.matrix[k][i] * x.matrix[k][j];
                        }
                    }
                }

                

                matRLB.inverseOBE();
                /* Sudah didapatkan inverse di matRLB */

                /* Membuat sisi kanan NEE */
                for(i = 0; i< peubahX+1; i++){
                    yNEE.matrix[i][0] = 0;
                    for(j = 0; j < nSampel; j++){
                        yNEE.matrix[i][0] += x.matrix[j][i]*y.matrix[j][0];
                    }
                }

                Matrix solusi = matRLB.multiplyMatrix(matRLB, yNEE);

                System.out.println("Maka didapatkan nilai koefisien B (beta)..\n");

                for(i = 0; i < peubahX+1; i++){
                    System.out.printf("B%d = %f\n", i, solusi.matrix[i][0]);
                }
                System.out.println();
                
                for(i = 0; i < peubahX+1; i++){
                    yTaksir += xTaksir[i]*solusi.matrix[i][0];
                }

                System.out.printf("y =");
                for(i = 0; i < peubahX+1; i++ ){
                    System.out.printf(" %f x %f", solusi.matrix[i][0],xTaksir[i]);
                    if(i != peubahX){
                        System.out.printf(" +");
                    }
                }
                System.out.printf(" = %f", yTaksir);
                
                System.out.println("\nMasukkan 1 untuk menggunakan operasi ini lagi ----- Masukkan 2 untuk kembali ke Menu Utama\n");

                int optionMenu = input.nextInt();
                
                if(optionMenu == 1){
                    subMenuRLB();
                }
                else{
                    MainMenu();
                }


            }
        }catch (Exception e){
            System.out.println("Masukkan menu tidak valid, silahkan ulangi.");
            subMenuRLB();
        }
    }
    public static int pilihanMasukan(int jenis){
        int sumber;
        Scanner input = new Scanner(System.in);
        System.out.println("--------------------------------");
        System.out.println("         Pilihan Sumber:        ");
        System.out.println("--------------------------------");
        System.out.println("1. Masukan dari CLI");
        System.out.println("2. Masukan dari file .txt");
        switch(jenis){
            case 1:
                System.out.println("3. Kembali ke Menu Pilihan Metode");
            default:
                break;
        }
        System.out.println("--------------------------------");
        System.out.println("Masukkan pilihan sumber Anda: ");
        sumber = input.nextInt();
        return sumber;
    }

    public static void penutup()
    {
        System.out.println("------------------------------------------------------");
        System.out.println("Terima kasih telah menggunakan kalkulator matriks kami");
        System.out.println("------------------------------------------------------");
        System.exit(0);
    }

}
