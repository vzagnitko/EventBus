package com.example.event;

import com.google.common.eventbus.AsyncEventBus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author victorzagnitko
 */
@Service
public class EventService {

    private static final Logger LOG = LoggerFactory.getLogger(EventService.class);

    @Autowired
    private AsyncEventBus asyncEventBus;

    private String eventMessage;

    public boolean postEvent(String message) {
        try {
            asyncEventBus.post(new EventMessage(message));
            return true;
        } catch (Exception exc) {
            LOG.error("Error post event in the Event Bus {}", exc);
            return false;
        }
    }

    public String getEventMessage() {
        return eventMessage;
    }

    public void setEventMessage(String eventMessage) {
        this.eventMessage = eventMessage;
    }

}
