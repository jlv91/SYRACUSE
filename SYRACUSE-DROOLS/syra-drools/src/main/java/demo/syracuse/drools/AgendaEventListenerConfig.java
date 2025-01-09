package demo.syracuse.drools;

import org.kie.api.event.rule.BeforeMatchFiredEvent;
import org.kie.api.event.rule.DefaultAgendaEventListener;
import org.kie.kogito.drools.core.config.DefaultRuleEventListenerConfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Pour tracer le nom des règles juste avant leur exécution.
 */
public class AgendaEventListenerConfig extends DefaultRuleEventListenerConfig{
    public AgendaEventListenerConfig() {
        super(new MyAgendaEventListener());
    }
}


class MyAgendaEventListener extends DefaultAgendaEventListener {
	private static Logger LOGGER = LoggerFactory.getLogger(MyAgendaEventListener.class);
	@Override
	public void beforeMatchFired(BeforeMatchFiredEvent event) {
		LOGGER.info(String.format("--------- %s - %s ---------", event.getMatch().getRule().getPackageName(), event.getMatch().getRule().getName()));
	}
}
