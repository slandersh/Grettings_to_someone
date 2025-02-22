import java.util.Scanner;
import java.util.Random;

class Assassin {
    String NamaHero;
    String Emblem;
    String Skill_1;
    String Skill_2;
    String Skill_3;
    String Skill_Ultimate;
    int Hp;
    int Basic_Attack;
    boolean isAlive;

    void aturAtributHero(String nama, String emblem, String s1, String s2, String s3, String ult, int hp, int serang) {
        this.NamaHero = nama;
        this.Emblem = emblem;
        this.Skill_1 = s1;
        this.Skill_2 = s2;
        this.Skill_3 = s3;
        this.Skill_Ultimate = ult;
        this.Hp = hp;
        this.Basic_Attack = serang;
        this.isAlive = true;
    }

    int gunakanSkill(int nomorSkill) {
        int damage = 0;
        switch (nomorSkill) {
            case 1:
                damage = Basic_Attack + 50;
                System.out.println(NamaHero + " menggunakan " + Skill_1 + " (Damage: " + damage + ")");
                break;
            case 2:
                damage = Basic_Attack + 100;
                System.out.println(NamaHero + " menggunakan " + Skill_2 + " (Damage: " + damage + ")");
                break;
            case 3:
                damage = Basic_Attack + 150;
                System.out.println(NamaHero + " menggunakan " + Skill_3 + " (Damage: " + damage + ")");
                break;
            case 4:
                damage = Basic_Attack + 300;
                System.out.println(NamaHero + " menggunakan " + Skill_Ultimate + " (Damage: " + damage + ")");
                break;
        }
        return damage;
    }

    void terimaSerangan(int damage) {
        Hp -= damage;
        if (Hp <= 0) {
            Hp = 0;
            isAlive = false;
        }
        System.out.println(NamaHero + " menerima " + damage + " damage. HP tersisa: " + Hp);
    }

    void tampilkanStatus() {
        System.out.println("\nStatus " + NamaHero + ":");
        System.out.println("HP: " + Hp);
        System.out.println("Basic Attack: " + Basic_Attack);
    }
}

public class MobileLegend {
    static void tampilkanMenuSkill() {
        System.out.println("\nPilih skill:");
        System.out.println("1. Skill 1");
        System.out.println("2. Skill 2");
        System.out.println("3. Skill 3");
        System.out.println("4. Ultimate");
    }

    static Assassin buatLing() {
        Assassin hero = new Assassin();
        hero.aturAtributHero("Ling", "Pedang", "Tebasan Pedang", 
                            "Pedang Keadilan", "Serangan Keadilan", 
                            "Tebasan Ultimate", 3000, 200);
        return hero;
    }

    static Assassin buatFanny() {
        Assassin hero = new Assassin();
        hero.aturAtributHero("Fanny", "Pedang", "Tebasan Kabel", 
                            "Lemparan Kabel", "Serangan Kabel", 
                            "Tornado Kabel", 2800, 220);
        return hero;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        
        System.out.println("Pilih hero Anda (1: Ling, 2: Fanny):");
        Assassin playerHero = (input.nextInt() == 1) ? buatLing() : buatFanny();
        Assassin enemyHero = (playerHero.NamaHero.equals("Ling")) ? buatFanny() : buatLing();

        System.out.println("\nPERTEMPURAN DIMULAI!");
        System.out.println(playerHero.NamaHero + " VS " + enemyHero.NamaHero);

        while (playerHero.isAlive && enemyHero.isAlive) {
            // Player turn
            playerHero.tampilkanStatus();
            enemyHero.tampilkanStatus();
            
            tampilkanMenuSkill();
            int skillChoice = input.nextInt();
            int playerDamage = playerHero.gunakanSkill(skillChoice);
            enemyHero.terimaSerangan(playerDamage);

            if (!enemyHero.isAlive) {
                System.out.println("\n" + playerHero.NamaHero + " MENANG!");
                break;
            }

            // Enemy turn
            System.out.println("\nGiliran musuh!");
            int enemySkill = rand.nextInt(4) + 1;
            int enemyDamage = enemyHero.gunakanSkill(enemySkill);
            playerHero.terimaSerangan(enemyDamage);

            if (!playerHero.isAlive) {
                System.out.println("\n" + enemyHero.NamaHero + " MENANG!");
                break;
            }
        }

        input.close();
    }
}