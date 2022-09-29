# zadanieSpringBoot

## funkcia
Pomocou OpenCSV kniznice parsujem subor inventuraVzor do modelu (InventuraTable)
Podla modelu InventuraTable som vytvoril Table v databaze(postgres)
Vytvoril som pozadovane restApi

## Dockefile
Dockerfile sa nachadza v resources aj so zalohou DB

### RestAPI
Pre lepsie narabanie s restApi som implementoval OpenAPI3.0 pomocou ktorej sa snimi naraba praktickejsie
dostat sa k nemu da na http://localhost:8080/swagger-ui/index.html#/

1. Mapovane na "insertToDB" nacita z csv suboru udaje do modelu a nasledne do DB
2. Mapovane na "getRooms" vrati zoznam unikatnych rooms z DB
3. Mapovane na "getMajetok" vrati zoznam majetku z DB zoradeny podla ceny od najvyssej po najnizsiu ako parameter je state OK/M/V/removed
4. Mapovane na "deleteAll" vymaze Table inventura_table z DB ... vytvoril som ju aby sa s databazou dalo praktickejsie pracovat

## TODO
RestApi insertToDB nieje restApi loadFromFile ktore som mal originalne spravit, neponuka moznost vlozenia csv suboru z disku, zatial odovzdavam aplikaciu takto ale stale robim na fixe tohto nedostatku cize je mozne ze do zajtra(piatku) to odovzdam vo finalnom stave. Nechcem len riskovat ze by sa mi to nepodarilo a nestihol by som to nacas odovzdat.

### Poznamka
Stlpec price v DB som zmenil z formatu xx,xxEUR na xx.xx pre jednoduchsie pracovanie so stlpcom 
