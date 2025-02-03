package demo.syracuse.app;

import java.util.HashMap;
import java.util.Map;

import org.jbpm.ruleflow.instance.RuleFlowProcessInstance;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;
import org.kie.internal.command.CommandFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import demo.syracuse.mdl.Syracuse;

public class SyracuseBatchApplicationLegacy {
    private static final  Logger LOGGER = LoggerFactory.getLogger(SyracuseBatchApplicationLegacy.class);
  
    public static void main(String[] args) {

        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();

        final Map<String, Object> params = new HashMap<>();

        int u0 = 1;
        StatelessKieSession kieSession = kieContainer.newStatelessKieSession();
        while (u0 < 100) {
            params.put("u0", u0);
            @SuppressWarnings("unchecked")
            RuleFlowProcessInstance rfp = (RuleFlowProcessInstance) 
                kieSession.execute( // each execute on a stateless session create internally a new session
                    CommandFactory.newStartProcess("syra", params)
                );

            Syracuse syra = (Syracuse) rfp.getVariable("syracuse");
            LOGGER.info(String.format("U0 = %d, Altitude max : %d, Tps vol : %d, Tps vol altitude : %d", 
            u0,        
            syra.getAltitudeMax(), 
                    syra.getTpsVol(), 
                    syra.getTpsVolEnAltitude()));
            
            u0++;
            
            // syra.getSuite().forEach(e -> LOGGER.info(String.format("U%d = %d",e.getIndex(), e.getValeur())));
        }


    }

}