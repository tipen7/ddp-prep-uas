package SoalSimulasiUAS2;

/**
* Kelas untuk Menu pada Le Soleil
* Silahkan tambahkan atribut dan method yang menurut Anda sesuai
* Notes : 
* 1. Anda dapat membuat subclass-subclass dari kelas ini
* 2. Anda dapat menjadikan kelas ini abstract class jika dibutuhkan
* 3. Anda dapat menjadikan method-method yang disediakan menjadi abstract method jika dibutuhkan
* 4. Anda dapat menjadikan kelas ini sebagai interface jika dibutuhkan
*/
public abstract class MenuItem {
    private String name;
    private double price;
    private Type type;

    public MenuItem(String name, double price, Type type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

	public abstract String getInfoDetail();
    public abstract String getInfoConcise();

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type.getType();
    }

    public double getPrice() {
        return this.price;
    }

}