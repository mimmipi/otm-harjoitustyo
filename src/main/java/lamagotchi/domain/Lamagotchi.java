package lamagotchi.domain;

import lamagotchi.userinterface.UserInterface;
/**
 * Luokka edustaa yhtä instanssia Lamagotchi-hahmosta
 * @author piikkila
 */
public class Lamagotchi {

    private String name;
    private double age;
    private int hungry;
    private int dirty;
    private int happy;
    private int energy;
    
    /**
     * Metodi luo uuden instanssin Lamagotchi-luokasta
     * @param name Lamagotchi-oliolle annettava nimi
     */

    public Lamagotchi(String name) {
        this.name = name;
        this.age = 0;
        this.dirty = 0;
        this.happy = 3;
        this.hungry = 0;
        this.energy = 0;
    }

    public void setEnergy(int x) {
        this.energy = x;
    }

    public void setDirty(int x) {
        this.dirty = x;
    }

    public void setHungry(int x) {
        this.hungry = x;
    }

    public void setHappy(int x) {
        this.happy = x;
    }

    public double getAge() {
        return this.age / 10;
    }

    public String getName() {
        return this.name;
    }

    public int getEnergy() {
        return this.energy;
    }

    public int getHappiness() {
        return this.happy;
    }

    public int getHunger() {
        return this.hungry;
    }

    public int getDirty() {
        return this.dirty;
    }
    
    /**
     * Metodi palauttaa Lamagotchi-olion tiedot luettavassa muodossa
     * @return Lamagotchin tiedot luettavassa muodossa
     */

    public String printInformation() {
        return "Lamagotchi: " + this.name + "\nIkä: " + this.getAge() + "\nVirkeys: " + this.energy + "\nOnnellisuus: " + this.happy
                + "\nHygienia: " + this.dirty + "\nEnergia: " + this.hungry + "\n";
    }

}
