# Arkkitehtuurikuvaus

## Rakenne

Ohjelman rakenne noudattelee kolmitasoista kerrosarkkitehtuuria, ja koodin pakkausrakenne on seuraava:

* userinterface
* domain
* DAO

Pakkaus _lamagotchi.userinterface_ sisältää JavaFX:llä toteutetun käyttöliittymän _lamagotchi.domain_ sovelluslogiikan ja _lamagotchi.dao_ tietojen pysyväistallennuksesta vastaavan koodin.

## Käyttöliittymä

Käyttöliittymä tulee sisältämään kolme erillistä näkymää
- kirjautuminen
- uuden käyttäjän luominen
- pelinäkymä

jokainen näistä on toteutettu omana [Scene](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/Scene.html)-oliona. 
Näkymistä yksi kerrallaan on näkyvänä eli sijoitettuna sovelluksen [stageen](https://docs.oracle.com/javase/8/javafx/api/javafx/stage/Stage.html).

Käyttöliittymä on pyritty eristämään täysin sovelluslogiikasta, se ainoastaan kutsuu sopivin parametrein sovelluslogiikan toteuttavan olion _lamagotchiServicen_ metodeja.


## Sovelluslogiikka

Sovelluksen loogisen datamallin muodostavat luokat User ja Lamagotchi.

Toiminnallisista kokonaisuuksista vastaa luokka lamagotchiService.


## Tietojen pysyväistallennus

Pakkauksen _lamagotchi.DAO_ luokat _FileUseroDao_ ja _FileLamagotchiDao_ huolehtivat tietojen tallettamisesta tiedostoihin.

Luokat noudattavat [Data Access Object](https://en.wikipedia.org/wiki/Data_access_object) -suunnittelumallia ja ne on tarvittaessa mahdollista korvata uusilla toteutuksilla, jos sovelluksen datan talletustapaa päätetään vaihtaa. Luokat onkin eristetty rajapintojen _LamagotchiDao_ ja _UserDao_ taakse ja sovelluslogiikka ei käytä luokkia suoraan.

### Tiedostot

Sovellus tallettaa käyttäjien ja lamagotchien tiedot erillisiin tiedostoihin.

### Päätoiminnallisuudet



## Ohjelman rakenteeseen jääneet heikkoudet

