# Käyttöohje

Lataa tiedosto lamagotchi.jar.

## Konfigurointi

Ohjelma olettaa, että sen käynnistyshakemistossa on konfiguraatiotiedosto config.properties, joka määrittelee käyttäjät tallentavan tiedoston nimen. Tiedoston muoto on tällainen:

```
userFile=users.txt
```

## Ohjelman käynnistäminen

Ohjelma käynnistetään komennolla 

```
java -jar lamagothi.jar

```
## Kirjautuminen

Sovellus käynnistyy kirjautumisnäkymään:


Kirjautuminen tapahtuu kirjoittamalla aiemmin luodun nimen ja salasanan syötekenttään ja painamalla _login_.

## Uuden käyttäjän luominen

Kirjautumisnäkymästä voi siirtyä uuden käyttäjän luomisnäkymään painamalla _new user_.
Uusi käyttäjä luodaan syöttämällä nimi ja salasana syötekenttiin ja painamalla _create_.

Jos käyttäjän luominen onnistuu, palataan krjautumisnäkymään.

## Pelinäkymä ja pelaaminen

Onnistuneen kirjautumisen jälkeen siirrytään pelinäkymään, jossa Lamagotchi-hahmo ja sen tilaa merkkaavat mittarit päivittyvät koko ajan. 


Näkymä mahdollistaa mittarien hallinnan painikkeilla _feed_, _sleep_, _wash_ ja _play_. Jos käyttäjä ei pidä mittarien lukemia korkealla, tulostuu hahmon valitusviestejä näkymään.
Jos nälkää kuvaava mittari, ensimmäinen vasemmalta, tyhjenee nollaan on peli ohi. Tällöin pelaajalle avautuu Lamagotchin kuolemasta kertova sivu.
