FROM python:3.10-slim

# Installer les dépendances
RUN apt-get update && apt-get install -y \
    python3-pip \
    && apt-get clean

# Définir le répertoire de travail
WORKDIR /app

# Copier le code source
COPY . .

RUN pip install -r requirements.txt

# Exposer le port Flask
EXPOSE 50

# Commande par défaut
CMD ["python", "app.py"]