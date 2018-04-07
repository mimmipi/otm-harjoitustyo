
import java.util.Scanner;

public class PlayScreen {

    private Lamagotchi Lama;

    public PlayScreen(Lamagotchi Lama) {
        this.Lama = Lama;
        Scanner lukija = new Scanner(System.in);
        System.out.println("Mitä haluat tehdä Lamagotchisi kanssa?");
        while (true) {
            this.Lama.timePasses();
            System.out.println("Voit kirjoittaa komennon: leiki, nuku, syo, peseydy, lopeta");
            String komento = lukija.nextLine();
            if (komento.equals("lopeta")) {
                break;
            } else if (komento.equals("leiki")) {
                this.Lama.playWithLama();
            } else if (komento.equals("nuku")) {
                this.Lama.sleepLama();
            } else if (komento.equals("syo")) {
                this.Lama.feedLama();
            } else if (komento.equals("peseydy")) {
                this.Lama.washLama();
            } else {
                System.out.println("En ymmärtänyt komentoa.");
            }
            System.out.println(this.Lama.printInformation());
            
        }
    }

}
