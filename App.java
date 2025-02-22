class Mobil {
    String merek;
    String model;
    int tahun;

    public Mobil(String merek, String model, int tahun) {
        this.merek = merek;
        this.model = model;
        this.tahun = tahun;
    }

    public void tampilkanInfo()  {
        System.out.println("Merek: " + merek);
        System.out.println("Model: " + model);
        System.out.println("Tahun: " + tahun);
    }
}

public class App{
    public static void main(String[] args) {
        Mobil mobil1 = new Mobil ("BMW", "Corolla", 2022);
        Mobil mobil2 = new Mobil ("Wuling", "Civic", 2024);

        mobil1.tampilkanInfo();
        System.out.println();
        mobil2.tampilkanInfo();
    }
}