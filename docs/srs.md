# Wellnes Badges Software Requirements Specification

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

**A mostani helyzet általános problémái:**
- Hosszadalmas fizetési módszerek.
- Az ügyfélnek mindenhova magával kell vinnie a bankkártyát, vagy készpénzt.
- Több élőerőt kell alkalmazni, mint a teljesen automatizált rendszerünknél.
- Vendégek személyes adatai nem biztos, hogy védve vannak.
- Számla rendezés bonyolult lehet.

## **Vágyálom rendszer**

### Terjedés, az az kik fogják használni a rendszert:

 A program egyaránt a szálloda üzemeltetőinek, és vendégeinek is készül. 
 A vendégeknek a gyors és akadálymentes fizetés, a szállodának a könnyű nyomon-
  követés, valamint a törvényi kötelezettségek betartása az érdeke. 
  Előreláthatólag három jogosultsági szint lesz, admin, belső felhasználó, és
  felhasználó.
  
### A szoftvernek egyértelmű üzeneteket kell küldenie.
 
A vendégektől nem várható el, hogy számukra értelmezhetetlen üzeneteket
kapjanak egy esetleges hibáról, ezt széleskörűen kell unit-tesztelni a 
szoftvert, és minden felmerülő problémáról egyértelmű üzenetet kell kapniuk.
 
### A későbbiekben a szálloda bővülhet.

A rendszernek fel kell készülnie rá, hogy új funkciók, új helyek kerülhetnek
a szálloda szolgáltatásai közé, ezeket esetleg egy minimális frissítéssel
kezelnie kell, hogy tudja.

### Rendszer specifikációs álmok.

 A program müködtetésére szolgáló eszközök az alábbiak lesznek: 
- Egy leolvasó, ami fix helyekre, valamint mobil változatban is elérhető lesz.
- Egy karóra-szerű microchip-et tartalmazó szerkezet, amelyet a vendégek
hordanak a karukon, lehetővé téve a rendszer használatát.
- Szoftver, amivel a belső felhasználói, valamint az admin műveleteket lehet 
elvégzezni.

## **Követelmény lista**
 *A rendszer tulajdonságai:*
 - Tartalmazza a vendégek adatait, de csak annyit, amennyi a rendszerhez kell. - int(UID) | string(name) | int(age) | bool(TypeOfWatch)
 - Képes lekérdezni az adatokat egy külső eszköz segítségével. - int(UID) | string(name) | int(age)
 - Képes szolgáltatások esetleges elutasítására az automatikus kor ellenőrző segíségével. - int(UID) | bool(allowed)
 - Nem automatizált rendszer esetén az automatikus kor ellenőrző figyelmezteti a kiszolgálót, ha szükséges. - int(UID) | bool(allowed)
 - Felhasználóbarát hibaüzenetek ad vissza, jelzi a hibát az üzemeltetőnek is. - int(EID) | int(UID) | string(ErrorMessage)
 - Képes közös számlát kiállítani több ügyfélnek együttesen, a karórákon lévő összeg alapján. - int(UID) | int(TotalBill) | int(IndividualBill)
 - Kijelentkezéskor a felszabadult azonosítókat új embereknek rendeli hozzá.
 
## **Funkcionális követelmény**

### *A belső felhasználók lehetőségei:*
 - A recepciós viszi be az adatokat, ő rendeli az emberekhez az azonosítót. - int(UID) | string(name) | int(age) | bool(TypeOfWatch)
 - A pincér lekérheti az illető korát, a kora ellenőrzéséhez. - int(UID) | int(age)
 - A pénzügyes kérheti le a fizetési adatok, és elkészíti a számlát. - int(UID) | int(TotalBill) | int(IndividualBill) | string(invoice)
 
### *A felhasználók lehetőségei:*
 - Lehetőségük van azonosítás után a szolgáltatásokat igénybevenni. - int(UID) | int(age)
 - Egyes hibaüzenetek esetén saját maguk is elháríthatják a hibákat, jelzi a hibát az üzemeltetőnek. - int(EID) | int(UID) | string(exception)
 
### *Az adminok lehetőségei:*
- Minden, a rendszer által nyújtott szolgáltatáshoz joguk van.

A rendszer fejlesztői: Dudás Botond, Tóth Szabina, Barna Bence.