# Funkcionális specifikáció

## **Áttekintés**
Egy wellness szállodának szeretnénk készpénz nélküli rendszert bevezetni, ahol vendégek könnyedén igénybe vehetnek
szolgáltatásokat. A vendégek kapnak egy órát, amely azonosítja őket. Amikor sok vendég megérkezik, mindenki megkapja 
a saját óráját, de lehetőség van rá, hogy közös számlán fizessenek.  Amikor a vendégek elmennek, visszaadják az új 
vendégeknek kijelölt órákat. A vendégek a PayPasshoz hasonló terminál megérintésével kényelmesen fizethetnek a 
különféle szolgáltatásokért.

Szeretnénk figyelemmel kísérni fogyasztásukat, és szükség esetén részletes számlát adni. 
Ezen túlmenően szeretnénk korlátozni a vendégek számára elérhető szolgáltatásokat, így bizonyos személyek számára 
bizonyos szolgáltatások nem lesznek elérhetőek(pl. a gyerekek nem vásárolhatnak alkoholt).
Bizonyos szolgáltatásokat emberek nyújtanak, például az italokat egy csapos szolgálja fel a bárban.
Mások automatizált szolgáltatások, mint például a szauna.

Az órák és az olvasók már telepítve vannak, és az interneten keresztül kommunikálnak a rendszerrel.
Ezek az eszközök képesek feldolgozni a választ, jóváhagyni vagy elutasítani a tranzakciót. Ezen eszközök
képesek egyszerű válasz üzenetek nyomtatására a hibáról, ha van. Például, ha egy gyermek  szaunázni akar, 
akkor a bejárati kapu elutasítja a kérését. Egy másik forgatókönyv szerint, ha egy 17 éves akar fizetni
akar az alkoholért, akkor a csapos üzenetet kap a korlátozásról.

## **Jelenlegi helyzet**
Hosszadalmas fizetési módszerek, az ügyfélnek mindenhova magával kell vinnie a bankkártyát, vagy készpénzt.
Több élőerőt kell alkalmazni, mint a teljesen automatizált rendszerünknél. Vendégek személyes adatai nem biztos, hogy védve vannak.
Számla rendezés bonyolult lehet, az azonosítás nem biztos emberi tényezők miatt. Az üzemeltető kevesebb embert
szeretne alkalmazni ezzel csökkenve az üzemeltetés árát, valamint kényelmi funkciót ajánlani az ügyfeleknek.
Ezért szükséges egy karóra ami nyomon követi, hogy milyen szolgáltatásokat vehetnek illetve vesznek igénybe.

## **Követelmény lista**
Modul | ID | Név | v. | Kifejtés
--- | --- | --- | --- |---
Jogosultság | F1 | Ügyfél adatainak megadása | 1.0 | Ügyfél nevének és életkorának tárolása, karórához való hozzárendelése
Jogosultság | F2 | Jogosultsági szintek | 1.0 | Felnőtt(18+): Mindent szolgáltatást igénybevehet<br/>Gyermek: Korhatáros szolgáltatásokhoz nem kap hozzáférést
Modifikáció | F3 | Ügyfél adatainak változtatása | 1.0 | Ügyfél nevének és életkorának változtatása
Igénybevétel | F4 | Gépi igénybevétel | 1.0 | Ajtó nyitása, automatás vásárlás korhatáros szolgáltatás esetén csak a megfelelő karórának
Igénybevétel | F5 | Emberi igénybevétel | 1.0 | Szolgáltatásoknál ahol szükséges munkatársat alkalmazni, ellátni egy leolvasó eszközzel
Igénybevétel | F6 | Számlázás | 1.0 | Szolgáltatás igénybevétele esetén fizetendő összeg hozzáadása az órához tartozó számlához
Ügyintézés | F7 | Számla kiállítás | 1.0 | Az igénybevett szolgáltatások kilístázása és erről való számla kiállítása
Ügyintézés | F8 | Fizetés | 1.0 | Az óra leolvasása és az igénybevett szolgáltatások alapján a fizetendő összeg meghatározása
Ügyintézés | F9 | Csoportos fizetés | 1.0 | Több órához tartozó számlák egyben történő kifizetése
Ügyintézés | F10 | Csoportos számla kiállítás | 1.0 | Több órához tartozó számlák egybevonása, egy listába rendezése
Jogosultság | F11 | Karóra felszabadítása | 1.0 | Ügyfél távozásakor a karóra adatai alaphelyzetbe állnak

## **Jelenlegi üzleti folyamatok modellje**
A jelenlegi rendszer nagy munkaerőt kíván egy-egy munkatárs elvesztése kritikus lehet.
Az ügyfeleknek figyelniük kell értékeikre mivel fizetőeszközeiket nem hagyhatják egy zárható szekrényben
hiszen azok nélkül a különböző szolgáltatások igénybevétele nem lenne lehetséges. Sok vásárló
ezért kevés szolgáltatást vesz igénybe vagy akár egyántalán nem, csak az alapokat.

## **Igényelt üzleti folyamatok**
Az ügyfelek karórát kapnak, amit használhatnak a különféle szolgáltatások igénybevételéhez.
A kerórák kortól függően vannak beállítva, hogy a korhoz kötött szolgáltatásokat ne tudja bárki elérni.
Távozáskor igény szerint a rendszer számlát állít ki, amin követhető, hogy ki milyen szolgáltatásokat vett
igénybe, valamint a fizetés is utólag teljesül, hogy minél szabadabb legyen az egyes szolgáltatások igénybevétele.

## **Használati esetek**
ADMIN: Az ADMIN képes megváltoztatni az órához rendelt ügyfél nevét, életkorát, a számlán lévő igénybe vett szolgálatatásokat
tudja törölni, módosítani
FELHASZNÁLÓ: A FELHASZNÁLÓ különféle szolgáltatásokat tud igénybe venni, ha az életkora ezt megengedi korhatáros szolgálatások esetén,
melyek a hozzá tartozó számlához adódnak hozzá

## **Használati esetek megfeleltetése a követelményeknek**
F1 - ADMIN <br/>
F2 - ADMIN <br/>
F3 - ADMIN <br/>
F4 - FELHASZNÁLÓ, ADMIN <br/>
F5 - FELHASZNÁLÓ, ADMIN <br/>
F6 - FELHASZNÁLÓ, ADMIN <br/>
F7 - FELHASZNÁLÓ, ADMIN <br/>
F8 - FELHASZNÁLÓ, ADMIN <br/>
F9 - FELHASZNÁLÓ, ADMIN <br/>
F10 - FELHASZNÁLÓ, ADMIN <br/>
F11 - ADMIN <br/>

## **Forgatókönyv**
Szereplők: Futási időben három szereplő figyelhető meg. Az
első szereplő maga a futó alkalmazás.
A karóra segítségével különféle szolgáltatásokat lehet igénybevenni. Mind az aoutomatizált és nem
aoutomatizált rendszereknél a keróra ellenőrzést végez, hogy a felhasználó igénybe veheti-e a szolgáltatást, ha az
korhatáros. A harmadik szereplő egy web-service, ami a szolgáltatásokhoz
szükséges adatokat szolgáltatja az alkalmazásnak egy adatbázisból.
