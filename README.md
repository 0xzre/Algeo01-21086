# 🧮🔥 Algeo01-13521086 🔥🧮
<a href='https://www.java.com/en/' target="_blank"><img alt='oracle' src='https://img.shields.io/badge/JAVA_| Language-100000?style=flat&logo=oracle&logoColor=FFFFFF&labelColor=6C6C6C&color=A90000'/></a>  <a href='https://github.com/semifinal-com/Algeo01-13521086' target="_blank"><img alt='github' src='https://img.shields.io/badge/GITHUB_| VersionControlSystem-100000?style=flat&logo=github&logoColor=FFFFFF&labelColor=6C6C6C&color=1D00A0'/></a>
<a href='https://line.me/en/' target="_blank"><img alt='line' src='https://img.shields.io/badge/LINE_| Communication-100000?style=flat&logo=line&logoColor=FFFFFF&labelColor=6C6C6C&color=0F9300'/></a>

## Sistem Persamaan Linear, Determinan ,dan Aplikasinya 
Program ini dibuat untuk memenuhi **Tugas Besar Mata Kuliah IF2123 Aljabar Linier dan Geometri** yang ke-1 pada Semester I Tahun Akademik 2022/2023.

## Deskripsi Program
Program dalam bahasa Java yang dapat digunakan untuk menyelesaikan persoalan-persoalan terkait **Sistem Persamaan Linear(SPL), Determinan, serta aplikasi lain dari keduanya**.

Penjelasan singkat mengenai folder/file:
- `Algeo-1` folder utama yang berisi folder-folder lain<br>
	- `bin` berisi Java bytecode **(*.class)**
	- `src` berisi Java source code **(*.java)**
	- `test/input` berisi File **(*.txt)** masukan/data uji
	- `test/output` berisi File **(*.txt)** penyimpanan hasil operasi
- `README.md` file Markdown sebagai deskripsi program keseluruhan
- `Tubes1-Algeo-2022.pdf` file spesifikasi TuBes Algeo01

## Anggota Kelompok
**Kelompok Seringai** 🐺
* 13521086 - Ariel Jovananda <a href="https://github.com/arieljovananda88">GitHub</a>
* 13521128 - Muhammad Abdul Aziz Ghazali <a href="https://github.com/semifinal-com">GitHub</a>
* 13521166 - Mohammad Rifqi Farhansyah <a href="https://github.com/rifqifarhansyah">GitHub</a>

## CARA MENJALANKAN PROGRAM
Pertama, compile file.java dengan command `javac -d bin src/*java`. Hasil compile program akan berupa Java bytecode `.class` yang akan langsung ditampung pada folder `/bin`. Langkah selanjutnya, masuk ke folder `/bin` lalu jalankan command `java Main` untuk menjalankan program. **Main** merupakan nama class utama dari program ini.

