package SoalSimulasiUAS2;

public class Song extends MenuItem {
    private String singer;
    private String album;

    public Song(String name, double price, Type type, String singer, String album) {
        super(name, price, type);
        this.singer = singer;
        this.album = album;
    }

    @Override
    public String getInfoDetail() {
        return this.getName() + "\n" +
                "penyanyi: " + this.singer + "\n" +
                "album: " + this.album + "\n" +
                "harga: " + this.getPrice() + " MeidoPointo" + "\n";
    }

    @Override
    public String getInfoConcise() {
        return this.getName() + "\n" +
                "penyanyi: " + this.singer + "\n" +
                "album: " + this.album + "\n" +
                "harga: " + this.getPrice() + " MeidoPointo" + "\n";
    }
}
