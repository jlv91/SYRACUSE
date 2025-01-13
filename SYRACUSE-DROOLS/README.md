# Calcul des éléments de la [suite de Syracuse](https://fr.wikipedia.org/wiki/Conjecture_de_Syracuse) avec Drools 8 et Docker.

## Création d'un network
<code>docker network create drools_network</code>

## syra-drools
<br>C'est un projet DROOLS Maven qui peut s'exécuter dans un container Docker. Il expose un webservice REST qui calcule la suite de Syracuse.

<br>3 règles sont nécessaires pour calculer la suite : 
<li>Une règle d'initialisation pour créer U0</li>
<li>Une règle pour calculer Un+1 lorsque Un est pair</li>
<li>Une règle pour calculer Un+1 lorsque Un est impair</li>
<br>Ces 2 dernières sont dans une table de décision.

Les temps de vol, temps de vol en altitude, et altitude max sont calculés par 3 autres règles.

Le swagger est http://localhost:8080/swagger-ui/index.html

curl -X 'POST' \
  'http://localhost:8080/syra' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
  "u0": 257}'


<code>docker image build -t syra-drools .
<br>docker run --rm --name drools --network drools_network -p 8080:8080 syra-drools</code>

## syra-flask-drools
<br>C'est un webserver qui expose une page pour définir u0, lancer le calcul et afficher les résultats du calcul de la suite de Syracuse par le webservice syra-drools. Il peut s'exécuter dans un container Docker.

<code>docker image build -t syra-flask-drools .
<br>docker run --rm -e WEBSERVICE_URL=http://drools:8080/syra  --network drools_network -p 5000:5000 syra-flask-drools</code>

La page web est http://localhost:5000

## Docker Compose
Pour construire et lancer les 2 containers:
<br><code>docker-compose up --build</code>