package demo.syracuse.drools;

import org.kie.api.event.rule.DefaultRuleRuntimeEventListener;
import org.kie.api.event.rule.ObjectInsertedEvent;
import org.kie.kogito.drools.core.config.DefaultRuleEventListenerConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Pour suivre l'insertion des objets dans le datasources du RuleUnit.
 */
public class RuleEventListenerConfig extends DefaultRuleEventListenerConfig {
    public RuleEventListenerConfig() {
        super(new MyRuleRuntimeEventListener());
    }
}

class MyRuleRuntimeEventListener extends DefaultRuleRuntimeEventListener {
    private static Logger LOGGER = LoggerFactory.getLogger(MyRuleRuntimeEventListener.class);

    @Override
    public void objectInserted(ObjectInsertedEvent event) {
        Object o = event.getObject();
        LOGGER.info(String.format("Insert an object %s with value %s",  o.getClass().getSimpleName(), o.toString()));
        super.objectInserted(event);
    }
}
