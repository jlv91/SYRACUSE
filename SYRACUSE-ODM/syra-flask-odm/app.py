from flask import Flask, request, render_template
import requests
import os

app = Flask(__name__)

# Adresse du webservice distant
WEBSERVICE_URL = os.getenv("WEBSERVICE_URL", "http://localhost:9090/DecisionService/rest/syra_ruleapp/syracuse")

# Page principale avec le formulaire
@app.route("/", methods=["GET"])
def index():
    return render_template("index.html", error=None, result=None)

# Route pour traiter le formulaire et appeler le webservice
@app.route("/calcul_syracuse", methods=["POST"])
def calcul_syracuse():
    try:
        # Validation de l'entrée utilisateur
        u0 = request.form.get("u0", type=int)
        if u0 is None or u0 <= 0:
            return render_template("index.html", error="Veuillez entrer un entier positif.", result=None)
        
        # Préparer la requête POST
        payload = {"u0": u0}
        headers = {
            "accept": "application/json",
            "Content-Type": "application/json"
        }
        
        # Appeler le webservice
        response = requests.post(WEBSERVICE_URL, json=payload, headers=headers)
        response.raise_for_status()  
        result = response.json()  
        # Renvoyer les résultats à la page HTML
        return render_template("index.html", error=None, result=result)
    
    except requests.RequestException as e:
        return render_template("index.html", error=f"Erreur lors de l'appel au webservice : {e}", result=None)
    except Exception as e:
        return render_template("index.html", error=f"Erreur inattendue : {e}", result=None)

if __name__ == "__main__":
    # app.run(debug=True)
    app.run(debug=True, host="0.0.0.0", port=5010)
