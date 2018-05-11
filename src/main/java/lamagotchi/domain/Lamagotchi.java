package lamagotchi.domain;

import lamagotchi.userinterface.UserInterface;

/**
 * Luokka edustaa yhtä instanssia Lamagotchi-hahmosta
 *
 * @author piikkila
 */
public class Lamagotchi {

    private String name;
    private double age;
    private double hungry;
    private double dirty;
    private double happy;
    private double energy;

    /**
     * Metodi luo uuden instanssin Lamagotchi-luokasta
     *
     * @param name Lamagotchi-oliolle annettava nimi
     */
    public Lamagotchi(String name) {
        this.name = name;
        this.age = 0;
        this.dirty = 1;
        this.happy = 1;
        this.hungry = 1;
        this.energy = 1;
    }

    public void setEnergy(double x) {
        this.energy = x;
    }

    public void setDirty(double x) {
        this.dirty = x;
    }

    public void setHunger(double x) {
        this.hungry = x;
    }

    public void setHappy(double x) {
        this.happy = x;
    }

    public double getAge() {
        return this.age;
    }
    
    public void setAge(double x) {
        this.age = x;
    }

    public String getName() {
        return this.name;
    }

    public double getEnergy() {
        return this.energy;
    }

    public double getHappiness() {
        return this.happy;
    }

    public double getHunger() {
        return this.hungry;
    }

    public double getDirty() {
        return this.dirty;
    }

    /**
     * Metodi palauttaa Lamagotchi-olion tiedot luettavassa muodossa
     *
     * @return Lamagotchin tiedot luettavassa muodossa
     */
    public String printInformation() {
        return "Lamagotchi: " + this.name + "\nIkä: " + this.getAge() + "\nVirkeys: " + this.energy + "\nOnnellisuus: " + this.happy
                + "\nHygienia: " + this.dirty + "\nEnergia: " + this.hungry + "\n";
    }

}
