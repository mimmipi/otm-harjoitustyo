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

<img src="https://github.com/mimmipi/otmLamagotchi/blob/master/dokumentointi/kuvat/loginScreenLamagotchi.png" width="500">


Kirjautuminen tapahtuu kirjoittamalla aiemmin luodun nimen ja salasanan syötekenttään ja painamalla _login_.

## Uuden käyttäjän luominen

<img src="https://github.com/mimmipi/otmLamagotchi/blob/master/dokumentointi/kuvat/newUserScreen.png" width="500">

Kirjautumisnäkymästä voi siirtyä uuden käyttäjän luomisnäkymään painamalla _new user_.
Uusi käyttäjä luodaan syöttämällä nimi ja salasana syötekenttiin ja painamalla _create_.

Jos käyttäjän luominen onnistuu, palataan krjautumisnäkymään.

## Pelinäkymä ja pelaaminen

<img src="https://github.com/mimmipi/otmLamagotchi/blob/master/dokumentointi/kuvat/LamagotchiGameScreen.png" width="500">

Onnistuneen kirjautumisen jälkeen siirrytään pelinäkymään, jossa Lamagotchi-hahmo ja sen tilaa merkkaavat mittarit päivittyvät koko ajan. 


Näkymä mahdollistaa mittarien hallinnan painikkeilla _feed_, _sleep_, _wash_ ja _play_. Jos käyttäjä ei pidä mittarien lukemia korkealla, tulostuu hahmon valitusviestejä näkymään.
Jos nälkää kuvaava mittari, ensimmäinen vasemmalta, tyhjenee nollaan on peli ohi. Tällöin pelaajalle avautuu Lamagotchin kuolemasta kertova sivu.

<img src="https://github.com/mimmipi/otmLamagotchi/blob/master/dokumentointi/kuvat/endScreen.png" width="500">
