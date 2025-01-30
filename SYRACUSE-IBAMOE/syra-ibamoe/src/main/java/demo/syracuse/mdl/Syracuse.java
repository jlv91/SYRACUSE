package demo.syracuse.mdl;

import java.util.LinkedList;
import java.util.List;

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
    public void add(Element e) {
        this.suite.add(e);
    }
    public List<Element> getSuite() {
        return suite;
    }

    public void setSuite(List<Element> suite) {
        this.suite = suite;
    }
}
