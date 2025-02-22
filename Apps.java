class Mobil {
    String merek;
    String model;
    int tahun;

    public Mobil(String merek, String model, int tahun) {
        this.merek = merek;
        this.model = model;
        this.tahun = tahun;
    }

    public void tampilkanInfo() {
        System.out.println("Merek: " + merek);
        System.out.println("Model: " + model);
        System.out.println("Tahun: " + tahun);
    }
}

public class Apps {
    public static void main(String[] args) {
        Mobil mobil11 = new Mobil("BMW", "corolla", 2022);
        Mobil mobil12 = new Mobil("Wuling", "civic", 2024);

        mobil11.tampilkanInfo();
        System.out.println();
        mobil12.tampilkanInfo();
    }
}
