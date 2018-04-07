
public class Lamagotchi {

    private String name;
    private double age;
    private int hungry;
    private int dirty;
    private int happy;
    private int energy;

    public Lamagotchi(String name) {
        this.name = name;
        this.age = 0;
        this.dirty = 10;
        this.happy = 10;
        this.hungry = 10;
        this.energy = 10;
    }

    public void timePasses() {
        if (this.hungry > 0) {
            this.hungry--;
        }
        if (this.happy > 0) {
        this.happy--;
        }
        if (this.dirty > 0) {
        this.dirty--;
        }
        if (this.energy > 0) {
        this.energy--;
        }
        this.age++;
    }

    public void washLama() {
        this.dirty = 10;
    }

    public void feedLama() {
        this.hungry = 10;
    }

    public void sleepLama() {
        this.energy = 10;
    }

    public void playWithLama() {
        this.happy = 10;
    }

    public double getAge() {
        return this.age / 10;
    }

    public String printInformation() {
        return "Lamagotchi: " + this.name + "\nIkä: " + this.getAge() + "\nVirkeys: " + this.energy + "\nOnnellisuus: " + this.happy
                + "\nHygienia: " + this.dirty + "\nEnergia: " + this.hungry + "\n";
    }

    public void killLama() {

    }
}
