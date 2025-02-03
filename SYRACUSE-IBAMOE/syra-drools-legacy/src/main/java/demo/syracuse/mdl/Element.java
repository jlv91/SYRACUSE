package demo.syracuse.mdl;

/**
 * Représente un élément de la suite avec son index et la valeur.
 */
public class Element {
    
    private int index;
    private int valeur;
    
    
    public Element(int index, int valeur) {
        this.index = index;
        this.valeur = valeur;
    }

    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }
    public int getValeur() {
        return valeur;
    }
    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    @Override
    public String toString() {
        return String.format("U%d = %d", index, valeur);
    }
}
