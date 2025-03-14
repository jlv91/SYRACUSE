package demo.syracuse.mdl;

import java.util.LinkedList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Stocke les résultats.
 */
public class Syracuse {
    
    private int tpsVol;
    private int tpsVolEnAltitude;
    private int altitudeMax;

    private List<Element> suite = new LinkedList<>();

    public int getTpsVol() {
        return tpsVol;
    }

    public void setTpsVol(int tpsVol) {
        this.tpsVol = tpsVol;
    }

    public int getTpsVolEnAltitude() {
        return tpsVolEnAltitude;
    }

    public void setTpsVolEnAltitude(int tpsVolEnAltitude) {
        this.tpsVolEnAltitude = tpsVolEnAltitude;
    }

    public int getAltitudeMax() {
        return altitudeMax;
    }

    public void setAltitudeMax(int altitudeMax) {
        this.altitudeMax = altitudeMax;
    }

    public List<Element> getSuite() {
        return suite;
    }

    public void setSuite(List<Element> suite) {
        this.suite = suite;
    }
    
    public void addElement(int index, int value) {
    	this.suite.add(new Element(index, value));
    }
    
    @JsonIgnore
    public Element getLastElement() {
    	if (this.suite.isEmpty()) return null;
    	return this.suite.get(this.suite.size() - 1);
    }
}
