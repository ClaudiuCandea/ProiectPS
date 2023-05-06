# Aplicatie pentru serviciu transport de tip taxi
###  Candea Claudiu, Grupa 30237




## Despre proiect
Aplicatia este menita sa faciliteze modul in care sunt oferite si solicitate cursele de tip taxi in cadrul unui oras. Clienti pot sa solicite o curs prin intermediul aplicatie introducand locatia curenta si unde doresc sa ajunga, iar soferi pot accepta curs, totul fiind foarte usor si simplu. Dupa ce s-a plasat cursa de catre client, acesta trebuie doar sa astepte in locatia de start indicata la plasare cursei, in cel mai scurt timp posibil un sofer va accepta curs si va sosi sa il ridice. 

## Functionalitati
Aplicatia trebuie sa permita inregistrare de noi utilzatori, a caror date de autentificare sa fie salvate in baza de data. Totodata trebuie sa permita autentificare utilizatorilor deja existenti pe baza unui nume de utilizator si parola, acestea fiind nevoite sa coincida cu un set de nume si utilizator si parola deja existent in daza de data a aplicatie pentru a putea fi permis accesul la aplicatie. 
Aplicatia are 3 tipuri de utilizatori: client, sofer, administrator. La efectuare unei inregistrari de utilizator nou se poate alege ca acesta sa fie sofer sau client, nu se poate creea un administrator nou. 
Clientul trebuie sa abia posibilitatea de a accesa aplicatia in baza credentialelor introdus la inregistrare. Acesta poate sa plasese o cursa introducand in casetele text prezente adresa de plecare si cea a destinatiei. Totodata, clientul va fi notificat daca curs plasata de acesta a fost acceptata de catre un sofer.
Soferul trebuie sa abia posibilitatea de a accesa aplicatia in baza credentialelor introdus la inregistrare. Acesta poate sa vizualizeze cursele plasate de clienti ce nu au fost acceptate inca de alti soferi si poate sa aleaga ce curs avrea sa accepte dintre cele ce ii sunt prezentate.
Administratorul poate sa vada date despre client si soferi si poate sa stearga utilizatori.
Ca cerinte nonfunctionale aplicatia trebuie sa oferie o interfata prietenoasa si intuitiva pentru utilizatorii sai si sa asigure validitatea datelor introduse de acestia.


## Baza de date
In baza de date sunt 5 tabele: user, client, driver, car, order.
Tabelul "user" contine datele genereale ale unui utilizator al aplicatiei precum: nume, telefon, adresa de email, parola si tipul utilizatorului. 
Tabelul "client" este un tabel ce contine date despre un anumit tip de utilizator, dupa cum indica si numele date despre clienti. Aici este stocata ca cheie straina o referinta spre tabelul "user" unde se afla datele genereale alea clientului. Pe langa asta, in acest tabel mai este stoact si numarul cardului pe care clientul l-a introdus ca metoda de plata a curselor.
Tabelul "driver" contine date despre utilizatorii ce s-au inscris in aplicatie cu rolul de sofer. In tabel se afla o cheie straina ce refera tabelul "user", unde se gasesc datele genereale ale unui utilizator al aplicatiei. Se stocheaza si numarul de comenzi pe care soferul le-a acceptat.
Tabel "car" mentine date despre masinile soferilor. Exista o cheie straina ce refera tabelul "driver" pentru a asocia masina cu soferul. Se stocheza date despre producatorul masinii, modelul masinii si numarul de inmatriculare al acesteia. De asmenea, se stocheaza si numarul de comenzi acceptate de soferul masinii.
Tabelul "order" metine inforamtii despre comenziile efectuate de clientii. Se mentine id-ul clientul si cel al soferului care a acceptat cursa sub fora de referinte spre tabelele "client" si "driver". De asemenea, se stocheaza locatia de start si destinatia intorduse de client, precum si data la care a fost efectuate cursa.  

## Endpoint-uri
Am creat endpoint-uri de POST,PUT,DELETE si GET pentru toate tabelele din baza de date, oferind astfel posibilitatea de a salva, actualiza, sterge sau extrage informatiile necesare stocate in baza de date. Pentru fiecare table s-a creat o clasa controller care incorporeaza endpoint-urile.
Functile get reprezinta endpoint-urile pentru request-urile de tipul GET, ce returneaza informatii stocate in baza de date. Functile save reprezinta endpoint-uri pentru request-urile de tip POST, permitand astfel inserarea de noi randuri in baza de date. Functile reprezinta endpoint-uri pentru request-urile de tip PUT, permitand astfel sa se actualizeze randurile deja prezente in baza de date. Functile delete reprezinta endpoint-uri pentru request-urile de tip DELETE, prin intermediul carora se sterg informatii stocate in baza de date.
##### User controller
In aceasta clasa s-au implementat endpoint-urile pentru useri. Metoda getUsers returneaza toti user-ii din baza de date sub forma unei liste. Metoda getUserById primeste un parametru de tipul int ce reprezinta un id, returnand user-ul din baza de data corespunzator id-ului.

Metoda getUserById primeste ca parametru un string ce reprezinta un email si returneaza user-ul din baza de date care are acest email.

Metoda saveUser() primeste un obiect de tipul User pe care il va stoca in baza de date. 
    
Metoda updateUser() primeste un obiect de tipul User si actualizeaza user-ul din baza de date care are id-ul corespunzator cu cel al user-ului primit ca parametru. Valorile campurilor user-ului primit ca parametru sunt cele ce se vor modifica in baza de date.
    
Metoda deleteUser() primeste ca parametru un o valoare de tip int reprezentant id-ul user-ului ce va fi sters din baza de date. 
    
