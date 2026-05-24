# Soal 2

Setelah menu digital yang Anda buat digunakan oleh Le Soleil, manajer Le Soleil memberikan Anda pekerjaan baru untuk mengimplementasikan beberapa fungsionalitas baru.

## Perlu Merancang Kelas Lagi?

Setelah manajer Le Soleil memberitahukan Anda *requirements* untuk fungsionalitas baru, Anda menyadari bahwa Anda mungkin harus merancang ulang kelas `MenuItem` yang sebelumnya Anda buat. Terdapat perbedaan *behavior* yang cukup signifikan di antara makanan, minuman, dan lagu karaoke yang disediakan oleh Le Soleil meskipun perintah yang dipanggil sama (contoh : untuk memutar lagu karaoke, pelanggan harus membayar dengan MeidoPointo, tidak seperti memesan makanan atau minuman). Anda pun terpikir bahwa solusi untuk masalah ini adalah dengan menerapkan *polymorphism* karena dengan menggunakan konsep ini, perilaku-perilaku yang jauh berbeda bisa diimplementasikan meskipun perintah yang dipanggil sama.

Manfaatkan *interface*, *abstract class*, dan *inheritance* dalam merancang dan mengimplementasikan ulang kelas-kelas yang Anda butuhkan untuk memenuhi *requirements* dari perintah-perintah baru. Anda diperbolehkan untuk membuat kelas baru, baik konkret maupun abstrak, ataupun *interface* baru pada bagian ini.

## Input dari Pengguna

Untuk soal ini, Anda harus mengimplementasikan beberapa perintah baru, yaitu `MENU_DETAIL (index)`, `ORDER (index)`, dan `INVOICE`

### "MENU_DETAIL (index)"

Perintah ini dipanggil oleh pengguna saat pengguna ingin melihat informasi rinci dari salah satu makanan/minuman/lagu yang tersedia di menu. Pengguna memasukkan nilai `index` untuk memberitahu program makanan/minuman/lagu apa yang informasi rincinya ingin mereka lihat. Program akan menggunakan parameter `index` dengan menggunakan method `get(index)` yang tersedia pada *interface* `List` untuk mendapatkan makanan/minuman/lagu yang diinginkan oleh pengguna. 

Perintah ini sudah diimplementasikan oleh rekan Anda namun implementasi tersebut membutuhkan implementasi dari metode `getInfoDetail()` yang terdapat pada kelas `MenuItem` (atau *inteface* `MenuItem`, jika Anda mengubah kelas tersebut menjadi *interface*).

Hint : Anda dapat menggunakan karakter `\n` untuk mencetak baris selanjutnya. Contoh, jika Anda ingin mencetak:
```
Baris 1
Baris 2
```
Maka Anda dapat membuat `String` Anda dengan nilai `Baris1\nBaris2`

Untuk makanan, metode `getInfoDetail()` akan mengembalikan beberapa baris `String` sebagai berikut:
```
<nama makanan>
<deskripsi>
harga : <harga> IDR
bonus : <bonus> MeidoPointo (15% dari harga makanan)
```

Contoh untuk makanan seperti berikut:
- nama : SuperDuperMie Goreng
- deskripsi : Mie instan yang direbus dan disajikan tanpa kuah
- harga : 10000.0

`getInfoDetail()` akan mengembalikan beberapa baris berikut :
```
SuperDuperMie Goreng
Mie instan yang direbus dan disajikan tanpa kuah
harga : 10000.0 IDR
bonus : 1500.0 MeidoPointo (15% dari harga makanan)
```

Untuk minuman, metode `getInfoDetail()` akan mengembalikan beberapa baris `String` sebagai berikut:
```
<nama minuman>
<deskripsi>
harga : <harga> IDR
bonus : <bonus> MeidoPointo
```

Contoh untuk minuman seperti berikut:
- nama : Cappuccino
- deskripsi : Kopi kesukaan Kafuu Chino
- harga : 15000.0
- bonus : 3450.0

`getInfoDetail()` akan mengembalikan beberapa baris berikut :
```
Cappuccino
Kopi kesukaan Kafuu Chino
harga : 15000.0 IDR
bonus : 3450.0 MeidoPointo
```

Untuk lagu, metode `getInfoDetail()` akan mengembalikan beberapa baris `String` sebagai berikut:
```
<nama lagu>
penyanyi : <nama penyanyi/artist>
album : <nama album>
harga : <harga> MeidoPointo
```

Contoh untuk lagu seperti berikut:
- nama : Baka Mitai
- nama penyanyi/artist : Kazuma Kiryu
- album : Ryu Ga Gotoku Karaoke Soundtrack
- harga : 3000.0

