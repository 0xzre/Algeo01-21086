import java.sql.SQLOutput;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) {
        String art = """
                ███████╗███████╗██████╗ ██╗███╗   ██╗ ██████╗  █████╗ ██╗
                ██╔════╝██╔════╝██╔══██╗██║████╗  ██║██╔════╝ ██╔══██╗██║
                ███████╗█████╗  ██████╔╝██║██╔██╗ ██║██║  ███╗███████║██║
                ╚════██║██╔══╝  ██╔══██╗██║██║╚██╗██║██║   ██║██╔══██║██║
                ███████║███████╗██║  ██║██║██║ ╚████║╚██████╔╝██║  ██║██║
                ╚══════╝╚══════╝╚═╝  ╚═╝╚═╝╚═╝  ╚═══╝ ╚═════╝ ╚═╝  ╚═╝╚═╝
                """;
        for(int i=0; i<art.length(); i++){
            System.out.print(art.charAt(i));
            try{
                Thread.sleep(2);
            }catch(InterruptedException e){};
        }
        MainMenu();
    }

    public static void MainMenu(){
        try{
            int pilihan; // variabel masukan pilihan menu dari user
            Scanner input = new Scanner(System.in);
            System.out.println("---------------------------------------------------------");
            System.out.println("                      TUBES ALGEO-01                     ");
            System.out.println("                     KELOMPOK SERINGAI                   ");
            System.out.println("---------------------------------------------------------");
            System.out.println("                        Menu Utama                       ");
            System.out.println("---------------------------------------------------------");
            System.out.println("1. Sistem Persamaan Linier(SPL) ");
            System.out.println("2. Determinan");
            System.out.println("3. Matriks Balikan");
            System.out.println("4. Interpolasi Polinom");
            System.out.println("5. Interpolasi Bicubic");
            System.out.println("6. Regresi Linier berganda");
            System.out.println("7. Keluar");
            System.out.println("---------------------------------------------------------");
            System.out.println("Masukkan pilihan menu Anda:     ");
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
            int i,j,metode,nCols,akhir;
            int nRows=0;
            int sumber =0;
            char simpan =0;
            String res = "";
            double b[][];
            String namaFile = null;
            Matrix mat = new Matrix(0,0);
            Matrix matA = new Matrix(0,0);
            double[][] matB = new double[0][0];
            Scanner input = new Scanner(System.in);

            System.out.println("---------------------------------------------------------");
            System.out.println("                           Menu                          ");
            System.out.println("              1.Sistem Persamaan Linier(SPL)             ");
            System.out.println("---------------------------------------------------------");
            System.out.println("                      Pilihan Metode:                    ");
            System.out.println("1. Metode Eliminasi Gauss");
            System.out.println("2. Metode Eliminasi Gauss-Jordan");
            System.out.println("3. Metode Matriks balikan");
            System.out.println("4. Kaidah Cramer");
            System.out.println("5. Kembali ke Menu Utama");
            System.out.println("---------------------------------------------------------");
            System.out.println("Masukkan pilihan metode Anda: ");
            metode = input.nextInt();

            switch(metode){
                case 1:
                    System.out.println("---------------------------------------------------------");
                    System.out.println("                          Metode                         ");
                    System.out.println("                 1. Metode Eliminasi Gauss               ");
                    System.out.println("---------------------------------------------------------");
                    sumber = pilihanMasukan(1);
                    break;
                case 2:
                    System.out.println("---------------------------------------------------------");
                    System.out.println("                          Metode                         ");
                    System.out.println("             2. Metode Eliminasi Gauss-Jordan            ");
                    System.out.println("---------------------------------------------------------");
                    sumber = pilihanMasukan(1);
                    break;
                case 3:
                    System.out.println("---------------------------------------------------------");
                    System.out.println("                          Metode                         ");
                    System.out.println("                 3. Metode Matriks Balikan               ");
                    System.out.println("---------------------------------------------------------");
                    sumber = pilihanMasukan(1);
                    break;
                case 4:
                    System.out.println("---------------------------------------------------------");
                    System.out.println("                          Metode                         ");
                    System.out.println("                     4. Kaidah Cramer                    ");
                    System.out.println("---------------------------------------------------------");
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
                    System.out.println("---------------------------------------------------------");
                    System.out.println("                          Sumber                         ");
                    System.out.println("                    1. Masukan dari CLI                  ");
                    System.out.println("---------------------------------------------------------");
                    System.out.println("Masukkan jumlah baris: ");
                    nRows = input.nextInt();
                    System.out.println("Masukkan jumlah kolom: ");
                    nCols = input.nextInt();
                    mat = new Matrix(nRows,nCols);
                    System.out.println("Masukkan matriks: ");
                    mat.readMatrixCLI(nRows,nCols);
                    System.out.println("Matriks berhasil dibaca.");
                    break;
                case 2:
                    System.out.println("---------------------------------------------------------");
                    System.out.println("                          Sumber                         ");
                    System.out.println("                 2. Masukan dari file .txt               ");
                    System.out.println("---------------------------------------------------------");
                    System.out.println("Masukkan nama file (.txt) dalam folder test: ");
                    namaFile = input.next();
                    mat.readMatrixFILE(namaFile);
                    break;
                case 3:
                    subMenuSPL();
                default:
                    System.out.println("Masukan sumber tidak valid, silahkan ulangi.");
                    subMenuSPL();
            }
            System.out.println("---------------------------------------------------------");
            System.out.println("Matriks yang dibaca: ");
            mat.displayMatrix();

            // OPERASI SPL TARUH DISINI

            // KHUSUS MATRIKS BALIKAN DAN CRAMER
            if((metode == 3 || metode ==4) && sumber == 2){
                matA = new Matrix(mat.rows,mat.cols);
                matB = new double[mat.rows][1];
                for(i=0; i<mat.rows; i++){
                    for(j=0; j<mat.cols; j++){
                        if(j==mat.cols-1){
                            matB[i][0] = mat.matrix[i][j];
                        }
                        else{
                            matA.matrix[i][j] = mat.matrix[i][j];
                        }
                    }
                }
            }

            if(metode == 1 && (sumber == 1 || sumber == 2)){
                // MENCARI SOLUSI SPL DENGAN ELIMINASI GAUSS
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
                                // mat.displayMatrix();
                                // System.out.println();
                            }
                        }
                    }
                }

                System.out.println("---------------------------------------------------------");
                System.out.println("Dengan metode Eliminasi Gauss, diperoleh solusi SPL:  ");
                // PANGGIL FUNGSI GAUSS
                for(i = 0; i < mat.rows; i++){
                    System.out.printf("X%d = %f\n",i+1,mat.matrix[i][mat.cols-1]);
                }

                // RES DIGUNAKAN UNTUK MENYIMPAN HASIL SOLUSI SPL
                System.out.println(res);
                System.out.println("---------------------------------------------------------");
                System.out.println("Hasil ingin disimpan? (y/n):    ");
                simpan = input.next().charAt(0);
                System.out.println("---------------------------------------------------------");
            }
            else if(metode == 2 && (sumber == 1 || sumber ==2)){
                // MENCARI SOLUSI SPL DENGAN ELIMINASI GAUSS JORDAN

                System.out.println();
                mat.gaussJordan();

                System.out.println("---------------------------------------------------------");
                System.out.println("Dengan metode Eliminasi Gauss-Jordan, diperoleh solusi SPL:  ");
                
                // PANGGIL FUNGSI GAUSS-JORDAN
                for(i = 0; i < mat.rows; i++){
                    System.out.printf("X%d = %f\n",i+1,mat.matrix[i][mat.cols-1]);
                }

                // RES DIGUNAKAN UNTUK MENYIMPAN HASIL SOLUSI SPL
                System.out.println(res);
                System.out.println("---------------------------------------------------------");
                System.out.println("Hasil ingin disimpan? (y/n):    ");
                simpan = input.next().charAt(0);
                System.out.println("---------------------------------------------------------");
            }
            else if(metode == 3){
                // MENCARI SOLUSI SPL DENGAN MATRIKS BALIKAN
                System.out.println("---------------------------------------------------------");
                if(sumber==1){
                    if(!mat.isSquare()){
                        System.out.println("Oleh karena matriks bukan persegi, maka");
                        System.out.println("Metode Matriks Balikan tidak dapat diterapkan");
                    }
                    else{
                        if(mat.determinanKofaktor() == 0){
                            System.out.println("Oleh karena determinan matriks = 0, maka");
                            System.out.println("Metode Matriks Balikan tidak dapat diterapkan");
                        }
                        else{
                            System.out.println("Masukan Matriks B: ");
                            b = new double[nRows][1];
                            for(i=0; i<nRows; i++){
                                b[i][0] = input.nextInt();
                            }
                            System.out.println("---------------------------------------------------------");
                            System.out.println("Dengan metode Matriks Balikan,");
                            System.out.println("diperoleh solusi SPL:     ");
                            res = mat.multiplyInvers(b);
                        }
                    }
                }
                else if (sumber == 2) {
                    if(!matA.isSquare()){
                        System.out.println("Oleh karena matriks bukan persegi, maka");
                        System.out.println("Metode Matriks Balikan tidak dapat diterapkan");
                    }
                    else{
                        if(matA.determinanKofaktor() == 0){
                            System.out.println("Oleh karena determinan matriks = 0, maka");
                            System.out.println("Metode Matriks Balikan tidak dapat diterapkan");
                        }
                        else{
                            System.out.println("Dengan metode Matriks Balikan,");
                            System.out.println("diperoleh solusi SPL:     ");
                            res = matA.multiplyInvers(matB);
                        }
                    }
                }
                // MENYIMPAN FILE
                System.out.println(res);
                System.out.println("---------------------------------------------------------");
                System.out.println("Hasil ingin disimpan? (y/n):    ");
                simpan = input.next().charAt(0);
                System.out.println("---------------------------------------------------------");

            }else if(metode==4){
                // MENYELESAIKAN SPL DENGAN METODE CRAMER
                System.out.println("---------------------------------------------------------");
                if(sumber==1){
                    if(!mat.isSquare()){
                        System.out.println("Oleh karena matriks bukan persegi, maka");
                        System.out.println("Metode Kaidah Cramer tidak dapat diterapkan");
                    }
                    else{
                        if(mat.determinanKofaktor() == 0){
                            System.out.println("Oleh karena determinan matriks = 0, maka");
                            System.out.println("Metode Kaidah Cramer tidak dapat diterapkan");
                        }
                        else{
                            System.out.println("Masukan Matriks B: ");
                            b = new double[nRows][1];
                            for(i=0; i<nRows; i++){
                                b[i][0] = input.nextInt();
                            }
                            System.out.println("Dengan metode Kaidah Cramer,");
                            System.out.println("diperoleh solusi SPL:     ");
                            res = mat.Cramer(b);
                        }
                    }
                }
                else if (sumber == 2) {
                    if(!matA.isSquare()){
                        System.out.println("Oleh karena matriks bukan persegi, maka");
                        System.out.println("Metode Kaidah Cramer tidak dapat diterapkan");
                    }
                    else{
                        if(matA.determinanKofaktor() == 0){
                            System.out.println("Oleh karena determinan matriks = 0, maka");
                            System.out.println("Metode Kaidah Cramer tidak dapat diterapkan");
                        }
                        else{
                            System.out.println("Dengan metode Kaidah Cramer,");
                            System.out.println("diperoleh solusi SPL:     ");
                            res = matA.Cramer(matB);
                        }
                    }
                }
                // MENYIMPAN FILE
                System.out.println(res);
                System.out.println("---------------------------------------------------------");
                System.out.println("Hasil ingin disimpan? (y/n):    ");
                simpan = input.next().charAt(0);
                System.out.println("---------------------------------------------------------");
            }

            if(simpan == 'y'){
                System.out.println("Nama output file (*.txt):       ");
                namaFile = input.next();
                BufferedWriter output = new BufferedWriter(new FileWriter("../test/output/"+namaFile));
                for(i=0; i<mat.rows; i++){
                    String string = "";
                    for(j=0; j<mat.cols; j++){
                        if(j!=0){
                            string += " ";
                        }
                        string += Double.toString(mat.matrix[i][j]);
                    }
                    string += "\n";
                    output.write(string);
                }
                if (metode == 1){
                    output.write("Dengan menggunakan Metode Eliminasi Gauss, diperoleh solusi SPL-nya: " + res +"\n");
                }
                else if (metode == 2){
                    output.write("Dengan menggunakan Metode Eliminasi Gauss Jordan, diperoleh solusi SPL-nya: " + res + "\n");
                }
                else if (metode == 3){
                    output.write("Dengan menggunakan Metode Matriks Balikan, diperoleh solusi SPL-nya: " + res + "\n");
                }
                else if (metode == 4){
                    output.write("Dengan menggunakan Metode Kaidah Cramer, diperoleh solusi SPL-nya: " + res + "\n");
                }
                output.close();
                System.out.println("---------------------------------------------------------");
                System.out.println("File " +namaFile+ " berhasil disimpan.");
            }

            System.out.println("---------------------------------------------------------");
            System.out.println("             Operasi Sistem Persamaan Linier             ");
            System.out.println("                          SELESAI                        ");
            System.out.println("                   Kembali ke Menu Utama                 ");
            System.out.println("---------------------------------------------------------");
            MainMenu();

        }catch (Exception e){
            System.out.println("Masukan menu tidak valid, silahkan ulangi.");
            subMenuSPL();
        }
    }

    public static void subMenuDet(){
        try{
            int metode,ukuran;
            int sumber =0;
            double res =0;
            char simpan =0;
            String namaFile = null;
            Matrix mat = new Matrix(0,0);
            Scanner input = new Scanner(System.in);

            System.out.println("---------------------------------------------------------");
            System.out.println("                           Menu                          ");
            System.out.println("                       2.Determinan                      ");
            System.out.println("---------------------------------------------------------");
            System.out.println("                      Pilihan Metode:                    ");
            System.out.println("1. Metode Eliminasi Gauss");
            System.out.println("2. Metode Ekspansi Kofaktor");
            System.out.println("3. Kembali ke Menu Utama");
            System.out.println("---------------------------------------------------------");
            System.out.println("Masukkan pilihan metode Anda: ");
            metode =  input.nextInt();

            switch(metode){
                case 1:
                    System.out.println("---------------------------------------------------------");
                    System.out.println("                         Metode                          ");
                    System.out.println("                1. Metode Eliminasi Gauss                ");
                    System.out.println("---------------------------------------------------------");
                    sumber = pilihanMasukan(1);
                    break;
                case 2:
                    System.out.println("---------------------------------------------------------");
                    System.out.println("                         Metode                          ");
                    System.out.println("               2. Metode Ekspansi Kofaktor               ");
                    System.out.println("---------------------------------------------------------");
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
                    System.out.println("---------------------------------------------------------");
                    System.out.println("                         Sumber                          ");
                    System.out.println("                   1. Masukan dari CLI                   ");
                    System.out.println("---------------------------------------------------------");
                    System.out.println("Masukkan ukuran matriks persegi (NxN) N: ");
                    ukuran = input.nextInt();
                    mat = new Matrix(ukuran,ukuran);
                    System.out.println("Masukkan matriks: ");
                    mat.readMatrixCLI(ukuran,ukuran);
                    System.out.println("Matriks berhasil dibaca.");
                    break;
                case 2:
                    System.out.println("---------------------------------------------------------");
                    System.out.println("                           Sumber                        ");
                    System.out.println("                2. Masukan dari file .txt                ");
                    System.out.println("---------------------------------------------------------");
                    System.out.println("Masukkan nama file (.txt) dalam folder test: ");
                    namaFile = input.next();
                    mat.readMatrixFILE(namaFile);
                    break;
                case 3:
                    subMenuDet();
                default:
                    System.out.println("Masukan sumber tidak valid, silahkan ulangi.");
                    subMenuDet();
            }
            System.out.println("---------------------------------------------------------");
            System.out.println("Matriks yang dibaca: ");
            mat.displayMatrix();

            // OPERASI DETERMINAN TARUH DISINI
            if(metode==1 && (sumber==1 || sumber==2)){
                // MENCARI NILAI DET DENGAN ELIMINASI GAUSS
                System.out.println("---------------------------------------------------------");
                System.out.println("Dengan metode Eliminasi Gauss,  ");
                System.out.println("diperoleh nilai determinan:     ");
                res = mat.determinanOBE();;
                System.out.println(res);
                System.out.println("---------------------------------------------------------");

                // MENYIMPAN FILE
                System.out.println("Hasil ingin disimpan? (y/n):    ");
                simpan = input.next().charAt(0);
                System.out.println("---------------------------------------------------------");
            }
            else if(metode==2 && (sumber==1 || sumber==2)){
                //MENCARI NILAI DET DENGAN EKSPANSI KOFAKTOR
                System.out.println("---------------------------------------------------------");
                System.out.println("Dengan metode Ekspansi Kofaktor,");
                System.out.println("diperoleh nilai determinan:     ");
                res = mat.determinanKofaktor();
                System.out.println(res);
                System.out.println("---------------------------------------------------------");
                // MENYIMPAN FILE
                System.out.println("Hasil ingin disimpan? (y/n):    ");
                simpan = input.next().charAt(0);
                System.out.println("---------------------------------------------------------");
            }

            

            if(simpan == 'y'){
                int i,j;
                System.out.println("Nama output file (*.txt):       ");
                namaFile = input.next();
                BufferedWriter output = new BufferedWriter(new FileWriter("../test/output/"+namaFile));
                for(i=0; i<mat.rows; i++){
                    String string = "";
                    for(j=0; j<mat.cols; j++){
                        if(j!=0){
                            string += " ";
                        }
                        string += Double.toString(mat.matrix[i][j]);
                    }
                    string += "\n";
                    output.write(string);
                }
                if (metode == 1){
                    output.write("Dengan menggunakan Metode Eliminasi Gauss, diperoleh nilai determinan matriks: " + res + "\n");
                }
                else if (metode == 2){
                    output.write("Dengan menggunakan Metode Ekspansi Kofaktor, diperoleh nilai determinan matriks: " + res + "\n");
                }
                output.close();
                System.out.println("---------------------------------------------------------");
                System.out.println("File " +namaFile+ " berhasil disimpan.");
            }
            System.out.println("---------------------------------------------------------");
            System.out.println("                   Operasi Determinan                    ");
            System.out.println("                         SELESAI                         ");
            System.out.println("                  Kembali ke Menu Utama                  ");
            System.out.println("---------------------------------------------------------");
            MainMenu();

        }catch (Exception e){
            System.out.println("Masukkan menu tidak valid, silahkan ulangi.");
            subMenuDet();
        }
    }
    public static void subMenuInv(){
        try{
            int metode, ukuran;
            int sumber =0;
            char simpan =0;
            String namaFile = null;
            Matrix mat = new Matrix(0,0);
            Matrix res = new Matrix(0,0);
            Scanner input  = new Scanner(System.in);

            System.out.println("---------------------------------------------------------");
            System.out.println("                           Menu                          ");
            System.out.println("                    3. Matriks Balikan                   ");
            System.out.println("---------------------------------------------------------");
            System.out.println("                      Pilihan Metode:                    ");
            System.out.println("1. Metode Eliminasi Gauss");
            System.out.println("2. Metode Ekspansi Kofaktor");
            System.out.println("3. Kembali ke Menu Utama");
            System.out.println("---------------------------------------------------------");
            System.out.println("Masukkan pilihan metode Anda: ");
            metode =  input.nextInt();

            switch(metode){
                case 1:
                    System.out.println("---------------------------------------------------------");
                    System.out.println("                          Metode                         ");
                    System.out.println("                1. Metode Eliminasi Gauss                ");
                    System.out.println("---------------------------------------------------------");
                    sumber = pilihanMasukan(1);
                    break;
                case 2:
                    System.out.println("---------------------------------------------------------");
                    System.out.println("                          Metode                         ");
                    System.out.println("               2. Metode Ekspansi Kofaktor               ");
                    System.out.println("---------------------------------------------------------");
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
                    System.out.println("---------------------------------------------------------");
                    System.out.println("                          Sumber                         ");
                    System.out.println("                    1. Masukan dari CLI                  ");
                    System.out.println("---------------------------------------------------------");
                    System.out.println("Masukkan ukuran matriks persegi (NxN) N: ");
                    ukuran = input.nextInt();
                    mat = new Matrix(ukuran,ukuran);
                    System.out.println("Masukkan matriks: ");
                    mat.readMatrixCLI(ukuran,ukuran);
                    System.out.println("Matriks berhasil dibaca.");
                    break;
                case 2:
                    System.out.println("---------------------------------------------------------");
                    System.out.println("                           Sumber                        ");
                    System.out.println("                 2. Masukan dari file .txt               ");
                    System.out.println("---------------------------------------------------------");
                    System.out.println("Masukkan nama file (.txt) dalam folder test: ");
                    namaFile = input.next();
                    mat.readMatrixFILE(namaFile);
                    break;
                case 3:
                    subMenuInv();
                default:
                    System.out.println("Masukan sumber tidak valid, silahkan ulangi.");
                    subMenuInv();
            }
            System.out.println("---------------------------------------------------------");
            System.out.println("Matriks yang dibaca: ");
            mat.displayMatrix();

            // OPERASI MATRIKS BALIKAN TARUH DISINI
            if(metode==1 && (sumber==1 || sumber==2)){
                // MENCARI MATRIKS BALIKAN DENGAN ELIMINASI GAUSS
                if(mat.isZero(mat.inverseOBE(), mat.epsilon)){
                    System.out.println("---------------------------------------------------------");
                    System.out.println("Dengan metode Eliminasi Gauss,  ");
                    System.out.println("diperoleh matriks balikan:     ");
                    mat.displayMatrix();
                    res = mat;

                    System.out.println("---------------------------------------------------------");
                    

                }
                else{
                    System.out.println("determinan matriks adalah 0,\nmatriks tidak memiliki matriks balikan\n---------------------------------------------------------");
                }

                // MENYIMPAN FILE
                System.out.println("Hasil ingin disimpan? (y/n):    ");
                simpan = input.next().charAt(0);
                System.out.println("---------------------------------------------------------");
                
            }
            else if(metode==2 && (sumber==1 || sumber==2)){
                //MENCARI MATRIKS BALIKAN DENGAN EKSPANSI KOFAKTOR
                if(mat.determinanKofaktor() == 0){
                    System.out.println("Oleh karena determinan matriks = 0, maka");
                    System.out.println("matriks tidak memiliki balikan");
                    System.out.println("---------------------------------------------------------");
                }
                else{
                    System.out.println("---------------------------------------------------------");
                    System.out.println("Dengan metode Ekspansi Kofaktor,");
                    System.out.println("diperoleh matriks balikannya:   ");
                    res = mat;
                    res.invers();
                    res.displayMatrix();
                    System.out.println("---------------------------------------------------------");
                }
                // MENYIMPAN FILE
                System.out.println("Hasil ingin disimpan? (y/n):    ");
                simpan = input.next().charAt(0);
                System.out.println("---------------------------------------------------------");
            }

            if(simpan == 'y'){
                int i,j;
                System.out.println("Nama output file (*.txt):       ");
                namaFile = input.next();
                BufferedWriter output = new BufferedWriter(new FileWriter("../test/output/"+namaFile));
                for(i=0; i<mat.rows; i++){
                    String string = "";
                    for(j=0; j<mat.cols; j++){
                        if(j!=0){
                            string += " ";
                        }
                        string += Double.toString(mat.matrix[i][j]);
                    }
                    string += "\n";
                    output.write(string);
                }
                if (metode == 1){
                    output.write("Dengan menggunakan Metode Eliminasi Gauss, diperoleh matriks balikannya: " + res +"\n");
                }
                else if (metode == 2){
                    output.write("Dengan menggunakan Metode Ekspansi Kofaktor, diperoleh matriks balikannya: " + res + "\n");
                }
                output.close();
                System.out.println("---------------------------------------------------------");
                System.out.println("File " +namaFile+ " berhasil disimpan.");
            }
            System.out.println("---------------------------------------------------------");
            System.out.println("                  Operasi Matriks Balikan                ");
            System.out.println("                         SELESAI                         ");
            System.out.println("                   Kembali ke Menu Utama                 ");
            System.out.println("---------------------------------------------------------");
            MainMenu();

        }catch (Exception e){
            System.out.println("Masukkan menu tidak valid, silahkan ulangi.");
            subMenuInv();
        }
    }
    public static void subMenuInterPol(){
        try{
            int sumber;
            char simpan =0;
            String namaFile = null;
            Matrix mat = new Matrix(0,0);
            Scanner input = new Scanner(System.in);
            int i,j;
            double[] solusiInterpolasi = new double[1];
            Matrix xy = new Matrix(0, 0);
            
            int n= 0;

            System.out.println("---------------------------------------------------------");
            System.out.println("                           Menu                          ");
            System.out.println("                  4. Interpolasi Polinom                 ");
            System.out.println("---------------------------------------------------------");
            sumber = pilihanMasukan(0);

            switch(sumber){
                case 1:
                    System.out.println("---------------------------------------------------------");
                    System.out.println("                          Sumber                         ");
                    System.out.println("                    1. Masukan dari CLI                  ");
                    System.out.println("---------------------------------------------------------");
                    // MEMINTA MASUKAN TITIK DAN CREATE TITIK
                    System.out.printf("Masukkan banyaknya titik sampel (X,Y) = ");
                    n = input.nextInt();
                    solusiInterpolasi = new double[n];
                    xy = new Matrix(n, 2);
                    for(i = 0; i < n; i++){
                        System.out.printf("\nMasukkan X%d = ",i+1);
                        xy.matrix[i][0] = input.nextDouble();
                        System.out.printf("Masukkan Y%d = ",i+1);
                        xy.matrix[i][1] = input.nextDouble();

                    }
                    break;
                case 2:
                    System.out.println("---------------------------------------------------------");
                    System.out.println("                           Sumber                        ");
                    System.out.println("                 2. Masukan dari file .txt               ");
                    System.out.println("---------------------------------------------------------");
                    System.out.println("Masukkan nama file (.txt) dalam folder test: ");
                    namaFile = input.next();
                    mat.readMatrixFILE(namaFile);
                    // NILAI TITIK
                    break;
                default:
                    System.out.println("Masukan sumber tidak valid, silahkan ulangi.");
                    subMenuInterPol();
            }

            // OPERASI INTERPOLASI POLINOM TARUH DISINI
                /* Interpolasi di main asyik */
            
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

            System.out.printf("\nSolusi SPL f(x) =");

            
            for(i = n-1; i >= 0; i--){

                if(i == 0){
                    System.out.printf(" %f", solusiInterpolasi[0]);
                }

                else if(i == 1){
                    System.out.printf(" %fx +", solusiInterpolasi[1]);
                }

                else{
                    System.out.printf(" %fx^%d +", solusiInterpolasi[i],i);
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
            // MENYIMPAN FILE
            System.out.println("Hasil ingin disimpan? (y/n):    ");
            simpan = input.next().charAt(0);
            System.out.println("---------------------------------------------------------");

            if(simpan == 'y'){
                System.out.println("Nama output file (*.txt):       ");
                namaFile = input.next();
                BufferedWriter output = new BufferedWriter(new FileWriter("../test/output/"+namaFile));
                for(i=0; i<mat.rows; i++){
                    String string = "";
                    for(j=0; j<mat.cols; j++){
                        if(j!=0){
                            string += " ";
                        }
                        string += Double.toString(mat.matrix[i][j]);
                    }
                    string += "\n";
                    output.write(string);
                }

                String strong = "";
                System.out.printf("f(x) =");

            
                for(i = n-1; i >= 0; i--){

                    if(i == 0){
                        strong += " " + Double.toString(solusiInterpolasi[0]) ;
                    }

                    else if(i == 1){
                        strong += " "+ Double.toString(solusiInterpolasi[1]) + "x +";
                    }

                    else{
                        strong += " " + Double.toString(solusiInterpolasi[i]) + "x^" + Integer.toString(i) +" +";
                    }

                    
                    
                }


                output.write(strong/* TULIS DISINI BOSSS OUTPUT INTERPOLASI NYA*/);
            output.close();
            System.out.println("---------------------------------------------------------");
            System.out.println("File " +namaFile+ " berhasil disimpan.");

            System.out.println("---------------------------------------------------------");
            System.out.println("                Operasi Interpolasi Polinom              ");
            System.out.println("                          SELESAI                        ");
            System.out.println("                   Kembali ke Menu Utama                 ");
            System.out.println("---------------------------------------------------------");
            MainMenu();
            }
        }catch (Exception e){
            System.out.println("Masukkan menu tidak valid, silahkan ulangi.");
            subMenuInterPol();
        }
    }
    public static void subMenuInterBic(){
        try{
            int sumber;
            char simpan =0;
            String namaFile = null;
            Matrix mat = new Matrix(0,0);
            Scanner input = new Scanner(System.in);

            System.out.println("---------------------------------------------------------");
            System.out.println("                           Menu                          ");
            System.out.println("                  5. Interpolasi Bicubic                 ");
            System.out.println("---------------------------------------------------------");
            sumber = pilihanMasukan(0);

            switch(sumber){
                case 1:
                    System.out.println("---------------------------------------------------------");
                    System.out.println("                          Sumber                         ");
                    System.out.println("                    1. Masukan dari CLI                  ");
                    System.out.println("---------------------------------------------------------");
                    // MEMINTA MASUKAN TITIK DAN CREATE TITIK
                    break;
                case 2:
                    System.out.println("---------------------------------------------------------");
                    System.out.println("                           Sumber                        ");
                    System.out.println("                2. Masukan dari file .txt                ");
                    System.out.println("---------------------------------------------------------");
                    System.out.println("Masukkan nama file (.txt) dalam folder test: ");
                    namaFile = input.next();
                    mat.readMatrixFILE(namaFile);
                    // NILAI TITIK
                    break;
                default:
                    System.out.println("Masukan sumber tidak valid, silahkan ulangi.");
                    subMenuInterBic();
            }

            // OPERASI INTERPOLASI BICUBIC TARUH DISINI
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

            // MENYIMPAN FILE
            System.out.println("Hasil ingin disimpan? (y/n):    ");
            simpan = input.next().charAt(0);
            System.out.println("---------------------------------------------------------");

            if(simpan == 'y'){
                System.out.println("Nama output file (*.txt):       ");
                namaFile = input.next();
                BufferedWriter output = new BufferedWriter(new FileWriter("../test/output/"+namaFile));
                for(i=0; i<mat.rows; i++){
                    String string = "";
                    for(j=0; j<mat.cols; j++){
                        if(j!=0){
                            string += " ";
                        }
                        string += Double.toString(mat.matrix[i][j]);
                    }
                    string += "\n";
                    output.write(string);
                }

                String strong = "";
                strong += ("f(" + Double.toString(u) +","+ Double.toString(v) + ") = " + Double.toString(sum));


                output.write(strong/* TULIS DISINI BOSSS OUTPUT bicubb NYA*/);
            output.close();
            System.out.println("---------------------------------------------------------");
            System.out.println("File " +namaFile+ " berhasil disimpan.");                      
            System.out.println("---------------------------------------------------------");
            System.out.println("               Operasi Interpolasi Bicubic               ");
            System.out.println("                         SELESAI                         ");
            System.out.println("                  Kembali ke Menu Utama                  ");
            System.out.println("---------------------------------------------------------");
            MainMenu();
            }

        }catch (Exception e){
            System.out.println("Masukkan menu tidak valid, silahkan ulangi.");
            subMenuInterBic();
        }
    }
    public static void subMenuRLB() {
        try {
            int sumber, i, j, k;
            String namaFile = null;
            Matrix mat = new Matrix(0, 0);
            Scanner input = new Scanner(System.in);
            Matrix x = new Matrix(0, 0);
            Matrix y = new Matrix(0, 0);
            double[] xTaksir = new double[1];
            int peubahX = 0, nSampel = 0;
            char simpan =' ';

            System.out.println("---------------------------------------------------------");
            System.out.println("                          Menu                           ");
            System.out.println("               5. Regresi Linier Berganda                ");
            System.out.println("---------------------------------------------------------");
            sumber = pilihanMasukan(0);

            switch (sumber) {
                case 1:
                    System.out.println("---------------------------------------------------------");
                    System.out.println("                          Sumber                         ");
                    System.out.println("                    1. Masukan dari CLI                  ");
                    System.out.println("---------------------------------------------------------");
                    // MEMINTA MASUKAN TITIK DAN CREATE TITIK
                    System.out.printf("\nMasukkan banyak sampel n : ");
                    nSampel = input.nextInt();
                    System.out.printf("\nMasukkan banyak varibel x : ");
                    peubahX = input.nextInt();

                    x = new Matrix(nSampel, peubahX + 1);
                    y = new Matrix(nSampel, 1);
                    xTaksir = new double[peubahX + 1];


                    for (i = 0; i < nSampel; i++) {
                        for (j = 0; j < peubahX + 2; j++) {
                            if (j == 0) {
                                x.matrix[i][0] = 1;
                            } else {
                                if (j == peubahX + 1) {
                                    System.out.printf("Masukkan nilai y untuk sampel %d : ", i + 1);
                                    y.matrix[i][0] = input.nextDouble();
                                } else {
                                    System.out.printf("Masukkan nilai X%d untuk sampel %d : ", j, i + 1);
                                    x.matrix[i][j] = input.nextDouble();
                                }

                            }

                        }
                    }

                    System.out.println("\nMasukkan nilai-nilai X yang akan ditaksir...\n");
                    for (i = 0; i < peubahX + 1; i++) {
                        if (i == 0) {
                            xTaksir[0] = 1;
                        } else {
                            System.out.printf("Nilai X%d : ", i);
                            xTaksir[i] = input.nextDouble();
                        }

                    }
                    break;
                case 2:
                    System.out.println("---------------------------------------------------------");
                    System.out.println("                           Sumber                        ");
                    System.out.println("                 2. Masukan dari file .txt               ");
                    System.out.println("---------------------------------------------------------");
                    System.out.println("Masukkan nama file (.txt) dalam folder test: ");
                    namaFile = input.next();
                    mat.readMatrixFILE(namaFile);
                    // NILAI TITIK
                    break;
                default:
                    System.out.println("Masukan sumber tidak valid, silahkan ulangi.");
                    subMenuRLB();
            }

            // OPERASI REGRESI LINIER BERGANDA TARUH DISINI        

            Matrix yNEE = new Matrix(peubahX + 1, 1);
            Matrix matRLB = new Matrix(peubahX + 1, peubahX + 1);
            double yTaksir = 0;


            for (i = 0; i < peubahX + 1; i++) {
                for (j = 0; j < peubahX + 1; j++) {
                    matRLB.matrix[i][j] = 0;

                    for (k = 0; k < nSampel; k++) {
                        matRLB.matrix[i][j] += x.matrix[k][i] * x.matrix[k][j];
                    }
                }
            }


            matRLB.inverseOBE();
            /* Sudah didapatkan inverse di matRLB */

            /* Membuat sisi kanan NEE */
            for (i = 0; i < peubahX + 1; i++) {
                yNEE.matrix[i][0] = 0;
                for (j = 0; j < nSampel; j++) {
                    yNEE.matrix[i][0] += x.matrix[j][i] * y.matrix[j][0];
                }
            }

            Matrix solusi = matRLB.multiplyMatrix(matRLB, yNEE);

            System.out.println("Maka didapatkan persamaan..\n");
            System.out.printf("f(x) =");

            for (i = 0; i < peubahX + 1; i++) {
                if( i == 0){
                    System.out.printf(" %f +", solusi.matrix[i][0]);
                }
                else{
                    System.out.printf(" %fX%d", solusi.matrix[i][0], i);
                }
                
            }
            System.out.println();

            for (i = 0; i < peubahX + 1; i++) {
                yTaksir += xTaksir[i] * solusi.matrix[i][0];
            }

            System.out.printf("y =");
            for (i = 0; i < peubahX + 1; i++) {
                System.out.printf(" %f x %f", solusi.matrix[i][0], xTaksir[i]);
                if (i != peubahX) {
                    System.out.printf(" +");
                }
            }
            System.out.printf(" = %f", yTaksir);

            // MENYIMPAN FILE
            System.out.println("Hasil ingin disimpan? (y/n):    ");
            simpan = input.next().charAt(0);
            System.out.println("---------------------------------------------------------");

            if(simpan == 'y'){
                System.out.println("Nama output file (*.txt):       ");
                namaFile = input.next();
                BufferedWriter output = new BufferedWriter(new FileWriter("../test/output/"+namaFile));
                for(i=0; i<mat.rows; i++){
                    String string = "";
                    for(j=0; j<mat.cols; j++){
                        if(j!=0){
                            string += " ";
                        }
                        string += Double.toString(mat.matrix[i][j]);
                    }
                    string += "\n";
                    output.write(string);
                }

                String strong = "";
                strong += ("f(x) = ");

                strong += Double.toString(solusi.matrix[0][0]) + " ";
                
                if (peubahX+1 >= 2){
                    strong += "+ " + Double.toString(solusi.matrix[1][0]) + "x1 " ;
                }

                if ( peubahX+1 >= 3){
                    for(i = 2; i < peubahX+1; i++){
                        strong += " + " + Double.toString(solusi.matrix[i][0]) + "x"+ Integer.toString(i)+ " " ;
                    }
                }

                strong += "\nf(Xk) = " + Double.toString(yTaksir); 


                output.write(strong/* TULIS DISINI BOSSS OUTPUT INTERPOLASI NYA*/);
            output.close();
            System.out.println("---------------------------------------------------------");
            System.out.println("File " +namaFile+ " berhasil disimpan.");
            System.out.println("---------------------------------------------------------");
            System.out.println("             Operasi Regresi Linier Berganda             ");
            System.out.println("                         SELESAI                         ");
            System.out.println("                  Kembali ke Menu Utama                  ");
            System.out.println("---------------------------------------------------------");
            MainMenu();
            }

        } catch (Exception e) {
            System.out.println("Masukkan menu tidak valid, silahkan ulangi.");
            subMenuRLB();
        }
    }
    public static int pilihanMasukan(int jenis){
        int sumber;
        Scanner input = new Scanner(System.in);
        System.out.println("                     Pilihan Sumber:                     ");
        System.out.println("---------------------------------------------------------");
        System.out.println("1. Masukan dari CLI");
        System.out.println("2. Masukan dari file .txt");
        switch(jenis){
            case 1:
                System.out.println("3. Kembali ke Menu Pilihan Metode");
            default:
                break;
        }

        System.out.println("---------------------------------------------------------");

        System.out.println("Masukkan pilihan sumber Anda: ");
        sumber = input.nextInt();
        return sumber;
    }

    public static void penutup()
    {
        System.out.println("---------------------------------------------------------");
        System.out.println("                       Terima Kasih                      ");
        System.out.println("                     telah menggunakan                   ");
        System.out.println("                  Kalkulator Matriks Kami                ");
        System.out.println("---------------------------------------------------------");
        System.exit(0);
    }

}