## MENU UTAMA
Setelah program dijalankan, CLI akan menampilkan **menu utama** sebagai berikut:
```
███████╗███████╗██████╗ ██╗███╗   ██╗ ██████╗  █████╗ ██╗
██╔════╝██╔════╝██╔══██╗██║████╗  ██║██╔════╝ ██╔══██╗██║
███████╗█████╗  ██████╔╝██║██╔██╗ ██║██║  ███╗███████║██║
╚════██║██╔══╝  ██╔══██╗██║██║╚██╗██║██║   ██║██╔══██║██║
███████║███████╗██║  ██║██║██║ ╚████║╚██████╔╝██║  ██║██║
╚══════╝╚══════╝╚═╝  ╚═╝╚═╝╚═╝  ╚═══╝ ╚═════╝ ╚═╝  ╚═╝╚═╝
---------------------------------------------------------
                      TUBES ALGEO-01
  SISTEM PERSAMAAN LINIER, DETERMINAN, DAN APLIKASINYA
---------------------------------------------------------
                        Menu Utama
---------------------------------------------------------
1. Sistem Persamaan Linier(SPL)
2. Determinan
3. Matriks Balikan
4. Interpolasi Polinom
5. Interpolasi Bicubic
6. Regresi Linier berganda
7. Keluar
---------------------------------------------------------
Masukkan pilihan menu Anda:

```
Masukkan SubMenu yang hendak dijalankan berupa sebuah masukan angka, antara 1-6 (inklusif).
## SISTEM PERSAMAAN LINIER
Apabila pengguna memasukkan angka 1 (Sistem Persamaan Linier), maka akan muncul **pilihan metode** yang dapat digunakan sesuai kebutuhan pengguna. Masing-masing pilihan berkaitan dengan metode penyelesaian Sistem Persamaan Linier(SPL).
```
---------------------------------------------------------
                           Menu
              1.Sistem Persamaan Linier(SPL)
---------------------------------------------------------
                      Pilihan Metode:
1. Metode Eliminasi Gauss
2. Metode Eliminasi Gauss-Jordan
3. Metode Matriks balikan
4. Kaidah Cramer
5. Kembali ke Menu Utama
---------------------------------------------------------
Masukkan pilihan metode Anda:

```
## Pilihan Sumber
Pada tiap pilihan metode yang telah ditentukan oleh pengguna, akan memunculkan sebuah menu lanjutan berupa **pilihan sumber input** yang dapat ditentukan sendiri oleh pengguna. pengguna dapat memilih untuk langsung memasukkan data olahan via `CLI/keyboard` atau melalui `file.txt`
```
---------------------------------------------------------
                          Metode
                 1. Metode Eliminasi Gauss
---------------------------------------------------------
                     Pilihan Sumber:
---------------------------------------------------------
1. Masukan dari CLI
2. Masukan dari file .txt
3. Kembali ke Menu Pilihan Metode
---------------------------------------------------------
Masukkan pilihan sumber Anda:

```
### Metode Eliminasi Gauss
Mula-mula pengguna akan diminta untuk memasukkan matriks *augmented* dari Sistem Persamaan Linear yang hendak diselesaikan. Misal, sebuah sistem persamaan linier terdiri dari tiga persamaan di bawah ini:
> x+y+z=0;  
> 2x+3y+z=1;  
> 3x+y+2z=1;  

Maka matriks *augmented*-nya adalah <br>
1 1 1 0 <br>
2 3 1 1 <br>
3 1 2 1 <br>

Untuk masukan via CLI, pengguna akan diminta untuk memasukkan nilai tiap elemen baris dan kolom pada matriks augmented, program yang akan muncul sebagai berikut:
```
---------------------------------------------------------
                          Sumber
                    1. Masukan dari CLI
---------------------------------------------------------
Masukkan jumlah baris:
3
Masukkan jumlah kolom:
4
Masukkan matriks:
Masukkan nilai untuk baris ke-1 kolom ke-1:
1
Masukkan nilai untuk baris ke-1 kolom ke-2:
1
Masukkan nilai untuk baris ke-1 kolom ke-3:
1
Masukkan nilai untuk baris ke-1 kolom ke-4:
0
Masukkan nilai untuk baris ke-2 kolom ke-1:
2
Masukkan nilai untuk baris ke-2 kolom ke-2:
3
Masukkan nilai untuk baris ke-2 kolom ke-3:
1
Masukkan nilai untuk baris ke-2 kolom ke-4:
1
Masukkan nilai untuk baris ke-3 kolom ke-1:
3
Masukkan nilai untuk baris ke-3 kolom ke-2:
1
Masukkan nilai untuk baris ke-3 kolom ke-3:
2
Masukkan nilai untuk baris ke-3 kolom ke-4:
1
Matriks berhasil dibaca.
---------------------------------------------------------
```

Sementara untuk masukan via file.txt, pengguna akan diminta untuk memasukkan nama file **(*.txt)** yang telah disimpan dalam folder `test/input`.
```
---------------------------------------------------------
                          Sumber
                 2. Masukan dari file .txt
---------------------------------------------------------
Masukkan nama file (.txt) dalam folder test:

```

Misalkan nama file-nya adalah *inputSPLGauss.txt*, ketika nama file telah benar, maka akan muncul tampilan sebagai berikut:
```
---------------------------------------------------------
                          Sumber
                 2. Masukan dari file .txt
---------------------------------------------------------
Masukkan nama file (.txt) dalam folder test:
inputSPLGauss.txt
Matriks (file:inputSPLGauss.txt) berhasil dibaca.
---------------------------------------------------------
```

