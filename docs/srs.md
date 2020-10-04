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
képesek egyszerű válaszüzenetek nyomtatására a hibáról, ha van. Például, ha egy gyermek  szaunázni akar, 
akkor a bejárati kapu elutasítja a kérését. Egy másik forgatókönyv szerint, ha egy 17 éves akar fizetni
akar az alkoholért, akkor a csapos üzenetet kap a korlátozásról.

## **Jelenlegi helyzet**

**A mostani helyzet általános problémái:**
- Hosszadalmas fizetési módszerek
- Az ügyfélnek mindenhova magával kell vinnie a bankkártyát, vagy készpénzt
- Több élőerőt kell alkalmazni, mint a teljesen automatizált rendszerünknél
- Vendégek személyes adatai védve vannak, csak az és csak annyit lát, akinek feltétlen szükséges
- Rendkívül könnyű számla rendezés