`getInfoDetail()` akan mengembalikan beberapa baris berikut :
```
Baka Mitai
penyanyi : Kazuma Kiryu
album : Ryu Ga Gotoku Karaoke Soundtrack
harga : 3000.0 MeidoPointo
```

### "ORDER (index)"

Perintah ini dipanggil oleh pengguna saat pengguna ingin memesan makanan atau minuman atau ingin memutar lagu pada layanan karaoke. Rekan Anda telah mengimplementasikan metode ini namun implementasi tersebut belum selesai. Pada implementasi tersebut sudah ada bagian kode untuk mendapatkan makanan/minuman/lagu yang dipesan (dengan menggunakan parameter `index`). Tugas Anda untuk mengimplementasikan perintah ini adalah :
1. Memasukkan makanan/minuman/lagu ke dalam daftar pesanan
2. Mencetak output:

Untuk makanan/minuman :
```
Anda memesan <nama makanan/minuman> seharga <harga> IDR
Anda mendapatkan bonus sebesar <bonus> MeidoPointo
```

Untuk lagu :
```
Anda memutar lagu <nama lagu>
Anda mengeluarkan MeidoPointo sebesar <harga> MeidoPointo
```

### "INVOICE"

Perintah ini dipanggil oleh pengguna saat pengguna ingin mendapatkan *invoice* dari pesanan-pesanan yang sudah mereka buat sebelumnya (dengan memanggil perintah `ORDER (index)`). Saat perintah ini dipanggil, program mencetak :
```
Pesanan :
0. <pesanan[0].getInfoConcise()>
1. <pesanan[1].getInfoConcise()>
...
n. <pesanan[n]>.getInfoConcise()>

Total Biaya : <totalBiaya> IDR
Sisa Meido Pointo : <sisaMeidoPointo> MeidoPointo
Biaya yang Harus Dibayar : <biayaAkhir>
```

Penjelasan nilai-nilai variabel pada *template* di atas adalah:
- `pesanan[i].getInfoConcise()` : Mendapatkan nilai `getInfoConcise()` dari pesanan. `pesanan[i]` mengindikasikan pesanan dengan indeks `i`. Daftar pesanan dapat menggunakan struktur data apapun
- `totalBiaya` : jumlahan dari harga-harga semua pesanan
- `sisaMeidoPointo` : jumlah dari MeidoPointo yang belum dipakai
- `biayaAkhir` : biaya yang harus dibayar oleh pengguna. Akan dijelaskan selanjutnya

Biaya akhir yang harus dibayar oleh pengguna adalah `totalBiaya` IDR. Jika masih terdapat sisa MeidoPointo, maka akan terdapat potongan sebanyak 30% dari sisa MeidoPointo yang tidak terpakai (jadi biaya akhir sama dengan `totalBiaya - 0.25 * sisaMeidoPointo`). Jika ternyata pemakaian MeidoPointo melebihi jumlah bonus MeidoPointo yang didapatkan (dengan kata lain, nilai `sisaMeidoPointo` bernilai negatif), maka akan dikenakan biaya tambahan sebesar 30% dari kekurangan MeidoPointo (jadi biaya akhir sama dengan `totalBiaya - 0.3 * sisaMeidoPointo`)

Contoh `sisaMeidoPointo` positif :
```
0. Makanan1 | Harga : 10000.0 IDR | Bonus : 1500.0 MeidoPointo
1. MinumanX | Harga : 5500.0 IDR | Bonus : 1000.0 MeidoPointo
2. Aku Ganteng |  Harga : 1500.0 MeidoPointo
Total Biaya : 15500.0 IDR
Sisa Meido Pointo : 1000.0 MeidoPointo
Biaya yang Harus Dibayar : 15250.0 IDR
```

Contoh `sisaMeidoPointo` negatif :
```
0. MinumanX | Harga : 5500.0 IDR | Bonus : 1000.0 MeidoPointo
1. BakaMitai | Harga : 3000.0 MeidoPointo
2. Makanan1 | Harga : 10000.0 IDR | Bonus : 1500.0 MeidoPointo

Total Biaya : 15500.0 IDR
Sisa Meido Pointo : -500.0 MeidoPointo
Biaya yang Harus Dibayar : 15800.0 IDR
```

## To Do Soal 2
- [ ] Rancang ulang kelas-kelas yang Anda buat sebelumnya. Manfaatkan konsep *polymorphism*.
- [ ] Mengimplementasikan metode `getInfoDetail()` pada kelas-kelas yang dibuat untuk perintah `MENU_DETAIL (index)`
- [ ] Mengimplementasikan perintah `ORDER (index)`
- [ ] Mengimplementasikan perintah `INVOICE`
- [ ] Perhatikan penerapan exception handler dan prinsip Object Oriented dalam pembuatan program.