Program akan menjalankan eliminasi Gauss pada matriks *augmented* tersebut. Proses eliminasi akan berjalan seperti di bawah ini:
```
---------------------------------------------------------
Matriks yang dibaca:
1.000000 1.000000 1.000000 0.000000
2.000000 3.000000 1.000000 1.000000
3.000000 1.000000 2.000000 1.000000


Kurangi baris ke-2 dengan 2.000000 kali baris ke-1
1.000000 1.000000 1.000000 0.000000
0.000000 1.000000 -1.000000 1.000000
3.000000 1.000000 2.000000 1.000000


Kurangi baris ke-3 dengan 3.000000 kali baris ke-1
1.000000 1.000000 1.000000 0.000000
0.000000 1.000000 -1.000000 1.000000
0.000000 -2.000000 -1.000000 1.000000


Kurangi baris ke-3 dengan -2.000000 kali baris ke-2
1.000000 1.000000 1.000000 0.000000
0.000000 1.000000 -1.000000 1.000000
0.000000 0.000000 -3.000000 3.000000

Bagi setiap elemen di baris ke-1 dengan 1.00
1.000000 1.000000 1.000000 0.000000
0.000000 1.000000 -1.000000 1.000000
0.000000 0.000000 -3.000000 3.000000

Bagi setiap elemen di baris ke-2 dengan 1.00
1.000000 1.000000 1.000000 0.000000
0.000000 1.000000 -1.000000 1.000000
0.000000 0.000000 -3.000000 3.000000

Bagi setiap elemen di baris ke-3 dengan -3.00
1.000000 1.000000 1.000000 0.000000
0.000000 1.000000 -1.000000 1.000000
0.000000 0.000000 1.000000 -1.000000

---------------------------------------------------------
```
Di akhir proses eliminasi Gauss, akan dihasilkan sebuah matriks eselon baris. Lalu program akan melakukan substitusi balik dan menghasilkan solusi seperti berikut:
```
---------------------------------------------------------
Dengan metode Eliminasi Gauss, diperoleh solusi SPL:
X1=1.00 X2=0.00 X3=-1.00
---------------------------------------------------------
```

### Metode Eliminasi Gauss-Jordan
Pada metode eliminasi Gauss-Jordan, langkah-langkah yang dilakukan sama dengan metode eliminasi gauss. Namun, pada akhir proses eliminasi akan dihasilkan **matriks eselon baris tereduksi**. Berikut ini adalah simulasi proses penyelesaian Sistem Persamaan Linier dengan metode Gauss-Jordan:
```
---------------------------------------------------------
Matriks yang dibaca:
1.000000 1.000000 2.000000 4.000000
2.000000 -1.000000 1.000000 2.000000
1.000000 2.000000 3.000000 7.000000

Kurangi baris ke-2 dengan 2.000000 kali baris ke-1
1.000000 1.000000 2.000000 4.000000
0.000000 -3.000000 -3.000000 -6.000000
1.000000 2.000000 3.000000 7.000000

Kurangi baris ke-3 dengan 1.000000 kali baris ke-1
1.000000 1.000000 2.000000 4.000000
0.000000 -3.000000 -3.000000 -6.000000
0.000000 1.000000 1.000000 3.000000

Kurangi baris ke-3 dengan -0.333333 kali baris ke-2
1.000000 1.000000 2.000000 4.000000
0.000000 -3.000000 -3.000000 -6.000000
0.000000 0.000000 0.000000 1.000000

Bagi setiap elemen di baris ke-1 dengan 1.00
1.000000 1.000000 2.000000 4.000000
0.000000 -3.000000 -3.000000 -6.000000
0.000000 0.000000 0.000000 1.000000

Bagi setiap elemen di baris ke-2 dengan -3.00
1.000000 1.000000 2.000000 4.000000
0.000000 1.000000 1.000000 2.000000
0.000000 0.000000 0.000000 1.000000

Kurangi baris ke-1 dengan 1.000000 kali baris ke-2
1.000000 0.000000 1.000000 2.000000
0.000000 1.000000 1.000000 2.000000
0.000000 0.000000 0.000000 1.000000

Bagi setiap elemen di baris ke-1 dengan 1.00
1.000000 0.000000 1.000000 2.000000
0.000000 1.000000 1.000000 2.000000
0.000000 0.000000 0.000000 1.000000

Bagi setiap elemen di baris ke-2 dengan 1.00
1.000000 0.000000 1.000000 2.000000
0.000000 1.000000 1.000000 2.000000
0.000000 0.000000 0.000000 1.000000

Bagi setiap elemen di baris ke-1 dengan 1.00
1.000000 0.000000 1.000000 2.000000
0.000000 1.000000 1.000000 2.000000
0.000000 0.000000 0.000000 1.000000

Bagi setiap elemen di baris ke-2 dengan 1.00
1.000000 0.000000 1.000000 2.000000
0.000000 1.000000 1.000000 2.000000
0.000000 0.000000 0.000000 1.000000
---------------------------------------------------------
```

