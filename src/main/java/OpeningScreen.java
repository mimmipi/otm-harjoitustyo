
import java.util.Scanner;

public class OpeningScreen {
        private Lamagotchi Lama;
    
    public OpeningScreen() {
        Scanner lukija = new Scanner(System.in);
        System.out.println("Tervetuloa pelaamaan Lamagotchia!");
        System.out.println("Luo uusi Lamagotchi");
        System.out.println("Nimi: ");
        String name = lukija.nextLine();
        this.Lama = new Lamagotchi(name);
        System.out.println(Lama.printInformation());
    }
    
    public Lamagotchi getLamagotchi() {
        return this.Lama;
    }
    

}
