package com.example.event;

import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.Subscribe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * This class receive async event to star backup process
 *
 * @author victorzagnitko
 */
@Component
public class EventMessageSubscriber {

    private static final Logger LOG = LoggerFactory.getLogger(EventMessageSubscriber.class);

    @Autowired
    private EventService eventService;

    @Autowired
    private AsyncEventBus asyncEventBus;

    @Subscribe
    @AllowConcurrentEvents
    public void messageSubcriber(EventMessage eventMessage) {
        try {
            eventService.setEventMessage(eventMessage.getMessage());
        } catch (Exception exc) {
            LOG.error("Fail backup data {}", exc);
        }
    }

    @PostConstruct
    private void init() {
        asyncEventBus.register(this);
    }

}
