# Calcul des éléments de la [suite de Syracuse](https://fr.wikipedia.org/wiki/Conjecture_de_Syracuse) avec IBAMOE dans le cas d'une application java BATCH.

## Utilisation de IBAMOE
IBAMOE est IBM Business Automation Open Edition. C'est Kogito Drools jBpmn maintenu par IBM.

## Pour un appel BATCH
On ne veut pas faire appel à un webservice mais on veut exécuter les règles métiers dans la JVM de l'application.

Je n'ai pas réussi à avoir un batch qui fonctionne avec  un Ruleflow et des RuleUnit. J'ai dû écrire les règles en Drools Legacy (pas lié à IBAMOE).