Di akhir proses eliminasi Gauss-Jordan, akan dihasilkan sebuah matriks eselon baris tereduksi dan sebuah solusi SPL, sebagai berikut:
```
---------------------------------------------------------
Dengan metode Eliminasi Gauss-Jordan, diperoleh solusi SPL:
SPL tidak memiliki solusi
---------------------------------------------------------
```

Apabila sebuah sistem persamaan linier memiliki solusi tak hingga/banyak, maka program akan menuliskan solusinya, sebagai berikut:
```
---------------------------------------------------------
Dengan metode Eliminasi Gauss-Jordan, diperoleh solusi SPL:
X1=-2.00t+3.00s+7.00 X2=1.00t-4.00s+5.00 X3=t X4=s
---------------------------------------------------------
```

### Metode Matriks Balikan
Dengan metode ini, matriks akan disajikan dalam model Ax=B. Misal, sebuah sistem persamaan linier terdiri dari empat persamaan di bawah ini:

> a+b-c-d=1;  
> 2a+5b-7c-5d=2;  
> 2a-b+c+3d=4;  
> 5a+2b-4c+2d=6;  

Untuk masukan via CLI, pengguna akan diminta untuk memasukkan nilai tiap elemen baris dan kolom pada matriks A terlebih dahulu, kemudian mengisi matriks B, program yang akan muncul sebagai berikut:
```
---------------------------------------------------------
                          Sumber
                    1. Masukan dari CLI
---------------------------------------------------------
Masukkan jumlah baris:
4
Masukkan jumlah kolom:
4
Masukkan matriks:
Masukkan nilai untuk baris ke-1 kolom ke-1:
1
Masukkan nilai untuk baris ke-1 kolom ke-2:
1
Masukkan nilai untuk baris ke-1 kolom ke-3:
-1
Masukkan nilai untuk baris ke-1 kolom ke-4:
-1
Masukkan nilai untuk baris ke-2 kolom ke-1:
2
Masukkan nilai untuk baris ke-2 kolom ke-2:
5
Masukkan nilai untuk baris ke-2 kolom ke-3:
-7
Masukkan nilai untuk baris ke-2 kolom ke-4:
-5
Masukkan nilai untuk baris ke-3 kolom ke-1:
2
Masukkan nilai untuk baris ke-3 kolom ke-2:
-1
Masukkan nilai untuk baris ke-3 kolom ke-3:
1
Masukkan nilai untuk baris ke-3 kolom ke-4:
3
Masukkan nilai untuk baris ke-4 kolom ke-1:
5
Masukkan nilai untuk baris ke-4 kolom ke-2:
2
Masukkan nilai untuk baris ke-4 kolom ke-3:
-4
Masukkan nilai untuk baris ke-4 kolom ke-4:
2
Matriks berhasil dibaca.
---------------------------------------------------------
```

Namun, karena pada studi kasus yang dipilih, nilai determinan Matriks A bernilai 0, maka pengguna tidak akan diminta memasukkan nilai elemen matriks B (Matriks A tidak memiliki Matriks Balikan). Program akan mengeluarkan tampilan sebagai berikut:
```
---------------------------------------------------------
Matriks yang dibaca:
1.000000 1.000000 -1.000000 -1.000000
2.000000 5.000000 -7.000000 -5.000000
2.000000 -1.000000 1.000000 3.000000
5.000000 2.000000 -4.000000 2.000000
---------------------------------------------------------
Oleh karena determinan matriks = 0, maka
Metode Matriks Balikan tidak dapat diterapkan
---------------------------------------------------------
```

Apabila masukan via file (*.txt), maka penulisan matriks A dan B harus dilakukan secara augmented seperti yang dilakukan pada metode Gauss dan Gauss-Jordan.

