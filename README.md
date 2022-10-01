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
Apabila pengguna memasukkan angka 2 (Determinan Matriks), maka akan muncul **pilihan metode** yang dapat digunakan sesuai kebutuhan pengguna. Masing-masing pilihan berkaitan dengan metode penyelesaian nilai determinan sebuah matriks.
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

## MATRIKS BALIKAN
Apabila pengguna memasukkan angka 3 (Matriks Balikan), maka akan muncul **pilihan metode** yang dapat digunakan sesuai kebutuhan pengguna. Masing-masing pilihan berkaitan dengan metode penyelesaian sebuah matriks balikan dari masukan pengguna.
```
---------------------------------------------------------
                           Menu
                    3. Matriks Balikan
---------------------------------------------------------
                      Pilihan Metode:
1. Metode Eliminasi Gauss
2. Metode Ekspansi Kofaktor
3. Kembali ke Menu Utama
---------------------------------------------------------
Masukkan pilihan metode Anda:

```

### Metode Eliminasi Gauss
Metode perhitungan determinan ini sebenarnya menggunakan operasi baris elementer (metode Gauss, tetapi diagonal utama matriks tidak perlu bernilai 1). Matriks akan dioperasikan beriringan dengan matriks identitas (matriks dengan elemen diagonal utama bernilai 1, dan elemen lainnya bernilai 0) sehingga akan terbentuk matriks baru yang merupakan matriks balikan dari matriks awal. 
> [A|I] -> [I|A^-1]

Misalkan untuk studi kasus matriks: <br>
4 2 -1 <br>
0 2 3 <br>
-1 1 5 <br>

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
-1
Masukkan nilai untuk baris ke-2 kolom ke-1:
0
Masukkan nilai untuk baris ke-2 kolom ke-2:
2
Masukkan nilai untuk baris ke-2 kolom ke-3:
-3
Masukkan nilai untuk baris ke-3 kolom ke-1:
-1
Masukkan nilai untuk baris ke-3 kolom ke-2:
1
Masukkan nilai untuk baris ke-3 kolom ke-3:
5
Matriks berhasil dibaca.
---------------------------------------------------------
```

Berikut ini adalah simulasi proses penyelesaian matriks balikan dengan metode Gauss:
```
---------------------------------------------------------
Matriks yang dibaca:
4.000000 2.000000 -1.000000
0.000000 2.000000 -3.000000
-1.000000 1.000000 5.000000

4.000000 2.000000 -1.000000 1.000000 0.000000 0.000000
0.000000 2.000000 -3.000000 0.000000 1.000000 0.000000
-1.000000 1.000000 5.000000 0.000000 0.000000 1.000000

Kurangi baris ke-3 dengan -0.250000 kali baris ke-1
4.000000 2.000000 -1.000000 1.000000 0.000000 0.000000
0.000000 2.000000 -3.000000 0.000000 1.000000 0.000000
0.000000 1.500000 4.750000 0.250000 0.000000 1.000000

Kurangi baris ke-3 dengan 0.750000 kali baris ke-2
4.000000 2.000000 -1.000000 1.000000 0.000000 0.000000
0.000000 2.000000 -3.000000 0.000000 1.000000 0.000000
0.000000 0.000000 7.000000 0.250000 -0.750000 1.000000

Bagi setiap elemen di baris ke-1 dengan 4.00
1.000000 0.500000 -0.250000 0.250000 0.000000 0.000000
0.000000 2.000000 -3.000000 0.000000 1.000000 0.000000
0.000000 0.000000 7.000000 0.250000 -0.750000 1.000000

Bagi setiap elemen di baris ke-2 dengan 2.00
1.000000 0.500000 -0.250000 0.250000 0.000000 0.000000
0.000000 1.000000 -1.500000 0.000000 0.500000 0.000000
0.000000 0.000000 7.000000 0.250000 -0.750000 1.000000

Bagi setiap elemen di baris ke-3 dengan 7.00
1.000000 0.500000 -0.250000 0.250000 0.000000 0.000000
0.000000 1.000000 -1.500000 0.000000 0.500000 0.000000
0.000000 0.000000 1.000000 0.035714 -0.107143 0.142857

