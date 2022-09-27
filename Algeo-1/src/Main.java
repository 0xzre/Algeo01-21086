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
                Thread.sleep(1);
            }catch(InterruptedException e){};
        }
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
            System.out.println("1. Sistem Persamaan Linier(SPL) ");
            System.out.println("2. Determinan");
            System.out.println("3. Matriks Balikan");
            System.out.println("4. Interpolasi Polinom");
            System.out.println("5. Interpolasi Bicubic");
            System.out.println("6. Regresi Linier berganda");
            System.out.println("7. Keluar");
            System.out.println("--------------------------------");
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
            int i,j,metode,nRows=0,nCols=0;
            int sumber =0;
            char simpan =0;
            String res = "";
            double b[][];
            String namaFile = null;
            Matrix mat = new Matrix(0,0);
            Matrix matA = new Matrix(0,0);
            double[][] matB = new double[0][0];
            Scanner input = new Scanner(System.in);

            System.out.println("--------------------------------");
            System.out.println("              Menu              ");
            System.out.println(" 1.Sistem Persamaan Linier(SPL) ");
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
                    System.out.println("Matriks berhasil dibaca.");
                    break;
                case 2:
                    System.out.println("--------------------------------");
                    System.out.println("             Sumber             ");
                    System.out.println("    2. Masukan dari file .txt   ");
                    System.out.println("--------------------------------");
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
            System.out.println("--------------------------------");
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

            if(metode == 1){
                // MENCARI SOLUSI SPL DENGAN ELIMINASI GAUSS
                System.out.println("--------------------------------");
                System.out.println("Dengan metode Eliminasi Gauss,  ");
                System.out.println("diperoleh solusi SPL:     ");
                // PANGGIL FUNGSI GAUSS
            }
            else if(metode == 2){
                // MENCARI SOLUSI SPL DENGAN ELIMINASI GAUSS JORDAN
                System.out.println("--------------------------------");
                System.out.println("Dengan metode Eliminasi Gauss-Jordan,");
                System.out.println("diperoleh nilai determinan:     ");
                // PANGGIL FUNGSI GAUSS-JORDAN
            }
            else if(metode == 3){
                // MENCARI SOLUSI SPL DENGAN MATRIKS BALIKAN
                System.out.println("--------------------------------");
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
                            System.out.println("Dengan metode Matriks Balikan,");
                            System.out.println("diperoleh solusi SPL:     ");
                            res = mat.multiplyInvers(b);
                            System.out.println(res);
                            System.out.println("--------------------------------");
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
                            System.out.println(res);
                            System.out.println("--------------------------------");
                        }
                    }
                }
                // MENYIMPAN FILE
                System.out.println("Hasil ingin disimpan? (y/n):    ");
                simpan = input.next().charAt(0);
                System.out.println("--------------------------------");
            }else if(metode==4){
                // MENYELESAIKAN SPL DENGAN METODE CRAMER
                System.out.println("--------------------------------");
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
                            System.out.println(res);
                            System.out.println("--------------------------------");
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
                            System.out.println(res);
                            System.out.println("--------------------------------");
                        }
                    }
                }
                // MENYIMPAN FILE
                System.out.println("Hasil ingin disimpan? (y/n):    ");
                simpan = input.next().charAt(0);
                System.out.println("--------------------------------");
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
                    output.write("Dengan menggunakan Metode Eliminasi Gauss, diperoleh nilai determinan matriks: " + res +"\n");
                }
                else if (metode == 2){
                    output.write("Dengan menggunakan Metode Ekspansi Kofaktor, diperoleh nilai determinan matriks: " + res + "\n");
                }
                output.close();
                System.out.println("--------------------------------");
                System.out.println("File " +namaFile+ ".txt berhasil disimpan.");
            }

            System.out.println("--------------------------------");
            System.out.println(" Operasi Sistem Persamaan Linier");
            System.out.println("             SELESAI            ");
            System.out.println("      Kembali ke Menu Utama     ");
            System.out.println("--------------------------------");
            MainMenu();

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
            char simpan =0;
            String namaFile = null;
            Matrix mat = new Matrix(0,0);
            Scanner input = new Scanner(System.in);

            System.out.println("--------------------------------");
            System.out.println("              Menu              ");
            System.out.println("          2.Determinan          ");
            System.out.println("--------------------------------");
            System.out.println("         Pilihan Metode:        ");
            System.out.println("1. Metode Eliminasi Gauss");
            System.out.println("2. Metode Ekspansi Kofaktor");
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
                    System.out.println("   2. Metode Ekspansi Kofaktor  ");
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
                    mat.readMatrixFILE(namaFile);
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

            // OPERASI DETERMINAN TARUH DISINI
            if(metode==1 && (sumber==1 || sumber==2)){
                // MENCARI NILAI DET DENGAN ELIMINASI GAUSS
                System.out.println("--------------------------------");
                System.out.println("Dengan metode Eliminasi Gauss,  ");
                System.out.println("diperoleh nilai determinan:     ");


                // MENYIMPAN FILE
                System.out.println("Hasil ingin disimpan? (y/n):    ");
                simpan = input.next().charAt(0);
                System.out.println("--------------------------------");
            }
            else if(metode==2 && (sumber==1 || sumber==2)){
                //MENCARI NILAI DET DENGAN EKSPANSI KOFAKTOR
                System.out.println("--------------------------------");
                System.out.println("Dengan metode Ekspansi Kofaktor,");
                System.out.println("diperoleh nilai determinan:     ");
                res = mat.determinanKofaktor();
                System.out.println(res);
                System.out.println("--------------------------------");
                // MENYIMPAN FILE
                System.out.println("Hasil ingin disimpan? (y/n):    ");
                simpan = input.next().charAt(0);
                System.out.println("--------------------------------");
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
                System.out.println("--------------------------------");
                System.out.println("File " +namaFile+ ".txt berhasil disimpan.");
            }
            System.out.println("--------------------------------");
            System.out.println("       Operasi Determinan       ");
            System.out.println("             SELESAI            ");
            System.out.println("      Kembali ke Menu Utama     ");
            System.out.println("--------------------------------");
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

            System.out.println("--------------------------------");
            System.out.println("              Menu              ");
            System.out.println("       3. Matriks Balikan       ");
            System.out.println("--------------------------------");
            System.out.println("         Pilihan Metode:        ");
            System.out.println("1. Metode Eliminasi Gauss");
            System.out.println("2. Metode Ekspansi Kofaktor");
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
                    System.out.println("   2. Metode Ekspansi Kofaktor  ");
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
                    mat.readMatrixFILE(namaFile);
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

            // OPERASI MATRIKS BALIKAN TARUH DISINI
            if(metode==1 && (sumber==1 || sumber==2)){
                // MENCARI MATRIKS BALIKAN DENGAN ELIMINASI GAUSS
                System.out.println("--------------------------------");
                System.out.println("Dengan metode Eliminasi Gauss,  ");
                System.out.println("diperoleh nilai determinan:     ");


                // MENYIMPAN FILE
                System.out.println("Hasil ingin disimpan? (y/n):    ");
                simpan = input.next().charAt(0);
                System.out.println("--------------------------------");
            }
            else if(metode==2 && (sumber==1 || sumber==2)){
                //MENCARI MATRIKS BALIKAN DENGAN EKSPANSI KOFAKTOR
                if(mat.determinanKofaktor() == 0){
                    System.out.println("Oleh karena determinan matriks = 0, maka");
                    System.out.println("matriks tidak memiliki balikan");
                    System.out.println("--------------------------------");
                }
                else{
                    System.out.println("--------------------------------");
                    System.out.println("Dengan metode Ekspansi Kofaktor,");
                    System.out.println("diperoleh matriks balikannya:   ");
                    res = mat;
                    res.invers();
                    res.displayMatrix();
                    System.out.println("--------------------------------");
                }
                // MENYIMPAN FILE
                System.out.println("Hasil ingin disimpan? (y/n):    ");
                simpan = input.next().charAt(0);
                System.out.println("--------------------------------");
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
                System.out.println("--------------------------------");
                System.out.println("File " +namaFile+ " berhasil disimpan.");
            }
            System.out.println("--------------------------------");
            System.out.println("     Operasi Matriks Balikan    ");
            System.out.println("             SELESAI            ");
            System.out.println("      Kembali ke Menu Utama     ");
            System.out.println("--------------------------------");
            MainMenu();

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
                    mat.readMatrixFILE(namaFile);
                    // NILAI TITIK
                    break;
                default:
                    System.out.println("Masukan sumber tidak valid, silahkan ulangi.");
                    subMenuInterPol();
            }

            // OPERASI INTERPOLASI POLINOM TARUH DISINI

            System.out.println("--------------------------------");
            System.out.println("   Operasi Interpolasi Polinom  ");
            System.out.println("             SELESAI            ");
            System.out.println("      Kembali ke Menu Utama     ");
            System.out.println("--------------------------------");
            MainMenu();

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
                    mat.readMatrixFILE(namaFile);
                    // NILAI TITIK
                    break;
                default:
                    System.out.println("Masukan sumber tidak valid, silahkan ulangi.");
                    subMenuInterBic();
            }

            // OPERASI INTERPOLASI BICUBIC TARUH DISINI

            System.out.println("--------------------------------");
            System.out.println("   Operasi Interpolasi Bicubic  ");
            System.out.println("             SELESAI            ");
            System.out.println("      Kembali ke Menu Utama     ");
            System.out.println("--------------------------------");
            MainMenu();

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
            System.out.println("   5. Regresi Linier Berganda   ");
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
                    mat.readMatrixFILE(namaFile);
                    // NILAI TITIK
                    break;
                default:
                    System.out.println("Masukan sumber tidak valid, silahkan ulangi.");
                    subMenuRLB();
            }

            // OPERASI REGRESI LINIER BERGANDA TARUH DISINI

            System.out.println("--------------------------------");
            System.out.println(" Operasi Regresi Linier Berganda");
            System.out.println("             SELESAI            ");
            System.out.println("      Kembali ke Menu Utama     ");
            System.out.println("--------------------------------");
            MainMenu();

        }catch (Exception e){
            System.out.println("Masukkan menu tidak valid, silahkan ulangi.");
            subMenuRLB();
        }
    }
    public static int pilihanMasukan(int jenis){
        int sumber;
        Scanner input = new Scanner(System.in);
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
        System.out.println("--------------------------------");
        System.out.println("          Terima Kasih          ");
        System.out.println("        telah menggunakan       ");
        System.out.println("     Kalkulator Matriks Kami    ");
        System.out.println("--------------------------------");
        System.exit(0);
    }

}
