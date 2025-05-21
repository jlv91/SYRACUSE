# Calcul des éléments de la [suite de Syracuse](https://fr.wikipedia.org/wiki/Conjecture_de_Syracuse) avec IBAMOE dans le cas d'une application java BATCH.

## Utilisation de IBAMOE
IBAMOE est IBM Business Automation Open Edition. C'est Kogito Drools jBPMN maintenu par IBM.

## Pour un appel BATCH
On ne veut pas faire appel à un webservice mais on veut exécuter les règles métiers dans la JVM de l'application.

Je n'ai pas réussi à avoir un batch qui fonctionne avec  un Ruleflow et des RuleUnit. J'ai dû écrire les règles en Drools Legacy (cad sans RuleUnit).

Le projet syra-drools-ruleunit fonctionne avec Quarkus (donc tout est bien du point de vue jBPMN et Kogito). Renommer pom-quarkus.xml en pom.xml puis lancer 
```bash
mvn -f quarkus clean compile quarkus:dev
```
On peut accéder au swaggerQuarkus ici : http://localhost:8080/q/swagger-ui/

Pour compiler, il faut lancer le repo maven avec les dépendances maven :
```bash
docker run -d -t -p 9000:8080 -i --rm quay.io/bamoe/maven-repository:9.1.1-ibm-0003