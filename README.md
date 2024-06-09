## Group Name : TND
Nama Anggota :

  1. A. Tasdik Bijaksana - H071231041
  2. Diza Sazkia - H071231043
  3. Andi Nafil Fayzul Haq - H071231092

## Tema yang dipilih : Finance and Budgeting
## Nama Pendamping : Kelvin Leonardo Sianipar
## Tim Juri :

  1. Irfan Nurhadi Prasetyo
  2. Ihlasul Mufti Faqih

## Executive Summary
Aplikasi FunGoals menawarkan pendekatan unik dalam perencanaan keuangan yang membedakannya dari aplikasi keuangan sehari-hari lainnya. Sementara banyak aplikasi keuangan fokus pada pengelolaan anggaran harian dan pemantauan pengeluaran, FunGoals dirancang khusus untuk membantu pengguna mencapai tujuan finansial besar mereka, seperti barang impian, masa pensiun yang nyaman dan persiapan dana darurat. Dengan mengedepankan perencanaan untuk tujuan-tujuan jangka panjang dan besar ini, FunGoals memberikan solusi yang lebih menyeluruh dan terarah bagi pengguna yang ingin memastikan bahwa mereka bisa mencapai mimpi-mimpi mereka.
Masalah utama yang diatasi oleh FunGoals adalah ketidakmampuan banyak individu dan keluarga dalam menilai kelayakan dan merencanakan tujuan keuangan besar mereka. Banyak orang kesulitan untuk mengetahui apakah pendapatan dan tabungan mereka cukup untuk mewujudkan impian mereka dalam jangka waktu yang diinginkan. FunGoals menawarkan fitur simulasi dan analisis yang komprehensif, yang memungkinkan pengguna untuk mengevaluasi secara realistis kemampuan finansial mereka dalam mencapai tujuan-tujuan tersebut. Aplikasi ini tidak hanya menilai kelayakan, tetapi juga menyediakan rencana alternatif jika tujuan awal tampak tidak realistis, memastikan bahwa pengguna selalu memiliki jalur yang jelas menuju pencapaian impian mereka.
Dengan dashboard utama yang memberikan ringkasan kondisi keuangan dan visualisasi data yang memudahkan pemahaman, FunGoals memastikan pengguna tetap termotivasi dan fokus pada tujuan mereka. Fitur pemberitahuan dan pengingat juga berperan penting dalam menjaga pengguna di jalur yang benar, mengingatkan mereka tentang kemajuan dan langkah-langkah yang perlu diambil. Melalui pendekatan yang terfokus ini, FunGoals tidak hanya membantu pengguna mengelola keuangan, tetapi juga memberikan mereka alat yang diperlukan untuk mewujudkan impian mereka secara efektif dan menyenangkan.


## Fitur Aplikasi
  1. Pengguna  dapat memilih mimpi apa yang akan mereka wujudkan
  2. Dapat Menampilkan Form Input untuk Pengguna yang memungkinkan pengguna memasukkan data terkait impian mereka
  3. Dapat Mengevaluasi Rencana Pengguna apakah rencana tersebut realistis berdasarkan input yang telah dimasukkan
  4. Menampilkan Hasil Evaluasi Rencana Pengguna
  5. Dapat memberikan tips jika rencana belum realistis dengan kondisi keuangan saat ini


## Penjelasan Penerapan Prinsip OOP
1. Pada DanaKeuangan.java, terdapat abstract class DanaKeuangan yang memiliki dua atribut umum (targetInvestasiTiapBulan dan returnInvestasiPerTahun) dan satu metode abstract hitungInvestasi(). (Abstraction)
2. Pada DanaDaruratModel.java , terdapat class DanaDarurat yang mewarisi class DanaKeuangan, dan memiliki empat atribut private (pengeluaranWajibTiapBulan, jumlahTanggungan, lamaTargetMengumpulkan, dan danaDaruratSaatIni). Class ini meng-override metode abstract hitungInvestasi() dari class DanaKeuangan untuk memberikan implementasi spesifik bagi dana darurat. (Encapsulation, Inheritance, dan Polimorfisme)
3. Pada DanaPensiunModel.java , terdapat class DanaPensiun yang juga mewarisi class DanaKeuangan, dan memiliki sepuluh atribut private (pengeluaranPerBulan, pengeluaranPerTahun, usiaSekarang, usiaPensiun, asumsiInflasiPerTahun, pengeluaranTahunanSaatPensiun, uangYangDibutuhkan, danaPensiunSaatIni, lamaWaktuPensiun, dan targetInvestasiTiapBulan). Class ini meng-override metode abstract hitungInvestasi() dari class DanaKeuangan untuk memberikan implementasi spesifik bagi dana pensiun. (Encapsulation, Inheritance, dan Polimorfisme)

## Mentoring
- Kak Kelvin Leonardo Sianipar [Jumat, 24 mei 2024]

## Link Repository GitHub
[https://github.com/seizenB/Fun-Goals](https://github.com/seizenB/Fun-Goals)

## Screenshots
### Login Scene
![Login Scene](https://github.com/seizenB/Fun-Goals/tree/main/readme/LoginScene.png)

### Menu Sign Up
![Menu Sign Up](https://github.com/seizenB/Fun-Goals/tree/main/readme/MenuSignup.png)

### Menu Sign in
![Menu Sign in](https://github.com/seizenB/Fun-Goals/tree/main/readme/MenuSignin.png)

### Scene Barang
![Scene Barang](https://github.com/seizenB/Fun-Goals/tree/main/readme/Scene_Barang1.jpeg)
![Scene Barang](https://github.com/seizenB/Fun-Goals/tree/main/readme/Scene_Barang2.png)

### Scene Dana Darurat
![Scene Dana Darurat](https://github.com/seizenB/Fun-Goals/tree/main/readme/Scene_DanaDarurat.jpeg)

### Scene Dana Pensiun
![Scene Dana Pensiun](https://github.com/seizenB/Fun-Goals/tree/main/readme/Scene_DanaPensiun1.jpeg)
![Scene Dana Pensiun](https://github.com/seizenB/Fun-Goals/tree/main/readme/Scene_DanaPensiun2.png)

## Pengujian Pada Aplikasi
![Table](https://github.com/seizenB/Fun-Goals/tree/main/readme/Table.png)
