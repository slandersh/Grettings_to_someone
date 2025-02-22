import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;

public class Mahasiswa {
    private Set<String> nama;
    private int nim;
    private String jurusan;
    private String universitas;
    private int angkatan;
    private String alamat;

    public Mahasiswa() {
        nama = new HashSet<>();
        nim = 0;
        jurusan = "";
        universitas = "Universitas Default";
        angkatan = 2023;
        alamat = "Alamat Default";
    }

    public void tambahMahasiswa(String nama, int nim, String jurusan, String universitas, int angkatan, String alamat) {
        this.nama.add(nama);
        this.nim = nim;
        this.jurusan = jurusan;
        this.universitas = universitas;
        this.angkatan = angkatan;
        this.alamat = alamat;
    }

    public void tampilkanMahasiswa() {
        for (String n : nama) {
            System.out.println(n + " adalah mahasiswa " + universitas + 
                             " program studi " + jurusan + 
                             " angkatan " + angkatan + 
                             " dengan nim " + nim + 
                             " dan tempat tinggal di " + alamat);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Mahasiswa mahasiswa = new Mahasiswa();

        System.out.print("Masukkan Nama: ");
        String nama = scanner.nextLine();

        System.out.print("Masukkan NIM: ");
        int nim = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Masukkan Jurusan: ");
        String jurusan = scanner.nextLine();

        System.out.print("Masukkan Universitas: ");
        String universitas = scanner.nextLine();

        System.out.print("Masukkan Angkatan: ");
        int angkatan = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Masukkan Alamat: ");
        String alamat = scanner.nextLine();

        mahasiswa.tambahMahasiswa(nama, nim, jurusan, universitas, angkatan, alamat);
        mahasiswa.tampilkanMahasiswa();

        scanner.close();
    }
}
