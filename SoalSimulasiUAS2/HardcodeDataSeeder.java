package SoalSimulasiUAS2;

import java.util.List;
import java.util.ArrayList;

/**
 * Kelas ini hanya untuk placeholder
 * Untuk soal 1, Anda wajib mengimplementasikan seeder dengan membaca file .csv
 * (Lihat kelas CsvDataSeeder)
*/
public class HardcodeDataSeeder implements DataSeeder {

    @Override
    public List<String[]> seedFoodData() {
        List<String[]> list = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            String name = "Food " + i;
            int price = 10000 + 1000 * i;
            String description = "Description " + i;

            String[] strings = {
                name, "" + price, description
            };

            list.add(strings);
        }

        return list;
    }

    @Override
    public List<String[]> seedBeverageData() {
        List<String[]> list = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            String name = "Drink " + i;
            int price = 10000 + 1000 * i;
            int bonus = 2500 + 250 * i;
            String description = "Description" + i;

            String[] strings = {
                name, "" + price, "" + bonus, description
            };

            list.add(strings);
        }

        return list;
    }

    @Override
    public List<String[]> seedSongData() {
        List<String[]> list = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            String name = "Song " + i;
            String artist = "Artist " + i;
            String album = "Album " + i;
            int price = 5000 + 500 * i;

            String[] strings = {
                name, artist, album, "" + price
            };

            list.add(strings);
        }

        return list;
    }
    
}
