# Lamagotchi

Sovellus on versio 90-luvun Tamagotchi-hittipelistä. Pelissä pelaaja saa hoidettavakseen pienen olion, jota hän ruokkii, pesee ja leikittää pelin tarjoamien painikkeiden avulla. Olion tarpeet muuttuvat ajan kuluessa. Aika kuluu koko ajan pelin aikana ja olion tilaa merkitsevät mittarien lukemat heikkenevät. Pelaajan tehtävä on pitää huolta lemmikistään syöttämällä, nukuttamalla, leikittämällä ja pesemällä sitä ruudulla olevien painikkeiden avulla. Jos käyttäjä antaa lemmikin nälkää kuvaavan mittarin painua nollaan, lemmikki kuolee ja peli on ohi.

## Dokumentaatio

[Vaatimusmäärittely](https://github.com/mimmipi/otm-harjoitustyo/blob/master/dokumentointi/Vaatimusmaarittely.md)


[Työaikakirjanpito](https://github.com/mimmipi/otm-harjoitustyo/blob/master/dokumentointi/tyoaikakirjanpito.md)


[Käyttöohje](https://github.com/mimmipi/otmLamagotchi/blob/master/dokumentointi/kayttoohje.md)


[Arkkitehtuurikuvaus](https://github.com/mimmipi/otmLamagotchi/blob/master/dokumentointi/arkkitehtuuri.md)


[Testausdokumentti](https://github.com/mimmipi/otmLamagotchi/blob/master/dokumentointi/testausdokumentti.md)

## Release

* [Viikon 5 release](https://github.com/mimmipi/otmLamagotchi/releases/tag/Viikko5)

* [Viikon 6 release](https://github.com/mimmipi/otmLamagotchi/releases/tag/Viikko6)

* [Loppupalautus-release](https://github.com/mimmipi/otmLamagotchi/releases/tag/loppupalautus)


## Komentorivitoiminnot

### Testaus

Testit suoritetaan komennolla

```
mvn test
```

Testikattavuusraportti luodaan komennolla

```
mvn jacoco:report
```

Kattavuusraporttia voi tarkastella avaamalla selaimella tiedosto _target/site/jacoco/index.html_

### Suoritettavan jarin generointi

Komento

```
mvn package
```

generoi hakemistoon _target_ suoritettavan jar-tiedoston _otmLamagotchi-1.0-SNAPSHOT.jar_

### JavaDoc

JavaDoc generoidaan komennolla

```
mvn javadoc:javadoc
```

JavaDocia voi tarkastella avaamalla selaimella tiedosto _target/site/apidocs/index.html_

### Checkstyle

Tiedoston [checkstyle.xml](https://github.com/mimmipi/otmLamagotchi/blob/master/checkstyle.xml) määrittelemät tarkistukset suoritetaan komennolla

```
 mvn jxr:jxr checkstyle:checkstyle
```

Mahdolliset virheilmoitukset selviävät avaamalla selaimella tiedosto _target/site/checkstyle.html_

