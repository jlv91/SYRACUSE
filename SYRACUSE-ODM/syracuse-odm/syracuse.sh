#!/usr/bin/bash

export RTS_ADMIN='rtsAdmin:rtsAdmin'
export HTTP_ODM=http://odm:9060

echo 'Changement de la locale en fr_FR'
#Update locale
curl -u $RTS_ADMIN -X 'PUT' \
  $HTTP_ODM'/decisioncenter-api/v1/DBAdmin/persistencelocale?persistenceLocale=fr_FR' \
  -H 'accept: */*'

echo 'Import service de decision'
# Import decision service
curl -u $RTS_ADMIN -X 'POST' \
  $HTTP_ODM'/decisioncenter-api/v1/decisionservices/import?enableDGF=false' \
  -H 'accept: */*' \
  -H 'Content-Type: multipart/form-data' \
  -F 'file=@syracuse-rules.zip;type=application/zip'

echo
echo 'Deploiement sur le RES'
# to deploy to RES
DS_ID=$(curl -u $RTS_ADMIN -X 'GET' \
  $HTTP_ODM'/decisioncenter-api/v1/decisionservices?q=name%3Asyracuse-rules' \
  -H 'accept: application/json' | jq -r '.elements[0].id')


DEPLOYMENT_ID=$(curl -u $RTS_ADMIN -X 'GET' \
  $HTTP_ODM'/decisioncenter-api/v1/decisionservices/'$DS_ID'/deployments' \
  -H 'accept: */*' | jq -r '.elements[0].id')
 
SERVER_ID=$(curl -u $RTS_ADMIN -X 'GET' \
  $HTTP_ODM'/decisioncenter-api/v1/servers?q=name%3ADecision%20Service%20Execution' \
  -H 'accept: */*' | jq -r '.elements[0].id')
  
  
curl -u $RTS_ADMIN -X 'POST' \
  $HTTP_ODM'/decisioncenter-api/v1/deployments/'$DEPLOYMENT_ID'/deploy?serverId='$SERVER_ID'' \
  -H 'accept: application/json' \
  -d ''