### Metode Cramer
Dengan metode ini, matriks akan disajikan dalam model Ax=B. Misal, sebuah sistem persamaan linier terdiri dari empat persamaan di bawah ini:

> w+x-y-z=1;  
> 2w+5x-7y-5z=-2;  
> 2w-x+y+3z=4;  
> 5w+2x-4y+2z=6; 

Untuk masukan via CLI, pengguna akan diminta untuk memasukkan nilai tiap elemen baris dan kolom pada matriks A terlebih dahulu, kemudian mengisi matriks B, program yang akan muncul sebagai berikut:
```
---------------------------------------------------------
                          Sumber
                    1. Masukan dari CLI
---------------------------------------------------------
Masukkan jumlah baris:
4
Masukkan jumlah kolom:
5
Masukkan matriks:
Masukkan nilai untuk baris ke-1 kolom ke-1:
1
Masukkan nilai untuk baris ke-1 kolom ke-2:
-1
Masukkan nilai untuk baris ke-1 kolom ke-3:
0
Masukkan nilai untuk baris ke-1 kolom ke-4:
0
Masukkan nilai untuk baris ke-1 kolom ke-5:
1
Masukkan nilai untuk baris ke-2 kolom ke-1:
1
Masukkan nilai untuk baris ke-2 kolom ke-2:
1
Masukkan nilai untuk baris ke-2 kolom ke-3:
0
Masukkan nilai untuk baris ke-2 kolom ke-4:
-3
Masukkan nilai untuk baris ke-2 kolom ke-5:
0
Masukkan nilai untuk baris ke-3 kolom ke-1:
2
Masukkan nilai untuk baris ke-3 kolom ke-2:
-1
Masukkan nilai untuk baris ke-3 kolom ke-3:
0
Masukkan nilai untuk baris ke-3 kolom ke-4:
1
Masukkan nilai untuk baris ke-3 kolom ke-5:
-1
Masukkan nilai untuk baris ke-4 kolom ke-1:
-1
Masukkan nilai untuk baris ke-4 kolom ke-2:
2
Masukkan nilai untuk baris ke-4 kolom ke-3:
0
Masukkan nilai untuk baris ke-4 kolom ke-4:
-2
Masukkan nilai untuk baris ke-4 kolom ke-5:
-1
Matriks berhasil dibaca.
---------------------------------------------------------
```

Namun, karena pada studi kasus yang dipilih, Matriks A bukan merupakan matriks persegi, maka pengguna tidak akan diminta memasukkan nilai elemen matriks B (Matriks A tidak memiliki Matriks Balikan). Program akan mengeluarkan tampilan sebagai berikut:
```
---------------------------------------------------------
Matriks yang dibaca:
1.000000 -1.000000 0.000000 0.000000 1.000000
1.000000 1.000000 0.000000 -3.000000 0.000000
2.000000 -1.000000 0.000000 1.000000 -1.000000
-1.000000 2.000000 0.000000 -2.000000 -1.000000
---------------------------------------------------------
Oleh karena matriks bukan persegi, maka
Metode Kaidah Cramer tidak dapat diterapkan
---------------------------------------------------------
```

Apabila masukan via file (*.txt), maka penulisan matriks A dan B harus dilakukan secara augmented seperti yang dilakukan pada metode Gauss dan Gauss-Jordan.

## DETERMINAN MATRIKS
Apabila pengguna memasukkan angka 1 (Sistem Persamaan Linier), maka akan muncul **pilihan metode** yang dapat digunakan sesuai kebutuhan pengguna. Masing-masing pilihan berkaitan dengan metode penyelesaian Sistem Persamaan Linier(SPL).
```
---------------------------------------------------------
                           Menu
                       2.Determinan
---------------------------------------------------------
                      Pilihan Metode:
1. Metode Eliminasi Gauss
2. Metode Ekspansi Kofaktor
3. Kembali ke Menu Utama
---------------------------------------------------------
Masukkan pilihan metode Anda:

```

### Metode Eliminasi Gauss
Metode perhitungan determinan ini sebenarnya menggunakan operasi baris elementer (metode Gauss, tetapi diagonal utama matriks tidak perlu bernilai 1). Matriks akan dioperasikan sehingga berbentuk segitiga atas (seluruh elemen matriks di bawah diagonal utama bernilai 0). Perhitungan determinan akan dilakukan dengan mengalikan seluruh elemen diagonal utama matriks hasil OBE.