Kurangi baris ke-2 dengan -1.500000 kali baris ke-3
1.000000 0.500000 -0.250000 0.250000 0.000000 0.000000
0.000000 1.000000 0.000000 0.053571 0.339286 0.214286
0.000000 0.000000 1.000000 0.035714 -0.107143 0.142857

Kurangi baris ke-1 dengan -0.250000 kali baris ke-3
1.000000 0.500000 0.000000 0.258929 -0.026786 0.035714
0.000000 1.000000 0.000000 0.053571 0.339286 0.214286
0.000000 0.000000 1.000000 0.035714 -0.107143 0.142857

Kurangi baris ke-1 dengan 0.500000 kali baris ke-2
1.000000 0.000000 0.000000 0.232143 -0.196429 -0.071429
0.000000 1.000000 0.000000 0.053571 0.339286 0.214286
0.000000 0.000000 1.000000 0.035714 -0.107143 0.142857
---------------------------------------------------------
```

Di akhir proses eliminasi Gauss, akan dihasilkan matriks balikan sebagai berikut:
```
---------------------------------------------------------
Dengan metode Eliminasi Gauss,
diperoleh matriks balikan:
0.232143 -0.196429 -0.071429
0.053571 0.339286 0.214286
0.035714 -0.107143 0.142857
---------------------------------------------------------
```
Apabila masukan via file (*.txt), maka penulisan matriks A harus dilakukan secara augmented (dengan syarat, matriks A merupakan matriks persegi, ukuran baris = ukuran kolom) seperti yang dilakukan pada metode-metode sebelumnya.

### Metode Ekspansi Kofaktor
Metode perhitungan determinan ini memanfaatkan nilai determinan suatu matriks dan matriks adjoin (matriks transpose dari sebuah matriks kofaktor). Metode ini berdasarkan pada rumus:
> [A^-1] = 1/det(A) * [adj(A)]

Misalkan untuk studi kasus matriks: <br>
3 3 0 5 <br>
2 2 0 -2 <br>
4 1 -3 0 <br>
2 10 3 2 <br>

Pada metode ekspansi kofaktor, untuk masukan via CLI, pengguna akan diminta untuk memasukkan nilai tiap elemen baris dan kolom pada matriks augmented (matriks harus berupa matriks persegi, ukuran baris = ukuran kolom), program yang akan muncul sebagai berikut:
```
---------------------------------------------------------
                          Sumber
                    1. Masukan dari CLI
---------------------------------------------------------
Masukkan ukuran matriks persegi (NxN) N:
4
Masukkan matriks:
Masukkan nilai untuk baris ke-1 kolom ke-1:
3
Masukkan nilai untuk baris ke-1 kolom ke-2:
3
Masukkan nilai untuk baris ke-1 kolom ke-3:
0
Masukkan nilai untuk baris ke-1 kolom ke-4:
5
Masukkan nilai untuk baris ke-2 kolom ke-1:
2
Masukkan nilai untuk baris ke-2 kolom ke-2:
2
Masukkan nilai untuk baris ke-2 kolom ke-3:
0
Masukkan nilai untuk baris ke-2 kolom ke-4:
-2
Masukkan nilai untuk baris ke-3 kolom ke-1:
4
Masukkan nilai untuk baris ke-3 kolom ke-2:
1
Masukkan nilai untuk baris ke-3 kolom ke-3:
-3
Masukkan nilai untuk baris ke-3 kolom ke-4:
0
Masukkan nilai untuk baris ke-4 kolom ke-1:
2
Masukkan nilai untuk baris ke-4 kolom ke-2:
10
Masukkan nilai untuk baris ke-4 kolom ke-3:
3
Masukkan nilai untuk baris ke-4 kolom ke-4:
2
Matriks berhasil dibaca.
---------------------------------------------------------
```

Di akhir proses ekspansi kofaktor, akan dihasilkan matriks balikan sebagai berikut:
```
---------------------------------------------------------
Matriks yang dibaca:
3.000000 3.000000 0.000000 5.000000
2.000000 2.000000 0.000000 -2.000000
4.000000 1.000000 -3.000000 0.000000
2.000000 10.000000 3.000000 2.000000
---------------------------------------------------------
Dengan metode Ekspansi Kofaktor,
diperoleh matriks balikannya:
0.325000 0.612500 -0.200000 -0.200000
-0.200000 -0.300000 0.200000 0.200000
0.366667 0.716667 -0.533333 -0.200000
0.125000 -0.187500 0.000000 0.000000
---------------------------------------------------------
```

Apabila masukan via file (*.txt), maka penulisan matriks A harus dilakukan secara augmented (dengan syarat, matriks A merupakan matriks persegi, ukuran baris = ukuran kolom) seperti yang dilakukan pada metode-metode sebelumnya.

## INTERPOLASI POLINOM
Apabila pengguna memasukkan angka 4 (Interpolasi Polinom), maka akan muncul **pilihan metode** yang dapat digunakan sesuai kebutuhan pengguna. Masing-masing pilihan berkaitan dengan metode penyelesaian interpolasi polinom dari masukan pengguna.

Misalkan untuk studi kasus:
x|0.1|0.3|0.5|0.7|0.9|1.1|1.3
-|-|-|-|-|-|-|-
y|0.003|0.067|0.148|0.248|0.370|0.518|0.697

Pada menu interpolasi polinom, untuk masukan via CLI, pengguna akan diminta untuk memasukkan banyak nilai sampel, serta ordinat dan , program yang akan muncul sebagai berikut:
```
---------------------------------------------------------
                          Sumber
                    1. Masukan dari CLI
