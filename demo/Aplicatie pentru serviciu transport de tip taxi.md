# Aplicatie pentru serviciu transport de tip taxi
###  Candea Claudiu, Grupa 30237




## Despre proiect
Aplicatia este menita sa faciliteze modul in care sunt oferite si solicitate cursele de tip taxi in cadrul unui oras. Clienti pot sa solicite o curs prin intermediul aplicatie introducand locatia curenta si unde doresc sa ajunga, iar soferi pot accepta curs, totul fiind foarte usor si simplu.
Dupa ce s-a plasat cursa de catre client, acesta trebuie doar sa astepte in locatia de start indicata la plasare cursei, in cel mai scurt timp posibil un sofer va accepta curs si va sosi sa il ridice. 

## Functionalitati
Aplicatia trebuie sa permita inregistrare de noi utilzatori, a caror date de autentificare sa fie salvate in baza de data. Totodata trebuie sa permita autentificare utilizatorilor deja existenti pe baza unui nume de utilizator si parola, acestea fiind nevoite sa coincida cu un set de nume si utilizator si parola deja existent in daza de data a aplicatie pentru a putea fi permis accesul la aplicatie. 

Aplicatia are 3 tipuri de utilizatori: client, sofer, administrator. La efectuare unei inregistrari de utilizator nou se poate alege ca acesta sa fie sofer sau client, nu se poate creea un administrator nou. 

Clientul trebuie sa abia posibilitatea de a accesa aplicatia in baza credentialelor introdus la inregistrare. Acesta poate sa plasese o cursa introducand in casetele text prezente adresa de plecare si cea a destinatiei. Totodata, clientul va fi notificat daca curs plasata de acesta a fost acceptata de catre un sofer.

Soferul trebuie sa abia posibilitatea de a accesa aplicatia in baza credentialelor introdus la inregistrare. Acesta poate sa vizualizeze cursele plasate de clienti ce nu au fost acceptate inca de alti soferi si poate sa aleaga ce curs avrea sa accepte dintre cele ce ii sunt prezentate.

Administratorul poate sa vada date despre client si soferi si poate sa stearga utilizatori.

Ca cerinte nonfunctionale aplicatia trebuie sa oferie o interfata prietenoasa si intuitiva pentru utilizatorii sai si sa asigure validitatea datelor introduse de acestia.


## Baza de date
In baza de date sunt 4 tabele: user, client, driver, car, order.

Tabelul "user" contine datele genereale ale unui utilizator al aplicatiei precum: nume, telefon, adresa de email. 

Tabelul "client" este un tabel ce contine date despre un anumit tip de utilizator, dupa cum indica si numele date despre clienti. Aici este stocata ca cheie straina o referinta spre tabelul "user" unde se afla datele genereale alea clientului. Pe langa asta, in acest tabel mai este stoact si numarul cardului pe care clientul l-a introdus ca metoda de plata a curselor.

Tabelul "driver" contine date despre utilizatorii ce s-au inscris in aplicatie cu rolul de sofer. In tabel se afla o cheie straina ce refera tabelul "user", unde se gasesc datele genereale ale unui utilizator al aplicatiei.

Tabel "car" mentine date despre masinile soferilor. Exista o cheie straina ce refera tabelul "driver" pentru a asocia masina cu soferul. Se stocheza date despre producatorul masinii, modelul masinii si numarul de inmatriculare al acesteia.

Tabelul "order" metine inforamtii despre comenziile efectuate de clientii. Se mentine id-ul clientul si cel al soferului care a acceptat cursa sub fora de referinte spre tabelele "client" si "driver". De asemenea, se stocheaza locatia de start si destinatia intorduse de client, precum si data la care a fost efectuate cursa.  
