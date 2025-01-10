FROM ubuntu

#Installer curl et jq
RUN apt-get update && apt-get install -y \ 
            jq \
            curl \
            vim \
    && apt-get clean

WORKDIR /syracuse
COPY syracuse.sh .
COPY syracuse-rules.zip .

CMD ["/syracuse/syracuse.sh"]