---------------------------------------------------------
Masukkan banyaknya titik sampel (X,Y) = 7
---------------------------------------------------------
Masukkan X1 = 0.1
Masukkan Y1 = 0.003
---------------------------------------------------------
Masukkan X2 = 0.3
Masukkan Y2 = 0.067
---------------------------------------------------------
Masukkan X3 = 0.5
Masukkan Y3 = 0.148
---------------------------------------------------------
Masukkan X4 = 0.7
Masukkan Y4 = 0.248
---------------------------------------------------------
Masukkan X5 = 0.9
Masukkan Y5 = 0.370
---------------------------------------------------------
Masukkan X6 = 1.1
Masukkan Y6 = 0.518
---------------------------------------------------------
Masukkan X7 = 1.3
Masukkan Y7 = 0.697
---------------------------------------------------------
```

Berikut ini adalah simulasi proses penyelesaian interpolasi polinom:
```
---------------------------------------------------------
Matriks koefisien dari persamaan derajat 7 :
1.000000 0.100000 0.010000 0.001000 0.000100 0.000010 0.000001 0.003000
1.000000 0.300000 0.090000 0.027000 0.008100 0.002430 0.000729 0.067000
1.000000 0.500000 0.250000 0.125000 0.062500 0.031250 0.015625 0.148000
1.000000 0.700000 0.490000 0.343000 0.240100 0.168070 0.117649 0.248000
1.000000 0.900000 0.810000 0.729000 0.656100 0.590490 0.531441 0.370000
1.000000 1.100000 1.210000 1.331000 1.464100 1.610510 1.771561 0.518000
1.000000 1.300000 1.690000 2.197000 2.856100 3.712930 4.826809 0.697000

Kurangi baris ke-2 dengan 1.000000 kali baris ke-1
1.000000 0.100000 0.010000 0.001000 0.000100 0.000010 0.000001 0.003000
0.000000 0.200000 0.080000 0.026000 0.008000 0.002420 0.000728 0.064000
1.000000 0.500000 0.250000 0.125000 0.062500 0.031250 0.015625 0.148000
1.000000 0.700000 0.490000 0.343000 0.240100 0.168070 0.117649 0.248000
1.000000 0.900000 0.810000 0.729000 0.656100 0.590490 0.531441 0.370000
1.000000 1.100000 1.210000 1.331000 1.464100 1.610510 1.771561 0.518000
1.000000 1.300000 1.690000 2.197000 2.856100 3.712930 4.826809 0.697000

(...perhitungan tidak ditampilkan seluruhnya untuk mempersingkat...)

Kurangi baris ke-1 dengan 0.010000 kali baris ke-3
1.000000 0.100000 0.000000 0.000000 0.000000 0.000000 0.000000 0.001023
0.000000 1.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.240000
0.000000 0.000000 1.000000 0.000000 0.000000 0.000000 0.000000 0.197396
0.000000 0.000000 0.000000 1.000000 0.000000 0.000000 0.000000 0.000000
0.000000 0.000000 0.000000 0.000000 1.000000 0.000000 0.000000 0.026042
0.000000 0.000000 0.000000 0.000000 0.000000 1.000000 0.000000 0.000000
0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 1.000000 0.000000

