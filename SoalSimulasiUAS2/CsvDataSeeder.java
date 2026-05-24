package SoalSimulasiUAS2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class CsvDataSeeder implements DataSeeder {

    /**
     * Method ini untuk membaca file .csv dan melakukan konversi
     * data yang dibaca menjadi string-string yang sudah dilakukan tokenisasi
     * Notes :
     *  * Anda dapat melihat dan menggunakan kode dari TP 10
     *  * Anda dapat 
     * @param fileName nama file dengan ekstensi .csv
     * @return list dari array of string yang berisi
    */
    public List<String[]> convertCsvToList(String fileName){
        List<String[]> list = new ArrayList<>();
        // TO DO : Implement me
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

            String records;
            while ((records = reader.readLine()) != null) {
                String[] data = records.split(",");
                for (String d: data) {
                    list.add(new String[]{d});
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public List<String[]> seedSongData(){
        return this.convertCsvToList("song.csv");
    }

    @Override
    public List<String[]> seedFoodData() {
        return this.convertCsvToList("food.csv");
    }

    @Override
    public List<String[]> seedBeverageData() {
        return this.convertCsvToList("beverage.csv");
    }
}
