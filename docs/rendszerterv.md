# Funkcionális specifikáció

## **A rendszer célja**
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

## **Projektterv**
Projektszerepkörök, felelőségek:
Scrum master: Tóth Zsolt
Product owner: Tóth Zsolt
Projektmunkások és felelőségek:
Backend munkálatok: Dudás Botond, Tóth Szabina, Barna Bence
Feladatuk az adatok tárolásához szükséges adatszerkezetek kialakítása,
funkciók létrehozása, a különböző platformok kiszolgálása adatokkal.
Ütemterv:

Funkció | Feladat | Prioritás | Becslés | Aktuális becslés | Eltelt idő | Hátralévő idő
--- | --- | --- | --- | --- | --- | ---
Követelmény specifikáció |  | 0 | 10 | 10 | 10 | 0
Funkcionális specifikáció |  | 0 | 12 | 12 | 12 | 0
Rendszerterv |  | 0 | 13 | 13 | 13 | 0
Adattárolás | Adatmodell megtervezése | 0 | 3 | 3 | 3 | 0
| | Adatbázis megvalósítása a szerveren | 1 | 1 | 1 | 1 | 0
Funkció | Adatfelvétel megvalósítása | 1 | 7 | 7 | 7 | 0
| | Szolgáltatások megvalósítása | 1 | 14 | 14 | 14 | 0
| | Szolgáltatások korlátozása | 3 | 3 | 3 | 3 | 0
| | Szolgáltatások igénybevehetősége | 2 | 8 | 8 | 8 | 0
| | Szolgáltatások számlára való terhelése | 2 | 6 | 6 | 6 | 0
Ügyfél | Fizetési lehetőség | 1 | 9 | 9 | 9 | 0
| | Csoportos Fizetési lehetőség | 2 | 14 | 14 | 14 | 0
| | Számla kiállítási lehetőség | 2 | 7 | 7 | 7 | 0
| | Csoportos számla kiállítási lehetőség | 3 | 10 | 10 | 10 | 0
Adatkezelés | Leadott óra felszabadítása, adatok törlése | 1 | 5 | 5 | 5 | 0

## **Követelmények**
### *Funkcionális követelmények:*
- Felhasználók adatainak tárolása.
- Felhasználók csoportokba szervezése.
- Felhasználók korlátozása szükség esetén.
- Fizetési lehetőség megteremtése.
- Számla kiállítási lehetőség.

### *Nem funkcionális követelmények:*
- Szolgáltatás igénybevétele időhöz kötötten, ne lehessen véletlenül igénybe venni valamit
- Óra leadásakor az ügyfél adatinak törlése

### *Törvényi előírások, szabványok:*
- GDPR-nek való megfelelés

## **Funkcionális terv**
### Rendszerszereplők:
- Admin
- Felhasználó

### Rendszerhasználati esetek és lefutásaik:
ADMIN:

- Teljes hozzáférés a rendszerhez
- Felhasználók adatit változtathatja
- Szolgáltatások letiltása
- Órák letiltása

FELHASZNÁLÓ:

- Szolgáltatásokat tud igénybe venni
- Megtakinthati a számláját

## **Fizikai környezet**
- Az alkalamzás egy internetes rendszer
- A karórák kommunikálnak a fő rendszerrel
- Szolgáltatások igénybevétele és számlázása egy leolvasóval működik
- Fejlesztői eszközök:
    - IntelliJ IDEA
    - Webstorm
    - Notepad++
    - Docker
    - MySQL Workbench
    
## **Architekturális terv**
A rendszerhez szükség van egy adatbázis szerverre, ebben az esetben
MySql-t használunk. A kliens oldali programokat egy java alapú api
szolgálja ki, ez csatlakozik az adatbázis szerverhez. A kliensekkel JSON
objektumokkal kommunikál.
Web Kliens:
A web alkalmazás React JS keretrendszer használatával készül el. Az 
api-hoz a user belépését követően egyedi api-key segítségével lehet
hozzáférni, ez biztosítja, hogy illetéktelen felhasználók ne módosíthassák az
adatokat.

## **Implementációs terv**
Web:
A Webes felület főként HTML, CSS, és Javascript nyelven fog készülni.
Ezeket a technológiákat amennyire csak lehet külön fájlokba írva készítjük, és
úgy fogjuk egymáshoz csatolni a jobb átláthatóság, könnyebb változtathatóság,
és könnyebb bővítés érdekében. Képes lesz felhasználni a Backend részen futó
Java api szolgáltatás metódusait, ezáltal tud felvinni és lekérdezni adatokat az
adatbázisból. Az eltelt időt a kliens fogja számolni a feladatoknál, hogy ne
legyenek eltérések.

## **Tesztterv**
A tesztelések célja a rendszer és komponensei funkcionalitásának
teljes vizsgálata, ellenőrzése, a rendszer által megvalósított üzleti
szolgáltatások verifikálása

**Tesztelési eljárások**<br/>
**Unit teszt:**
Ahol csak lehetséges, szükséges már a fejlesztési idő alatt is tesztelni, hogy a
metódusok megfelelően működnek-e.
Ezért a metódusok megfelelő működésének biztosítására mindegyikhez írni
kell Unit teszteket, a minél nagyobb kódlefedettséget szem előtt tartva. A
metódusok akkor vannak kész, ha a tesztesetek hiba nélkül lefutnak az egyes
metódusokon

**Alfa teszt:**
Fejlesztőcsapat teszteli a rendszert a felfedezett hibákat javítja, finomítja
gyorsítja a rendszert szükség esetén

**Beta teszt:**
Kezdetleges rendszer telepítése a megrendelő által kívánt helyre és annak tesztelése egy
héten át, problémák fellépése esetén jelezni azokat

**Tesztelendő funkciók**<br/>
**Backend Service**
Képesnek kell lennie adatokat fogadni és küldeni a karóráknak.
Képesnek kell lennie egy időben kiszolgálni több klienst is.
Fel kell tudnia tölteni, és le kell tudnia kérdezni az adatbázis adatait.

**Karóra**
**Adatmegadás:**
Elvárt működés: A megadott adatokat az óra megfelelően tárolja, szükség esetén módisítható
**Szolgáltatások:**
Képesnek kell lennie kommunikációt biztosítani az adatbázis és az órák között.
A karórán tárolt adatok segíségével meg kell tagadnia korhatáros szolgáltatásokat


## **Telepítési terv**
- Érzékelők kihejezése a szolgáltatások igénybevételéhez
- Megfelelő mennyiségű karóra üzembehelyezése
- Munkatársak képzése a rendszer kezelésére
- Állandó internetkapcsolat a karórák és a rendszer közti kpmmunikációhoz

## **Karbantartási terv**
A rendszer folyamatos üzemeltetése és karbantartása, mely
magában foglalja a programhibák elhárítását, a belső igények változása miatti
módosításokat, valamint a környezeti feltételek változása miatt
megfogalmazott program-, illetve állomány módosítási igényeket
### **Karbantartás**
Adaptive Maintenance: A program naprakészen tartása és finomhangolása.
Perfective Maintenance: A rendszer hosszútávú használata érdekében végzett
módosítások, új funkciók, a szoftver teljesítményének és működési
megbízhatóságának javítása.
Preventive Maintenance: Olyan problémák elhárítása, amelyek még nem
tűnnek fontosnak, de később komoly problémákat okozhatnak.