Kurangi baris ke-1 dengan 0.100000 kali baris ke-2
1.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 -0.022977
0.000000 1.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.240000
0.000000 0.000000 1.000000 0.000000 0.000000 0.000000 0.000000 0.197396
0.000000 0.000000 0.000000 1.000000 0.000000 0.000000 0.000000 0.000000
0.000000 0.000000 0.000000 0.000000 1.000000 0.000000 0.000000 0.026042
0.000000 0.000000 0.000000 0.000000 0.000000 1.000000 0.000000 0.000000
0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 1.000000 0.000000
---------------------------------------------------------
```

Selanjutnya, akan dihasilkan sebuah solusi dari interpolasi polinom, sebagai berikut:
```
---------------------------------------------------------
Solusi SPL f(x) = 0.000000x^6 + 0.000000x^5 + 0.026042x^4 + 0.000000x^3 + 0.197396x^2 + 0.240000x + -0.022977
---------------------------------------------------------
```

Pengguna kemudian akan diminta untuk memasukkan nilai X (ordinat) yang hendak ditaksir nilainya, program selanjutnya akan menampilkan solusi dari nilai taksiran yang diinginkan pengguna:
```
---------------------------------------------------------
Masukan nilai x yang akan ditaksir : 0.2
Hasil interpolasi f(0.200000) = 0.032961
---------------------------------------------------------
```

## Interpolasi Bicubic
Apabila pengguna memasukkan angka 5 (Interpolasi Bicubic), maka akan muncul **pilihan metode** yang dapat digunakan sesuai kebutuhan pengguna. Masing-masing pilihan berkaitan dengan metode penyelesaian interpolasi Bicubic dari masukan pengguna.

Misalkan untuk studi kasus:
(x,y)|(-1,-1)|(-1,0)|(-1,1)|(-1,2)|(0,-1)|(0,0)|(0,1)|(0,2)|(1,-1)|(1,0)|(1,1)|(1,2)|(2,-1)|(2,0)|(2,1)|(2,2)
-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-
f(x,y)|4|6|8|12|4|9|10|2|1|6|13|4|7|18|9|4

Pada menu interpolasi bicubic, untuk masukan via CLI, pengguna akan diminta untuk memasukkan banyak nilai sampel, serta ordinat dan absis, program yang akan muncul sebagai berikut:
```
---------------------------------------------------------
                          Sumber
                    1. Masukan dari CLI