#### Client controller
In aceasta clasa s-au implementat endpoint-uri pentru user-ii de tip clienti. Metodele getClientByID() si getAllClients() returneaza un client in functie de un client_id specificat, repectiv o lista cu toti  clientii. Informatiile extrase sunt atat din tabelul user unde se pastreaza informatiile generale despre utilizatori, cat si din tabelul clienti unde se pastreaza informatiile specifice pentru clienti.
    
Metoda saveClient() primeste un obiect de tipul Client pe care il salveaza in baza de date. Se insereaza cate un rand nou atat in tabeul user cat si in tabelul client.
    
Metoda updateClient() primeste un obiect de tipul Client si actualizeaza informatiile de la randul corespunzator id-ului clientului cu valorile campurilor obiectului primit ca parametru.
Se actualizeaza informatiile atat din tabelul user cat si din tabelul client.
    
Metoda deleteClient() primeste un userId corepunzator unui client si sterge informatiile legate de acest id atat din tabelul user cat si din tabelul client.

##### Drive controller
In aceasta clasa s-au implementat endpoint-uri pentru operatiile asupra tabelului driver. La fel ca si client, driver reprezinta un tip special de utilizator al aplicatie.

Metodele getAllDrivers si getDriverById au acelasi comportament ca si metodele getAllClients si getClientById, insa de data aceasta informatiile extrase sunt din tabelele user si driver.

Metoda saveDrive() primeste un obiect de tipul Driver pe care i-l va stoca in baza de date. O parte din informatiile continute de acest obiect sunt stocate in tabeul user, iar cealalta parte in tabelul driver.

Metoda updateDriver() primeste un obiect de tipul Driver si actualizeaza informatiile de la randul corespunzator id-ului driver-ului cu valorile campurilor obiectului primit ca parametru.
Se actualizeaza informatiile atat din tabelul user cat si din tabelul driver.

Metoda deleteDriver() primeste un id de utilizator corespunzator unui driver, stergand atat randul corespunzator id-ului din tabelul user cat si din tabelul driver.

##### Car controller
In aceasta clasa s-au implementat endpoint-urile pentru operatiile asupra tabelului car.

Metodele getCarById() si getAllCars() permit extragerea de informatii despre masini din baza de date. Se pot extrage atat informatii despre o singura masina, pe baza id-ului acesteia, cat si informatii despre toate masinile sub forma unei liste de obiecte de tipul Car.

Metoda saveCar() permite stocare in baza de date a informatiilor despre o noua masina contiune de obiectul de tipul Car primit ca si parametru. Se insereaza un nou rand in tabelul car.

Metoda updateCar() permite actualizarea informatiilor despre o masina deja stoca in baza de date. Identificare randului ce trebuie actualizate din tabeul Car se face in baza id-ului masini din obiectul de tip Car primit ca parametru de functia de update. Valorile noi ale coloanelor sunt continute de campurile obiectului de tip Car.

Metoda deleteCar() perimte stergera unei masini in baza unui id de de masina. Se producerea stergea unui rand din tabelul Car.

##### Order controller

In aceasta clasa s-au implementat endpoint-urile pentru operatiile asupra tabelui order.

Metodele getOrderById() si getAllOrders() perimit extragerea informatiilor stocate in tabelul order. Se returneaza informatiile despre o singura comada in baza unui id, sau informatii despre toate comeziile sub forma unei liste.

Metoda saveOrder() primeste un obiect de tipul Order ca parametru si il insereaza in tabelul Order.

Metoda updateOrder() actualizeaza informatiile unui rand din tabelul order. Acest rand este identificat in baza id-ului obiectului Order primit ca argument, totodata, obiecut acesta contine si valorile ce vor fi folosite in actualizare coloanelor din baza de date.

Metoda deleteOrder() primeste un id-ul unei comezi si sterge randul corepunzator din tabelul order.

## Clasele DAO
Clasele UserDAO, ClientDAO, DriverDAO, CarDAO si OrderDAO implementeaza interfata DAO ce descrie principalele operatii ce se executa asupra unei baza de date: stergere, insereare, interogare si actualizare.

Fiecare dintre aceste clase contine codul specific necesar realizarii unei legaturi intre tabelul corespunzator din baza de date si aplicatia noastraJava. S-a utilizat interfata DAO pentru a separa implementarea specifica necesara legarii cu repository-ul de logica aplicatiei, astfel ca, daca dorim sa schimb baza de date sau modul in care comunicam cu aceasta, logica de business a aplicatiei noaste nu v-a avea de suferit intrucat ea e dependeta de o abstractizare, in cazul curent interfata DAO, si nu de niste clase concrete.

In principla in aceste 5 clase metodele prezente realizeaza o conexiune de baza de date din MySql si creeaza query-uri SQL pe care apoi le executa, in final returand rezultatul acestor query-uri.

Metodele de get returneaza obiecte sau liste de obiecte(CLient, Driver, User, Car, Order) obtinute in urma procesarii resultSet-urior obinute in urma executie de query-uri.

Metodele delete, update si insert returneaza cheia din tabel la care s-a facut modificare sau la care s-a efectuat o stergere sau care tocmai a fost genereata in urma unei inserari.

## Design Pattern Observer

Clasa Car implemeteaza interfara Observar cu metoda update. Metoda primeste ca paramteru o valoare de tipul int ce va fi asignata campului noTakenOrder al obiectului de tipul Car cu care a fost apelata.

Clasa Driver mentine o referinta spre un obiect de tipul Obsever si are o metoda addObserver prin care se poate schimba referinta. Metoda notify din clasa Driver apeleaza metoda update a obiecului Observer trimitand-ui ca parametru numarul de comezi acceptate de catre sofer. Astfel de fiecare data cand se actualizeaza numarul de comenzi acceptate din obiectul clasei Driver, se va actualiza si cel din obiectul corespunzator din clasa Car.

