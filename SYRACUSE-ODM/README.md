# Calcul des éléments de la [suite de Syracuse](https://fr.wikipedia.org/wiki/Conjecture_de_Syracuse) avec ODM 9.0 on Docker


# Exécuter ODM dans un container Docker
## Création d'un network
<code>docker network create odm_network</code>
<br>Il permet à un autre container de communiquer avec le container ODM pour exécuter l'API REST de decision center.

## Lancer le container ODM icr.io/cpopen/odm-k8s/odm
<code>docker run -d -e SAMPLE=false -e LICENSE=accept --rm --name odm --network odm_network -p 9090:9060 -p 9443:9443  icr.io/cpopen/odm-k8s/odm:9.0</code>

Les applications ODM sont accessibles via http://localhost:9090. La base de données est recréée à chaque RUN, on pourrait la mettre dans un volume mappé <code>-v C:\Users\jlvassent\IBM\ODM\DB:/config/dbdata/</code>

# syracuse-rule-designer
Contient le projet pour le xom et le projet pour les règles. On peut voir les règles semblables à celles de Drools dans syracuse-rules.

# syracuse-odm
C'est le container pour importer le service de decision et le deployer.

## Lancer le container qui charge le service de décision
Ce container importe le service de décision dans Decision center et deploie la ruleapp sur le RES.

Dans le répertoire syracuse-odm
<li>construire l'image</li>
<code>docker build -t syracuse-odm .</code>
<li>lancer le container avec le network</li>
<code>docker run -it --rm --network odm_network syracuse-odm</code>

# syra-flask-odm
C'est l'application flask qui permet de saisir u0, appeler le webservice REST et afficher les résultats.
<br>Dans le répertoire syra-flask-odm:
<li>
<code>
docker image build -t syra-flask-odm .</code>
<li><code>docker run --rm -e WEBSERVICE_URL=http://odm:9060/DecisionService/rest/syra_ruleapp/syracuse --network odm_network -p 5010:5010 syra-flask-odm</code>

La page web est http://localhost:5010