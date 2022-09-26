import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
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
                    System.out.println("Matriks berhasil dibaca.");
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
