

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
            System.out.println("   KAKEAN CANGKEM DIISI MENGKO  ");
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
                    subMenuInter();
                    break;
                case 5:
                    subMenuRLB();
                    break;
                case 6:
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
                    mat.readMatrixCLI();
                    System.out.println("Matriks berhasil dibaca.");
                    break;
                case 2:
                    System.out.println("--------------------------------");
                    System.out.println("             Masukan            ");
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
            



        }
    }

    public static void subMenuDet(){}
    public static void subMenuInv(){}
    public static void subMenuInter(){}
    public static void subMenuRLB(){}
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
