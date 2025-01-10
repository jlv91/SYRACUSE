# Calcul des éléments de la [suite de Syracuse](https://fr.wikipedia.org/wiki/Conjecture_de_Syracuse) avec ODM 9.0 on Docker

<br>Le but est de calculer les éléments de la suite de Syracuse avec des règles ODM.
Il y a les 5 règles équivalentes à celle de la solution DROOLS.

# Exécuter ODM dans un container Docker
## Création d'un network
<code>docker network create odm_network</code>
<br>Il permet à un autre container de communiquer avec le container ODM pour exécuter l'API REST de decision center.

## Lancer le container ODM icr.io/cpopen/odm-k8s/odm
<code>docker run -d -e SAMPLE=false -e LICENSE=accept --name odm --network odm_network -p 9090:9060 -p 9443:9443  icr.io/cpopen/odm-k8s/odm:9.0</code>

Les applications ODM sont accessibles via http://localhost:9090. La base de données est recréée à chaque RUN, on pourrait la mettre dans un volume mappé <code>-v C:\Users\jlvassent\IBM\ODM\DB:/config/dbdata/</code> .

## Lancer le container qui charge le service de décision
Ce container importe le service de décision dans Decision center et deploy la ruleapp sur le RES.

Dans le répertoire syracuse-decision-center
<li>construire l'image</li>
<code>docker build -t syracuse-odm .</code>
<li>lancer le container avec le network</li>
<code>docker run -it --network odm_network syracuse-odm</code>

