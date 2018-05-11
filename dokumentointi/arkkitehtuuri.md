# Arkkitehtuurikuvaus

## Rakenne

Ohjelman rakenne noudattelee kolmitasoista kerrosarkkitehtuuria, ja koodin pakkausrakenne on seuraava:

<img src="https://github.com/mimmipi/otmLamagotchi/blob/master/dokumentointi/kuvat/Untitled%20Diagram.png" width="160">

* userinterface
* domain
* DAO

Pakkaus _lamagotchi.userinterface_ sisältää JavaFX:llä toteutetun käyttöliittymän _lamagotchi.domain_ sovelluslogiikan ja _lamagotchi.dao_ käyttäjätietojen pysyväistallennuksesta vastaavan koodin.

## Käyttöliittymä

Käyttöliittymä sisältää neljä erilaista näkymää
* kirjautuminen
* uuden käyttäjän luominen
* pelinäkymä
* pelin loppu

jokainen näistä on toteutettu omana [Scene](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/Scene.html)-oliona. 
Näkymistä yksi kerrallaan on näkyvänä eli sijoitettuna sovelluksen [stageen](https://docs.oracle.com/javase/8/javafx/api/javafx/stage/Stage.html).
Käyttöliittymä on rakennettu ohjelmallisesti luokassa lamagotchi.userinterface.UserInterface.

Käyttöliittymä on pyritty eristämään täysin sovelluslogiikasta, se ainoastaan kutsuu sopivin parametrein sovelluslogiikan toteuttavan olion _lamagotchiServicen_ metodeja.

Pelinäkymässä kutsutaan hyvin lyhyellä aikavälillä jatkuvassa loopissa lamagotchiServicen metodia timePasses, joka kuluttaa peliaikaa eli vähentää onnellisuus, puhtaus, energisyys ja kylläisyys -mittarien lukemaa sekä kasvattaa
Lamagotchi-olennon ikää. Käyttäjä voi vaikuttaa lukemaan painamalla Button-painikkeita joilla Lamagotchia voi syöttää, nukuttaa, leikittää ja pestä. Jos nälkäisyyttä edustava mittari laskee nollaan, peli loppuu ja käyttäjälle
avataan loppuruutu, joka kertoo Lamagotchin kuolleen.

## Sovelluslogiikka

Sovelluksen loogisen datamallin muodostavat luokat User ja Lamagotchi.

Toiminnallisista kokonaisuuksista vastaa luokka lamagotchiService. Luokka tarjoaa kaikille käyttöliittymässä toimiville toiminnoille oman metodin. Näitä ovat:

* boolean login(String name, String password)
* void createNewUser(String name, String password)
* void createNewLama(String name)
* void timePasses()
* void washLama()
* void feedLama()
* void sleepLama()
* void playWithLama()

LamagotchiService pääsee käsiksi tallennettuihin käyttäjätietoihin tallennuksesta vastaavan pakkauksessa lamagotchi.dao sijaitsevan UserDao luokan kautta. Luokan toteutus injektoidaan sovelluslogiikalle konstruktorikutsun yhteydessä.
LamagotchiServicen ja ohjelman muiden osien suhdetta kuvaava luokka/pakkauskaavio:


<img src="https://github.com/mimmipi/otmLamagotchi/blob/master/dokumentointi/kuvat/relations.png" width="300">

## Tietojen pysyväistallennus

Pakkauksen _lamagotchi.DAO_ luokka _FileUseroDao_  huolethii käyttäjän tietojen tallettamisesta tiedostoihin.

Luokka noudattaa [Data Access Object](https://en.wikipedia.org/wiki/Data_access_object) -suunnittelumallia ja se  on tarvittaessa mahdollista korvata uudella toteutuksella, jos sovelluksen datan talletustapaa päätetään vaihtaa. Luokka onkin eristetty rajapinnan _UserDao_ taakse ja sovelluslogiikka ei käytä luokkia suoraan

### Tiedostot

Sovellus tallettaa käyttäjien tiedot erilliseen tiedostoon.
Sovelluksen juureen sijoitettu konfiguraatiotiedosto config.properties määrittelee tiedoston nimen.
Sovellus talletta käyttäjät formaatissa nimi;salasana, eli ensin käyttäjän nimi ja puolipisteellä erotettuna salasana. 

### Päätoiminnallisuudet

#### Käyttäjän kirjautuminen

Kirjautumiskenttään on syötekenttään kirjoitettu käyttäjätunnus ja salasana salasanakenttään ja klikataan painiketta loginButton, etennee sovelluksen kontrolli näin:

#### Lamagotchin syöttäminen


#### Ajan kuluminen


## Ohjelman rakenteeseen jääneet heikkoudet

### Käyttöliittymä

Käyttöliittymän ulkoasu jäi valitettavasti ajanpuutteen vuoksi hyvin alkeelliseksi, sillä päätin panostaa rajallisen ajan mieluummin toiminnallisuuden valmiiksi saamiseen kuin visuaalisesti miellyttävän ohjelman tuottamiseen.
Ajanpuutteen vuoksi myös pelilogiikka on yksinkertaisempi kuin oli ajatuksena alunperin, eikä palautus ole varsinaisesti kovin pelillinen. 
Kaikki näkymät luodaan tällä hetkellä samassa metodissa start, mikä olisi syytä korjata ja etenkin päänäkymät luovat koodit erotella omiksi metodeikseen. 

### DAO-luokat

Tarkoitus oli rakentaa myös Lamagotchit tallentava oma dao-luokka Lamagotchi-olioita tallentavalle tiedostolle, mutta ajanpuutteen vuoksi koodi jäi kesken ja luokka piti karsia loppupalautuksesta. 
