
public class Main {

    public static void main(String[] args) {

        OpeningScreen alku = new OpeningScreen();
        PlayScreen peli = new PlayScreen(alku.getLamagotchi());
    }
}