Pada metode Eliminasi Gauss, untuk masukan via CLI, pengguna akan diminta untuk memasukkan nilai tiap elemen baris dan kolom pada matriks augmented (matriks harus berupa matriks persegi, ukuran baris = ukuran kolom), program yang akan muncul sebagai berikut:
```
---------------------------------------------------------
                         Sumber
                   1. Masukan dari CLI
---------------------------------------------------------
Masukkan ukuran matriks persegi (NxN) N:
3
Masukkan matriks:
Masukkan nilai untuk baris ke-1 kolom ke-1:
4
Masukkan nilai untuk baris ke-1 kolom ke-2:
2
Masukkan nilai untuk baris ke-1 kolom ke-3:
8
Masukkan nilai untuk baris ke-2 kolom ke-1:
2
Masukkan nilai untuk baris ke-2 kolom ke-2:
1
Masukkan nilai untuk baris ke-2 kolom ke-3:
5
Masukkan nilai untuk baris ke-3 kolom ke-1:
3
Masukkan nilai untuk baris ke-3 kolom ke-2:
2
Masukkan nilai untuk baris ke-3 kolom ke-3:
4
Matriks berhasil dibaca.
---------------------------------------------------------
```

Di akhir proses eliminasi Gauss, akan dihasilkan nilai determinan matriks, sebagai berikut:
```
---------------------------------------------------------
Matriks yang dibaca:
4.000000 2.000000 8.000000
2.000000 1.000000 5.000000
3.000000 2.000000 4.000000
---------------------------------------------------------
Dengan metode Eliminasi Gauss,
diperoleh nilai determinan:
-2.0
---------------------------------------------------------
```

Apabila masukan via file (*.txt), maka penulisan matriks A harus dilakukan secara augmented (dengan syarat, matriks A merupakan matriks persegi, ukuran baris = ukuran kolom) seperti yang dilakukan pada metode-metode sebelumnya.

### Metode Kofaktor
Metode perhitungan determinan ini menggunakan minor dan kofaktor pada matriks masukan.Perhitungan determinan akan menggunakan elemen pada baris pertama yang masing-masing akan dikalikan dengan kofaktor-nya. Masing-masing kofaktor akan dihitung dengan mencari minornya yang kemudian determinannya akan dihitung pula menggunakan fungsi determinan metode kofaktor (rekursi).

Pada metode Kofaktor, untuk masukan via CLI, pengguna akan diminta untuk memasukkan nilai tiap elemen baris dan kolom pada matriks augmented (matriks harus berupa matriks persegi, ukuran baris = ukuran kolom), program yang akan muncul sebagai berikut:
```
---------------------------------------------------------
                         Sumber
                   1. Masukan dari CLI
---------------------------------------------------------
Masukkan ukuran matriks persegi (NxN) N:
3
Masukkan matriks:
Masukkan nilai untuk baris ke-1 kolom ke-1:
2
Masukkan nilai untuk baris ke-1 kolom ke-2:
0
Masukkan nilai untuk baris ke-1 kolom ke-3:
1
Masukkan nilai untuk baris ke-2 kolom ke-1:
3
Masukkan nilai untuk baris ke-2 kolom ke-2:
1
Masukkan nilai untuk baris ke-2 kolom ke-3:
2
Masukkan nilai untuk baris ke-3 kolom ke-1:
4
Masukkan nilai untuk baris ke-3 kolom ke-2:
2
Masukkan nilai untuk baris ke-3 kolom ke-3:
3
Matriks berhasil dibaca.
---------------------------------------------------------
```

Di akhir proses metode kofaktor, akan dihasilkan nilai determinan matriks, sebagai berikut:
```
---------------------------------------------------------
Matriks yang dibaca:
2.000000 0.000000 1.000000
3.000000 1.000000 2.000000
4.000000 2.000000 3.000000
---------------------------------------------------------
Dengan metode Ekspansi Kofaktor,
diperoleh nilai determinan:
0.0
---------------------------------------------------------
```

Apabila masukan via file (*.txt), maka penulisan matriks A harus dilakukan secara augmented (dengan syarat, matriks A merupakan matriks persegi, ukuran baris = ukuran kolom) seperti yang dilakukan pada metode-metode sebelumnya.