---------------------------------------------------------
Masukkan nilai f(-1,-1) = 4
Masukkan nilai f(-1,0) = 6
Masukkan nilai f(-1,1) = 8
Masukkan nilai f(-1,2) = 12
Masukkan nilai f(0,-1) = 4
Masukkan nilai f(0,0) = 9
Masukkan nilai f(0,1) = 10
Masukkan nilai f(0,2) = 2
Masukkan nilai f(1,-1) = 1
Masukkan nilai f(1,0) = 6
Masukkan nilai f(1,1) = 13
Masukkan nilai f(1,2) = 4
Masukkan nilai f(2,-1) = 7
Masukkan nilai f(2,0) = 18
Masukkan nilai f(2,1) = 9
Masukkan nilai f(2,2) = 4
---------------------------------------------------------
```

Selanjutnya, pengguna akan diminta untuk menentukan nilai a dan b yang hendak ditentukan hasil f(a,b)-nya dengan interpolasi bicubic:

Misalkan
> a = 2;  
> b = 4;  

```
---------------------------------------------------------
Untuk mencari nilai f(a,b) dengan interpolasi...
Masukkan a = 2
Masukkan b = 4
---------------------------------------------------------
```

Berikut ini adalah simulasi proses penyelesaian interpolasi bicubic:
```
---------------------------------------------------------
Kurangi baris ke-2 dengan 1.000000 kali baris ke-1
1.000000 -1.000000 1.000000 -1.000000 -1.000000 1.000000 -1.000000 1.000000 1.000000 -1.000000 1.000000 -1.000000 -1.000000 1.000000 -1.000000 1.000000 4.000000
0.000000 1.000000 -1.000000 1.000000 0.000000 -1.000000 1.000000 -1.000000 0.000000 1.000000 -1.000000 1.000000 0.000000 -1.000000 1.000000 -1.000000 2.000000
1.000000 1.000000 1.000000 1.000000 -1.000000 -1.000000 -1.000000 -1.000000 1.000000 1.000000 1.000000 1.000000 -1.000000 -1.000000 -1.000000 -1.000000 8.000000
1.000000 2.000000 4.000000 8.000000 -1.000000 -2.000000 -4.000000 -8.000000 1.000000 2.000000 4.000000 8.000000 -1.000000 -2.000000 -4.000000 -8.000000 12.000000
1.000000 -1.000000 1.000000 -1.000000 0.000000 -0.000000 0.000000 -0.000000 0.000000 -0.000000 0.000000 -0.000000 0.000000 -0.000000 0.000000 -0.000000 4.000000
1.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 9.000000
1.000000 1.000000 1.000000 1.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 10.000000
1.000000 2.000000 4.000000 8.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 2.000000
1.000000 -1.000000 1.000000 -1.000000 1.000000 -1.000000 1.000000 -1.000000 1.000000 -1.000000 1.000000 -1.000000 1.000000 -1.000000 1.000000 -1.000000 1.000000
1.000000 0.000000 0.000000 0.000000 1.000000 0.000000 0.000000 0.000000 1.000000 0.000000 0.000000 0.000000 1.000000 0.000000 0.000000 0.000000 6.000000
1.000000 1.000000 1.000000 1.000000 1.000000 1.000000 1.000000 1.000000 1.000000 1.000000 1.000000 1.000000 1.000000 1.000000 1.000000 1.000000 13.000000
1.000000 2.000000 4.000000 8.000000 1.000000 2.000000 4.000000 8.000000 1.000000 2.000000 4.000000 8.000000 1.000000 2.000000 4.000000 8.000000 4.000000
1.000000 -1.000000 1.000000 -1.000000 2.000000 -2.000000 2.000000 -2.000000 4.000000 -4.000000 4.000000 -4.000000 8.000000 -8.000000 8.000000 -8.000000 7.000000
1.000000 0.000000 0.000000 0.000000 2.000000 0.000000 0.000000 0.000000 4.000000 0.000000 0.000000 0.000000 8.000000 0.000000 0.000000 0.000000 18.000000
1.000000 1.000000 1.000000 1.000000 2.000000 2.000000 2.000000 2.000000 4.000000 4.000000 4.000000 4.000000 8.000000 8.000000 8.000000 8.000000 9.000000
1.000000 2.000000 4.000000 8.000000 2.000000 4.000000 8.000000 16.000000 4.000000 8.000000 16.000000 32.000000 8.000000 16.000000 32.000000 64.000000 4.000000

(...perhitungan tidak ditampilkan seluruhnya untuk mempersingkat...)

Kurangi baris ke-1 dengan -1.000000 kali baris ke-2
1.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 9.000000
0.000000 1.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 3.833333
0.000000 0.000000 1.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 -2.000000
0.000000 0.000000 0.000000 1.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 -0.833333
0.000000 0.000000 0.000000 0.000000 1.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 -3.500000
0.000000 0.000000 0.000000 0.000000 0.000000 1.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 7.027778
0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 1.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 3.666667
0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 1.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 -3.361111
0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 1.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 -3.000000
0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 1.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 1.500000
0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 1.000000 0.000000 0.000000 0.000000 0.000000 0.000000 2.500000
0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 1.000000 0.000000 0.000000 0.000000 0.000000 -0.500000
0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 1.000000 0.000000 0.000000 0.000000 3.500000
0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 1.000000 0.000000 0.000000 -3.361111
0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 1.000000 0.000000 -3.166667
0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 0.000000 1.000000 1.694444
---------------------------------------------------------
```

Di akhir proses interpolasi bicubic, program akan menampilkan nilai f(a,b) hasil dari masukan nilai a dan b pengguna:
```
---------------------------------------------------------
Maka f(2.000000,4.000000) = -58.000000
---------------------------------------------------------
```

## REGRESI LINIER BERGANDA
Apabila pengguna memasukkan angka 6 (Regresi Linier Berganda), maka akan muncul **pilihan metode** yang dapat digunakan sesuai kebutuhan pengguna. Masing-masing pilihan berkaitan dengan metode penyelesaian regresi linier berganda dari masukan pengguna.

Misalkan untuk studi kasus:
> n (banyak sampel) = 3;  
> x (banyak variabel x) = 1;  

X1|3|1|5
-|-|-|-
y|2|4|6

Pada menu regresi linier berganda, untuk masukan via CLI, pengguna akan diminta untuk memasukkan banyak nilai sampel, serta banyak variabel X yang akan digunakan , program yang akan muncul sebagai berikut:
```
---------------------------------------------------------
                          Sumber
                    1. Masukan dari CLI
