
public class Main {

    public static void main(String[] args) {

        OpeningScreen alku = new OpeningScreen();
        System.out.println(alku.getLamagotchi().printInformation());
        PlayScreen peli = new PlayScreen(alku.getLamagotchi());
        
    }
}
