package SoalSimulasiUAS2;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	/*
	* Menyediakan data dengan membaca dan memproses file .csv
	* uncomment baris kode di bawah jika implementasi membaca
	* dan memproses file .csv sudah selesai
	*/
	// private static DataSeeder seeder = new CsvDataSeeder();

	/*
	* Menyediakan data secara hardcode
	* comment baris kode di bawah jika implementasi membaca
	* dan memproses file .csv sudah selesai
	*/
	private static DataSeeder seeder = new HardcodeDataSeeder();
	public static void main(String[] args){
		List<MenuItem> menu = generateMenu();
		Scanner in = new Scanner(System.in);
		// silahkan tambahkan variabel-variabel lain disini jika dibutuhkan
		
		while(in.hasNextLine()){
			StringTokenizer st = new StringTokenizer(in.nextLine());
			String command = st.nextToken();

			if(command.equalsIgnoreCase("MENU_LIST")){
				// implementasi kode ini sudah dibuat
				// silahkan implementasi method MenuItem.getInfoConcise()
				int length = menu.size();
				for(int i = 0; i < length; i++){
					MenuItem item = menu.get(i);
					String info = String.format("%d. %s", i, item.getInfoConcise());
					System.out.println(info);
				}
			} else if(command.equalsIgnoreCase("MENU_DETAIL")){
				// implementasi kode ini sudah dibuat
				// silahkan implementasi method MenuItem.getInfoDetail()
				int idx = Integer.parseInt(st.nextToken());
				MenuItem item = menu.get(idx);
				System.out.println(item.getInfoDetail());
			} else if(command.equalsIgnoreCase("ORDER")){
				int idx = Integer.parseInt(st.nextToken());
				MenuItem item = menu.get(idx);
				// TO DO : implementasi bagian ini
			} else if(command.equalsIgnoreCase("INVOICE")){
				// TO DO : implementasikan bagian ini
			} else {
				System.out.println("Perintah tidak dikenal");
			}
		}
		
		in.close();

	}

	public static List<MenuItem> generateMenu(){
		List<MenuItem> menu = new ArrayList<>();
		menu.addAll(generateFoods());
		menu.addAll(generateBeverages());
		menu.addAll(generateSongs());
		return menu;
	}

	private static List<MenuItem> generateFoods(){
		List<MenuItem> menu = new ArrayList<>();
		List<String[]> foodData = seeder.seedFoodData();
		for(String[] data : foodData){
			// TO DO : konversi string dari String[] menjadi objek yang sesuai
			String foodName = data[0];
			double foodPrice = Double.parseDouble(data[1]);
			int meidoPointBonus =  Integer.parseInt(data[2]);
			String foodDescription = data[3];

			Food food = new Food(foodName, foodPrice, Type.FOOD, foodDescription, meidoPointBonus);
			menu.add(food);

		}

		return menu;
	}

	private static List<MenuItem> generateBeverages(){
		List<MenuItem> menu = new ArrayList<>();
		List<String[]> beverageData = seeder.seedBeverageData();
		for(String[] data : beverageData){
			// TO DO : konversi string dari String[] menjadi objek yang sesuai

			String beverageName = data[0];
			double beveragePrice = Double.parseDouble(data[1]);
			int meidoPointBonus =  Integer.parseInt(data[2]);
			String beverageDescription = data[3];

			Beverage beverage = new Beverage(beverageName, beveragePrice, Type.BEVERAGE, beverageDescription, meidoPointBonus);
			menu.add(beverage);

		}

		return menu;
	}
	
	private static List<MenuItem> generateSongs(){
		List<MenuItem> menu = new ArrayList<>();
		List<String[]> songData = seeder.seedSongData();
		for(String[] data : songData){
			// TO DO : konversi string dari String[] menjadi objek yang sesuai
			String songName = data[0];
			String artist = data[1];
			String album = data[2];
			double meidoPointCost = Double.parseDouble(data[3]);

			Song song = new Song(songName, meidoPointCost, Type.SONG, artist, album);
			menu.add(song);
		}

		return menu;
	}
}