---------------------------------------------------------
Masukkan banyak sampel n : 3
Masukkan banyak varibel x : 1
---------------------------------------------------------
Masukkan nilai X1 untuk sampel 1 : 3
Masukkan nilai y untuk sampel 1 : 2
---------------------------------------------------------
Masukkan nilai X1 untuk sampel 2 : 1
Masukkan nilai y untuk sampel 2 : 4
---------------------------------------------------------
Masukkan nilai X1 untuk sampel 3 : 5
Masukkan nilai y untuk sampel 3 : 6
---------------------------------------------------------
```

Selanjutnya, pengguna akan diminta untuk menentukan nilai-nilai x yang hendak ditaksir dengan regresi linier berganda:

Misalkan:
> X1 = 3;  

```
---------------------------------------------------------
Masukkan nilai-nilai X yang akan ditaksir...
Nilai X1 : 3
---------------------------------------------------------
```

Berikut ini adalah simulasi proses penyelesaian regresi linier berganda:
```
---------------------------------------------------------
3.000000 9.000000 1.000000 0.000000
9.000000 35.000000 0.000000 1.000000

Kurangi baris ke-2 dengan 3.000000 kali baris ke-1
3.000000 9.000000 1.000000 0.000000
0.000000 8.000000 -3.000000 1.000000

Bagi setiap elemen di baris ke-1 dengan 3.00
1.000000 3.000000 0.333333 0.000000
0.000000 8.000000 -3.000000 1.000000

Bagi setiap elemen di baris ke-2 dengan 8.00
1.000000 3.000000 0.333333 0.000000
0.000000 1.000000 -0.375000 0.125000

Kurangi baris ke-1 dengan 3.000000 kali baris ke-2
1.000000 0.000000 1.458333 -0.375000
0.000000 1.000000 -0.375000 0.125000
---------------------------------------------------------
```

Di akhir proses regresi linier berganda, program akan menampilkan persamaan yang didapat, serta hasil taksiran nilai variabel masukan pengguna:
```
---------------------------------------------------------
Maka didapatkan persamaan..
f(x) = 2.500000 + 1.142857X1
y = 2.500000 x 1.000000 + 1.142857 x 3.000000 = 5.928571
---------------------------------------------------------
```

## PENUTUP
Apabila pengguna memasukkan angka 7 (Penutup), maka program akan tertutup secara otomatis.
```
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
7
```

## MENYIMPAN FILE
Pada tiap pilihan metode, ketika hasil telah dicetak ke layar, pengguna dapat memilih untuk menyimpan file di *local directory*-nya atau tidak, dengan mengetikan 'y' untuk menyimpan file dalam bentuk (*.txt) serta 'n' untuk tidak menyimpan file dan mengembalikan program ke tampilan menu utama. Apabila pengguna mengetikan 'y', tampilan program sebagai berikut:

```
---------------------------------------------------------
Hasil ingin disimpan? (y/n):
y
---------------------------------------------------------
Nama output file (*.txt):
coba.txt
---------------------------------------------------------
File coba.txt berhasil disimpan.
---------------------------------------------------------
```

Pengguna akan diminta menentukan nama file yang hendak disimpan dengan extension `.txt`. File (*.txt) yang disimpan nantinya akan berada dalam folder `test\output` , sementara itu ketika pengguna mengetikan 'n', tampilan program sebagai berikut:
```
---------------------------------------------------------
Hasil ingin disimpan? (y/n):
n
---------------------------------------------------------
---------------------------------------------------------
             Operasi Sistem Persamaan Linier
                          SELESAI
                   Kembali ke Menu Utama
---------------------------------------------------------
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

pengguna akan langsung dikembalikan ke menu utama secara otomatis.

