package demo.syracuse.rules;

import org.drools.ruleunits.api.RuleUnitData;
import org.drools.ruleunits.api.SingletonStore;

import demo.syracuse.mdl.Element;
import demo.syracuse.mdl.Syracuse;

import org.drools.ruleunits.api.DataSource;
import org.drools.ruleunits.api.DataStore;

/**
 * Le RuleUnit:
 * -1 SingletonStore pour l'entier de départ
 * -1 SingletonStore pour le résultat Syracuse
 * -1 DataStore pour stocker les éléments de la suite
 */
public class SyracuseUnit implements RuleUnitData {

    private SingletonStore<Integer> u0;
    private SingletonStore<Syracuse> syracuse;
    private DataStore<Element> suite;
    
    public SyracuseUnit() {
        this.u0 = DataSource.createSingleton();
        this.syracuse = DataSource.createSingleton();
        this.suite = DataSource.createStore();
    }

    public SingletonStore<Integer> getU0() {
        return u0;
    }

    public void setU0(SingletonStore<Integer> u0) {
        this.u0 = u0;
    }

    public SingletonStore<Syracuse> getSyracuse() {
        return syracuse;
    }

    public void setSyracuse(SingletonStore<Syracuse> syracuse) {
        this.syracuse = syracuse;
    }

    public DataStore<Element> getSuite() {
        return suite;
    }

    public void setSuite(DataStore<Element> suite) {
        this.suite = suite;
    }

}
