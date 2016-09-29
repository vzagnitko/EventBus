package com.example.controller;

import com.example.event.EventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

/**
 * @author victorzagnitko
 */
@RestController
@RequestMapping(value = "/events")
public class DataController {

    private static final Logger LOG = LoggerFactory.getLogger(DataController.class);

    @Autowired
    private EventService eventService;

    @RequestMapping(value = "/2", method = RequestMethod.GET)
    public Map<String, Boolean> postEventController(@RequestParam String message) {
        boolean result = false;
        try {
            result = eventService.postEvent(message);
        } catch (Exception exc) {
            LOG.error("Error post event in the Event Bus {}", exc);
        }
        return Collections.singletonMap("result", result);
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getMessageController() {
        return eventService.getEventMessage();
    }

}
